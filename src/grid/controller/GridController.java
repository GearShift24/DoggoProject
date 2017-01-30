package grid.controller;

import javax.swing.JOptionPane;
import grid.view.GridFrame;
import grid.model.*;
import java.util.ArrayList;

public class GridController 
{
	private GridFrame appFrame;
	
	public GridController()
	{
		//make model objects here
		
		appFrame = new GridFrame(this);
		
	}
	
	public void start()
	{
		JOptionPane.showMessageDialog(appFrame, "hi bois");
	}
	
}
