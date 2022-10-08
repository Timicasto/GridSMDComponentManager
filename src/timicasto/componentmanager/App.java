package timicasto.componentmanager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class App {

	public JFrame createInstance(int width, int height) {
		JFrame frame = new JFrame("GridSMDComponentManager - SNAPSHOT by QuantumHardwareStudio");
		frame.setSize(width, height);
		frame.setCursor(Cursor.CROSSHAIR_CURSOR);
		frame.setResizable(false);
		frame.setVisible(true);
		BufferedImage icon = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
		try {
			icon = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icon.png"));
		} catch (Throwable ignored) {
			Main.LOGGER.severe("Failed to load Icon image, please check the integrity of the main Jar executable. (" + this.getClass().getClassLoader().toString() + ")");
		}
		frame.setIconImage(icon);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		return frame;
	}

	public JPanel makeMainPage(Dimensions res) {

	}
}
