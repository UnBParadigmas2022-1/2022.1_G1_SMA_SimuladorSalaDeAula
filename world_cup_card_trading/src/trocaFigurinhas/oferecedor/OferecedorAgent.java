package trocaFigurinhas.oferecedor;

import jade.core.Agent;

import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.*;
import jade.domain.FIPAAgentManagement.*;
import jade.proto.ContractNetResponder;
import ontologia.*;
import jade.content.*;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.*;
import jade.content.onto.basic.*;

import java.util.*;

public class OferecedorAgent extends Agent {

	  private Map catalogue = new HashMap();

	  private OferecedorAgentGui myGui;
	  private Codec codec = new SLCodec();
	  private Ontology ontology = OntologiaTrocaFigurinhas.getInstance();
	  protected void setup() {
	    System.out.println(new StringBuilder(getAID().getName()).append(" esta oferecendo figurinhas"));

	    getContentManager().registerLanguage(codec);
	    getContentManager().registerOntology(ontology);

	    myGui = new OferecedorAgentGui();
	    myGui.setAgent(this);
	    myGui.show();

	    addBehaviour(new CallForOfferServer());

	    DFAgentDescription dfd = new DFAgentDescription();
	    dfd.setName(getAID());
	    ServiceDescription sd = new ServiceDescription();
	    sd.setType("Oferecendo-figurinhas");
	    sd.setName(getLocalName()+"-Oferecendo-figurinhas");
	    dfd.addServices(sd);
	    try {
	      DFService.register(this, dfd);
	    }
	    catch (FIPAException fe) {
	      fe.printStackTrace();
	    }
	  }

	  protected void takeDown() {
	    if (Objects.nonNull(myGui)) {
	      myGui.dispose();
	    }

	    System.out.println("Seller-agent " + getAID().getName() + "terminating.");
	    try {
	      DFService.deregister(this);
	    }
	    catch (FIPAException fe) {
	      fe.printStackTrace();
	    }
	  }

	  public void putForSale(String nomeJogador, int numeroFigurinha, int raridadeMinimaInicial, int raridadeMinima) {
	    addBehaviour(new PriceManager(this, nomeJogador, raridadeMinimaInicial, raridadeMinima, numeroFigurinha));
	  }

	  private class PriceManager extends TickerBehaviour {
		  
	    private String nomeJogador;
	    private int raridadeMinimaInicial, raridadeMinima, numeroFigurinha;

	    private PriceManager(Agent a, String nomeJogador, int raridadeMinimaInicial, int raridadeMinima, int numeroFigurinha) {
	      super(a, 5000); // tick every minute
	      this.nomeJogador = nomeJogador;
	      this.raridadeMinimaInicial = raridadeMinimaInicial;
	      this.raridadeMinima = raridadeMinima;
	      this.numeroFigurinha = numeroFigurinha;
	    }

	    public void onStart() {
	      catalogue.put(numeroFigurinha, this);
	      super.onStart();
	    }

	    public void onTick() {
	    	raridadeMinima--;
	    }

	    public int getRaridadeMinima() {
	      return raridadeMinima;
	    }
	  }

	  private class CallForOfferServer extends ContractNetResponder {

	    int price;

	    CallForOfferServer() {
	      super(OferecedorAgent.this, MessageTemplate.and(MessageTemplate.MatchOntology(ontology.getName()),MessageTemplate.MatchPerformative(ACLMessage.CFP)));
	    }

	    protected ACLMessage handleCfp(ACLMessage cfp) throws RefuseException, FailureException, NotUnderstoodException {
	      ACLMessage reply = cfp.createReply();
	      try {
	        ContentManager cm = myAgent.getContentManager();
	        Action act = (Action) cm.extractContent(cfp);
	        Sell sellAction = (Sell) act.getAction();
	        Figurinha fig = sellAction.getItem();
	        myGui.notifyUser("Received Proposal to buy " + fig.getNumero());
	        PriceManager pm = (PriceManager) catalogue.get(fig.getNumero());
	        System.out.println(Objects.nonNull(pm));
	        if (Objects.nonNull(pm)) {
	          reply.setPerformative(ACLMessage.PROPOSE);
	          ContentElementList cel = new ContentElementList();
	          cel.add(act);
	          CustoFigurinha costs = new CustoFigurinha();
	          costs.setFigurina(fig);
	          price = pm.getRaridadeMinima();
	          costs.setRaridade(price);
	          cel.add(costs);
	          cm.fillContent(reply, cel);
	        }
	        else {
	          reply.setPerformative(ACLMessage.REFUSE);
	        }
	      } catch (OntologyException oe) {
	    	System.out.println("erro de ontologia 1");
	        oe.printStackTrace();
	        reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
	      } catch (CodecException ce) {
		    System.out.println("erro de ontologia 2");
	        ce.printStackTrace();
	        reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
	      } catch (Exception e) {
	    	  System.out.println("erro de ontologia 3");
	          e.printStackTrace();
	          reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
	      }
	      myGui.notifyUser(reply.getPerformative() == ACLMessage.PROPOSE ? "Sent Proposal to sell at " + price : "Refused Proposal as the service is not available");
	      return reply;
	    }

	    protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException {
	      ACLMessage inform = accept.createReply();
	      inform.setPerformative(ACLMessage.INFORM);
	      inform.setContent(Integer.toString(price));
	      myGui.notifyUser("Sent Inform at price "+price);
	      return inform;
	    }

	  }


}
