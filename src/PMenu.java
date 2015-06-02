
import java.awt.Event;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class PMenu extends JMenuBar 
{
	private static final long serialVersionUID = 1L;
	PListCommand comList = null;

	public PMenu(PListCommand comList)
	{
		this.comList = comList;

		// Создаем вкладки File, Edit, View, Help
		JMenu mnuFile = new JMenu("File");
		JMenu mnuEdit = new JMenu("Edit");
		JMenu mnuView = new JMenu("View");
		JMenu mnuHelp = new JMenu("Help");

		// Создаем подменю для File >  Open, Save, Exit 
		JMenuItem mnuFileOpen = new JMenuItem("Open");
		mnuFileOpen.addActionListener(comList.fileOpen);
		JMenuItem mnuFileSave = new JMenuItem("Save");
		mnuFileSave.addActionListener(comList.fileSave);
		JMenuItem mnuFileExit = new JMenuItem("Exit");
		mnuFileExit.addActionListener(comList.fileExit);

		// добавляем в File в той очерёдности которая нам нужна
		mnuFile.add(mnuFileOpen);
		mnuFile.add(mnuFileSave);
		mnuFile.addSeparator(); // разделительная линия
		mnuFile.add(mnuFileExit);

		// Создаем подменю для Edit >  Color, Vids > Vids1, Vids5, Vids10
		JMenuItem mnuEditColor = new JMenuItem("Color");
		mnuEditColor.addActionListener(comList.editColor);
		JMenu mnuVids = new JMenu("Vids");
		JMenuItem vids1 = new JMenuItem("Vids1");
		vids1.addActionListener(comList.vids1);
		JMenuItem vids5 = new JMenuItem("Vids5");
		vids5.addActionListener(comList.vids5);
		JMenuItem vids10 = new JMenuItem("Vids10");
		vids10.addActionListener(comList.vids10);

		mnuVids.add(vids1);
		mnuVids.add(vids5);
		mnuVids.add(vids10);

		mnuEdit.add(mnuEditColor);
		mnuEdit.add(mnuVids);

		//	add(newMenu);
		add(mnuFile);
		add(mnuEdit);
		add(mnuView);
		add(mnuHelp);

		//Добавляем "горячею клавишу для выбора цвета цвета"
		mnuEditColor.setAccelerator(KeyStroke.getKeyStroke('C',Event.CTRL_MASK));
		mnuFileOpen.setAccelerator(KeyStroke.getKeyStroke('O',Event.CTRL_MASK));
		mnuFileSave.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK));
	}
}
