import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class ComboBoxBackgroundPainter extends AbstractLookAndFeelRegionPainter
{
	private Color fillColor, borderColor, arrowAreaColor;
	
	public ComboBoxBackgroundPainter(Color fillColor, Color borderColor,
			Color arrowAreaColor)
	{
		super();
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.arrowAreaColor = arrowAreaColor;
	}
	
	@Override
	protected void doPaint(Graphics2D g, JComponent c, int width, int height,
			Object[] extendedCacheKeys)
	{
		this.setRenderingHints(g);
		
		this.paintBorder(g, width, height);
		this.paintBackground(g, width, height);
		this.paintArrowArea(g, width, height);
	}
	
	private void paintBackground(Graphics2D g, int width, int height)
	{
		g.setColor(this.fillColor);
		g.fillRoundRect(3, 3, width - 5, height - 5, 10, 10);
	}
	
	private void paintBorder(Graphics2D g, int width, int height)
	{
		g.setColor(this.borderColor.brighter().brighter());
		g.drawRoundRect(1, 1, width - 2, height - 2, 10, 10);
		g.setColor(this.borderColor);
		g.drawRoundRect(2, 2, width - 4, height - 4, 10, 10);
	}
	
	private void paintArrowArea(Graphics2D g, int width, int height)
	{
		g.setColor(this.arrowAreaColor);
		g.fillRoundRect(width - 20, 3, 18, height - 5, 10, 10);
		g.fillRect(width - 20, 3, 5, height - 5);
		
		g.setColor(this.borderColor);
		g.drawLine(width - 20, 3, width - 20, height - 3);
	}
}
