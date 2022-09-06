package trocaFigurinhas.oferecedor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class OferecedorAgentGui extends JFrame {
	
	private OferecedorAgent agente;
	
	private JTextField numeroFigurinhaInput, nomeJogadorInput,  raridadeMinimaInput;

	private JTextField titleTF, desiredCostTF, maxCostTF, deadlineTF;
	private JButton setDeadlineB;
	private JButton setCCB, buyB, resetB, exitB;
	private JTextArea logTA;
	
	private Date deadline;
	
	public void setAgent(OferecedorAgent a) {
		agente = a;
		setTitle(agente.getName());
	}
	
	public OferecedorAgentGui() {
		
		super();
		
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				agente.doDelete();
			}
		} );

		

		JPanel rootPanel = new JPanel();		
		rootPanel.setLayout(new GridBagLayout());
	    rootPanel.setMinimumSize(new Dimension(330, 125));
	    rootPanel.setPreferredSize(new Dimension(330, 125));
		
		JLabel l = new JLabel("Nome jogador ");
	    l.setHorizontalAlignment(SwingConstants.LEFT);
	    GridBagConstraints gridBagConstraints = new GridBagConstraints();
	    gridBagConstraints.gridx = 0;
	    gridBagConstraints.gridy = 0;
	    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	    gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 3);
	    rootPanel.add(l, gridBagConstraints);
	
	    nomeJogadorInput = new JTextField(64);
	    nomeJogadorInput.setMinimumSize(new Dimension(222, 20));
	    nomeJogadorInput.setPreferredSize(new Dimension(222, 20));
	    gridBagConstraints = new GridBagConstraints();
	    gridBagConstraints.gridx = 1;
	    gridBagConstraints.gridy = 0;
	    gridBagConstraints.gridwidth = 3;
	    gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
	    gridBagConstraints.insets = new Insets(5, 3, 0, 3);
	    rootPanel.add(nomeJogadorInput, gridBagConstraints);
	
		l = new JLabel("Nº figurinha ");
	    l.setHorizontalAlignment(SwingConstants.LEFT);
	    gridBagConstraints = new GridBagConstraints();
	    gridBagConstraints.gridx = 0;
	    gridBagConstraints.gridy = 1;
	    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	    gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 3);
	    rootPanel.add(l, gridBagConstraints);
	
	    numeroFigurinhaInput = new JTextField(64);
	    numeroFigurinhaInput.setMinimumSize(new Dimension(70, 20));
	    numeroFigurinhaInput.setPreferredSize(new Dimension(70, 20));
	    gridBagConstraints = new GridBagConstraints();
	    gridBagConstraints.gridx = 1;
	    gridBagConstraints.gridy = 1;
	    gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
	    gridBagConstraints.insets = new Insets(5, 3, 0, 3);
	    rootPanel.add(numeroFigurinhaInput, gridBagConstraints);
	
		l = new JLabel("Raridade mínima:");
	    l.setHorizontalAlignment(SwingConstants.LEFT);
	    gridBagConstraints = new GridBagConstraints();
	    gridBagConstraints.gridx = 0;
	    gridBagConstraints.gridy = 2;
	    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	    gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 3);
	    rootPanel.add(l, gridBagConstraints);
	
	    raridadeMinimaInput = new JTextField(64);
	    raridadeMinimaInput.setMinimumSize(new Dimension(70, 20));
	    raridadeMinimaInput.setPreferredSize(new Dimension(20, 20));
	    gridBagConstraints = new GridBagConstraints();
	    gridBagConstraints.gridx = 1;
	    gridBagConstraints.gridy = 2;
	    gridBagConstraints.gridwidth = 2;
	    gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
	    gridBagConstraints.insets = new Insets(5, 3, 0, 3);
	    rootPanel.add(raridadeMinimaInput, gridBagConstraints);
			
	    rootPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
	    
	    getContentPane().add(rootPanel, BorderLayout.NORTH);
	    
	    
	    logTA = new JTextArea();
	    logTA.setEnabled(false);
	    JScrollPane jsp = new JScrollPane(logTA);
	    jsp.setMinimumSize(new Dimension(300, 180));
	    jsp.setPreferredSize(new Dimension(300, 180));
	    JPanel p = new JPanel();
	    p.setBorder(new BevelBorder(BevelBorder.LOWERED));
	    p.add(jsp);
	    getContentPane().add(p, BorderLayout.CENTER);
	  
	    p = new JPanel();
	    buyB = new JButton("Ofertar");
		buyB.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		String numeroFigurinha = numeroFigurinhaInput.getText();
		  		System.out.println(numeroFigurinha);
		  		int raridadeDesejada = -1;
		  		int raridade = -1;	  		
		  		if (Objects.nonNull(numeroFigurinha) && numeroFigurinha.length() > 0) {
		  			try {
			  			String agenteName = agente.getAID().getName() + ":\n";
			  			String dadosFigurinha = ("nomeJogador: " + nomeJogadorInput.getText() + "\n").
												concat("numeroFigurinha: " + numeroFigurinhaInput.getText() + "\n").
												concat("raridadeMinima: " + raridadeMinimaInput.getText() + "\n");
			  			String line = "";
			  			try {
			  				File myObj = new File("entradas_vendedores.txt");
				  			Scanner myReader = new Scanner(myObj);
				  			while (myReader.hasNextLine()) {
				  				System.out.println(myReader.nextLine());
				  				line.concat(myReader.nextLine());
				  		    }
				  		    myReader.close();
			  			}
			  			catch (FileNotFoundException exec) {}
			  			System.out.println(line);
			  			BufferedWriter writer = null; 
			  			if (line.contains(agenteName)) {
			  				String aux = line.substring(line.indexOf(agenteName));
			  				aux = new StringBuilder(line.indexOf(agenteName)).insert(aux.indexOf(":"), dadosFigurinha).toString();
			  				writer = new BufferedWriter(new FileWriter("entradas_vendedores.txt"));
				  			writer.write(aux);
			  			} else {
			  				writer = new BufferedWriter(new FileWriter("entradas_vendedores.txt"));
				  			writer.write(agenteName.concat(dadosFigurinha));
			  			}
			  			writer.close();
		  			} catch (IOException exc) {
		  				exc.printStackTrace();
		  			}
		  			try {
				  		try {
	//			  			raridadeMinima = Integer.parseInt(numeroFigurinhaInput.getText());
					  		agente.putForSale(nomeJogadorInput.getText(), Integer.parseInt(numeroFigurinhaInput.getText()), 0, Integer.parseInt(raridadeMinimaInput.getText()));
					  		notifyUser(new StringBuilder().append("Figurinha ").append(numeroFigurinha).append(" colocada a venda").toString()); 
				  		} catch (Exception ex1) {
				  			JOptionPane.showMessageDialog(OferecedorAgentGui.this, "Invalid max cost", "WARNING", JOptionPane.WARNING_MESSAGE);
				  		}
			  		}
			  		catch (Exception ex2) {
			  			JOptionPane.showMessageDialog(OferecedorAgentGui.this, "Invalid best cost", "WARNING", JOptionPane.WARNING_MESSAGE);
			  		}
		  		}
				else {
		  			JOptionPane.showMessageDialog(OferecedorAgentGui.this, "Insira um número de figurinha", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
		  	}
		});
		
	    resetB = new JButton("Limpar");
		resetB.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		numeroFigurinhaInput.setText("");
		  		raridadeMinimaInput.setText("");
		  		nomeJogadorInput.setText("");
		  	}
		});
		
	    exitB = new JButton("Sair");
		exitB.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		agente.doDelete();
		  	}
		});
				
	    buyB.setPreferredSize(resetB.getPreferredSize());
	    exitB.setPreferredSize(resetB.getPreferredSize());
	    
	    p.add(buyB);
	    p.add(resetB);
	    p.add(exitB);
	    
	    p.setBorder(new BevelBorder(BevelBorder.LOWERED));
	    getContentPane().add(p, BorderLayout.SOUTH);
	    
	    pack();
	    
	    setResizable(false);
	}
	
	public void notifyUser(String message) {
		logTA.append(message+"\n");
	}
}
