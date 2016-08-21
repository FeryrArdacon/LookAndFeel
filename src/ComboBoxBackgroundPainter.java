import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * Zeichnet den ComboBox-Hintergrund
 * 
 * @author Patrick
 *
 */
public class ComboBoxBackgroundPainter extends AbstractLookAndFeelRegionPainter
{
	private Color fillColor, borderColor, arrowAreaColor;
	
	/**
	 * Erzeugt einen ComboBoxBackgroundPainter
	 * 
	 * @param fillColor
	 *            Farbe des Hintergrunds
	 * @param borderColor
	 *            Farbe des Rahmens der ComboBox
	 * @param arrowAreaColor
	 *            Hintergrundfarbe des Aufklapp-Buttons
	 */
	public ComboBoxBackgroundPainter(Color fillColor, Color borderColor,
			Color arrowAreaColor)
	{
		super();
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.arrowAreaColor = arrowAreaColor;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.plaf.nimbus.AbstractRegionPainter#doPaint()
	 */
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
		
		GradientPaint gp = new GradientPaint(width / 2, 0, brighterFillColor,
				width / 2, height, darkerFillColor);
		
		g.setPaint(gp);
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
		Color darkerFillColor = new Color(
				this.arrowAreaColor.getRed() - 10 < 0 ? 0
						: this.arrowAreaColor.getRed() - 10,
				this.arrowAreaColor.getGreen() - 10 < 0 ? 0
						: this.arrowAreaColor.getGreen() - 10,
				this.arrowAreaColor.getBlue() - 10 < 0 ? 0
						: this.arrowAreaColor.getBlue() - 10), brighterFillColor = new Color(
				this.arrowAreaColor.getRed() + 10 > 255 ? 255
						: this.arrowAreaColor.getRed() + 10,
				this.arrowAreaColor.getGreen() + 10 > 0 ? 255
						: this.arrowAreaColor.getGreen() + 10,
				this.arrowAreaColor.getBlue() + 10 > 0 ? 255
						: this.arrowAreaColor.getBlue() + 10);
		
		GradientPaint gp = new GradientPaint(width / 2, 0, brighterFillColor,
				width / 2, height, darkerFillColor);
		
		g.setPaint(gp);
		g.fillRoundRect(width - 20, 3, 18, height - 5, 10, 10);
		g.fillRect(width - 20, 3, 5, height - 5);
		
		g.setColor(this.borderColor);
		g.drawLine(width - 20, 3, width - 20, height - 3);
	}
}
