import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

public class Test
{
	
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException
	{
		LookAndFeel laf = new LookAndFeel();
		laf.setLookAndFeel();
		
		JFrame frame = new JFrame("Test");
		
		// frame.setUndecorated(true);
		
		JProgressBar pb = new JProgressBar();
		pb.setValue(50);
		
		JComboBox<Object> cb = new JComboBox<Object>();
		cb.setToolTipText("Test ToolTip");
		
		cb.addItem("Hallo");
		cb.addItem("Test");
		
		frame.add(cb, BorderLayout.CENTER);
		frame.add(pb, BorderLayout.NORTH);
		frame.add(new JTextField(), BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
