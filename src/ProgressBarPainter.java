import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.AbstractRegionPainter;

final class ProgressBarPainter extends AbstractRegionPainter
{

	private Color fillColor;
	private PaintContext ctx;

	public ProgressBarPainter(Color color)
	{
		fillColor = color;

		AbstractRegionPainter abstractPainter = (AbstractRegionPainter) UIManager
				.get("ToolTip[Enabled].backgroundPainter");
		Class<?> clazz = abstractPainter.getClass();
		Method protectedMethod = null;
		try
		{
			protectedMethod = clazz.getDeclaredMethod("getPaintContext");
		} catch (NoSuchMethodException | SecurityException e)
		{
			e.printStackTrace();
		}
		protectedMethod.setAccessible(true);

		try
		{
			this.ctx = (PaintContext) protectedMethod.invoke(abstractPainter);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void doPaint(Graphics2D g, JComponent c, int width, int height,
			Object[] extendedCacheKeys)
	{
		g.setColor(fillColor);
		g.fillRect(3, 3, width - 6, height - 6);
	}

	@Override
	public PaintContext getPaintContext()
	{
		return this.ctx;
	}
}
