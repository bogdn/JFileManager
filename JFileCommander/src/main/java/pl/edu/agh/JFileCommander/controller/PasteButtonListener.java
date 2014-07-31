package pl.edu.agh.JFileCommander.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;

public class PasteButtonListener implements ActionListener {
	private MainWindow view;
	private CopyButtonListener copy;
	private MyTableModel model;
	public PasteButtonListener(MainWindow view, MyTableModel model, CopyButtonListener copy) {
		this.view = view;
		this.copy = copy;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		Path source = copy.getFileToCopy().toPath();
		Path target = Paths.get(model.getPath());
		
		System.out.println(model.getPath());
		try {
			Files.copy(source, target.resolve(source.getFileName()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		view.setLeftTableModel(new MyTableModel(model.getPath()));

	}

}
