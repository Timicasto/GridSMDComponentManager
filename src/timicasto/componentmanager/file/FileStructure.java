package timicasto.componentmanager.file;

import com.google.common.collect.BiMap;
import timicasto.componentmanager.Main;
import timicasto.componentmanager.data.Component;
import timicasto.componentmanager.data.GridStructure;
import timicasto.componentmanager.utils.Vec2i;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *  Grid SMD Component Manager Files Structure:
 *      8 Bytes File Header: 5F 51 53 43 48 4D 45 30
 *      Integer: Grid Counts: Ref to how many boxes you have.
 *      GridMetadata: n * 8 Bytes: Ref to how many rows and columns a Grid has.
 *
 */
public class FileStructure {
	public static final byte[] HEADER = {0x5F, 0x51, 0x53, 0x43, 0x48, 0x4D, 0x45, 0x30};
	public static final byte[] ENDING = {0x10, 0x10, 0x10, 0x10};

	public int gridCount;
	public GridMetadata[] grids;
	public GridStructure[] structures;

	public int size = 0;

	public FileStructure(int gridCount) {
		this.gridCount = gridCount;
		this.grids = new GridMetadata[gridCount];
		this.structures = new GridStructure[gridCount];
	}

	public boolean saveMap(int[] rows, int[] columns, BiMap<Vec2i, Component>[] grid) {
		if (rows.length != columns.length || columns.length != grid.length || rows.length != gridCount) {
			Main.LOGGER.severe("Mismatched Grid Count, Aborting");
			return false;
		}
		for (int i = 0 ; i < gridCount ; ++i) {
			grids[i] = new GridMetadata(columns[i], rows[i], columns[i] * rows[i], i);
			structures[i] = new GridStructure(grid[i], grids[i]);
		}
		return true;
	}

	public static FileStructure readFromFile(RandomAccessFile file) {
		return new FileStructure(0);
	}

	public boolean write(RandomAccessFile file) {
		try {
			file.seek(0);
			file.write(HEADER);
			file.writeInt(gridCount);
			for (int i = 0; i < gridCount; ++i) {
				file.writeInt(grids[i].width);
				file.writeInt(grids[i].height);
			}
			for (int i = 0; i < gridCount; ++i) {
				structures[i].saveToFile(file);
			}
			file.write(ENDING);
		} catch (Throwable t) {
			Main.LOGGER.severe("Failed to save file " + file.toString());
			return false;
		}
		return true;
	}
}
