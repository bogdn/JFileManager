package pl.edu.agh.JFileCommander.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JTable;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;

public class FileClickMouseAdapter extends MouseAdapter {
	private MainWindow view;
	private MyTableModel model;
	private File clickedFile;
	public FileClickMouseAdapter(MainWindow view, MyTableModel model ) {
		this.view = view;
		this.model = model;
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		JTable table = (JTable) e.getSource();
		Point p = e.getPoint();
		int row = table.rowAtPoint(p);
		Object value = table.getValueAt(row, 0);
		File fileFromTable = (File) value;
		clickedFile = fileFromTable;
		System.out.println(fileFromTable.getName());
		
		if (e.getClickCount() == 2) {

			view.setLeftTableModel(new MyTableModel(fileFromTable.getAbsolutePath()));
			model.setPath(fileFromTable.getAbsolutePath());
		}

	}


	public File getClickedFile() {
		return clickedFile;
	}
}
