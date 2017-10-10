package net.codejava.crypto;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FyleChooserTEST /* extends JFileChooser */ {
	
	private JFrame frame;
	JFileChooser chooser = new JFileChooser();
	
	public FyleChooserTEST() {
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580, 220);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		System.out.println("finished building frame");
		
		//chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		System.out.println("DirectorySelectionEnabled: " + chooser.isDirectorySelectionEnabled());
	 	System.out.println("MultiSelectionEnabled: " + chooser.isMultiSelectionEnabled());
		
		//chooseFiles();
		chooseDirectory();
	}
	
	/**
	 * Show the chooser so user can select files to encrypt or decrypt.
	 */
	public void chooseFiles() {
		
		chooser.setDialogTitle("Select files to Encrypt or Decrypt");
		chooser.setApproveButtonText("TEST_123");
		
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(true);
		
	    int returnVal = chooser.showOpenDialog(frame);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	File[] selectedFiles = chooser.getSelectedFiles();
	    	for (File file: selectedFiles) {
	    		System.out.println("You chose to select/open this file: " +
	    				file.getName());
	    	 	System.out.println("AbsolutePath of " + file.getName() + " : " 
	    				+ file.getAbsolutePath());
	    	 	System.out.println();
	    	}
	       System.out.println("approve option clicked! chooser dialog closed");
	    }
	    else {
	    	frame.remove(chooser);
	    }
	}
	
	/**
	 * Show the chooser and let the user select one single directory.
	 */
	public void chooseDirectory() {
		
		chooser.setDialogTitle("Select directory where encrypted files " +
				"will be saved");
		
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setMultiSelectionEnabled(false);
		
		int returnVal = chooser.showSaveDialog(frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			//System.out.println(chooser.getCurrentDirectory());
			//System.out.println("absolute? " + chooser.getCurrentDirectory().isAbsolute());
			System.out.println("Name of chosen dir: " + chooser.getSelectedFile().getName());
			System.out.println("Path of chosen dir: " + chooser.getSelectedFile().getPath());
			System.out.println("Is above path absolute? " + chooser.getSelectedFile().isAbsolute());
			System.out.println("approve option clicked! chooser dialog closed");
		}
		else {
			frame.remove(chooser);
		}		
	}
	
	public static void main(String[] args) {
		FyleChooserTEST test = new FyleChooserTEST();
	}

}
