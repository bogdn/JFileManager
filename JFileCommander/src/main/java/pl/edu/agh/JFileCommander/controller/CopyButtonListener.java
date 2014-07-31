package pl.edu.agh.JFileCommander.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;

public class CopyButtonListener implements ActionListener {
	private File fileToCopy;
	private FileClickMouseAdapter mouseAdapter;
	public CopyButtonListener(FileClickMouseAdapter mouseAdapter) {
		this.mouseAdapter = mouseAdapter;
	}

	public void actionPerformed(ActionEvent e) {
		fileToCopy = mouseAdapter.getClickedFile(); 
		System.out.println("Clicked file copy to safe: " + fileToCopy.getName());

	}

	public File getFileToCopy() {
		return fileToCopy;
	}
}
