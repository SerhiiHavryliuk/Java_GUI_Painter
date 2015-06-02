
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public PFrame()
	{
		setBounds(5, 5, 500, 550);
		setTitle("Paint");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		PData data = new PData();
		PPanel pp = new PPanel(data);
		PListCommand comList = new PListCommand(pp);
		comList.data = data;

		PMenu pm = new PMenu(comList);
		PToolBar pb = new PToolBar(comList);

		PStatusBar ps = new PStatusBar();

		this.setJMenuBar(pm);
		this.add(pb, BorderLayout.PAGE_START);
		this.add(pp, BorderLayout.CENTER);

		this.add(ps, BorderLayout.SOUTH);

		setVisible(true);
	}
}

