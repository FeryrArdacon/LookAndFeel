import java.awt.Color;
import java.awt.GradientPaint;
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
	private boolean gradient = false;
	
	/**
	 * Erzeugt einen ProgressBarPainter
	 * 
	 * @param fillColor
	 *            Farbe
	 * @param borderColor
	 *            Farb des Rahmen der ProgressBar
	 * @param gradient
	 *            Linearer horizontaler gradient
	 */
	public ProgressBarPainter(Color fillColor, Color borderColor,
			boolean gradient)
	{
		super();
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.gradient = gradient;
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
		Color darkerFillColor = new Color(this.fillColor.getRed() - 10 < 0 ? 0
				: this.fillColor.getRed() - 10,
				this.fillColor.getGreen() - 10 < 0 ? 0 : this.fillColor
						.getGreen() - 10, this.fillColor.getBlue() - 10 < 0 ? 0
						: this.fillColor.getBlue() - 10), brighterFillColor = new Color(
				this.fillColor.getRed() + 10 > 255 ? 255
						: this.fillColor.getRed() + 10,
				this.fillColor.getGreen() + 10 > 0 ? 255 : this.fillColor
						.getGreen() + 10,
				this.fillColor.getBlue() + 10 > 0 ? 255 : this.fillColor
						.getBlue() + 10);
		this.setRenderingHints(g);
		
		if (this.borderColor != null)
		{
			g.setColor(this.borderColor.brighter().brighter());
			g.drawRoundRect(1, 1, width - 2, height - 2, 10, 10);
			g.setColor(this.borderColor);
			g.drawRoundRect(2, 2, width - 4, height - 4, 10, 10);
		}
		
		GradientPaint gp = new GradientPaint(width / 2, 0, brighterFillColor,
				width / 2, height, darkerFillColor);
		if (gradient)
			g.setPaint(gp);
		else
			g.setColor(this.fillColor);
		g.fillRoundRect(3, 3, width - 5, height - 5, 10, 10);
	}
}
