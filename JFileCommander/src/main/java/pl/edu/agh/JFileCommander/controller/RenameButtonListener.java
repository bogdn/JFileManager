package pl.edu.agh.JFileCommander.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JOptionPane;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;

public class RenameButtonListener implements ActionListener {
	private FileClickMouseAdapter mouseAdapter;
	private MainWindow view;
	private MyTableModel model;
	
	public RenameButtonListener(FileClickMouseAdapter mouseAdapter, MainWindow view, MyTableModel model) {
		this.mouseAdapter = mouseAdapter;
		this.view = view;
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent e) {
		Path source = mouseAdapter.getClickedFile().toPath();
		String newName = getNewFileNameFromUser();
		try {
			Files.move(source, source.resolveSibling(newName));
		} catch (IOException e1) {
			System.err.println("Problems with renaming");
			e1.printStackTrace();
		}
		view.setLeftTableModel(new MyTableModel(model.getPath()));
	}
		
	private String getNewFileNameFromUser() {
		String newName = JOptionPane.showInputDialog(view, "Please write new name", "New Name Here");
		return newName;
	}

}
