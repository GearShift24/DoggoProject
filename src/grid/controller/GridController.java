package grid.controller;

import javax.swing.JOptionPane;
import grid.view.GridFrame;
import grid.model.*;


public class GridController 
{
	private GridFrame appFrame;
	private Doggo [][] grid;
	
	public GridController()
	{
		//make model objects here
		
	
		grid = new Doggo[6][5];
		fillGrid();
		appFrame = new GridFrame(this);
		//or
		grid[0][2] = new Doggo();
	}
	
	public void start()
	{
		JOptionPane.showMessageDialog(appFrame, "Welcome to my doggo park, hope you like doggos :D!!");
	}
	
	private void fillGrid()
	{
		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[0].length; col++)
			{
				grid[row][col] = new Doggo();
			}
		}
	}
	
	public Doggo[][] getGrid()
	{
		return grid;
	}
	
	public GridFrame getFrame()
	{
		return appFrame;
	}
	
	
}
