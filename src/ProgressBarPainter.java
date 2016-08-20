import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

final class ProgressBarPainter extends AbstractLookAndFeelRegionPainter
{

	private Color fillColor;

	public ProgressBarPainter(Color color)
	{
		fillColor = color;
	}

	@Override
	public void doPaint(Graphics2D g, JComponent c, int width, int height,
			Object[] extendedCacheKeys)
	{
		g.setColor(fillColor);
		g.fillRect(3, 3, width - 6, height - 6);
	}
}
