package org.example.model;

public class Video extends Thing {
    private String length;
    private String quality;

    public Video() {

    }

    public Video(String serialNumber, String name, String length, String quality) {
        super(serialNumber, name);
        this.length = length;
        this.quality = quality;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String getDescription() {
        return super.getSerialNumber() + " - " + super.getName() + " - " + this.getLength() + " - " + this.getQuality();
    }


}
