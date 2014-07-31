package pl.edu.agh.JFileCommander.views;

import java.io.File;

import javax.swing.table.DefaultTableCellRenderer;

class FileNameRenderer extends DefaultTableCellRenderer {

	public FileNameRenderer() {
		super();
	}
	
	public void setValue(Object value) {
			File file = (File) value;
			setText((value == null) ? "" : file.getName());
	}
}
