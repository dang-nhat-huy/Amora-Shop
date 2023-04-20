/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import category.CategoryDAO;
import category.CategoryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import product.ProductDAO;
import product.ProductDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ShowProductDetailUserController", urlPatterns = {"/ShowProductDetailUserController"})
public class ShowProductDetailUserController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS_USER_PRODUCT_DETAIL_PAGE = "product-detail-user-page.jsp";


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String product_id = request.getParameter("product_id");
        
        try {
            ProductDAO dao = new ProductDAO();
            HttpSession session = request.getSession();
            List<ProductDTO> result = dao.getProductDetailByID(product_id);
            if(result.isEmpty()){
                log("No data have been retrieved!!!");
            }else{
                session.setAttribute("PRODUCT_DETAIL", result);
                url = SUCCESS_USER_PRODUCT_DETAIL_PAGE;
            }   
        } catch(ClassNotFoundException ex){
            log("ShowProductDetailUserController _ Naming " + ex.getMessage());
        } catch(SQLException ex){
            log("ShowProductDetailUserController _ SQL" + ex.getMessage());
        }
        finally{
            request.getRequestDispatcher(url).forward(request, response);
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
