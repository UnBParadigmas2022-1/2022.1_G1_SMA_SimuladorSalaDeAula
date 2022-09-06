# Simulador Sala De Aula (SMA)

**Disciplina**: FGA0210 - PARADIGMAS DE PROGRAMAÇÃO - T01 <br>
**Nro do Grupo**: 01<br>
**Paradigma**: SMA<br>

## Alunos

| Matrícula  | Aluno                                  |
| ---------- | -------------------------------------- |
| 18/0013637 | Arthur Paiva Tavares                   |
| 18/0117548 | Bruno Carmo Nunes                      |
| 16/0028361 | Gabriel Batista Albino Silva           |
| 14/0156909 | Nathalia Lorena Cardoso Dias           |
| 17/0051277 | Nicolas Georgeos Mantzos               |
| 17/0114333 | Sofia Costa Patrocinio                 |
| 19/0048760 | Wellington Jonathan de Souza Rodrigues |

## Sobre
Para essa entrega desenvolvemos um simulador de sala de aula, onde temos agentes do tipo Professor e Aluno. Para o agente Aluno temos diferentes categorias de alunos, por exemplo, o aluno Nerd, o aluno conversador, entre outros, e cada categoria de aluno possui comportamentos particulares. Já o agente Professor dispara uma série de ações como por exemplo chamar a atenção de uma aluno conversador, dar aula com conteúdo interessante entre outros. Cada comportamento do agente aluno responderá conforme as ações do agente Professor.

## Screenshots

![1](https://user-images.githubusercontent.com/38087662/188534445-1f374cfb-068b-4cb2-97ca-e414b61e210b.png)
![2](https://user-images.githubusercontent.com/38087662/188534465-65e1ee55-305b-4759-8481-a53f9e1f2f08.png)
![3](https://user-images.githubusercontent.com/38087662/188534494-37de77bd-496e-4e4c-8c29-19b32b459d3d.png)


## Instalação
### JADE

Inicialmente é necessario a instalação da plataforma JADE. Para isso utilizamos as orientações da professora de instalação no Linux disponíveis no Aprender da disciplina de Paradigmas.

Clone este repositório:

```
$ git clone <https://github.com/UnBParadigmas2022-1/2022.1_G1_SMA_SimuladorSalaDeAula.git>
``` 
Instale o Eclipse via terminal Linux com os seguintes comandos:
```
$ sudo snap install --classic eclipse
$ sudo apt update
$ sudo apt install default-jre

``` 

## Uso

Primeiramente, importe o projeto no Eclipse.

![photo1662428830](https://user-images.githubusercontent.com/38087662/188537557-c0ba67b2-7178-42ea-b80c-256f99589e11.jpeg)
```
Acesse o build path
``` 

![photo1662428840](https://user-images.githubusercontent.com/38087662/188537578-778adeec-95d1-4ae1-852d-169b260af434.jpeg)

```
Verifique se a pasta do projeto está no classpath
``` 

![photo1662428869](https://user-images.githubusercontent.com/38087662/188537595-9350d112-a6ab-4482-a113-17ab9fd6eb88.jpeg)

```
Verifique se o commons-codecs e o JADE estão nas bibliotecas
``` 

![photo1662428955](https://user-images.githubusercontent.com/38087662/188537628-8fe4db2c-ab19-4389-964b-14cb2c8f4828.jpeg)

```
Por fim, clique com o direito na Main e Run as > Java application
``` 

# Vídeo
[![Watch the video](https://user-images.githubusercontent.com/38709421/188527962-60968fed-3bf7-4db4-8701-2e161e7f3e9d.png)](https://www.youtube.com/watch?v=YmsYeVD6VwU)

## Participações

A tabela abaixo sintetiza, nas palavras do contribuidor, as contribuições acompanhadas de sua respectiva significância.
|Nome do Membro | Contribuição | Significância da Contribuição para o Projeto (Excelente/Boa/Regular/Ruim/Nula) |
| -- | ---- | - |
| Arthur Paiva Tavares | Criação dos agentes de aluno Migué, Conversador, Palestrinha e Perguntador. Criação do comportamento de verificação de sala do professor e ciclo de atualização de status da turma com a comunicação do agente de Interface. Gerência dos status de Professor e Aluno. |Excelente |
| Bruno Carmo Nunes | Contribui com a criação e integração do swing da aplicação, com a Sófia e a Nathália. Comunicação dos alunos e professores com o agente de interface. Passando atributos como status, tipo de aluno, nome do aluno, nota que modificam a ter essa mudança de comportamentos. | Excelente |
| Gabriel Batista Albino Silva |Construção da base do projeto (importação das bibliotecas, inicialização do JadeRuntime (para evitar necessidade de configuração de build enviroment), Módulós iniciais com a comunicação basica (mudança básica de conteudos, calculo basico de notas, etc) a fim de facilitar a implementação assincrona dos demais membros do grupo.|Excelente |
| Nathalia Lorena Cardoso Dias | Participei da construção da interface junto com os colegas Bruno e Sofia. | Regular |
| Nicolas Georgeos Mantzos |Desenvolvimento do *world_cup_card_trading*. Definição dos agentes, das estratégias de comunicação entre eles e da interface gráfica tomando como base a bibliografia e documentação do JADE. | Boa |
| Sofia Costa Patrocinio | Construção da interface junto ao Bruno e a Nathália, criação do agente de interface, que troca informações com os demais agentes, criação e diferenciação de labels para status de aula e alunos, além de nome e nota que atualizam de acordo com os ciclos. | Boa |
| Wellington Jonathan de Souza Rodrigues |Participei no desenvolvimento dos agentes do nosso sistema, em especial no desenvolvimento dos comportamentos específicos de cada aluno. | Boa |

## Percepções gerais, lições aprendidas, fragilidades superadas...

A tabela abaixo compila as percepções e lições aprendidas por cada participante no desenvolvimento do segundo módulo do projeto.

| Nome do Membro                         | Comentário                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| -------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Arthur Paiva Tavares                   | Achei a forma de criar comunicações através de canais e mensagens entre agentes bastante parecida com o uso de rotinas e canais em GoLang. Os principais desafios foram de configuração de projeto na máquina e melhorar a performance da comunicação entre os agentes, usamos muitos canais no projeto e deveríamos ter usado mais performativas. A representação de um ambiente real em um software com multiagentes ajudou a entender a individualidade de cada agente e como são afetados por comunicações, apesar de na programação precisamors prever todos os comportamentos e comunicações possíveis dentro do ambiente. |
| Bruno Carmo Nunes                      | Achei bem menos trabalhoso do que os últimos trabalhos. Sendo que não é muito tranquilo trabalhar com multiagentes, porém já tive contato antes com o Java, o que facilitou muito a implementação do paradigma. Gostei muito de integrar a nossa aplicação com o Swing, e foi bem divertido ver os bugs/features novas que eram geradas na tela. Muitas coisas foram modificadas, em relação a criação de um próprio agente para a interface, mudança de tempo para intervalos do professor e etc. Por fim, gostei muito desse paradigma o que me deixa feliz de tentar usa-lo futuramente.                                      |
| Gabriel Batista Albino Silva           | Multiagentes foi bem legal uma vez que permite construir softwares observáveis, com um comportamento que apesar de bem-definido, é interessante de se observar. Já era acostumado com sistemas de trocas de mensagens, porém ver as pontas da comunicação como agentes é bem interessante. No mais, creio que o projeto foi bem desafiador uma vez que foi necessário pensar em todos os fatores presentes na sala de aula que influenciam na aula, e o prinicipal de tudo, como representar isso em código.                                                                                                                     |
| Nathalia Lorena Cardoso Dias           | De fato esse foi o paradigma que achei mais interessante, são infinitas as possibilidades de aplicabilidade em contextos bem distintos. Tive problemas pessoais no decorrer do desenvolvimento do projeto e não consegui entregar o quanto eu gostaria para esse módulo, no entanto, consegui acompanhar pareando com os colegas.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| Nicolas Georgeos Mantzos               | Tive bastante dificuldade com a utilização de performativas e ontologias, pois me pareceram servir mais à organização do que ao efetivo funcionamento da estrutura de mensageria. No mais, percebi muitas semelhanças entre o que codei e o que utilizei ao trabalhar com microsserviços, o que acabou facilitando o entendimento dos ditos *behaviours*.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| Sofia Costa Patrocinio                 | Trabalhar com multiagentes foi interesssante, a mentalidade de um existir independente de outro é ótima para problemas mais complexos. O Swing GUI Designer facilitou bastante a construção da interface e a configuração no Eclipse foi bem intuitiva.                                                                                                                                                                                                                                                                                                                                                                          |
| Wellington Jonathan de Souza Rodrigues | Trabalhar com o paradigma de multiagentes, me permitiu entender melhor, como se desenvolver um sistema mais próximo do comportamento real, além do fato de ser muito interessante poder observar as trocas de mensagens entre cada agente e como cada um assume um comportamento. Desenvolver esse trabalho foi mais divertido que o dos outros paradigma.                                                                                                                                                                                                                                                                       |

## Trabalhos Futuros

Pretendemos realizar melhorias nos comportamentos dos agentes Professor e Aluno e criar uma nova categoria de aluno que seria o aluno dorminhoco.

## Fontes

- Base Agentes / Comportamentos: https://jade.tilab.com/doc/tutorials/JADEProgramming-Tutorial-for-beginners.pdf
- Base Swing: https://docs.oracle.com/javase/tutorial/uiswing/examples/start/HelloWorldSwingProject/src/start/HelloWorldSwing.java
- Jade RUNTIME: https://github.com/mihaimaruseac/JADE-ARIA/blob/master/src/examples/O2AInterface/O2AInterfaceExample.java
- Jade Topics: https://github.com/mihaimaruseac/JADE-ARIA/blob/master/src/examples/topic/TopicMessageReceiverAgent.java
