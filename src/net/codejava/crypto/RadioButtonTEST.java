package net.codejava.crypto;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonTEST extends JPanel {

	//private JPanel mainCardPanel;
	//private CardLayout cards;

	public RadioButtonTEST(JPanel mainCardPanel, CardLayout cards) {

		//this.mainCardPanel = mainCardPanel;
		//this.cards = cards;

		this.setLayout(new GridLayout(0, 1));

		JRadioButton sameLocation = new JRadioButton("Same Location");
		sameLocation.setSelected(true);

		JRadioButton otherLocation = new JRadioButton("Other Location");

		ButtonGroup group = new ButtonGroup();
		group.add(sameLocation);
		group.add(otherLocation);

		this.add(sameLocation);
		this.add(otherLocation);
		
		JPanel flowPanel = new JPanel(new FlowLayout());
		JPanel buttonGrid = new JPanel(new GridLayout(1, 2));
		flowPanel.add(buttonGrid);
		this.add(flowPanel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(mainCardPanel, "startPanel");
			}
		});
	    buttonGrid.add(backButton);
	    
	    JButton nextButton = new JButton("Next");
	    nextButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("Next-Button geklikt");
	    		if (otherLocation.isSelected()) {
	    			System.out.println("Show chooser - gebruiker moet hier locatie kunnen kiezen voor opslaan bestanden na encryptie/decryptie.");
	    		}
	    		else {
	    			System.out.println("same location geselecteerd");
	    		}
	    		if (FrameTEST.encryptMode) {
	    			cards.show(mainCardPanel, "encryptPanel");
	    		}
	    		else {
	    			cards.show(mainCardPanel, "decryptPanel");
	    		}
	    	}
	    });
	    buttonGrid.add(nextButton);

		//System.out.println(sameLocation.isSelected());
		//System.out.println(otherLocation.isSelected());
	}

}
