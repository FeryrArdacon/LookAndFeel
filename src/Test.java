import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UnsupportedLookAndFeelException;

public class Test
{

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException
	{
		LookAndFeel laf = new LookAndFeel();
		laf.setComboBox(Color.BLACK, Color.WHITE, null);
		laf.setToolTip(Color.WHITE, Color.DARK_GRAY, Color.BLACK, null);
		laf.setLookAndFeel();

		JFrame frame = new JFrame("Test");

		JProgressBar pb = new JProgressBar();
		pb.setValue(50);

		JComboBox<Object> cb = new JComboBox<Object>();
		cb.setToolTipText("Test ToolTip");

		frame.add(cb, BorderLayout.NORTH);
		frame.add(pb, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
