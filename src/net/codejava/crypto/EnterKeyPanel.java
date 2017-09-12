package net.codejava.crypto;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
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
	
	AbstractDocument fieldDoc;
	
	/**
	 * Constructor. Build GUI-components.
	 */
	public EnterKeyPanel(String buttonTxt, String labelTxt) {
		keyField = new JTextField(8);
	    button = new JButton(buttonTxt);
	    charCount = new JLabel("Number of characters typed:  0");
	    
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel flowPanel1 = new JPanel();
		this.add(flowPanel1);
		flowPanel1.add(new JLabel(labelTxt));

		keyField.setMaximumSize(new Dimension(168, 40));
     	Font newFont = keyField.getFont().deriveFont(Font.BOLD, (float)14.5);
     	keyField.setFont(newFont);
     	JPanel flowPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		flowPanel2.add(charCount);
		flowPanel2.add(Box.createHorizontalStrut(40));
		flowPanel2.add(keyField);
		this.add(flowPanel2);

		JPanel flowPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		flowPanel3.add(button);
		this.add(flowPanel3);
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
	 * Finally, enable or disable the 'Encrypt' button, it should only be
	 * enabled after at least 16 characters have been entered.
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
