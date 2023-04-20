/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product;

/**
 *
 * @author thaiq
 */
public class ProductImageDTO {
    private int productImageID;
    private String  image;
    private int productID;

    public ProductImageDTO() {
    }

    public ProductImageDTO(int productImageID, String image, int productID) {
        this.productImageID = productImageID;
        this.image = image;
        this.productID = productID;
    }

    public int getProductImageID() {
        return productImageID;
    }

    public String getImage() {
        return image;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductImageID(int productImageID) {
        this.productImageID = productImageID;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
