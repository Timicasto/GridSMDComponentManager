package timicasto.componentmanager.data;

public class Component {

    public enum ComponentType {
        CAPACITOR,
        RESISTOR,
        DIODE,
        TRANSIT,
        FET,
        IGBT,
        CHIPS,
        INDUCTORS,
        FUSE,
        CRYSTAL
    }

    public ComponentType type;
    public String model;

    public Component(ComponentType type, String model) {
        this.type = type;
        this.model = model;
    }

    public ComponentType getType() {
        return type;
    }

    public String getModel() {
        return model;
    }
}
