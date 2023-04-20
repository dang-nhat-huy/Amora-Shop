/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author long
 */
public class OrderDetailDAO {

    public double createOrderDetail(int orderID, String productID, float price, int quantity) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement st = null;
        float total = 0;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                        + "           ([order_id]\n"
                        + "           ,[product_id]\n"
                        + "           ,[price]\n"
                        + "           ,[quantity]\n"
                        + "           ,[total_price])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?)";
                st = con.prepareStatement(sql);
                st.setInt(1, orderID);
                st.setString(2, productID);
                st.setFloat(3, price);
                st.setInt(4, quantity);
                st.setFloat(5, quantity * price);
                //execute
                int effectedRow = st.executeUpdate();
                if (effectedRow > 0) {
                    total = quantity * price;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (st != null) {
                st.close();
            }
        }
        return total;
    }

}
