/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author thaiq
 */
public class UserDAO {

    private static final String LOGIN = "SELECT * FROM Users WHERE email = ? AND [password] = ?";

    private static final String CHECK_DUPLICATE = "SELECT * FROM Users WHERE email = ? ";

    private static final String INSERT = "INSERT INTO Users(full_name,password,email, status,role_id,image) VALUES(?,?,?,?,?,?)";

    private static final String REGISTER = "insert into Users(full_name, [password], gender, email, phone_number, [address], [status], role_id) values(?,?,?,?,?,?,?,?)";

    private static final String GET_USERS_BY_ID = "SELECT * FROM Users where user_id = ?";
    
    private static final String GET_USERS_BY_NAME = "select * from Users where full_name like ?";

   private static final String UPDATE_USER_BY_ID = "UPDATE [dbo].[Users]\n"
            + "   SET [full_name] = ?\n"
            + "      ,[password] = ?\n"
            + "      ,[gender] = ?\n"
            + "      ,[email] = ?\n"
            + "      ,[phone_number] = ?\n"
            + "      ,[address] = ?\n"
            + "      ,[status] = ?\n"
            + "      ,[role_id] = ?\n"
            + "      ,[image] = ?\n"
            + " WHERE [user_id] = ?";
    
   
   
   
   
   
   
   
   
   
   
   
   private static final String UPDATE_USER_BY_EMAIL = "UPDATE [dbo].[Users]\n"
            + "   SET full_name = ?\n"
            + "      ,[password] = ?\n"
            + "      ,gender = ?\n"
            + "      ,phone_number = ?\n"
            + "      ,address = ?\n"
            + "      ,[image] = ?\n"
            + " WHERE email = ?";
    private static final String CHANGE_PASSWORD = "UPDATE [dbo].[Users] SET [password] = ? WHERE email = ?";
    private static final String GET_IMAGE_BY_USERID = "SELECT image FROM [Users] where user_id = ?";

    public UserDTO checkLogin(String email, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("user_id");
                    String fullName = rs.getString("full_name");
                    password = rs.getString("password");
                    String gender = rs.getString("gender");
                    email = rs.getString("email");
                    String phoneNumber = rs.getString("phone_number");
                    String address = rs.getString("address");
                    String status = rs.getString("status");
                    int roleID = rs.getInt("role_id");
                    String image = rs.getString("image");

                    user = new UserDTO(userID, fullName, password, gender, email, phoneNumber, address, status, roleID, image);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public boolean checkDuplicate(String email) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public void register(String fullName, String password, String gender, String email, String phoneNumber, String address) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("INSERT INTO dbo.Users( full_name, [password], gender, email, phone_number, [address], [status], role_id) values(?,?,?,?,?,?,?,?)");
                ptm.setString(1, fullName);
                ptm.setString(2, password);
                ptm.setString(3, gender);
                ptm.setString(4, email);
                ptm.setString(5, phoneNumber);
                ptm.setString(6, address);
                ptm.setString(7, "ACTIVE");
                ptm.setInt(8, 2);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean insert(UserDTO user) throws SQLException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getPassword());
                ptm.setString(3, user.getEmail());
                ptm.setString(4, "ACTIVE");
                ptm.setInt(5, 2);
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }

    public List<UserDTO> getAllUsers() throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        UserDTO user = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Users");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("user_id");
                    String fullName = rs.getString("full_name");
                    String password = rs.getString("password");
                    String gender = rs.getString("gender");
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phone_number");
                    String address = rs.getString("address");
                    String status = rs.getString("status");
                    int roleID = rs.getInt("role_id");
                    // list.add(new UserDTO(userID, fullName, password, gender, email, phoneNumber, address, status, roleID));
                    String image = rs.getString("image");

                    user = new UserDTO(userID, fullName, password, gender, email, phoneNumber, address, status, roleID, image);
                    list.add(user);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ptm != null) {
                    ptm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error when closing connection: " + e.getMessage());
            }
        }
        return list;
    }

    public UserDTO getUserByID() {
        UserDTO user = null;

        return user;
    }

    public void updateUserByEmail(String fullName, String gender, String phoneNumber, String address, String email,String image) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_USER_BY_EMAIL);
                ptm.setString(1, fullName);
                ptm.setString(2, gender);
                ptm.setString(3, phoneNumber);
                ptm.setString(4, address);
                ptm.setString(5, email);
                ptm.setString(6, image);
                ptm.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void updatePassword(String email, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHANGE_PASSWORD);
                ptm.setString(1, email);
                ptm.setString(2, password);
                ptm.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
     public UserDTO getUserById(int userID) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_USERS_BY_ID);
                ptm.setInt(1, userID);

                rs = ptm.executeQuery();
                while (rs.next()) {
                    userID = rs.getInt("user_id");
                    String fullName = rs.getString("full_name");
                    String password = rs.getString("password");
                    String gender = rs.getString("gender");
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phone_number");
                    String address = rs.getString("address");
                    String status = rs.getString("status");
                    int roleID = rs.getInt("role_id");
                    String image = rs.getString("image");
                    user = new UserDTO(userID, fullName, password, gender, email, phoneNumber, address, status, roleID, image);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public void updateUserById(UserDTO updateUser) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                 ptm = conn.prepareStatement(UPDATE_USER_BY_ID);
                ptm.setString(1, updateUser.getFullName());
                ptm.setString(2, updateUser.getPassword());
                ptm.setString(3, updateUser.getGender());
                ptm.setString(4, updateUser.getEmail());
                ptm.setString(5, updateUser.getPhoneNumber());
                ptm.setString(6, updateUser.getAddress());
                ptm.setString(7, updateUser.getStatus());
                ptm.setInt(8, updateUser.getRoleID());
                ptm.setString(9, updateUser.getImage());
                ptm.setInt(10, updateUser.getUserID());

                ptm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }


     public List<UserDTO> getUserByName(String name) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_USERS_BY_NAME);
                ptm.setString(1, "%" + name + "%");

                rs = ptm.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("user_id");
                    String fullName = rs.getString("full_name");
                    String password = rs.getString("password");
                    String gender = rs.getString("gender");
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phone_number");
                    String address = rs.getString("address");
                    String status = rs.getString("status");
                    int roleID = rs.getInt("role_id");
                    String image = rs.getString("image");
                    user = new UserDTO(userID, fullName, password, gender, email, phoneNumber, address, status, roleID, image);
                    list.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
      public String getUrlImageById(int userID) throws SQLException {

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_IMAGE_BY_USERID);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    return rs.getString(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return null;

    }

}
