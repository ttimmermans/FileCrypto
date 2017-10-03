package net.codejava.crypto;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FyleChooserTEST /* extends JFileChooser */ {
	
	private JFrame frame;
	JFileChooser chooser = new JFileChooser();
	
	public FyleChooserTEST() {
		
		frame = new JFrame();
	 	//this.setApproveButtonText("TEST");
		chooser.setApproveButtonText("TEST");
	 	chooser.setDialogTitle("Select files to Encrypt or Decrypt");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580, 220);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		System.out.println("finished building frame");
		
		chooser.setMultiSelectionEnabled(true);
		
		System.out.println("DirectorySelectionEnabled: " + chooser.isDirectorySelectionEnabled());
	 	System.out.println("MultiSelectionEnabled: " + chooser.isMultiSelectionEnabled());
		
		//start();
		go();
	}
	
	/**
	 * Show filechooser so user can select files to encrypt or decrypt.
	 */
	public void start() {
	    int returnVal = chooser.showOpenDialog(frame);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	File[] selectedFiles = chooser.getSelectedFiles();
	    	for (File file: selectedFiles) {
	    		System.out.println("You chose to select/open this file: " +
	    				file.getName());
	    	 	System.out.println("AbsolutePath: " + file.getAbsolutePath());
	    	}
	       System.out.println("chooser dialog closed");
	    }
	    else {
	    	frame.remove(chooser);
	    }
	}
	
	/**
	 * 
	 */
	public void go() {
		int returnVal = chooser.showSaveDialog(frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println(chooser.getCurrentDirectory());
			System.out.println("absolute? " + chooser.getCurrentDirectory().isAbsolute());
			System.out.println("chooser dialog closed");
		}
		else {
			frame.remove(chooser);
		}
	}
	
	public static void main(String[] args) {
		FyleChooserTEST test = new FyleChooserTEST();
	}

}
