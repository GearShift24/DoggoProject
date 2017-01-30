package grid.view;

import javax.swing.JFrame;
import grid.controller.GridController;
import java.awt.Dimension;

public class GridFrame extends JFrame
{

	private GridController baseController;
	private GridPanel appPanel;
	
	public GridFrame(GridController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new GridPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("DoggoFarm");
		this.setSize(new Dimension(1280,720));
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
