///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package Cart;

import Cart.CartObj;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.ProductDAO;
import product.ProductDTO;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import orderDetail.OrderDetailDAO;
import orders.OrderDAO;
import user.UserDTO;
//
///**
// *
// * @author long
// */
//public class CheckoutController extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        String url ="";
//        Date date = new Date(System.currentTimeMillis());
//        try {
//            HttpSession session = request.getSession(false);
//            if (session != null) {
//                CartObj cart = (CartObj) session.getAttribute("CART");
//                if (cart != null) {
//                    Map<String, Integer> items = cart.getItems();
//                    if (items != null) {
//                        UserDTO dto = (UserDTO) session.getAttribute("LOGIN_USER");
//                        OrderDAO order = new OrderDAO();
//                        String fullName = request.getParameter("fullName");
//                        String address = request.getParameter("address");
//                        String status = request.getParameter("status");
//                        int userID = Integer.parseInt(request.getParameter("userID"));
//
//                        int orderId = order.createOrder(dto.getFullName(), dto.getAddress(), dto.getStatus(), date, dto.getUserID(), 0); // total = 0 vi ko co du lieu tu table order
//                        boolean success = false;
//                        if (orderId > 0) {
//                            float finalTotal = 0;
//                            for (String productID : items.keySet()) {
//                                ProductDAO product = new ProductDAO();
//                                float price = product.getProductByIdTypeString(productID).getPrice();
//                                int ProductQuantity = product.getProductByIdTypeString(productID).getQuantity();
//                                int userQuantity = items.get(productID);
//                                //Check if enough product in storage
//                                if (ProductQuantity > userQuantity) {
//                                    OrderDetailDAO orderDetail = new OrderDetailDAO();
//                                    finalTotal += orderDetail.createOrderDetail(orderId, productID, price, userQuantity);
//                                    product.updateQuantity(productID, ProductQuantity, userQuantity);
//                                } else {
//                                    //Not enough product
//                                    request.setAttribute("CHECKOUT_ERROR",
//                                            product.getProductByIdTypeString(productID).getName()
//                                            + " is out of stock, this items will be automatic removed. "
//                                            + "Sorry for this inconvenience.");
//                                    cart.removeItemFromCart(productID);
//                                    order.removeOrder(orderId);
//
//                                }
//                            }
//                            if (finalTotal > 0) {
//                                boolean checkUpdateTotal = order.updateOrderTotal(finalTotal, orderId);
//                                if (checkUpdateTotal) {
//                                    session.setAttribute("TOTAL_BILL", finalTotal);
//                                    session.setAttribute("DATE", date);
//                                    session.setAttribute("ORDER_ID", orderId);
//                                    session.setAttribute("CART", cart);
//                                    
//                                    //       session.setAttribute("ProductQuantity", price);
//                                }
//                            }
//                        }//create order successful
//                    }//Check product that user add has existed
//                }//CheckCart has existed
//            }//check session has existed
//        } catch (SQLException ex) {
//            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
//            rd.forward(request, response);
//        }
//        
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Carr;
//
//import Cart.CartObj;
//import jakarta.servlet.RequestDispatcher;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import product.ProductDAO;
//import product.ProductDTO;
//import jakarta.servlet.http.HttpSession;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import orderDetail.OrderDetailDAO;
//import orders.OrderDAO;
//import user.UserDTO;

/**
 *
 * @author long
 */
public class CheckoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("LOGIN_USER") == null) {
            request.setAttribute("error", "Pls login to continue");
            request.getRequestDispatcher("viewCart.jsp").forward(request, response);

        }else{
             response.sendRedirect("shipping-details.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            Date date = new Date(System.currentTimeMillis());
            if (session != null) {
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart != null) {
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
                        UserDTO dto = (UserDTO) session.getAttribute("LOGIN_USER");
                        OrderDAO order = new OrderDAO();
                        String fullName = request.getParameter("fullName");
                        String address = request.getParameter("address");
//                        String note = request.getParameter("note");
                        String status = request.getParameter("status");

                        int userID = Integer.parseInt(request.getParameter("userID"));
                        int orderId = order.createOrder(fullName, address, status, date, userID, 0); // total = 0 vi ko co du lieu tu table order
                        boolean success = false;
                        if (orderId > 0) {
                            float finalTotal = 0;
                            for (String productID : items.keySet()) {
                                ProductDAO product = new ProductDAO();
                                float price = product.getProductByIdTypeString(productID).getPrice();
                                int ProductQuantity = product.getProductByIdTypeString(productID).getQuantity();
                                int userQuantity = items.get(productID);
                                //Check if enough product in storage
                                if (ProductQuantity > userQuantity) {
                                    OrderDetailDAO orderDetail = new OrderDetailDAO();
                                    finalTotal += orderDetail.createOrderDetail(orderId, productID, price, userQuantity);
                                    product.updateQuantity(productID, ProductQuantity, userQuantity);
                                } else {
                                    //Not enough product
                                    request.setAttribute("CHECKOUT_ERROR",
                                            product.getProductByIdTypeString(productID).getName()
                                            + " is out of stock, this items will be automatic removed. "
                                            + "Sorry for this inconvenience.");
                                    cart.removeItemFromCart(productID);
                                    order.removeOrder(orderId);

                                }
                            }
                            if (finalTotal > 0) {
                                boolean checkUpdateTotal = order.updateOrderTotal(finalTotal, orderId);
                                if (checkUpdateTotal) {
                                    session.setAttribute("TOTAL_BILL", finalTotal);
                                    session.setAttribute("DATE", date);
                                    session.setAttribute("ORDER_ID", orderId);
                                    session.setAttribute("CART", cart);
                                    //       session.setAttribute("ProductQuantity", price);
                                }
                            }
                        }//create order successful
                    }//Check product that user add has existed
                }//CheckCart has existed
            }//check session has existed

        } catch (SQLException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
            rd.forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
