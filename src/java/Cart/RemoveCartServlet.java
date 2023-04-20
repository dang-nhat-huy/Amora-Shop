/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import Cart.CartError;
import Cart.CartObj;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.ProductDAO;
import product.ProductDTO;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author long
 */
public class RemoveCartServlet extends HttpServlet {

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
        try {
           HttpSession session = request.getSession(false);//False, vi chua add nen se khong co session, vi the se k thuc hien xoa
            if (session != null) {
                //2.cus take his/her cart
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart != null) {
                    //3.cus get all item
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
                        //4.cus chooses selected, (checked)lay du lieu kieu parameter, gui den server thanh mang chua string
                        String[] selectedItems = request.getParameterValues("chkItem");
                        if(selectedItems != null){
                            //5.system remove them from cart
                            for(String item : selectedItems){
                                cart.removeItemFromCart(item);
                            }//end remove item by item
                            //6.system refresh cart
                            session.setAttribute("CART", cart);
                        }
                    }//items have existed
                }//end cart has existed
            }//end if session has existed
        } finally { //UrlRewriting
            //6.system refresh cart --> call the view function in dispatchController = using url rewriting
            String urlRewriting = "ViewCartController";
            response.sendRedirect(urlRewriting);
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
        processRequest(request, response);
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
