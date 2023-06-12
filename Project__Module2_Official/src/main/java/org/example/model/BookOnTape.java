package org.example.model;

public class BookOnTape extends Thing {
    private String category;

    public BookOnTape() {

    }

    public BookOnTape(String serialNumber, String name, String category) {
        super(serialNumber, name);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getDescription() {
        return super.getSerialNumber() + " - " + super.getName() + " - " + this.getCategory();
    }
}
