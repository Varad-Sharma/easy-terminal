package com.larka.main;

import java.awt.EventQueue;


public class Main {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> new MainWindow());
		
		MainWindow mainWindow = new MainWindow();
			
	}

}
