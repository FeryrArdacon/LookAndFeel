import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UnsupportedLookAndFeelException;

public class Test
{
	
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException
	{
		LookAndFeel laf = new LookAndFeel();
		laf.setContol(Color.DARK_GRAY);
		laf.setLabel(Color.WHITE, null);
		// laf.setTextForeground(Color.WHITE);
		laf.setLookAndFeel();
		
		JFrame frame = new JFrame("Test");
		
		frame.setUndecorated(true);
		
		JProgressBar pb = new JProgressBar();
		pb.setValue(50);
		
		JComboBox<Object> cb = new JComboBox<Object>();
		cb.setToolTipText("Test ToolTip");
		
		cb.addItem("Hallo");
		cb.addItem("Test");
		
		frame.add(new JFrameTitlePanel(frame, false), BorderLayout.NORTH);
		frame.add(cb, BorderLayout.CENTER);
		frame.add(pb, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
