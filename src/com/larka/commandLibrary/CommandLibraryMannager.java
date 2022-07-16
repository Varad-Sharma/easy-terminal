package com.larka.commandLibrary;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;

import com.larka.fileIO.FileHandeler;
import com.larka.fileIO.editor.FileEditor;

public class CommandLibraryMannager {
	
	FileHandeler fileHandeler = new FileHandeler();
	ActionListener actionListener;
	
	
	public CommandLibraryMannager(String commandString,String commandArgs, JTextArea commandOutputArea) {
		
		
		
		if (commandString.startsWith("say")) {
			commandOutputArea.setForeground(Color.WHITE);
			commandOutputArea.setText("SYSTEM !+>  " + commandArgs);
			
		}
		
		else if (commandString.startsWith("math")) {
			//Lets say you have a string like this
			String questionArray = commandArgs;
			//Lets find the Arithmetic sign first in the String
			String sign = null;
			Pattern regex = Pattern.compile("[+*/]|(?<=\\s)-");
			Matcher matcher = regex.matcher(questionArray);
			    while(matcher.find()) {
			       sign = matcher.group().trim();  //Store that Arithmetic sign here.       
			    }

			String [] parts = questionArray.split("[+*/]|(?<=\\s)-"); //Now break up the string using this regex. 
			                                              //This regex will find whatever Arithmetic sign 
			                                              //there is inside this String and store the result 
			                                              //in parts array.

			int firstNumber = Integer.parseInt(parts[0]); //The first number in the String
			int secondNumber = Integer.parseInt(parts[1]);//The second number in the String

			//a simple if-else statements that will help us find the final answer.
			int result = 0;
			if (sign.equals("+")){
			    result = firstNumber + secondNumber;
			    commandOutputArea.setForeground(Color.WHITE);
			    commandOutputArea.setText("COMMAND !+>   " + commandString + "\nMATH !+>     " + result);
			   
			}
			else if (sign.equals("-")) {
			    result = firstNumber - secondNumber;
			    commandOutputArea.setForeground(Color.WHITE);
			    commandOutputArea.setText("COMMAND !+>   " + commandString + "\nMATH !+>     " + result);
			} 
			else if(sign.equals("*")) {    
			    result = firstNumber * secondNumber;
			    commandOutputArea.setForeground(Color.WHITE);
			    commandOutputArea.setText("COMMAND !+>   " + commandString + "\nMATH !+>     " + result);
			}
			else if (sign.equals("/")){
			    result = firstNumber / secondNumber;
			    commandOutputArea.setForeground(Color.WHITE);
			    commandOutputArea.setText("COMMAND !+>   " + commandString + "\nMATH !+>     " + result);
			    
			}else {
				commandOutputArea.setForeground(Color.RED);
				commandOutputArea.setText("Operator not found!");
			}
		}
		else if (commandString.equals("mkfile")) {
			fileHandeler.fileMaker(commandArgs, commandOutputArea);
		}
		
		else if (commandString.equals("mkdir")) {
			fileHandeler.dirMaker(commandArgs, commandOutputArea);
		}
		
		else if (commandString.equals("editf")) {
//			fileHandeler.fileEditor();
			new FileEditor();
		}
		
		else {
			commandOutputArea.setForeground(Color.RED);
			commandOutputArea.setText("Invalid Command");
		}
	}

}
