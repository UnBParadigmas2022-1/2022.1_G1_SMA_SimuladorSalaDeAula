package agents;

import constants.StatusAlunos;
import constants.StatusAula;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.messaging.TopicManagementHelper;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AlunoPerguntadorAgent extends AlunoAgent {
	private static final long serialVersionUID = 1L;

	public AlunoPerguntadorAgent() {
		super();
	}

	protected void setup() {
		super.setup();

		Behaviour handleContentUpdate = new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;

			/*
			 * Recebe as alterações de conteúdo e seta seu status de acordo. O Aluno nerd se
			 * comporta da seguinte maneira: Caso o conteudo esteja interessante, ele sempre
			 * presta atenção... Caso seja irrelevante, ele tem uma probabilidade de 5% de
			 * sair da aula.
			 */
			public void action() {
				ACLMessage msg = myAgent.receive(MessageTemplate.MatchTopic(topicAula));
				if (msg != null) {
					int statusAula = Integer.parseInt(msg.getContent());
					switch (statusAula) {
						case StatusAula.CONTEUDO_INTERESSANTE:
							status = getActionByChance(0.15, StatusAlunos.PERGUNTANDO, StatusAlunos.PRESTANDO_ATENCAO);
							break;
						case StatusAula.CONTEUDO_IRRELEVANTE:
							status = getActionByChance(0.05, StatusAlunos.PERGUNTANDO, StatusAlunos.PRESTANDO_ATENCAO);
					}
				} else {
					block();
				}
			}
		};

		addAlunoBehaviour(handleContentUpdate);

	}
}