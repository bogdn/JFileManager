package pl.edu.agh.JFileCommander.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import fileVisitors.CopyFileVisitor;
import fileVisitors.DeleteFileVisitor;
import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;

public class PasteButtonListener implements ActionListener {
	private MainWindow view;
	private CopyButtonListener copy;
	private MyTableModel model;
	private CopyFileVisitor copyVisitor;

	public PasteButtonListener(MainWindow view, MyTableModel model,
			CopyButtonListener copy) {
		this.view = view;
		this.copy = copy;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		Path source = copy.getFileToCopy().toPath();
		Path targetTemp = Paths.get(model.getPath());
		Path target = targetTemp.resolve(source.getFileName());
		copyVisitor = new CopyFileVisitor(source, target); 
		
		if(Files.isDirectory(source)) {
			try {
				Files.walkFileTree(source, copyVisitor);
				if(copy.isCutOption()) {
					Files.walkFileTree(source, new DeleteFileVisitor());
					
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		else if(source != null) {
			System.out.println(model.getPath());
			try {
				System.out.println(source);
				Files.copy(source, targetTemp.resolve(source.getFileName()));
				if(copy.isCutOption()) {
					Files.delete(source);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		view.setLeftTableModel(new MyTableModel(model.getPath())); // refresh table
	}
}
