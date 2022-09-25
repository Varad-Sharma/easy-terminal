package com.larka.fileIO;

// import java.awt.BorderLayout;
import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.io.File;
// import java.io.FileWriter;
import java.io.IOException;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.larka.commandInput.CommandInputMannager;
import com.larka.main.MainWindow;
// import com.larka.fileIO.editor.FileEditor;

public class FileHandeler{
	
public static File fileObj = new File("");
	
	
	MainWindow mainWindow = new MainWindow();
	CommandInputMannager commandInputMannager = new CommandInputMannager();
	
	
	
	
	public void fileMaker(String commandArgs, JTextArea commandOutputArea) {
		try {
		      File myObj = new File(commandArgs);
		      
		      if (myObj.createNewFile()) {
		    	  commandOutputArea.setForeground(Color.WHITE);
		    	  commandOutputArea.setText(("File created: " + myObj.getName()));
		      } else {
		        commandOutputArea.setForeground(Color.GREEN);
		        commandOutputArea.setText("The file already exists!");
		      }
		    } catch (IOException e) {
		    	commandOutputArea.setForeground(Color.RED);
		    	commandOutputArea.setText("An error occured!");
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		    }
	}
	
	
	public void dirMaker(String commandArgs, JTextArea commandOutputArea) {
		fileObj = new File(commandArgs);
		fileObj.mkdir();
		commandOutputArea.setText("MKDIR !+> Folder Created \n" + commandArgs);
	}
	
//	public FileHandeler() {
//		//Setting up the JTextArea of the fileEditor
//		fileEditorTextArea.setBackground(MainWindow.defaultElementColor);
//		fileEditorTextArea.setForeground(Color.WHITE);
//		fileEditorTextArea.setCaretColor(Color.WHITE);
//		fileEditorTextArea.setPreferredSize(new Dimension(650, 600));
//		fileEditorTextArea.setFont(MainWindow.defaultFont);
//				
//		//Setting up the Label for the fileEditor
//		fileEditorLabel.setFont(MainWindow.defaultFont);
//		fileEditorLabel.setForeground(Color.WHITE);
//		
//		//Setting up the SAVE button
//		mainWindow.buttonCSS(fileEditorSaveButton);
//		fileEditorSaveButton.addActionListener(this);
//		
//	}

	

//try to get the file editor work
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == fileEditorSaveButton) {
//			try {
//			      	FileWriter myWriter = new FileWriter(commandInputMannager.argString);
//			      	myWriter.write(fileEditorTextArea.getText());
//			      	myWriter.close();
//			      	MainWindow.outputTextArea.setForeground(Color.WHITE);
//			      	MainWindow.outputTextArea.setText("Wrote ");
//			    } catch (IOException exception) {
//			    	System.out.println("An error occurred.");
//			    	exception.printStackTrace();
//			    }
//		}
//		
	}

