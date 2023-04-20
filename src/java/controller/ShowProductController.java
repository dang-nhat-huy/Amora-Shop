/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import category.CategoryDAO;
import category.CategoryDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
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
import user.UserDTO;

/**
 *
 * @author thaiq
 */
public class ShowProductController extends HttpServlet {

    private static final String SUCCESS_USER = "products-user-page.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SUCCESS_USER;
        
        

        try {
            final int PAGE_SIZE = 20;
            int page = 1;
            String pageStr = request.getParameter("page");
            if (pageStr != null) {
                page = Integer.parseInt(pageStr);
            }
            ProductDAO productDAO = new ProductDAO();
            List<ProductDTO> listProducts = productDAO.getProductsWithPagging(page, PAGE_SIZE);
            //tinh tong so san pham trongdatabase r tra ve so trang 
            //de hien len man hinh jsp 
            int totalProducts = productDAO.getTotalProducts();
            int totalPage = totalProducts / PAGE_SIZE;
            //chia lay du totalProducts neu co du thi + 1 page cho totalPage
            if (totalProducts % PAGE_SIZE != 0) {
                totalPage += 1;
            }
            HttpSession session = request.getSession();
        UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("products", listProducts);

            List<CategoryDTO> ListCategory = new CategoryDAO().getAllCategory();
            request.setAttribute("ListCategory", ListCategory);

        } catch (SQLException ex) {
            Logger.getLogger(ShowProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
