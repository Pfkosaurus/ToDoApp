package classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class List extends JPanel {
	
	//Constructor
	List()
	{
		GridLayout layout = new GridLayout(10,1);			//Create 10 rows with 1 collumns
		layout.setVgap(5);									//Create gap bwtween rows with 5px gap
		this.setLayout(layout);
		this.setBackground((Color.BLUE));
		}
	
	
	public void updateNumbers()
	{
		Component[] listItems = this.getComponents();
		for(int i = 0; i < listItems.length; i++)
		{
			if (listItems[i] instanceof Task)
			{
				((Task)listItems[i]).changeIndex(i+1);
			}
		}
	}
	
	public void removeCompletedTasks()
	{
		
		for(Component c : getComponents())
		{
			if(c instanceof Task)
			{
				if(((Task)c).getState())
				{
					remove(c);
					updateNumbers();
				}
			}
		}
		
	}
}
