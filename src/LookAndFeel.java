import java.awt.Color;
import java.awt.Font;
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

	private String lookAndFeel = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	private Color bttbg = Color.BLUE, bttfg = Color.WHITE,
			control = Color.WHITE, tooltptxtcol = Color.BLACK,
			tooltpbg = Color.WHITE, tooltpborder = Color.DARK_GRAY;
	private Font bttft = new Font("Tahoma", Font.BOLD, 12), cbft = new Font(
			"Tahoma", Font.BOLD, 12), pbft = new Font("Tahoma", Font.BOLD, 12),
			tooltptxtft = new Font("Tahoma", Font.PLAIN, 11);

	/**
	 * Setzt ein Standard LookAndFeel
	 */
	public LookAndFeel()
	{
		super();
		this.setLookAndFeel();
	}

	/**
	 * Creiert das Objekt der Klasse und setzt ein Standard LookAndFeel, wenn
	 * der Parameter setDefaults true ist
	 * 
	 * @param setDefaults
	 *            Bei true wird ein Standard LookAndFeel gesetzt
	 */
	public LookAndFeel(boolean setDefaults)
	{
		super();
		if (setDefaults)
			this.setLookAndFeel();
		else
			def = UIManager.getLookAndFeelDefaults();
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
			this.lookAndFeel = lookAndFeel;
		this.setLookAndFeel();
	}

	/**
	 * Setzt ein LookAndFeel mit den übergebenen Parametern. Ist ein Parameter
	 * NULL, wird für diesen der Standardwert benutzt.
	 * 
	 * @param lookAndFeel
	 *            LookAndFeel
	 * @param bttbg
	 *            Button Hintergrundfabe
	 * @param bttfg
	 *            Button Vordergrundfarbe
	 * @param bttft
	 *            Button Schrifteinstellungen
	 * @param control
	 *            Control-Farbe (Hintergrund von Panels und Frames)
	 * @param tooltptxtcol
	 *            ToolTip Textfarbe
	 * @param tooltpbg
	 *            ToolTip Hintergrundfarbe
	 * @param tooltpborder
	 *            ToolTip Rahmenfarbe
	 * @param tooltptxtft
	 *            ToolTip Schriftrinstellungen
	 * @param cbft
	 *            ComboBox Schrifteinstellungen
	 * @param pbft
	 *            ProgressBar Schrifteinstellungen
	 */
	public LookAndFeel(Color bttbg, Color bttfg, Font bttft, Color control,
			Color tooltptxtcol, Color tooltpbg, Color tooltpborder,
			Font tooltptxtft, Font cbft, Font pbft)
	{
		super();
		if (bttbg != null)
			this.bttbg = bttbg;
		if (bttfg != null)
			this.bttfg = bttfg;
		if (control != null)
			this.control = control;
		if (tooltptxtcol != null)
			this.tooltptxtcol = tooltptxtcol;
		if (tooltpbg != null)
			this.tooltpbg = tooltpbg;
		if (tooltpborder != null)
			this.tooltpborder = tooltpborder;
		if (bttft != null)
			this.bttft = bttft;
		if (cbft != null)
			this.cbft = cbft;
		if (pbft != null)
			this.pbft = pbft;
		if (tooltptxtft != null)
			this.tooltptxtft = tooltptxtft;
		this.setLookAndFeel();
	}

	/**
	 * Setzt ein LookAndFeel mit den übergebenen Parametern. Ist ein Parameter
	 * NULL, wird für diesen der Standardwert benutzt.
	 * 
	 * @param bttbg
	 *            Button Hintergrundfabe
	 * @param bttfg
	 *            Button Vordergrundfarbe
	 * @param bttft
	 *            Button Schrifteinstellungen
	 * @param control
	 *            Control-Farbe (Hintergrund von Panels und Frames)
	 * @param tooltptxtcol
	 *            ToolTip Textfarbe
	 * @param tooltpbg
	 *            ToolTip Hintergrundfarbe
	 * @param tooltpborder
	 *            ToolTip Rahmenfarbe
	 * @param tooltptxtft
	 *            ToolTip Schriftrinstellungen
	 * @param cbft
	 *            ComboBox Schrifteinstellungen
	 * @param pbft
	 *            ProgressBar Schrifteinstellungen
	 */
	public LookAndFeel(String lookAndFeel, Color bttbg, Color bttfg,
			Font bttft, Color control, Color tooltptxtcol, Color tooltpbg,
			Color tooltpborder, Font tooltptxtft, Font cbft, Font pbft)
	{
		super();
		if (lookAndFeel != null && !lookAndFeel.equals(""))
			this.lookAndFeel = lookAndFeel;
		if (bttbg != null)
			this.bttbg = bttbg;
		if (bttfg != null)
			this.bttfg = bttfg;
		if (control != null)
			this.control = control;
		if (tooltptxtcol != null)
			this.tooltptxtcol = tooltptxtcol;
		if (tooltpbg != null)
			this.tooltpbg = tooltpbg;
		if (tooltpborder != null)
			this.tooltpborder = tooltpborder;
		if (bttft != null)
			this.bttft = bttft;
		if (cbft != null)
			this.cbft = cbft;
		if (pbft != null)
			this.pbft = pbft;
		if (tooltptxtft != null)
			this.tooltptxtft = tooltptxtft;
		this.setLookAndFeel();
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
		else
			this.setLookAndFeel();
	}

	/**
	 * Setzt die UIDefaults für Buttons, Comboboxen, Progressbars, Tooltips und
	 * Controls
	 */
	private void setLookAndFeel()
	{
		// http://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/_nimbusDefaults.html#primary
		try
		{
			UIManager.setLookAndFeel(this.lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
			return;
		}

		def = UIManager.getLookAndFeelDefaults();

		def.put("Button.background", this.bttbg);
		def.put("Button.font", this.bttft);
		def.put("Button.textForeground", this.bttfg);

		def.put("ComboBox.font", this.cbft);

		def.put("ProgressBar.font", this.pbft);

		def.put("ToolTip.textForeground", this.tooltptxtcol);
		def.put("ToolTip[Enabled].backgroundPainter",
				new ToolTipBackgroundPainter(1, this.tooltpbg,
						this.tooltpborder));
		def.put("ToolTip.font", this.tooltptxtft);

		UIManager.put("control", this.control);
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
	public void setLookAndFeel(String lookAndFeel)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(lookAndFeel);
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
		def.put("Button.background", background);
		def.put("Button.font", font);
		def.put("Button.textForeground", foreground);
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
		this.setComboBox(background, foreground, background, foreground, font);
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
			UIManager.put("ComboBox.background",
					new ColorUIResource(background));
		if (foreground != null)
			UIManager.put("ComboBox.foreground",
					new ColorUIResource(foreground));
		if (selectedBackground != null)
			UIManager.put("ComboBox.selectionBackground", new ColorUIResource(
					selectedBackground));
		if (selectedForeground != null)
			UIManager.put("ComboBox.selectionForeground", new ColorUIResource(
					selectedForeground));
		if (font != null)
			def.put("ComboBox.font", font);
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
	public void setProgressBar(Color foreground, Color background, Font font)
	{
		if (foreground != null)
		{
			UIManager.put("ProgressBar.foreground", foreground);
			UIManager.put("ProgressBar.selectionForeground", foreground);
			def.put("ProgressBar[Enabled].foregroundPainter",
					new ProgressBarPainter(foreground));
			def.put("ProgressBar[Enabled+Finished].foregroundPainter",
					new ProgressBarPainter(foreground));
		}
		if (background != null)
		{
			UIManager.put("ProgressBar.background", background);
			UIManager.put("ProgressBar.selectionBackground", background);
			def.put("ProgressBar[Enabled].backgroundPainter",
					new ProgressBarPainter(background));
			def.put("ProgressBar[Enabled+Finished].backgroundPainter",
					new ProgressBarPainter(background));
		}
		if (font != null)
			def.put("ProgressBar.font", font);
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
			def.put("ToolTip.textForeground", foreground);
		if (background != null && border != null)
			def.put("ToolTip[Enabled].backgroundPainter",
					new ToolTipBackgroundPainter(1, background, border));
		if (font != null)
			def.put("ToolTip.font", font);
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
		def.put(key, value);
	}

	/**
	 * Ruft die PUTDEFAULTS()-Methode der UIDefaults auf
	 * 
	 * @param keyValueList
	 *            Object-Array mit Werten für die UIDefaults
	 */
	public void putDefaultsUIDefault(Object[] keyValueList)
	{
		def.putDefaults(keyValueList);
	}

	/**
	 * Ruft die PUTALL()-Methode der UIDefaults auf
	 * 
	 * @param keyValueMap
	 *            Map mit Werten für die UIDefaults
	 */
	public void putAllUIDefault(
			Map<? extends Object, ? extends Object> keyValueMap)
	{
		def.putAll(keyValueMap);
	}
}