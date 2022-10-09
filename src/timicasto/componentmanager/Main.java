package timicasto.componentmanager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.*;

public class Main {
	public static final Logger LOGGER = Logger.getLogger("Component Manager");
	public static void main(String[] args) throws IOException {
		App app = new App();
		/*Handler console = new ConsoleHandler();
		console.setFormatter(new SimpleFormatter());
		LOGGER.addHandler(console);*/
		Handler file = new FileHandler("./latest.log");
		file.setFormatter(new SimpleFormatter());
		LOGGER.addHandler(file);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scr = toolkit.getScreenSize();
		Dimensions res = (scr.width > 1024 && scr.height > 576) ? ((scr.width > 1280 && scr.height > 720) ? ((scr.width > 1600 && scr.height > 900) ? ((scr.width > 1920 && scr.height > 1080) ? ((scr.width > 2560 && scr.height > 1440) ? ((scr.width > 3200 && scr.height > 1800) ? Dimensions.D6 : Dimensions.D5) : Dimensions.D4) : Dimensions.D3) : Dimensions.D2) : Dimensions.D1) : Dimensions.D0;
		LOGGER.info("Instance Creating, Screen size " + scr.width + " * " + scr.height + ", window size " + res.width + " * " + res.height);
		JFrame window = app.createInstance(res.width, res.height);
		LOGGER.info("Frame created.");
		JPanel mainPage = app.makeMainPage(res);
		window.setContentPane(mainPage);
	}
}