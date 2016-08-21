import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;

/**
 * Zeichnet den ToolTip-Hintergrund
 * 
 * @author 
 *         http://www.javafind.net/gate.jsp?q=/library/36/java6_full_apidocs/src-
 *         html/com/sun/java/swing/plaf/nimbus/ToolTipPainter.html#line.17
 *
 */
final class ToolTipBackgroundPainter extends AbstractLookAndFeelRegionPainter
{
	// package private integers representing the available states that
	// this painter will paint. These are used when creating a new instance
	// of ToolTipPainter to determine which region/state is being painted
	// by that instance.
	private static final int BACKGROUND_ENABLED = 1;
	// private static final String ToolTipPaintContext =
	// "ToolTip[Enabled].backgroundPainter";
	
	private int state; // refers to one of the static final ints above
	
	// the following 4 variables are reused during the painting code of the
	// layers
	@SuppressWarnings("unused")
	private Path2D path = new Path2D.Float();
	private Rectangle2D rect = new Rectangle2D.Float(0, 0, 0, 0);
	@SuppressWarnings("unused")
	private RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0, 0, 0,
			0, 0);
	@SuppressWarnings("unused")
	private Ellipse2D ellipse = new Ellipse2D.Float(0, 0, 0, 0);
	
	// All Colors used for painting are stored here. Ideally, only those
	// colors being used
	// by a particular instance of ToolTipPainter would be created. For the
	// moment at least,
	// however, all are created for each instance.
	private Color color1 = decodeColor("nimbusBorder", 0.0f, 0.0f, 0.0f, 0);
	private Color color2 = decodeColor("info", -0.8f, -0.8f, -0.8f, 0);
	
	// Array of current component colors, updated in each paint call
	@SuppressWarnings("unused")
	private Object[] componentColors;
	
	/**
	 * Erzeugt einen ToolTipBackgroundPainter
	 * 
	 * @param state
	 *            Hintergrund-Status (Hintergund 'Ein' == 1; Hintergrund 'Aus'
	 *            <> 1)
	 * @param background
	 *            Hintergrundfarbe des ToolTips
	 * @param border
	 *            Farbe des Rahmen des ToolTips
	 */
	public ToolTipBackgroundPainter(int state, Color background, Color border)
	{
		super();
		this.state = state;
		
		if (border != null)
			this.color1 = border;
		if (background != null)
			this.color2 = background;
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
		// populate componentColors array with colors calculated in
		// getExtendedCacheKeys call
		componentColors = extendedCacheKeys;
		// generate this entire method. Each state/bg/fg/border combo that
		// has
		// been painted gets its own KEY and paint method.
		switch (state)
		{
		case BACKGROUND_ENABLED:
			paintBackgroundEnabled(g);
			break;
		
		}
	}
	
	private void paintBackgroundEnabled(Graphics2D g)
	{
		this.setRenderingHints(g);
		
		rect = decodeRect1();
		g.setPaint(color1);
		g.fill(rect);
		rect = decodeRect2();
		g.setPaint(color1);
		g.fill(rect);
		rect = decodeRect3();
		g.setPaint(color1);
		g.fill(rect);
		rect = decodeRect4();
		g.setPaint(color1);
		g.fill(rect);
		rect = decodeRect5();
		g.setPaint(color2);
		g.fill(rect);
	}
	
	private Rectangle2D decodeRect1()
	{
		rect.setRect(decodeX(2.0f), // x
				decodeY(1.0f), // y
				decodeX(3.0f) - decodeX(2.0f), // width
				decodeY(2.0f) - decodeY(1.0f)); // height
		return rect;
	}
	
	private Rectangle2D decodeRect2()
	{
		rect.setRect(decodeX(0.0f), // x
				decodeY(1.0f), // y
				decodeX(1.0f) - decodeX(0.0f), // width
				decodeY(2.0f) - decodeY(1.0f)); // height
		return rect;
	}
	
	private Rectangle2D decodeRect3()
	{
		rect.setRect(decodeX(0.0f), // x
				decodeY(2.0f), // y
				decodeX(3.0f) - decodeX(0.0f), // width
				decodeY(3.0f) - decodeY(2.0f)); // height
		return rect;
	}
	
	private Rectangle2D decodeRect4()
	{
		rect.setRect(decodeX(0.0f), // x
				decodeY(0.0f), // y
				decodeX(3.0f) - decodeX(0.0f), // width
				decodeY(1.0f) - decodeY(0.0f)); // height
		return rect;
	}
	
	private Rectangle2D decodeRect5()
	{
		rect.setRect(decodeX(1.0f), // x
				decodeY(1.0f), // y
				decodeX(2.0f) - decodeX(1.0f), // width
				decodeY(2.0f) - decodeY(1.0f)); // height
		return rect;
	}
}
