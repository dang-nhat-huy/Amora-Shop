/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package role;

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
public class RoleDAO {
    private static final String GET_ALL_ROLE = "SELECT * FROM Role WHere role_id != 1";

    public List<RoleDTO> getAllRole() throws SQLException {
        List<RoleDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_ROLE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int role_id = rs.getInt("role_id");
                    String role_name = rs.getString("role_name");

                    list.add(new RoleDTO(role_id, role_name));
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
}
