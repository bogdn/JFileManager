package pl.edu.agh.JFileCommander.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;
import fileVisitors.DeleteFileVisitor;

public class DeleteButtonListener implements ActionListener {
	private FileClickMouseAdapter mouseAdapter;
	private MainWindow view;
	private MyTableModel model;
	public DeleteButtonListener(FileClickMouseAdapter mouseAdapter, MainWindow view, MyTableModel model ) {
		this.mouseAdapter = mouseAdapter;
		this.view = view;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		Path fileToDelete = mouseAdapter.getClickedFile().toPath();
		if(Files.isDirectory(fileToDelete)) {
			DeleteFileVisitor visitor = new DeleteFileVisitor();
			try {
				Files.walkFileTree(fileToDelete, visitor);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else {
			try {
				Files.delete(fileToDelete);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		view.setLeftTableModel(new MyTableModel(model.getPath()));
		
	}

}
