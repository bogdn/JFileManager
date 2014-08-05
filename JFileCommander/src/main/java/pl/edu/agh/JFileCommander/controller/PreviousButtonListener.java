package pl.edu.agh.JFileCommander.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;

public class PreviousButtonListener implements ActionListener {
	private MainWindow view;
	private MyTableModel model;
	
	public PreviousButtonListener(MainWindow view, MyTableModel model) {
		this.view = view;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		File file = new File(model.getPath());
		String previusPath = file.getParent();
		System.out.println(previusPath);
		view.setLeftTableModel(new MyTableModel(previusPath));
		model.setPath(previusPath);
		view.setCurrentPathLabel(model.getPath());

	}

}
