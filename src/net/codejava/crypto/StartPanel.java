package net.codejava.crypto;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartPanel extends JPanel {
	
	FyleChooserTEST chooser;
	RadioButtonTEST rBttnTest;
	
	public StartPanel(FyleChooserTEST chooser, RadioButtonTEST rBttnTest) {
		this.chooser = chooser;
		this.rBttnTest = rBttnTest;
		this.setLayout(new GridLayout(1, 2));
		this.add(new EncryptButton());
		this.add(new DecryptButton());
	}

	private class EncryptButton extends JButton {
		
		public EncryptButton() {
			this.setText("Encrypt Files");
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("EncryptButton (main menu) Clicked");
					FrameTEST.encryptMode = true;
					rBttnTest.setRadioButtonTexts();
					chooser.selectFiles();
					//cards.show(mainCardPanel, "radioButtons");
				}
			});
		}
	}

	private class DecryptButton extends JButton {
		
		public DecryptButton() {
			this.setText("Decrypt Files");
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("DecryptButton (main menu) Clicked");
					FrameTEST.encryptMode = false;
					rBttnTest.setRadioButtonTexts();
					chooser.selectFiles();
					//cards.show(mainCardPanel, "radioButtons");
				}
			});
		}
	}
	
}
