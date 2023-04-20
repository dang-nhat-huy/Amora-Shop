/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import category.CategoryDAO;
import category.CategoryDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import product.ProductDAO;
import product.ProductDTO;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author thaiq
 */
public class test {

    public static void main(String[] args) throws SQLException {
        //Test getAllUsers() function in User DAO
//        UserDAO dao = new UserDAO();
//        List<UserDTO> list = dao.getAllUsers();
//        if(list.size() > 1){
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i).toString());
//            }
//        } else if(list.size() < 0){
//            System.out.println("NULL");
//    }
//}

        //Test getAllProduct() function in product DAO
        
      ProductDAO dao = new ProductDAO();
      List<ProductDTO> list = dao.getAllProducts();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
