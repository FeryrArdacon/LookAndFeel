import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

/**
 * Oberklasse für die Painter des LookAndFeels
 * 
 * @author Patrick
 *
 */
abstract class AbstractLookAndFeelRegionPainter extends AbstractRegionPainter
{
	
	private PaintContext ctx = null;
	
	public AbstractLookAndFeelRegionPainter()
	{
		
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
	
	/**
	 * Setzt die RendringHints für hohe Qualität
	 * 
	 * @param g2d
	 *            Graphics2D Objekt, in das die RenderingHints gesetzt werden
	 */
	protected void setRenderingHints(Graphics2D g2d)
	{
		Map<Key, Object> rhMap = new HashMap<Key, Object>();
		rhMap.put(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		rhMap.put(RenderingHints.KEY_COLOR_RENDERING,
				RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		rhMap.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		rhMap.put(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		RenderingHints rh = new RenderingHints(rhMap);
		
		g2d.setRenderingHints(rh);
	}
	
}
