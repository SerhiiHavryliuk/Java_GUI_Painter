
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PListCommand 
{
	PData data = null;
	PPanel panel = null;

	public EditColor editColor = new EditColor();
	public FileSave fileSave = new FileSave();
	public FileOpen fileOpen = new FileOpen();
	public EditLine editLine = new EditLine();
	public vids1 vids1 = new vids1();
	public vids5 vids5 = new vids5();
	public vids10 vids10 = new vids10();
	public FileExit fileExit = new FileExit();
	public EditClear editClear = new EditClear();

	public PListCommand(PPanel panel)
	{
		this.panel = panel;
	}

	// --------------Clear-----------------
	class EditClear implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
		}
	}

	// выбор толщины линии через ползунок
	class EditLine implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e) 
		{
			JSlider source = (JSlider)e.getSource();
			data.size = source.getValue();
		}
	}

	// выбор цвете через диалог
	class EditColor implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.color = JColorChooser.showDialog(null, "Color shoose", data.color);
		}
	}

	// действие открыть фаил
	class FileOpen implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//-----------фильтры-------------
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(panel);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				System.out.println("You chose to open this file: " +
						chooser.getSelectedFile().getName());
			}
			//--------------------------------
			JFileChooser fc = new JFileChooser();
			if( JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null) )
			{
				File fname = fc.getSelectedFile();
				try 
				{
					data.image = ImageIO.read(fname);
					panel.repaint();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}

	// действие сохранить фаил
	class FileSave implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser fc = new JFileChooser();
			if( JFileChooser.APPROVE_OPTION == fc.showSaveDialog(null) )
			{
				File fname = fc.getSelectedFile();
				try 
				{
					ImageIO.write(data.image,"png", fname);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}

	// выбор толщины линии размером 1
	class vids1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.size = 1;
		}
	}
	// выбор толщины линии размером 5
	class vids5 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.size = 5;
		}
	}
	// выбор толщины линии размером 10
	class vids10 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.size = 10;
		}
	}

	// выход из программы
	class FileExit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
	}
}
