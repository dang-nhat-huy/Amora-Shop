/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import product.ProductDTO;

/**
 *
 * @author long
 */
public class CartObj implements Serializable{
    private Map<String, Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    } //khong co phuong thuc set vi phai lay hang tung mon
    
    public void addItemToCart(String productID, int quantity){
        if(productID == null){
            return;
        }
        if(productID.trim().isEmpty()){
            return;
        }
        if(quantity == 0){
            return;
        }
        //1. Check cart has existed?
        if(this.items == null){
            this.items = new HashMap<>();
        }
        //2. Check item has existed? --> increase quantity
        if(this.items.containsKey(productID)){
            quantity += this.items.get(productID);
        }
        //3. Update items
        this.items.put(productID,quantity);      
    }
    
    public void removeItemFromCart(String sku){
        if(sku == null){
            return;
        }
        if(sku.trim().isEmpty()){
            return;
        }
        //1. Check cart has existed?
        if(this.items == null){
            return;
        }
        //2. Check item has existed?
        if(this.items.containsKey(sku)){
            this.items.remove(sku);
            //Sau khi dele product, gio hang trong thi set null
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
        
        
    }
    
}

