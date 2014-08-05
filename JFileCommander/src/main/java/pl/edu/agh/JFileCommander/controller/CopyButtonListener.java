package pl.edu.agh.JFileCommander.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;

public class CopyButtonListener implements ActionListener {
	private File fileToCopy;
	private FileClickMouseAdapter mouseAdapter;
	private boolean cutOption;
	

	public CopyButtonListener(FileClickMouseAdapter mouseAdapter) {
		this.mouseAdapter = mouseAdapter;
	}

	public void actionPerformed(ActionEvent e) {
		fileToCopy = mouseAdapter.getClickedFile(); 
		System.out.println("Clicked file copy to safe: " + fileToCopy);
		JButton checkButton = (JButton) e.getSource();
		
		if(checkButton.getActionCommand().equals("CUT")) {
			cutOption = true;
			System.out.println("cut option");
		}
		
		else
			cutOption = false;
	}

	public File getFileToCopy() {
		return fileToCopy;
	}
	
	public boolean isCutOption() {
		return cutOption;
	}
}
