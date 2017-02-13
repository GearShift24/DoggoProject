package grid.view;

import javax.swing.*;
import grid.controller.GridController;
import grid.model.Doggo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.*;


public class GridPanel extends JPanel 
{

	private JTextField rowField;
	private JTextField columnField;
	private JTextField inputField;
	private JLabel inputLabel;
	private JLabel rowLabel;
	private JLabel columnLabel;
	private JButton submitButton;
	private SpringLayout baseLayout;
	private GridController baseController;
	
	private JTable gridTable;
	private JScrollPane gridPane;
	
	public GridPanel(GridController baseController)
	{
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.rowField = new JTextField(5);
		this.columnField = new JTextField(5);
		this.inputField = new JTextField(5);
		
		this.submitButton = new JButton("CLICK TO GET DOGGO");
		
		this.inputLabel = new JLabel("input: ");
		this.rowLabel = new JLabel("row: ");
		this.columnLabel = new JLabel("col:");
		
		
		
		setupTable();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupTable()
	{
		DefaultTableModel data = new DefaultTableModel(baseController.getGrid(), new String []{"one", "two", "three", "four", "five"});
		gridTable = new JTable();
		gridTable.setModel(data);
		gridPane = new JScrollPane();
		gridPane.setViewportView(gridTable);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(1024, 576));
		rowField.setEditable(true);
		columnField.setEditable(true);
		inputField.setEditable(true);
		this.setBackground(Color.CYAN);
		
		this.add(rowField);
		this.add(columnField);
		this.add(inputField);
		this.add(inputLabel);
		this.add(rowLabel);
		this.add(columnLabel);
		this.add(submitButton);

		this.add(gridPane);
		this.add(columnField);
		
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, rowField, -260, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rowField, 41, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rowField, -231, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, rowField, 140, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, columnLabel, 0, SpringLayout.WEST, rowLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, columnLabel, -6, SpringLayout.NORTH, columnField);
		baseLayout.putConstraint(SpringLayout.NORTH, columnField, 37, SpringLayout.SOUTH, rowField);
		baseLayout.putConstraint(SpringLayout.WEST, columnField, 0, SpringLayout.WEST, rowField);
		baseLayout.putConstraint(SpringLayout.SOUTH, columnField, 66, SpringLayout.SOUTH, rowField);
		baseLayout.putConstraint(SpringLayout.EAST, columnField, 0, SpringLayout.EAST, rowField);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, -91, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 162, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -42, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, 432, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, -36, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 102, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, 0, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, 318, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.NORTH, inputLabel, -34, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, inputLabel, 262, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputLabel, -7, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, inputLabel, 332, SpringLayout.WEST, this);
		inputLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		baseLayout.putConstraint(SpringLayout.WEST, rowLabel, 77, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rowLabel, -6, SpringLayout.NORTH, rowField);
		baseLayout.putConstraint(SpringLayout.NORTH, gridPane, 34, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, gridPane, 0, SpringLayout.WEST, inputLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, gridPane, -24, SpringLayout.NORTH, inputLabel);
		baseLayout.putConstraint(SpringLayout.EAST, gridPane, -138, SpringLayout.EAST, this);
		
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent selection) {
				if(isValidInteger(rowField.getText()) && isValidInteger(columnField.getText()))
				{ 
					
					
					String index = rowField.getText();
					
					String index2 = columnField.getText();
					
					int rowIndex = Integer.parseInt(index);
					
					int colIndex = Integer.parseInt(index2);
					
					
					
					String dog = inputField.getText();
					gridTable[rowIndex][colIndex] = dog;
					
//					 grid[][] = [rowField.getText()][columnField.getText()];
				}
			}
				});
		
		
		
		
//		rol col valid numb, call control to model like pokemon
		
		
		
	}
	
	private boolean isValidInteger(String input) {
		boolean isValid = false;
		try {
			Integer.parseInt(input);
			isValid = true;
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(this, "Pokemon needs an int with a valid length");
		}
		return isValid;}
	
	
	
	
	public GridController getBaseController()
	{
		return baseController;
	}
}
