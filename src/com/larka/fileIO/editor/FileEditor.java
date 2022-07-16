package com.larka.fileIO.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.larka.commandInput.CommandInputMannager;
import com.larka.main.MainWindow;

public class FileEditor implements ActionListener{
	
	private static final ActionEvent ActionEvent = null;
	public JTextArea fileEditorTextArea = new JTextArea();
	public JLabel fileEditorLabel = new JLabel("File Editor");
	public JButton fileEditorSaveButton = new JButton("SAVE");
	
	public static JFrame fileEditorFrame = new JFrame();
	
	CommandInputMannager commandInputMannager = new CommandInputMannager();
	MainWindow mainWindow = new MainWindow();
	
	public boolean hasSaved = false;

	public FileEditor() {
		
		//Setting up the JTextArea of the fileEditor
		fileEditorTextArea.setBackground(MainWindow.defaultElementColor);
		fileEditorTextArea.setForeground(Color.WHITE);
		fileEditorTextArea.setCaretColor(Color.WHITE);
		fileEditorTextArea.setPreferredSize(new Dimension(650, 600));
		fileEditorTextArea.setFont(MainWindow.defaultFont);
						
		//Setting up the Label for the fileEditor
		fileEditorLabel.setFont(MainWindow.defaultFont);
		fileEditorLabel.setForeground(Color.WHITE);
				
		//Setting up the SAVE button
		mainWindow.buttonCSS(fileEditorSaveButton);
		fileEditorSaveButton.addActionListener(this);
		
		fileEditorFrame.setSize(650, 650);
		fileEditorFrame.getContentPane().setBackground(MainWindow.defaultPanelColor);
		fileEditorFrame.setLayout(new BorderLayout());
		fileEditorFrame.add(fileEditorLabel, BorderLayout.NORTH);
		fileEditorFrame.add(fileEditorTextArea, BorderLayout.CENTER);
		fileEditorFrame.add(fileEditorSaveButton, BorderLayout.SOUTH);
		fileEditorFrame.setTitle("File Editor");
		fileEditorFrame.setVisible(true);
		
		actionPerformed(ActionEvent);
	}

	@Override
	//**************************HELP ME*************
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fileEditorSaveButton) {
			if (!hasSaved) {
				try {
			      	FileWriter myWriter = new FileWriter(commandInputMannager.argString);
			      	myWriter.write(fileEditorTextArea.getText());
			      	myWriter.close();
			      	MainWindow.outputTextArea.setForeground(Color.WHITE);
			      	MainWindow.outputTextArea.setText("Wrote successfuly");
			      	hasSaved = true;
			    } catch (IOException exception) {
//			    	System.out.println("An error occurred.");
			    	MainWindow.outputTextArea.setForeground(Color.RED);
			    	MainWindow.outputTextArea.setText("Error Ocurred!");
			    	exception.printStackTrace();
			    }
			}else {
				fileEditorFrame.dispose();
			}
		}
		
	}
	
}
