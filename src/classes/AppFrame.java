package classes;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame{

	private ButtonPanel btnPannel;
	private TitleBar title;
	private List list;
	private JButton addTask;
	private JButton clear;
		
	
	//Constructor
	AppFrame()
	{
		title = new TitleBar();									//Assigne and call constructors
		list = new List();										//Assigne and call constructors
		btnPannel = new ButtonPanel();							//Assigne and call constructors
		
		this.setSize(400,700);									//set frame dimension px*px
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//
		this.setVisible(true);									// is visible?
		
		
		this.add(title, BorderLayout.NORTH);					//add title bar to AppFrame
		this.add(btnPannel, BorderLayout.SOUTH);				//add btnPanel bar to AppFrame
		this.add(list, BorderLayout.CENTER);						//add list bar to AppFrame
		
		addTask = btnPannel.getAddTask();
		clear = btnPannel.getClear();
		
		addListeners();
		
	}

	public void addListeners()
	{
		addTask.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				Task task = new Task();
				list.add(task);
				list.updateNumbers();
				
				
				task.getDone().addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent e)
					{
						
						task.chageState();
						list.updateNumbers();
						revalidate();
						
					}
				});
			}
			
		});
		
		
		clear.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				list.removeCompletedTasks();
				repaint();
			}
		});
	}	
	
}