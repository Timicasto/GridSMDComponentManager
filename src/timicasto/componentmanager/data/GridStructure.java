package timicasto.componentmanager.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import timicasto.componentmanager.file.GridMetadata;
import timicasto.componentmanager.utils.Vec2i;

import java.io.RandomAccessFile;

public class GridStructure {
	public BiMap<Vec2i, Component> grid = HashBiMap.create();
	public GridMetadata metadata;

	public GridStructure(BiMap<Vec2i, Component> grid, GridMetadata metadata) {
		this.grid = grid;
		this.metadata = metadata;
	}

	public void saveToFile(RandomAccessFile file) {

	}
}
