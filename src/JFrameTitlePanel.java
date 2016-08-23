import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.awt.WindowClosingListener;

/**
 * @author Patrick
 *
 */
public class JFrameTitlePanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7956111686878391840L;
	
	private JButton min = new JButton("_"), windowModus = new JButton("WM"),
			fullscreenModus = new JButton("FM"), exit = new JButton("X");
	private JLabel title = new JLabel("New Application");
	private Window window;
	
	public JFrameTitlePanel(Window owner, boolean isDialog)
	{
		this.window = owner;
		this.createPanel();
	}
	
	private void createPanel()
	{
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbcLabel, gbcButtons;
		JPanel panelButtons = new JPanel(new GridLayout(1, 3)), panelMin = new JPanel(
				new GridLayout(1, 1)), panelModus = new JPanel(new GridLayout(
				1, 1)), panelExit = new JPanel(new GridLayout(1, 1));
		ButtonListener buttonListener = new ButtonListener();
		MouseMovement mouseMovement = new MouseMovement();
		
		gbcLabel = new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(5,
						5, 5, 5), 0, 0);
		gbcButtons = new GridBagConstraints(1, 0, 1, 1, 0, 0,
				GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(5,
						5, 5, 5), 0, 0);
		
		panelButtons.add(panelMin);
		panelButtons.add(panelModus);
		panelButtons.add(panelExit);
		
		panelMin.add(this.min);
		panelModus.add(this.fullscreenModus);
		panelExit.add(this.exit);
		
		this.min.addActionListener(buttonListener);
		this.windowModus.addActionListener(buttonListener);
		this.fullscreenModus.addActionListener(buttonListener);
		this.exit.addActionListener(buttonListener);
		
		this.title.addMouseListener(mouseMovement);
		this.title.addMouseMotionListener(mouseMovement);
		
		this.addMouseListener(mouseMovement);
		this.addMouseMotionListener(mouseMovement);
		this.add(this.title, gbcLabel);
		this.add(panelButtons, gbcButtons);
	}
	
	private class ButtonListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource().equals(JFrameTitlePanel.this.min))
			{
				
			}
			if (e.getSource().equals(JFrameTitlePanel.this.windowModus))
			{
				
			}
			if (e.getSource().equals(JFrameTitlePanel.this.fullscreenModus))
			{
				
			}
			if (e.getSource().equals(JFrameTitlePanel.this.exit))
			{
				System.exit(0);
			}
		}
		
	}
	
	private class MouseMovement implements MouseListener, MouseMotionListener
	{
		private boolean pressed = false;
		private int posX, posY;
		
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			this.pressed = true;
			this.posX = arg0.getX();
			this.posY = arg0.getY();
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0)
		{
			// this.pressed = false;
		}
		
		@Override
		public void mousePressed(MouseEvent arg0)
		{
			this.pressed = true;
			this.posX = arg0.getX();
			this.posY = arg0.getY();
		}
		
		@Override
		public void mouseReleased(MouseEvent arg0)
		{
			// this.pressed = false;
		}
		
		@Override
		public void mouseDragged(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseMoved(MouseEvent arg0)
		{
			if (this.pressed)
			{
				JFrameTitlePanel.this.window.setLocation(
						JFrameTitlePanel.this.window.getLocation().x
								+ (this.posX - arg0.getX()),
						JFrameTitlePanel.this.window.getLocation().y
								+ (this.posY - arg0.getY()));
				this.posX = arg0.getX();
				this.posY = arg0.getY();
			}
		}
		
	}
	
	private class WindowActions implements WindowClosingListener
	{
		
		@Override
		public RuntimeException windowClosingDelivered(WindowEvent arg0)
		{
			System.exit(0);
			return null;
		}
		
		@Override
		public RuntimeException windowClosingNotify(WindowEvent arg0)
		{
			System.exit(0);
			return null;
		}
		
	}
}
