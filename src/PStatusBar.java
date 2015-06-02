import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PStatusBar extends JPanel 
{
	private static final long serialVersionUID = 1L;
	public PStatusBar()
	{
		JLabel status = new JLabel("Paint  |  Created by Havryliuk Serhii"); //Строка статуса
		add(status,BorderLayout.SOUTH); //Добавляем стоку статуса на панель
	}
}
