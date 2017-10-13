package net.codejava.crypto;

import java.awt.CardLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FyleChooserTEST extends JFileChooser {
	
	private JFrame frame;
	private JPanel mainCardPanel;
	private CardLayout cards;
	
	public FyleChooserTEST(JFrame frame, JPanel cardPanel, CardLayout cards) {
		
		this.frame = frame;
		this.mainCardPanel = cardPanel;
		this.cards = cards;
		
		/*
		//chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		System.out.println("DirectorySelectionEnabled: " + chooser.isDirectorySelectionEnabled());
	 	System.out.println("MultiSelectionEnabled: " + chooser.isMultiSelectionEnabled());
		*/
	}
	
	/**
	 * Show the chooser so user can select files to encrypt or decrypt.
	 */
	public void selectFiles() {
		
		if (FrameTEST.encryptMode) {
			this.setDialogTitle("Select files to Encrypt");
		}
		else {
			this.setDialogTitle("Select files to Decrypt");
		}
		this.setApproveButtonText("TEST_123");
		
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.setMultiSelectionEnabled(true);

		int returnVal = this.showOpenDialog(frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File[] selectedFiles = this.getSelectedFiles();
			for (File file: selectedFiles) {
				System.out.println("You chose to select/open this file: " +
						file.getName());
				System.out.println("AbsolutePath of " + file.getName() + " : " 
						+ file.getAbsolutePath());
				System.out.println();
			}

			System.out.println("approve option clicked! chooser dialog closed");

			cards.show(mainCardPanel, "radioButtons");

		}
		else {
			frame.remove(this);
		}
	}
	
	/**
	 * Show the chooser and let the user select one single directory.
	 */
	public void selectDirectory() {
		
		this.setDialogTitle("Select directory where encrypted files " +
				"will be saved");
		
		this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.setMultiSelectionEnabled(false);
		
		int returnVal = this.showSaveDialog(frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			//System.out.println(chooser.getCurrentDirectory());
			//System.out.println("absolute? " + chooser.getCurrentDirectory().isAbsolute());
			System.out.println("Name of chosen dir: " + this.getSelectedFile().getName());
			System.out.println("Path of chosen dir: " + this.getSelectedFile().getPath());
			System.out.println("Is above path absolute? " + this.getSelectedFile().isAbsolute());
			System.out.println("approve option clicked! chooser dialog closed");
		}
		else {
			frame.remove(this);
		}		
	}
	/*
	public static void main(String[] args) {
		FyleChooserTEST test = new FyleChooserTEST();
	}
    */
}
