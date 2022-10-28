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
		JPanel panel = new JPanel(null);
		panel.setSize(res.width, res.height);
		JButton create = new JButton("创建新的网格文件");
		JButton read = new JButton("读取现有网格文件");
		panel.add(create);
		panel.add(read);
		switch (res.ordinal()) {
			case 0:
				create.setBounds(100, 100, 200, 200);
				read.setBounds(340, 100, 200, 200);
				break;
			case 1:
				create.setBounds(160, 160, 320, 320);
				read.setBounds(544, 160, 320, 320);
				break;
			case 2:
				create.setBounds(200, 200, 400, 400);
				read.setBounds(680, 200, 400, 400);
				break;
			case 3:
				create.setBounds(250, 250, 500, 500);
				read.setBounds(850, 250, 500, 500);
				break;
			case 4:
				create.setBounds(300, 300, 600, 600);
				read.setBounds(1020, 300, 600, 600);
				break;
			case 5:
				create.setBounds(400, 400, 800, 800);
				read.setBounds(1360, 400, 800, 800);
				break;
			case 6:
				create.setBounds(500, 500, 1000, 1000);
				read.setBounds(1700, 500, 1000, 1000);
				break;
		}
		return panel;
	}
}
