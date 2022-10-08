package timicasto.componentmanager;

import java.awt.*;
import java.io.IOException;
import java.util.logging.*;

public class Main {
	public static void main(String[] args) throws IOException {
		App app = new App();
		Logger logger = Logger.getLogger("ComponentManager");
		Handler console = new ConsoleHandler();
		console.setFormatter(new SimpleFormatter());
		logger.addHandler(console);
		Handler file = new FileHandler("./latest.log");
		file.setFormatter(new SimpleFormatter());
		logger.addHandler(file);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scr = toolkit.getScreenSize();
		Dimensions res = (scr.width > 640 && scr.height > 360) ? ((scr.width > 1024 && scr.height > 576) ? ((scr.width > 1280 && scr.height > 720) ? ((scr.width > 1600 && scr.height > 900) ? ((scr.width > 1920 && scr.height > 1080) ? ((scr.width > 2560 && scr.height > 1440) ? Dimensions.D6 : Dimensions.D5) : Dimensions.D4) : Dimensions.D3) : Dimensions.D2) : Dimensions.D1) : Dimensions.D0;
		logger.info("Instance Creating, Screen size " + scr.width + " * " + scr.height + ", window size " + res.width + " * " + res.height);
		app.createInstance(res.width, res.height);
	}
}