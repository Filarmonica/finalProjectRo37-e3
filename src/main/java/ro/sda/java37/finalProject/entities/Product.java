package ro.sda.java37.finalProject.entities;


public class Product {

    private Long id;
    private String title;
    private String description;
    private String thumbnail;
    private MainCategories category;
    private double price;
    private ProductType productType;
    private Brand brand;

    public Product(Long id, String title, String description, String thumbnail, MainCategories category, double price, ProductType productType, Brand brand) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.price = price;
        this.productType = productType;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public MainCategories getCategory() {
        return category;
    }

    public void setCategory(MainCategories category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
