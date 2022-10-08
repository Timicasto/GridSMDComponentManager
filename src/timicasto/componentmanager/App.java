package timicasto.componentmanager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class App {

	public JFrame createInstance(int width, int height) throws IOException {
		JFrame frame = new JFrame("GridSMDComponentManager - SNAPSHOT by QuantumHardwareStudio");
		frame.setSize(width, height);
		frame.setCursor(Cursor.CROSSHAIR_CURSOR);
		frame.setResizable(false);
		frame.setVisible(true);
		BufferedImage icon = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icon.png"));
		frame.setIconImage(icon);
		return frame;
	}

}
