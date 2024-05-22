package de.higherlower.adipositas.data;

public class OptionModel {
    private String product;
    private int calories;
    private String description;

    private String imageBase64;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OptionModel() {
    }

    public OptionModel(String product, int calories, String description, String imageBase64) {
        this.product = product;
        this.calories = calories;
        this.description = description;
        this.imageBase64 = imageBase64;
    }
}
