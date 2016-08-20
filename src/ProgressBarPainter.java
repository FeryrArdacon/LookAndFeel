import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

final class ProgressBarPainter extends AbstractLookAndFeelRegionPainter
{

	private Color fillColor, borderColor;

	public ProgressBarPainter(Color fillColor, Color borderColor)
	{
		this.fillColor = fillColor;
		this.borderColor = borderColor;
	}

	@Override
	public void doPaint(Graphics2D g, JComponent c, int width, int height,
			Object[] extendedCacheKeys)
	{
		if (this.borderColor != null)
		{
			g.setColor(this.borderColor.brighter().brighter());
			g.drawRoundRect(1, 1, width - 2, height - 2, 10, 10);
			g.setColor(this.borderColor);
			g.drawRoundRect(2, 2, width - 4, height - 4, 10, 10);
		}

		g.setColor(this.fillColor);
		g.fillRoundRect(3, 3, width - 6, height - 6, 10, 10);
	}
}
