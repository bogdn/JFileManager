package pl.edu.agh.JFileCommander.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import pl.edu.agh.JFileCommander.controller.FileClickMouseAdapter;
import pl.edu.agh.JFileCommander.controller.StartController;
import pl.edu.agh.JFileCommander.model.MyTableModel;

public class MainWindow extends JFrame {
	private JTable tableLeft;
	private MyTableModel myTableModel;
	private JButton previousButton;
	private JButton copyButton;
	private JButton cutButton;
	private JButton pasteButton;
	private JPanel commanderPanel;
	
	
	
	public MainWindow(MyTableModel myTableModel) {
		super("JFileCommander");
		this.myTableModel = myTableModel;

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800, 600));
		
		commanderPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 4;
		
		add(commanderPanel, BorderLayout.CENTER);
		
		//  to show friendly name in table used TableCellRenderer
		final TableCellRenderer renderer = new FileNameRenderer();
		tableLeft = new JTable(myTableModel) {
			public TableCellRenderer getCellRenderer(int row, int column) {
				if ((column == 0)) {
					return renderer;
				}
				// else...
				return super.getCellRenderer(row, column);
			}

		};
		
		JScrollPane scrollPane = new JScrollPane(tableLeft);
		tableLeft.setFillsViewportHeight(true);
		commanderPanel.add(scrollPane, c);;
		
		// buttons in commanderPanel
		previousButton = new JButton("PREV");
		c.gridwidth = 1; //reset to default
		c.ipadx = 40;
		c.gridy = 1;
		commanderPanel.add(previousButton, c);
		
		copyButton = new JButton("COPY");
		c.insets = new Insets(0, 6, 0, 0); // space beetween buttons
		c.gridx =2;
		commanderPanel.add(copyButton, c);
		
		cutButton = new JButton("CUT");
		c.gridx =3;
		commanderPanel.add(cutButton, c);
		
		pasteButton = new JButton("PASTE");
		c.gridx =4;
		commanderPanel.add(pasteButton, c);

		pack();

	}
	public void setLeftTableModel(MyTableModel model) {
		tableLeft.setModel(model);
	}
	public void addTableLeftMouseListener(MouseAdapter mouseAdapter) {
		tableLeft.addMouseListener(mouseAdapter);
	}
	public void addPreviousButtonListener(ActionListener al) {
		previousButton.addActionListener(al);
	}
	public void addCopyButtonListener(ActionListener al) {
		copyButton.addActionListener(al);
	}
	public void addPasteButtonListener(ActionListener al) {
		pasteButton.addActionListener(al);
	}
	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				
				MyTableModel tableModel = new MyTableModel("/");
				MainWindow mainWindow = new MainWindow(tableModel);
				StartController controller = new StartController(mainWindow, tableModel );
			}
		});
	}

	

}
