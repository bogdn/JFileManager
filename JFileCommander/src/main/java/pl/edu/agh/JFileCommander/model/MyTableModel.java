package pl.edu.agh.JFileCommander.model;

import java.io.File;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MyTableModel extends AbstractTableModel {

	private String path;
	private String[] columnNames = {"Name", "Size"};
	private Object[][] filesList;
	
	public MyTableModel(String path) {
		this.path = path;
		filesList = getFilesArrayWithSize(path);
		
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	public Object[][] getFilesArrayWithSize(String path) {
		File file = new File(path);
		File[] files = file.listFiles();
		
		Object[][] filesWithSize = new Object[files.length][2];
		
		
		for(int i=0; i<files.length; i++) {
				// Name column
				filesWithSize[i][0] = files[i];
				//length is <dir> if a File object is directory
				if(files[i].isDirectory())
					filesWithSize[i][1] = "<DIR>";
				else
					filesWithSize[i][1] = files[i].length();
		}
		
		return filesWithSize;
	}
	

	public Class<?> getColumnClass(int arg0) {
		return getValueAt(0, arg0).getClass();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	public String getColumnName(int arg0) {
		return columnNames[arg0];

	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return filesList.length;
	}

	public Object getValueAt(int arg0, int arg1) {
		
		return filesList[arg0][arg1];
	}

	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}


	public void setValueAt(Object arg0, int arg1, int arg2) {
		filesList[arg1][arg2] = arg0;
		
	}

}
