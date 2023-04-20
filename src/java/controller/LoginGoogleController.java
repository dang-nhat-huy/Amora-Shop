/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.UserDAO;
import user.UserDTO;
import user.UserGoogleDTO;
import utils.GoogleUtils;

/**
 *
 * @author thaiq
 */
public class LoginGoogleController extends HttpServlet {
   
    private static final String ERROR = "login.jsp";
    private static final String USER_PAGE = "user.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        String url = ERROR;
        try {
            String accessToken = GoogleUtils.getToken(code);
            UserGoogleDTO userGoogle = GoogleUtils.getUserInfo(accessToken);
            if (userGoogle != null) {
                UserDAO userDAO = new UserDAO();
                String email = userGoogle.getEmail();
                boolean userDTO_check = userDAO.checkDuplicate(email);
                UserDTO loginUser = new UserDTO();
                loginUser.setEmail(email);
                loginUser.setFullName(userGoogle.getName());
                loginUser.setStatus("ACTIVE");
                loginUser.setRoleID(2);
                if (userDTO_check == false) {
                    userDAO.insert(loginUser);
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", loginUser);
                    url = USER_PAGE;
                }else if(userDTO_check == true){
                    url = USER_PAGE;
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", loginUser);
                }
            } else {
                request.setAttribute("ERROR", "Incorrect google account");
            }
        } catch (IOException e) {
            log("Error at LoginGoogleController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGoogleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGoogleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
