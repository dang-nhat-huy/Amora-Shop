/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import product.ProductDAO;
import product.ProductDTO;
import product.ProductImageDTO;

/**
 *
 * @author thaiq
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000)
public class UpdateProductController extends HttpServlet {

    private static final String ERROR = "admin-update-product.jsp";
    private static final String SUCCESS = "/ShowProductAdminController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            int productID = Integer.parseInt(request.getParameter("productID"));
            String pName = request.getParameter("pName");
            int pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
            String pStatus = request.getParameter("pStatus");
            String pDescrip = request.getParameter("pDescrip");
            int pCapacity = Integer.parseInt(request.getParameter("pCapacity"));
            String pBrand = request.getParameter("pBrand");
            float pPrice = Float.parseFloat(request.getParameter("pPrice"));
            int pCategory = Integer.parseInt(request.getParameter("pCategory"));
            String folderName = "images";
            Part filePart = request.getPart("pImage");
            String fileName = filePart.getSubmittedFileName();
            String path = "";
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;
            if (fileName != null && !fileName.isEmpty()) {
                File dir = new File(uploadPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                path = folderName + File.separator + fileName;
                InputStream is = filePart.getInputStream();
                Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
            } else {
                // product existing image if file is null
                ProductDTO product = (ProductDTO) session.getAttribute("products");
                path = product.getImage();
            }
            if (pQuantity < 0 || pCapacity < 0 || pPrice < 0) {
                url = ERROR;
                ProductDTO product2 = new ProductDTO(productID, pName, pQuantity, pStatus, pDescrip, pCapacity, pBrand, pPrice, pCategory, path);
                request.getSession().setAttribute("products", product2);
            } else {
                ProductDAO dao = new ProductDAO();
                ProductDTO product2 = new ProductDTO(productID, pName, pQuantity, pStatus, pDescrip, pCapacity, pBrand, pPrice, pCategory, path);
                ProductImageDTO productImage = new ProductImageDTO(0, path, 0);
                boolean checkUpdate = dao.update(product2, productImage);
                if (checkUpdate) {
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            log("Error at Update Controller: " + e.toString());
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
