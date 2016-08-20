import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.AbstractRegionPainter;

/**
 * 
 */

/**
 * @author Patrick
 *
 */
abstract class AbstractLookAndFeelRegionPainter extends AbstractRegionPainter
{

	private PaintContext ctx;

	/**
	 * Creates object and get object of paintcontext
	 */
	public AbstractLookAndFeelRegionPainter()
	{
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.plaf.nimbus.AbstractRegionPainter#getPaintContext()
	 */
	@Override
	protected PaintContext getPaintContext()
	{
		return this.ctx;
	}

}
