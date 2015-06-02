
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;
import javax.swing.event.MouseInputListener;

public class PPanel extends JPanel implements MouseInputListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	private int last_x, last_y;
	PData data = null;
	//--------PopupMenu------------------
	public JPopupMenu popup;
	//---------------------------------
	static Graphics2D graphics2D;

	public PPanel(PData data)
	{
		this.data = data;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		//---------------PopupMenu-------------------------------
		popup = new JPopupMenu();
		ActionListener menuListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				PData.color = JColorChooser.showDialog(null, "Color shoose", PData.color);
			}
		};
		JMenuItem item;
		popup.add(item = new JMenuItem("Color", new ImageIcon("1.gif")));
		item.setHorizontalTextPosition(JMenuItem.RIGHT);
		item.addActionListener(menuListener);
		popup.add(item = new JMenuItem("Vids1", new ImageIcon("2.gif")));
		item.setHorizontalTextPosition(JMenuItem.RIGHT);
		item.addActionListener(menuListener);
		popup.add(item = new JMenuItem("Vids5", new ImageIcon("3.gif")));
		item.setHorizontalTextPosition(JMenuItem.RIGHT);
		item.addActionListener(menuListener);
		popup.add(item = new JMenuItem("Vids10", new ImageIcon("4.gif")));
		item.setHorizontalTextPosition(JMenuItem.RIGHT);
		item.addActionListener(menuListener);
		popup.addSeparator();
		popup.add(item = new JMenuItem("Settings . . ."));
		item.addActionListener(menuListener);

		popup.setLabel("Justification");
		popup.setBorder(new BevelBorder(BevelBorder.RAISED));

		addMouseListener(new MousePopupListener());

	}
	//PopupMenu. An inner class to check whether mouse events are the popup trigger
	class MousePopupListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e) 
		{
			checkPopup(e);
		}

		public void mouseClicked(MouseEvent e)
		{
			checkPopup(e);
		}

		public void mouseReleased(MouseEvent e)
		{
			checkPopup(e);
		}

		private void checkPopup(MouseEvent e)
		{
			if (e.isPopupTrigger())
			{
				popup.show(PPanel.this, e.getX(), e.getY());
			}
		}
	}
	//------------------------------------------------------------------------
	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(data.image == null)
		{
			data.image = (BufferedImage) createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)data.image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//clear(); создаем белый цвет
			graphics2D.setPaint(Color.white);
			graphics2D.fillRect(0, 0, getSize().width, getSize().height);
			graphics2D.setPaint(Color.black);
			repaint();
		}
		last_x = e.getX();
		last_y = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		Graphics g = this.getGraphics();
		int x = e.getX();
		int y = e.getY();

		((Graphics2D) g).setStroke(new BasicStroke(data.size));  // толщина линии
		g.setColor(data.color);// цвет линии
		g.drawLine(last_x, last_y, x, y);// рисование линии по заданым координатам

		Graphics gi = data.image.getGraphics();
		((Graphics2D) gi).setStroke(new BasicStroke(data.size));  // толщина линии для чорного квадрата
		gi.setColor(data.color);// цвет линии
		gi.drawLine(last_x, last_y, x, y);// рисование линии

		last_x = x;
		last_y = y;		
	}

	@Override
	public void paint(Graphics g) 
	{
		g.drawImage(data.image, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
}
