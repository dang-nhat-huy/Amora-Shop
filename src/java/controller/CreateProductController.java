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
public class CreateProductController extends HttpServlet {

    private static final String ERROR = "create-product.jsp";
    private static final String SUCCESS = "/ShowProductAdminController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            ProductDAO dao = new ProductDAO();
            String productName = request.getParameter("newproductname");
            int quantity = Integer.parseInt(request.getParameter("newquantity"));
            String status = request.getParameter("newstatus");
            String description = request.getParameter("newdescription");
            int capacity = Integer.parseInt(request.getParameter("newcapacity"));
            String brand = request.getParameter("newbrand");
            float price = Float.parseFloat(request.getParameter("newprice"));
            int categoryID = Integer.parseInt(request.getParameter("newcategoryid"));
            String folderName = "images";
            Part filePart = request.getPart("newimage");
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
                path = "";
            }
            if (quantity < 0 || capacity < 0 || price < 0) {
                url = ERROR;
                ProductDTO product = new ProductDTO(0, productName, quantity, status, description, capacity, brand, price, categoryID, path);
                request.getSession().setAttribute("products", product);
            } else {

                ProductImageDTO productImage = new ProductImageDTO(0, path, 0);
                ProductDTO product = new ProductDTO(0, productName, quantity, status, description, capacity, brand, price, categoryID, path);
                dao.insert(product, productImage);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
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
