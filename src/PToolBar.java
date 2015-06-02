
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;

public class PToolBar extends JToolBar 
{
	private static final long serialVersionUID = 1L;
	PListCommand comList = null;

	public PToolBar(PListCommand comList)
	{
		this.comList = comList;

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(comList.fileOpen);
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(comList.fileSave);
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(comList.editColor);
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(comList.editClear);

		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 15, 3);
		slider.setMajorTickSpacing(3); // ��������� ������ ����������, ����� ������� ����� ���������� ������� �������
		slider.setMinorTickSpacing(1); // ����������, ����� ������� ����� ���������� ��������� �������
		slider.setPaintTicks(true); // �������� ��� ��������� ���������� ���� �������
		slider.setPaintLabels(true); // �������� ��� ��������� ���������� ����� ��� �������� ���������.
		slider.setSnapToTicks(true); // �������� ��� ��������� ����������� �������� � ��������: ���� ������� ���� ����� � ���������� true, ������������ ������ ������� ��� ������ �������� ������ ��������, ��������������� ��������.
		slider.addChangeListener((ChangeListener) comList.editLine);

		add(btnOpen);
		add(btnSave);
		addSeparator();
		add(btnColor);
		add(btnClear);
		addSeparator();
		add(slider);
		addSeparator();
		addSeparator();
	}
}
