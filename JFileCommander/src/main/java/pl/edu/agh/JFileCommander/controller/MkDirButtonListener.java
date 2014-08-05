package pl.edu.agh.JFileCommander.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;

public class MkDirButtonListener implements ActionListener {
	private MainWindow view;
	private MyTableModel model;
	private String directoryName;

	public MkDirButtonListener(MainWindow view, MyTableModel model) {
		this.view = view;
		this.model = model;
		
	}

	public void actionPerformed(ActionEvent e) {
		directoryName = getDirectoryNameFromUser();
		Path newDir = Paths.get(model.getPath()+"/"+directoryName);
		try {
			Files.createDirectory(newDir);
		} catch (IOException e1) {
			System.err.println("Problems with create new directory");
			e1.printStackTrace();
		}
		view.setLeftTableModel(new MyTableModel(model.getPath()));

	}
	public String getDirectoryNameFromUser() {
		 String directoryName = JOptionPane.showInputDialog(view, "Please write new directory name", "New Folder");
		 return directoryName;
	}

}
