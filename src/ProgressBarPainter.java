import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * Zeichnet die Regionen der ProressBar
 * 
 * @author Patrick
 *
 */
final class ProgressBarPainter extends AbstractLookAndFeelRegionPainter
{
	
	private Color fillColor, borderColor;
	
	/**
	 * Erzeugt einen ProgressBarPainter
	 * 
	 * @param fillColor
	 *            Farbe
	 * @param borderColor
	 *            Farb des Rahmen der ProgressBar
	 */
	public ProgressBarPainter(Color fillColor, Color borderColor)
	{
		super();
		this.fillColor = fillColor;
		this.borderColor = borderColor;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.plaf.nimbus.AbstractRegionPainter#doPaint()
	 */
	@Override
	public void doPaint(Graphics2D g, JComponent c, int width, int height,
			Object[] extendedCacheKeys)
	{
		this.setRenderingHints(g);
		
		if (this.borderColor != null)
		{
			g.setColor(this.borderColor.brighter().brighter());
			g.drawRoundRect(1, 1, width - 2, height - 2, 10, 10);
			g.setColor(this.borderColor);
			g.drawRoundRect(2, 2, width - 4, height - 4, 10, 10);
		}
		
		g.setColor(this.fillColor);
		g.fillRoundRect(3, 3, width - 5, height - 5, 10, 10);
	}
}
