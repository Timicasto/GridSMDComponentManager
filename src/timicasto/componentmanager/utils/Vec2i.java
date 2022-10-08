package timicasto.componentmanager.utils;

import timicasto.componentmanager.Main;

import java.io.RandomAccessFile;

public class Vec2i {

    public int x, y;

    public Vec2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void serializeAndWrite(RandomAccessFile file, long offset) {
        try {
            file.seek(offset);
            file.writeInt(this.x);
            file.writeInt(this.y);
        } catch (Throwable ignored) {
            Main.LOGGER.severe("Serialize data failed: coordinate data " + x + ", " + y);
        }
    }

    public static Vec2i deserialize(RandomAccessFile file, long offset) {
        int x = 0, y = 0;
        try {
            file.seek(offset);
            x = file.readInt();
            y = file.readInt();
        } catch (Throwable ignored) {
            Main.LOGGER.severe("Deserialize data failed: coordinate data unknown");
        }
        return new Vec2i(x, y);
    }
}
