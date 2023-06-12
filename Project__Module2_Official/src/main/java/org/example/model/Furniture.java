package org.example.model;

public class Furniture extends Thing {
    private String type;
    private String material;

    public Furniture() {

    }

    public Furniture(String serialNumber, String name, String type, String material) {
        super(serialNumber, name);
        this.type = type;
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getDescription() {
        return super.getSerialNumber() + " - " + super.getName() + " - " + this.getType() + " - " + this.getMaterial();
    }

}