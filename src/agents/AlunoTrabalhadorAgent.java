package agents;
import constants.StatusAlunos;
import constants.StatusAula;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AlunoTrabalhadorAgent extends AlunoAgent {
	private static final long serialVersionUID = 1L;
	
	
	public AlunoTrabalhadorAgent() {
		super();
	
	}

	protected void setup() {
		super.setup();
		
		Behaviour handleContentUpdate = new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;

			/* Recebe as alteraÃ§Ãµes de conteÃºdo e seta seu status de acordo.
			 * O Aluno trabalhador se comporta da seguinte maneira: Caso o conteudo esteja interessante, ele sempre presta atenÃ§Ã£o...
			 * Caso seja irrelevante, ele tem uma probabilidade de 70% de de ir trabalhar  da aula.
			 * se ele for trabalha rele fica um tempo trabalhahando e verifica se a aula ficou interessante 
			 * */
			public void action() {
				ACLMessage msg = myAgent.receive(MessageTemplate.MatchTopic(topicAula));
				if (msg != null) {
					int statusAula = Integer.parseInt(msg.getContent());
					
					switch (statusAula) {
						case StatusAula.CONTEUDO_INTERESSANTE:
							dispersao += Math.random() * 0.70;
							break;
						case StatusAula.CONTEUDO_IRRELEVANTE:
							dispersao += Math.random() * 0.75;
							break;
						case StatusAula.RESPONDENDO_PERGUNTA:
							dispersao += Math.random() * 0.75;
							break;
						case StatusAula.CHAMANDO_ATENCAO:
							dispersao = 0;
							break;
					}
					setStatus(getActionByChance(dispersao, StatusAlunos.TRABALHANDO, StatusAlunos.PRESTANDO_ATENCAO));
				}
				else {
					block();
				}
			}
		};
		
		addAlunoBehaviour(handleContentUpdate);
		
	}
}
