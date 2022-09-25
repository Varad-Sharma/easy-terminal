package com.larka.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.larka.commandInput.CommandInputMannager;

public class MainWindow implements ActionListener{
	public static JFrame mainFrame = new JFrame();
	public static JLabel lableJLabel = new JLabel("$->Test"); 
	public static Font defaultFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	public static JTextArea outputTextArea = new JTextArea();
	public static Color defaultPanelColor = new Color(0x2b2a2a);
	public static Color defaultElementColor = new Color(0x141414);
	
	public static JPanel outputPanel = new JPanel(),//Panel for command in put and success out put- center
			inputPanel = new JPanel(),//Panel for input of command- south
			dateTimeMenuPanel = new JPanel(),//Panel for date, time & menu display- north
			currentDirPanel = new JPanel();//Panel for current working directory- West 
	
	public static JButton fileButton = new JButton("FILE"),
			editButton = new JButton("EDIT"),
			windowButton = new JButton("WINDOW"),
			helpButton = new JButton("HELP");
	
	public MainWindow() {
		
		CommandInputMannager commandMannager = new CommandInputMannager();
		
		windowSpawner();
		
		buttonCSS(fileButton);
		buttonCSS(editButton);
		buttonCSS(windowButton);
		buttonCSS(helpButton);
		
		lableJLabel.setFont(defaultFont);
		lableJLabel.setForeground(Color.WHITE);
		
		outputPanel.setBackground(defaultPanelColor);
		inputPanel.setBackground(defaultPanelColor);
		dateTimeMenuPanel.setBackground(defaultPanelColor);
		currentDirPanel.setBackground(defaultPanelColor);
		
		outputPanel.setPreferredSize(new Dimension(100, 100));
		inputPanel.setPreferredSize(new Dimension(100, 100));
		dateTimeMenuPanel.setPreferredSize(new Dimension(100, 50));
		currentDirPanel.setPreferredSize(new Dimension(200, 100));
		
		outputTextArea.setEditable(false);
//		outputTextArea.setPreferredSize(new Dimension(outputPanel.getPreferredSize()));
		outputTextArea.setPreferredSize(new Dimension(outputPanel.getWidth(), (outputPanel.getHeight()-15)));
		outputTextArea.setBackground(defaultElementColor);
		outputTextArea.setFont(defaultFont);
		outputTextArea.setForeground(Color.WHITE);
		outputTextArea.setBorder(BorderFactory.createLineBorder(new Color(0x736d6d), 2));
		
		outputPanel.setLayout(new BorderLayout());
		outputPanel.add(commandMannager.indicatorLabel, BorderLayout.NORTH);
		outputPanel.add(outputTextArea, BorderLayout.CENTER);
//		outputPanel.add(lableJLabel);
		
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(commandMannager.argInputTextField, BorderLayout.CENTER);
		inputPanel.add(commandMannager.commandInputFeild, BorderLayout.WEST);
		inputPanel.add(commandMannager.submitCommandButton, BorderLayout.EAST);
		
		dateTimeMenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		dateTimeMenuPanel.add(fileButton);
		dateTimeMenuPanel.add(editButton);
		dateTimeMenuPanel.add(windowButton);
		dateTimeMenuPanel.add(helpButton);
		
		MainWindow.mainFrame.add(outputPanel, BorderLayout.CENTER);
		MainWindow.mainFrame.add(inputPanel, BorderLayout.SOUTH);
		MainWindow.mainFrame.add(dateTimeMenuPanel, BorderLayout.NORTH);
		MainWindow.mainFrame.add(currentDirPanel, BorderLayout.WEST);
		
//		windowSpawner();
	}
	
	public void windowSpawner() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000, 600);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setTitle("Easy Terminal (Project Larka)  -Discontinued");
		mainFrame.getContentPane().setBackground(new Color(0x474747));
		mainFrame.setLayout(new BorderLayout(5,5));
		mainFrame.setVisible(true);
	}
	
	public void buttonCSS(JButton button) {
		button.setBackground(MainWindow.defaultElementColor);
		button.setForeground(Color.WHITE);
		button.setPreferredSize(new Dimension(100, 25));
		button.addActionListener(this);
		button.setFocusable(false);
	}
	
	public JFrame buttonPaneSpawner(String frameName) {
		JFrame fileFrame = new JFrame();
		fileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fileFrame.setSize(300, 600);
//		fileFrame.setPreferredSize(new Dimension(300, 600));
		fileFrame.getContentPane().setBackground(defaultPanelColor);
		fileFrame.setTitle(frameName);
		fileFrame.setVisible(true);
		return fileFrame;
		
	}
	//Discontinued Idea-Dropdown pane for options window


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fileButton) {
			buttonPaneSpawner("File Options");
			
		}
		else if (e.getSource() == editButton) {
			buttonPaneSpawner("Edit Options");
		}
		else if (e.getSource() == windowButton) {
			buttonPaneSpawner("Window options");
		}
		else if (e.getSource() == helpButton) {
			buttonPaneSpawner("Help options");
		}
	}
}
