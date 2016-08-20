import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

/**
 * Ändert das Design.
 * 
 * @author Feryr
 *
 */
public class LookAndFeel
{
	private UIDefaults def = null;

	private Map<Object, Object> keyValueMap = new HashMap<Object, Object>();

	public static final String NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	private String lookAndFeelName = NIMBUS;

	private Color bttbgcol = Color.BLUE, bttfgcol = Color.WHITE,
			control = Color.WHITE, tooltptxtcol = Color.BLACK,
			tooltpbg = Color.WHITE, tooltpborder = Color.DARK_GRAY,
			pbfgcol = Color.BLUE, pbbgcol = new Color(235, 235, 235),
			cbbgcol = Color.WHITE, cbfgcol = Color.BLACK,
			cbselbgcol = Color.BLUE, cbselfgcol = Color.WHITE,
			pbborder = Color.GRAY;
	private Font bttft = new Font("Tahoma", Font.BOLD, 12),
			cbft = new Font("Tahoma", Font.BOLD, 12),
			pbft = new Font("Tahoma", Font.BOLD, 12),
			tooltptxtft = new Font("Tahoma", Font.PLAIN, 12);

	/**
	 * Setzt ein Standard LookAndFeel
	 */
	public LookAndFeel()
	{
		super();
	}

	/**
	 * Setzt ein Standard LookAndFeel
	 * 
	 * @param lookAndFeel
	 *            LookAndFeel
	 */
	public LookAndFeel(String lookAndFeel)
	{
		super();
		if (lookAndFeel != null && !lookAndFeel.equals(""))
			this.lookAndFeelName = lookAndFeel;
	}

	/**
	 * Setzt ein LookAndFeel mit den übergebenen UIDefaults. Wird NULL
	 * übergeben, werden die Standardwerte benutzt.
	 * 
	 * @param def
	 */
	public LookAndFeel(UIDefaults def)
	{
		super();
		if (def != null)
			this.def = def;
	}

	/**
	 * Setzt die Einstellungen für Buttons, Comboboxen, Progressbars, Tooltips
	 * und Controls in Kraft
	 */
	public void setLookAndFeel()
	{
		// http://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/_nimbusDefaults.html#primary
		if (this.def == null)
		{
			try
			{
				UIManager.setLookAndFeel(this.lookAndFeelName);
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException
					| UnsupportedLookAndFeelException e)
			{
				e.printStackTrace();
				return;
			}

			this.def = UIManager.getLookAndFeelDefaults();
		}

		this.def.put("Button.background", this.bttbgcol);
		this.def.put("Button.font", this.bttft);
		this.def.put("Button.textForeground", this.bttfgcol);

		this.def.put("ComboBox.font", this.cbft);
		UIManager.put("ComboBox.background", new ColorUIResource(this.cbbgcol));
		UIManager.put("ComboBox.foreground", new ColorUIResource(this.cbfgcol));
		UIManager.put("ComboBox.selectionBackground",
				new ColorUIResource(this.cbselbgcol));
		UIManager.put("ComboBox.selectionForeground",
				new ColorUIResource(this.cbselfgcol));

		this.def.put("ProgressBar.font", this.pbft);
		UIManager.put("ProgressBar.foreground", this.pbfgcol);
		UIManager.put("ProgressBar.selectionForeground", this.pbfgcol);
		this.def.put("ProgressBar[Enabled].foregroundPainter",
				new ProgressBarPainter(this.pbfgcol, null));
		this.def.put("ProgressBar[Enabled+Finished].foregroundPainter",
				new ProgressBarPainter(this.pbfgcol, null));
		UIManager.put("ProgressBar.background", this.pbbgcol);
		UIManager.put("ProgressBar.selectionBackground", this.pbbgcol);
		this.def.put("ProgressBar[Enabled].backgroundPainter",
				new ProgressBarPainter(this.pbbgcol, this.pbborder));
		this.def.put("ProgressBar[Enabled+Finished].backgroundPainter",
				new ProgressBarPainter(this.pbbgcol, this.pbborder));

		this.def.put("ToolTip.textForeground", this.tooltptxtcol);
		this.def.put("ToolTip[Enabled].backgroundPainter",
				new ToolTipBackgroundPainter(1, this.tooltpbg,
						this.tooltpborder));
		this.def.put("ToolTip.font", this.tooltptxtft);

		UIManager.put("control", this.control);

		this.def.putAll(this.keyValueMap);
	}

	/**
	 * Setzt das übergebene Java-Standard LookAndFeel
	 * 
	 * @param lookAndFeel
	 *            Name des LookAndFeels
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws UnsupportedLookAndFeelException
	 */
	public void setLookAndFeelName(String lookAndFeelName)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException
	{
		if (lookAndFeelName != null)
			this.lookAndFeelName = lookAndFeelName;
	}

	/**
	 * Setzt das Aussehen des Buttons
	 * 
	 * @param background
	 *            Hintergrundfarbe
	 * @param foreground
	 *            Textfarbe
	 * @param font
	 *            Schrifteinstellungen
	 */
	public void setButton(Color background, Color foreground, Font font)
	{
		if (background != null)
			this.bttbgcol = background;
		if (foreground != null)
			this.bttfgcol = foreground;
		if (font != null)
			this.bttft = font;
	}

	/**
	 * Setzt das Aussehen der Combobox
	 * 
	 * @param background
	 *            Hintergrundfarbe
	 * @param foreground
	 *            Textfarbe
	 * @param font
	 *            Schrifteinstellungen
	 */
	public void setComboBox(Color background, Color foreground, Font font)
	{
		this.setComboBox(background, foreground, background.darker(),
				foreground, font);
	}

	/**
	 * Setzt das Aussehen der Combobox
	 * 
	 * @param background
	 *            Hintergrundfabe
	 * @param foreground
	 *            Textfarbe
	 * @param selectedBackground
	 *            Hintergrundfarbe bei aktiver Selektion
	 * @param selectedForeground
	 *            Textfarbe bei aktiver Selektion
	 * @param font
	 *            Schrifteinstellungen
	 */
	public void setComboBox(Color background, Color foreground,
			Color selectedBackground, Color selectedForeground, Font font)
	{
		if (background != null)
			this.cbbgcol = background;
		if (foreground != null)
			this.cbfgcol = foreground;
		if (selectedBackground != null)
			this.cbselbgcol = selectedBackground;
		if (selectedForeground != null)
			this.cbselfgcol = selectedForeground;
		if (font != null)
			this.cbft = font;
	}

	/**
	 * Setzt das Aussehen der ProgressBar
	 * 
	 * @param foreground
	 *            Farbe, wenn der Balken noch nicht 100% erreicht hat
	 * @param background
	 *            Farbe, wenn der Balen 100% erreicht hat
	 * @param font
	 *            Schrifteinstellungen
	 */
	public void setProgressBar(Color foreground, Color background, Color border,
			Font font)
	{
		if (foreground != null)
			this.pbfgcol = foreground;
		if (background != null)
			this.pbbgcol = background;
		if (border != null)
			this.pbborder = border;
		if (font != null)
			this.pbft = font;
	}

	/**
	 * Setzt das Aussehen der ToolTips
	 * 
	 * @param background
	 *            Hintergrundfarbe
	 * @param border
	 *            Rahmenfarbe
	 * @param foreground
	 *            Textfarbe
	 * @param font
	 *            Schrifteinstellungen
	 */
	public void setToolTip(Color background, Color border, Color foreground,
			Font font)
	{
		if (foreground != null)
			this.tooltptxtcol = foreground;
		if (background != null)
			this.tooltpbg = background;
		if (border != null)
			this.tooltpborder = border;
		if (font != null)
			this.tooltptxtft = font;
	}

	public void setContol(Color color)
	{
		UIManager.put("control", color);
	}

	/**
	 * Ruft die PUT()-Methode der UIDefaults auf
	 * 
	 * @param key
	 *            der Schlüssel
	 * @param value
	 *            der Wert, der dem Schlüssel zugewiesen wird
	 */
	public void putUIDefault(Object key, Object value)
	{
		this.keyValueMap.put(key, value);
	}

	/**
	 * Ruft die PUTALL()-Methode der UIDefaults auf
	 * 
	 * @param keyValueMap
	 *            Map mit Werten für die UIDefaults
	 */
	public void putAllUIDefault(Map<Object, Object> keyValueMap)
	{
		this.keyValueMap.putAll(keyValueMap);
	}
}