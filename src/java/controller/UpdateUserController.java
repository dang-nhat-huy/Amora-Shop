package controller;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author long
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000)
public class UpdateUserController extends HttpServlet {

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

        try ( PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
//            try {
//                HttpSession session = request.getSession();
//                int userID = Integer.parseInt(request.getParameter("userID"));
//                UserDTO us = new UserDAO().getUserById(userID);
//                List<RoleDTO> roleU = new RoleDAO().getAllRole();
//                session.setAttribute("roleU", roleU);
//                request.setAttribute("us", us);
//
//                request.getRequestDispatcher("update-user.jsp").forward(request, response);
//            } catch (SQLException ex) {
//                Logger.getLogger(UpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
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
        try {

            HttpSession session = request.getSession();

            String message = null;
            UserDAO dao = new UserDAO();

            String fullName = request.getParameter("fullName");

            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String password = request.getParameter("password");

            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String status = request.getParameter("status");

            int roleID = Integer.parseInt(request.getParameter("roleID"));

            int userID = Integer.parseInt(request.getParameter("userID"));

            String folderName = "images";

            Part filePart = request.getPart("image");
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
                // Use existing image if file is null
                UserDTO user = (UserDTO) session.getAttribute("us");
                path = user.getImage();
            }

            UserDTO updateUser = new UserDTO(userID, fullName, password, gender, email, phoneNumber, address, status, roleID, path);
            dao.updateUserById(updateUser);

            response.sendRedirect("http://localhost:8080/AmoraShop/ShowUserController");
        } catch (Exception ex) {
            log("Error at RegistrationController: " + ex.toString());
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
