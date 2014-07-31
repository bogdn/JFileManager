package pl.edu.agh.JFileCommander.controller;

import java.awt.event.MouseAdapter;
import java.io.File;

import pl.edu.agh.JFileCommander.model.MyTableModel;
import pl.edu.agh.JFileCommander.views.MainWindow;


public class StartController {
	private MainWindow mainWindow;
	private MyTableModel myTableModel;
	
	public StartController(MainWindow mainWindow, MyTableModel myTableModel) {
		this.mainWindow = mainWindow;
		this.myTableModel = myTableModel;
		//starting listeners...
		FileClickMouseAdapter mouseAdapter = new FileClickMouseAdapter(mainWindow, myTableModel);
		mainWindow.addTableLeftMouseListener(mouseAdapter);
		mainWindow.addPreviousButtonListener(new PreviousButtonListener(mainWindow, myTableModel));
		CopyButtonListener copy = new CopyButtonListener(mouseAdapter);
		mainWindow.addCopyButtonListener(copy);
		mainWindow.addPasteButtonListener(new PasteButtonListener(mainWindow, myTableModel, copy));
	}
}
