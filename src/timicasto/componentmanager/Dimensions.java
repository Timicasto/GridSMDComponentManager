package timicasto.componentmanager;

public enum Dimensions {
	D0(640, 360),
	D1(1024, 576),
	D2(1280, 720),
	D3(1600, 900),
	D4(1920, 1080),
	D5(2560, 1440),
	D6(3200, 1800);

	final int width;
	final int height;

	Dimensions(int width, int height) {
		this.width = width;
		this.height = height;
	}
}
