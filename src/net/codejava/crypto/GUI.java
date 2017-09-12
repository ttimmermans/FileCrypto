package net.codejava.crypto;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

/**
 * 
 * https://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
 * 
 * http://docs.oracle.com/javase/tutorial/uiswing/components/generaltext.html#filter
 * 
 * @author ttimmermans
 * @version 30-06-2017
 *
 */
public class GUI {
	
	private JFrame frame;
	private JFileChooser chooser;
	private JTextField keyField;
	private JButton button;
	private JLabel charCount;
	
	AbstractDocument fieldDoc;
	
	/**
	 * Constructor. Build GUI-components.
	 */
	public GUI() {
		frame = new JFrame("Enter Key");
		chooser = new JFileChooser();
		keyField = new JTextField(8);
	    button = new JButton("Encrypt!");
	    charCount = new JLabel("Number of characters typed:  0");
		
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());	
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		contentPane.add(main);
		
		JPanel flowPanel1 = new JPanel();
		main.add(flowPanel1);
		flowPanel1.add(new JLabel("<html>Please choose a password to encrypt the file with!<br>"
				+ "Be <i>VERY CAREFUL</i> to remember this password as <br>"
				+ "there is no way to decrypt and recover your files if you forget this!<br>"
				+ "<br>The password must be <i>EXACTLY</i> 16 characters long.</html>"));

		keyField.setMaximumSize(new Dimension(168, 40));
     	Font newFont = keyField.getFont().deriveFont(Font.BOLD, (float)14.5);
     	keyField.setFont(newFont);
     	JPanel flowPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		flowPanel2.add(charCount);
		flowPanel2.add(Box.createHorizontalStrut(40));
		flowPanel2.add(keyField);
		main.add(flowPanel2);

		JPanel flowPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		flowPanel3.add(button);
		main.add(flowPanel3);
		
		button.setEnabled(false);
		//addFieldLimit();
		addFieldCharCounter();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580, 220);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
		
		start();
	}
	
	/**
	 * Start program by showing filechooser so user can select files.
	 */
	public void start() {
	    int returnVal = chooser.showOpenDialog(frame);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	       enterKey();
	    }
	    else {
	    	System.exit(0);
	    }
	}
	
	/**
	 * 
	 */
	public void enterKey() {
		frame.setVisible(true);
	}
	
	/**
	 *  Add a limit of 16 characters to the textfield.
	 *
	public void addFieldLimit() {
		keyField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (keyField.getText().length() >= 16 ) {
		            e.consume();
		        }
		    }  
		});
	}
	*/
	
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
	 * enabled after exactly 16 characters have been entered.
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
	
	public static void main(String[] args) {
		GUI test = new GUI();
	}
}
