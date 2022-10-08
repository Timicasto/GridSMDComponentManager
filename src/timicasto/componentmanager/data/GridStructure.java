package timicasto.componentmanager.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import timicasto.componentmanager.utils.Vec2i;

public class GridStructure {
    BiMap<Vec2i, Component> grid = HashBiMap.create();


}
