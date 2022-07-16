package com.larka.commandInput;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JLayeredPane;
import javax.swing.JTextField;
//import javax.swing.text.html.HTML;
//import javax.swing.text.html.HTML.Tag;

import com.larka.main.MainWindow;
import com.larka.commandLibrary.CommandLibraryMannager;

public class CommandInputMannager implements ActionListener{
	public String commandString;
	public String oldTextString;
	public String argString;
	
	public JTextField commandInputFeild = new JTextField("COMMAND");
	public JTextField argInputTextField = new JTextField("ARGUMENTS");
	
	public JButton submitCommandButton = new JButton();
	
	public JLabel indicatorLabel = new JLabel("Command Output", JLabel.CENTER);
	
	
//	public boolean usedOnce = false;
	
	public CommandInputMannager() {
		submitCommandButton.setText("Submit");
		submitCommandButton.addActionListener(this);
		submitCommandButton.setBackground(MainWindow.defaultElementColor);
		submitCommandButton.setForeground(Color.WHITE);
		submitCommandButton.setPreferredSize(new Dimension(150, 5));
		submitCommandButton.setFocusable(false);
//		submitCommandButton.setBorder(BorderFactory.createEmptyBorder());
		
		
		commandInputFeild.setPreferredSize(new Dimension(500, 50));
		commandInputFeild.setBackground(MainWindow.defaultElementColor);
		commandInputFeild.setFont(MainWindow.defaultFont);
		commandInputFeild.setForeground(Color.WHITE);
		commandInputFeild.setBorder(BorderFactory.createLineBorder(new Color(0x474747)));
		commandInputFeild.setCaretColor(Color.WHITE);
		
		argInputTextField.setPreferredSize(new Dimension(500, 50));
		argInputTextField.setBackground(MainWindow.defaultElementColor);
		argInputTextField.setFont(MainWindow.defaultFont);
		argInputTextField.setForeground(Color.WHITE);
		argInputTextField.setBorder(BorderFactory.createLineBorder(new Color(0x474747)));
		argInputTextField.setCaretColor(Color.WHITE);
		
		indicatorLabel.setHorizontalTextPosition(JLabel.CENTER);
		indicatorLabel.setFont(MainWindow.defaultFont);
		indicatorLabel.setForeground(Color.WHITE);
		indicatorLabel.setVerticalAlignment(JLabel.TOP);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitCommandButton) {
			
			oldTextString = commandString;
			argString = argInputTextField.getText();
			commandString = commandInputFeild.getText();
			commandInputFeild.setText("COMMAND");
			argInputTextField.setText("ARGUMENT");
			
			@SuppressWarnings("unused")
			CommandLibraryMannager commandLibraryMannager = new CommandLibraryMannager(commandString, argString, MainWindow.outputTextArea);
			
//			         ****TEMPORARY****	
			
//			if (usedOnce) {
//				oldTextString = commandString;
//				commandString = commandInputFeild.getText();
//				commandInputFeild.setText("");
//				MainWindow.outputTextArea.setText("PREVIOUS->" + oldTextString + "\n\n$->" + commandString);//Print to the text area
//			}else {
//				oldTextString = "";
//				commandString = commandInputFeild.getText();
//				commandInputFeild.setText("");
//				MainWindow.outputTextArea.setText("$-> " + commandString);
//				usedOnce = true;
//			}
//			usedOnce = true;
//			
		}
		
	}
}
