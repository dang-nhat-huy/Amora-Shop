package product;

/**
 *
 * @author thaiq
 */
public class ProductDTO {
    private int productID;
    private String name;
    private int quantity;
    private String status;
    private String description;
    private int capacity;
    private String brand;
    private float price;
    private int categoryID;
    private String image;

    public ProductDTO() {
    }

    public ProductDTO(int productID, String name, int quantity, String status, String description, int capacity, String brand, float price, int categoryID, String image) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
        this.description = description;
        this.capacity = capacity;
        this.brand = brand;
        this.price = price;
        this.categoryID = categoryID;
        this.image = image;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    
}
