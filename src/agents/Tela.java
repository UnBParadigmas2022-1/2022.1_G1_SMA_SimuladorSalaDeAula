package agents;

import constants.StatusAlunos;
import constants.StatusAula;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Tela {

  JFrame frame;
  private JTextField txtProfessora;
  private JTextField txtContedoInteressante;
  private JTextField txtTempoRestante;
  private int timeLeft;

  private JTextField[] alunos = new JTextField[18];
  private JTextField[] tipo = new JTextField[18];
  private JTextField[] status = new JTextField[18];

  /**
   * Create the application.
   */
  public Tela() {
    for (int i = 0; i < 18; i++) {
      alunos[i] = new JTextField("Aluno " + i);
    }

    for (int i = 0; i < 18; i++) {
      tipo[i] = new JTextField();
    }

    for (int i = 0; i < 18; i++) {
      status[i] = new JTextField();
    }
    initialize();
  }

  public void updateLabels() {
    for (int i = 0; i < 18; i++) {
      String tipoAluno;
      if (i <= 3) {
        tipoAluno = "Palestrinha";
      } else if (i <= 5) {
        tipoAluno = "Perguntador";
      } else if (i <= 10) {
        tipoAluno = "Conversador";
      } else if (i <= 12) {
        tipoAluno = "Migué";
      } else if (i <= 15) {
        tipoAluno = "Nerd";
      } else {
        tipoAluno = "Trabalhador";
      }
      changeStudentType(i, tipoAluno);
    }
  }

  public void changeProfessorStatus(int valueStatus) {
    String texto = StatusAula.getStatusName(valueStatus);
    txtContedoInteressante.setText(texto);
    switch (valueStatus) {
      case 0:
        txtContedoInteressante.setBackground(new Color(0, 139, 139));
        break;
      case 1:
        txtContedoInteressante.setBackground(new Color(204, 102, 255));
        break;
      case 2:
        txtContedoInteressante.setBackground(new Color(204, 255, 102));
        break;
      case 3:
        txtContedoInteressante.setBackground(new Color(242, 123, 31));
        break;
      case 4:
        txtContedoInteressante.setBackground(new Color(230, 177, 149));
        break;
      case 5:
        txtContedoInteressante.setBackground(new Color(190, 242, 126));
        break;
      default:
        break;
    }
  }

  public void setTimeLeft(int timeLeft) {
    this.timeLeft = timeLeft;
    txtTempoRestante.setText("Etapa: " + this.timeLeft + "/10");
  }

  public void changeStudentStatus(String nome, int valueStatus) {
    int aluno = 0;
    String teste = nome;

    teste = teste.replaceAll("\\D+", "");

    aluno = Integer.parseInt(teste);
    String texto = StatusAlunos.getStatusName(valueStatus);
    status[aluno].setText(texto);

    switch (valueStatus) {
      case 0:
        status[aluno].setBackground(new Color(0, 139, 139));
        break;
      case 1:
        status[aluno].setBackground(new Color(0, 255, 127));
        break;
      case 2:
        status[aluno].setBackground(new Color(255, 0, 102));
        break;
      case 3:
        status[aluno].setBackground(new Color(192, 192, 192));
        break;
      case 4:
        status[aluno].setBackground(new Color(30, 144, 255));
        break;
      case 5:
        status[aluno].setBackground(new Color(102, 102, 204));
        break;
      case 6:
        status[aluno].setBackground(new Color(190, 242, 126));
        break;
      case 7:
        status[aluno].setBackground(new Color(176, 154, 230));
        break;
      default:
        break;
    }
  }

  public void changeStudentType(int aluno, String textValue) {
    tipo[aluno].setText(textValue);
  }

  public void changeStudentName(String nome, int nota) {
    int aluno = 0;
    String teste = nome;

    teste = teste.replaceAll("\\D+", "");

    aluno = Integer.parseInt(teste);

    alunos[aluno].setText(nome + " - " + nota + " pts");
  }

  /**
   * Initialize the contents of the frame.
   */
  public void initialize() {
    frame = new JFrame();
    frame
      .getContentPane()
      .setBackground(UIManager.getColor("EditorPane.background"));
    frame.setBounds(100, 100, 937, 506);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    txtContedoInteressante = new JTextField();
    txtContedoInteressante.setBackground(new Color(204, 255, 102));
    txtContedoInteressante.setText("CONTEÚDO INTERESSANTE");
    txtContedoInteressante.setHorizontalAlignment(SwingConstants.CENTER);
    txtContedoInteressante.setEditable(false);
    txtContedoInteressante.setColumns(10);
    txtContedoInteressante.setBounds(246, 46, 461, 46);
    frame.getContentPane().add(txtContedoInteressante);

    tipo[10] = new JTextField();
    tipo[10].setText("Conversador");
    tipo[10].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[10].setEditable(false);
    tipo[10].setColumns(10);
    tipo[10].setBackground(UIManager.getColor("Button.select"));
    tipo[10].setBounds(647, 367, 114, 18);
    frame.getContentPane().add(tipo[10]);

    status[6] = new JTextField();
    status[6].setText("Cadeira Vazia");
    status[6].setHorizontalAlignment(SwingConstants.CENTER);
    status[6].setEditable(false);
    status[6].setColumns(10);
    status[6].setBackground(new Color(102, 205, 170));
    status[6].setBounds(24, 324, 114, 18);
    frame.getContentPane().add(status[6]);

    status[9] = new JTextField();
    status[9].setText("Cadeira Vazia");
    status[9].setHorizontalAlignment(SwingConstants.CENTER);
    status[9].setEditable(false);
    status[9].setColumns(10);
    status[9].setBackground(new Color(102, 205, 170));
    status[9].setBounds(498, 324, 114, 18);
    frame.getContentPane().add(status[9]);

    tipo[11] = new JTextField();
    tipo[11].setText("Migué");
    tipo[11].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[11].setEditable(false);
    tipo[11].setColumns(10);
    tipo[11].setBackground(UIManager.getColor("Button.select"));
    tipo[11].setBounds(799, 367, 114, 18);
    frame.getContentPane().add(tipo[11]);

    tipo[7] = new JTextField();
    tipo[7].setText("Conversador");
    tipo[7].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[7].setEditable(false);
    tipo[7].setColumns(10);
    tipo[7].setBackground(UIManager.getColor("Button.select"));
    tipo[7].setBounds(173, 367, 114, 18);
    frame.getContentPane().add(tipo[7]);

    tipo[8] = new JTextField();
    tipo[8].setText("Conversador");
    tipo[8].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[8].setEditable(false);
    tipo[8].setColumns(10);
    tipo[8].setBackground(UIManager.getColor("Button.select"));
    tipo[8].setBounds(325, 367, 114, 18);
    frame.getContentPane().add(tipo[8]);

    tipo[13] = new JTextField();
    tipo[13].setText("Migué");
    tipo[13].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[13].setEditable(false);
    tipo[13].setColumns(10);
    tipo[13].setBackground(UIManager.getColor("Button.select"));
    tipo[13].setBounds(647, 294, 114, 18);
    frame.getContentPane().add(tipo[13]);

    tipo[14] = new JTextField();
    tipo[14].setText("Migué");
    tipo[14].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[14].setEditable(false);
    tipo[14].setColumns(10);
    tipo[14].setBackground(UIManager.getColor("Button.select"));
    tipo[14].setBounds(498, 294, 114, 18);
    frame.getContentPane().add(tipo[14]);

    tipo[12] = new JTextField();
    tipo[12].setText("Migué");
    tipo[12].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[12].setEditable(false);
    tipo[12].setColumns(10);
    tipo[12].setBackground(UIManager.getColor("Button.select"));
    tipo[12].setBounds(799, 294, 114, 18);
    frame.getContentPane().add(tipo[12]);

    tipo[17] = new JTextField();
    tipo[17].setText("NERD");
    tipo[17].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[17].setEditable(false);
    tipo[17].setColumns(10);
    tipo[17].setBackground(UIManager.getColor("Button.select"));
    tipo[17].setBounds(799, 221, 114, 18);
    frame.getContentPane().add(tipo[17]);

    tipo[16] = new JTextField();
    tipo[16].setText("NERD");
    tipo[16].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[16].setEditable(false);
    tipo[16].setColumns(10);
    tipo[16].setBackground(UIManager.getColor("Button.select"));
    tipo[16].setBounds(647, 221, 114, 18);
    frame.getContentPane().add(tipo[16]);

    tipo[15] = new JTextField();
    tipo[15].setText("NERD");
    tipo[15].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[15].setEditable(false);
    tipo[15].setColumns(10);
    tipo[15].setBackground(UIManager.getColor("Button.select"));
    tipo[15].setBounds(498, 221, 114, 18);
    frame.getContentPane().add(tipo[15]);

    tipo[5] = new JTextField();
    tipo[5].setText("Perguntador");
    tipo[5].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[5].setEditable(false);
    tipo[5].setColumns(10);
    tipo[5].setBackground(UIManager.getColor("Button.select"));
    tipo[5].setBounds(325, 294, 114, 18);
    frame.getContentPane().add(tipo[5]);

    tipo[4] = new JTextField();
    tipo[4].setText("Perguntador");
    tipo[4].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[4].setEditable(false);
    tipo[4].setColumns(10);
    tipo[4].setBackground(UIManager.getColor("Button.select"));
    tipo[4].setBounds(173, 294, 114, 18);
    frame.getContentPane().add(tipo[4]);

    status[3] = new JTextField();
    status[3].setText("Cadeira Vazia");
    status[3].setHorizontalAlignment(SwingConstants.CENTER);
    status[3].setEditable(false);
    status[3].setColumns(10);
    status[3].setBackground(new Color(102, 205, 170));
    status[3].setBounds(24, 251, 114, 18);
    frame.getContentPane().add(status[3]);

    tipo[2] = new JTextField();
    tipo[2].setText("Palestrinha");
    tipo[2].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[2].setEditable(false);
    tipo[2].setColumns(10);
    tipo[2].setBackground(UIManager.getColor("Button.select"));
    tipo[2].setBounds(325, 221, 114, 18);
    frame.getContentPane().add(tipo[2]);

    tipo[1] = new JTextField();
    tipo[1].setText("Palestrinha");
    tipo[1].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[1].setEditable(false);
    tipo[1].setColumns(10);
    tipo[1].setBackground(UIManager.getColor("Button.select"));
    tipo[1].setBounds(173, 221, 114, 18);
    frame.getContentPane().add(tipo[1]);

    tipo[0] = new JTextField();
    tipo[0].setText("Palestrinha");
    tipo[0].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[0].setEditable(false);
    tipo[0].setColumns(10);
    tipo[0].setBackground(UIManager.getColor("Button.select"));
    tipo[0].setBounds(24, 221, 114, 18);
    frame.getContentPane().add(tipo[0]);

    status[2] = new JTextField();
    status[2].setText("Cadeira Vazia");
    status[2].setHorizontalAlignment(SwingConstants.CENTER);
    status[2].setEditable(false);
    status[2].setColumns(10);
    status[2].setBackground(new Color(238, 232, 170));
    status[2].setBounds(325, 178, 114, 18);
    frame.getContentPane().add(status[2]);

    status[1] = new JTextField();
    status[1].setText("Cadeira Vazia");
    status[1].setHorizontalAlignment(SwingConstants.CENTER);
    status[1].setEditable(false);
    status[1].setColumns(10);
    status[1].setBackground(new Color(143, 188, 143));
    status[1].setBounds(173, 178, 114, 18);
    frame.getContentPane().add(status[1]);

    status[0] = new JTextField();
    status[0].setBackground(new Color(102, 205, 170));
    status[0].setEditable(false);
    status[0].setHorizontalAlignment(SwingConstants.CENTER);
    status[0].setText("Cadeira Vazia");
    status[0].setBounds(24, 178, 114, 18);
    frame.getContentPane().add(status[0]);
    status[0].setColumns(10);

    txtProfessora = new JTextField();
    txtProfessora.setEditable(false);
    txtProfessora.setHorizontalAlignment(SwingConstants.CENTER);
    txtProfessora.setText("PROFESSORA");
    txtProfessora.setBounds(204, 12, 538, 50);
    frame.getContentPane().add(txtProfessora);
    txtProfessora.setColumns(10);

    alunos[2] = new JTextField();
    alunos[2].setText("Aluno 3");
    alunos[2].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[2].setEditable(false);
    alunos[2].setColumns(10);
    alunos[2].setBounds(312, 187, 139, 46);
    frame.getContentPane().add(alunos[2]);

    alunos[1] = new JTextField();
    alunos[1].setText("Aluno 2");
    alunos[1].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[1].setEditable(false);
    alunos[1].setColumns(10);
    alunos[1].setBounds(161, 187, 139, 46);
    frame.getContentPane().add(alunos[1]);

    alunos[0] = new JTextField();
    alunos[0].setFont(new Font("Dialog", Font.PLAIN, 12));
    alunos[0].setText("Aluno 1");
    alunos[0].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[0].setEditable(false);
    alunos[0].setColumns(10);
    alunos[0].setBounds(12, 187, 139, 46);
    frame.getContentPane().add(alunos[0]);

    txtTempoRestante = new JTextField();
    txtTempoRestante.setBackground(new Color(255, 204, 153));
    txtTempoRestante.setFont(
      txtTempoRestante
        .getFont()
        .deriveFont(txtTempoRestante.getFont().getStyle() | Font.BOLD)
    );
    txtTempoRestante.setText("Etapa: 0/10");
    txtTempoRestante.setHorizontalAlignment(SwingConstants.CENTER);
    txtTempoRestante.setEditable(false);
    txtTempoRestante.setColumns(10);
    txtTempoRestante.setBounds(25, 56, 154, 50);
    frame.getContentPane().add(txtTempoRestante);

    tipo[3] = new JTextField();
    tipo[3].setText("Palestrinha");
    tipo[3].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[3].setEditable(false);
    tipo[3].setColumns(10);
    tipo[3].setBackground(UIManager.getColor("Button.select"));
    tipo[3].setBounds(24, 294, 114, 18);
    frame.getContentPane().add(tipo[3]);

    alunos[3] = new JTextField();
    alunos[3].setText("Aluno 4");
    alunos[3].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[3].setFont(new Font("Dialog", Font.PLAIN, 12));
    alunos[3].setEditable(false);
    alunos[3].setColumns(10);
    alunos[3].setBounds(12, 260, 139, 46);
    frame.getContentPane().add(alunos[3]);

    status[4] = new JTextField();
    status[4].setText("Cadeira Vazia");
    status[4].setHorizontalAlignment(SwingConstants.CENTER);
    status[4].setEditable(false);
    status[4].setColumns(10);
    status[4].setBackground(new Color(143, 188, 143));
    status[4].setBounds(173, 251, 114, 18);
    frame.getContentPane().add(status[4]);

    alunos[4] = new JTextField();
    alunos[4].setText("Aluno 5");
    alunos[4].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[4].setEditable(false);
    alunos[4].setColumns(10);
    alunos[4].setBounds(161, 260, 139, 46);
    frame.getContentPane().add(alunos[4]);

    status[5] = new JTextField();
    status[5].setText("Cadeira Vazia");
    status[5].setHorizontalAlignment(SwingConstants.CENTER);
    status[5].setEditable(false);
    status[5].setColumns(10);
    status[5].setBackground(new Color(238, 232, 170));
    status[5].setBounds(325, 251, 114, 18);
    frame.getContentPane().add(status[5]);

    alunos[5] = new JTextField();
    alunos[5].setText("Aluno 6");
    alunos[5].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[5].setEditable(false);
    alunos[5].setColumns(10);
    alunos[5].setBounds(312, 260, 139, 46);
    frame.getContentPane().add(alunos[5]);

    status[14] = new JTextField();
    status[14].setText("Cadeira Vazia");
    status[14].setHorizontalAlignment(SwingConstants.CENTER);
    status[14].setEditable(false);
    status[14].setColumns(10);
    status[14].setBackground(new Color(102, 205, 170));
    status[14].setBounds(498, 178, 114, 18);
    frame.getContentPane().add(status[14]);

    alunos[15] = new JTextField();
    alunos[15].setText("Aluno 16");
    alunos[15].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[15].setFont(new Font("Dialog", Font.PLAIN, 12));
    alunos[15].setEditable(false);
    alunos[15].setColumns(10);
    alunos[15].setBounds(486, 187, 139, 46);
    frame.getContentPane().add(alunos[15]);

    status[16] = new JTextField();
    status[16].setText("Cadeira Vazia");
    status[16].setHorizontalAlignment(SwingConstants.CENTER);
    status[16].setEditable(false);
    status[16].setColumns(10);
    status[16].setBackground(new Color(143, 188, 143));
    status[16].setBounds(647, 178, 114, 18);
    frame.getContentPane().add(status[16]);

    alunos[16] = new JTextField();
    alunos[16].setText("Aluno 17");
    alunos[16].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[16].setEditable(false);
    alunos[16].setColumns(10);
    alunos[16].setBounds(635, 187, 139, 46);
    frame.getContentPane().add(alunos[16]);

    status[17] = new JTextField();
    status[17].setText("Cadeira Vazia");
    status[17].setHorizontalAlignment(SwingConstants.CENTER);
    status[17].setEditable(false);
    status[17].setColumns(10);
    status[17].setBackground(new Color(238, 232, 170));
    status[17].setBounds(799, 178, 114, 18);
    frame.getContentPane().add(status[17]);

    alunos[17] = new JTextField();
    alunos[17].setText("Aluno 18");
    alunos[17].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[17].setEditable(false);
    alunos[17].setColumns(10);
    alunos[17].setBounds(786, 187, 139, 46);
    frame.getContentPane().add(alunos[17]);

    status[15] = new JTextField();
    status[15].setText("Cadeira Vazia");
    status[15].setHorizontalAlignment(SwingConstants.CENTER);
    status[15].setEditable(false);
    status[15].setColumns(10);
    status[15].setBackground(new Color(102, 205, 170));
    status[15].setBounds(498, 251, 114, 18);
    frame.getContentPane().add(status[15]);

    alunos[14] = new JTextField();
    alunos[14].setText("Aluno 15");
    alunos[14].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[14].setFont(new Font("Dialog", Font.PLAIN, 12));
    alunos[14].setEditable(false);
    alunos[14].setColumns(10);
    alunos[14].setBounds(486, 260, 139, 46);
    frame.getContentPane().add(alunos[14]);

    status[13] = new JTextField();
    status[13].setText("Cadeira Vazia");
    status[13].setHorizontalAlignment(SwingConstants.CENTER);
    status[13].setEditable(false);
    status[13].setColumns(10);
    status[13].setBackground(new Color(143, 188, 143));
    status[13].setBounds(647, 251, 114, 18);
    frame.getContentPane().add(status[13]);

    alunos[13] = new JTextField();
    alunos[13].setText("Aluno 14");
    alunos[13].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[13].setEditable(false);
    alunos[13].setColumns(10);
    alunos[13].setBounds(635, 260, 139, 46);
    frame.getContentPane().add(alunos[13]);

    status[12] = new JTextField();
    status[12].setText("Cadeira Vazia");
    status[12].setHorizontalAlignment(SwingConstants.CENTER);
    status[12].setEditable(false);
    status[12].setColumns(10);
    status[12].setBackground(new Color(238, 232, 170));
    status[12].setBounds(799, 251, 114, 18);
    frame.getContentPane().add(status[12]);

    alunos[12] = new JTextField();
    alunos[12].setText("Aluno 13");
    alunos[12].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[12].setEditable(false);
    alunos[12].setColumns(10);
    alunos[12].setBounds(786, 260, 139, 46);
    frame.getContentPane().add(alunos[12]);

    tipo[6] = new JTextField();
    tipo[6].setText("Conversador");
    tipo[6].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[6].setEditable(false);
    tipo[6].setColumns(10);
    tipo[6].setBackground(UIManager.getColor("Button.select"));
    tipo[6].setBounds(24, 367, 114, 18);
    frame.getContentPane().add(tipo[6]);

    alunos[6] = new JTextField();
    alunos[6].setText("Aluno 7");
    alunos[6].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[6].setFont(new Font("Dialog", Font.PLAIN, 12));
    alunos[6].setEditable(false);
    alunos[6].setColumns(10);
    alunos[6].setBounds(12, 333, 139, 46);
    frame.getContentPane().add(alunos[6]);

    status[7] = new JTextField();
    status[7].setText("Cadeira Vazia");
    status[7].setHorizontalAlignment(SwingConstants.CENTER);
    status[7].setEditable(false);
    status[7].setColumns(10);
    status[7].setBackground(new Color(143, 188, 143));
    status[7].setBounds(173, 324, 114, 18);
    frame.getContentPane().add(status[7]);

    alunos[7] = new JTextField();
    alunos[7].setText("Aluno 8");
    alunos[7].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[7].setEditable(false);
    alunos[7].setColumns(10);
    alunos[7].setBounds(161, 333, 139, 46);
    frame.getContentPane().add(alunos[7]);

    status[8] = new JTextField();
    status[8].setText("Cadeira Vazia");
    status[8].setHorizontalAlignment(SwingConstants.CENTER);
    status[8].setEditable(false);
    status[8].setColumns(10);
    status[8].setBackground(new Color(238, 232, 170));
    status[8].setBounds(325, 324, 114, 18);
    frame.getContentPane().add(status[8]);

    alunos[8] = new JTextField();
    alunos[8].setText("Aluno 9");
    alunos[8].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[8].setEditable(false);
    alunos[8].setColumns(10);
    alunos[8].setBounds(312, 333, 139, 46);
    frame.getContentPane().add(alunos[8]);

    tipo[9] = new JTextField();
    tipo[9].setText("Conversador");
    tipo[9].setHorizontalAlignment(SwingConstants.CENTER);
    tipo[9].setEditable(false);
    tipo[9].setColumns(10);
    tipo[9].setBackground(UIManager.getColor("Button.select"));
    tipo[9].setBounds(498, 367, 114, 18);
    frame.getContentPane().add(tipo[9]);

    alunos[9] = new JTextField();
    alunos[9].setText("Aluno 10");
    alunos[9].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[9].setFont(new Font("Dialog", Font.PLAIN, 12));
    alunos[9].setEditable(false);
    alunos[9].setColumns(10);
    alunos[9].setBounds(486, 333, 139, 46);
    frame.getContentPane().add(alunos[9]);

    status[10] = new JTextField();
    status[10].setText("Cadeira Vazia");
    status[10].setHorizontalAlignment(SwingConstants.CENTER);
    status[10].setEditable(false);
    status[10].setColumns(10);
    status[10].setBackground(new Color(143, 188, 143));
    status[10].setBounds(647, 324, 114, 18);
    frame.getContentPane().add(status[10]);

    alunos[10] = new JTextField();
    alunos[10].setText("Aluno 11");
    alunos[10].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[10].setEditable(false);
    alunos[10].setColumns(10);
    alunos[10].setBounds(635, 333, 139, 46);
    frame.getContentPane().add(alunos[10]);

    status[11] = new JTextField();
    status[11].setText("Cadeira Vazia");
    status[11].setHorizontalAlignment(SwingConstants.CENTER);
    status[11].setEditable(false);
    status[11].setColumns(10);
    status[11].setBackground(new Color(238, 232, 170));
    status[11].setBounds(799, 324, 114, 18);
    frame.getContentPane().add(status[11]);

    alunos[11] = new JTextField();
    alunos[11].setText("Aluno 12");
    alunos[11].setHorizontalAlignment(SwingConstants.CENTER);
    alunos[11].setEditable(false);
    alunos[11].setColumns(10);
    alunos[11].setBounds(786, 333, 139, 46);
    frame.getContentPane().add(alunos[11]);
  }
}
