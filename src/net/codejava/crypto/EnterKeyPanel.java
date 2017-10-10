package net.codejava.crypto;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

public abstract class EnterKeyPanel extends JPanel {
	
	private JTextField keyField;
	protected JButton button;
	private JLabel charCount;
	
	private AbstractDocument fieldDoc;
	
	protected JPanel mainCardPanel;
	protected CardLayout cards;
	
	/**
	 * Constructor. Build GUI-components.
	 */
	public EnterKeyPanel(String buttonTxt, String labelTxt) {
		keyField = new JTextField(12);
	    button = new JButton(buttonTxt);
	    charCount = new JLabel("Number of characters typed:  0");
	    
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel flowPanel1 = new JPanel();
		this.add(flowPanel1);
		flowPanel1.add(new JLabel(labelTxt));
		
		JPanel leftFlowPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel rightFlowPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JPanel fieldGrid = new JPanel(new GridLayout(1, 2));
		fieldGrid.add(leftFlowPanel1);
		fieldGrid.add(rightFlowPanel1);
		this.add(fieldGrid);
		keyField.setMaximumSize(new Dimension(196, 40));
     	Font newFont = keyField.getFont().deriveFont(Font.BOLD, (float)14.5);
     	keyField.setFont(newFont);
     	leftFlowPanel1.add(charCount);
     	rightFlowPanel1.add(keyField);
		
		JPanel leftFlowPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel rightFlowPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JPanel buttonGrid = new JPanel(new GridLayout(1, 2));
		buttonGrid.add(leftFlowPanel2);
		buttonGrid.add(rightFlowPanel2);
		this.add(buttonGrid);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyField.setText("");
				cards.show(mainCardPanel, "radioButtons");
			}
		});
		leftFlowPanel2.add(backButton);

		rightFlowPanel2.add(button);
		addListenerToButton();
		button.setEnabled(false);
		
		addFieldCharCounter();
	}
	
	/**
	 * Add a DocumentListener to the textfield calling the method 
	 * checkFieldInput each time a DocumentEvent fires.
	 */
	public void addFieldCharCounter() {
		fieldDoc = (AbstractDocument)keyField.getDocument();
		fieldDoc.addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				checkFieldInput();
			}
			public void insertUpdate(DocumentEvent e) {
				checkFieldInput();
			}
			public void removeUpdate(DocumentEvent e) {
				checkFieldInput();
			}
		});
	}
	
	/**
	 * Count the number of characters the user has typed in the textfield. 
	 * Show this number by setting it as the text in the charCount-label.
	 * Finally, enable or disable the 'Encrypt/Decrypt' button, it should 
	 * only be enabled after at least 16 characters have been entered.
	 */
	public void checkFieldInput() {
		
		int docLength = fieldDoc.getLength();
		if (docLength < 10) {
			charCount.setText("Number of characters typed:  " + docLength);
		}
		else {
			charCount.setText("Number of characters typed: " + docLength);
		}
		
		button.setEnabled((docLength >= 16) ? true : false);
	}
	
	public abstract void addListenerToButton();

}
