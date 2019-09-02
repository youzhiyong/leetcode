package com.yzy.jdbc;

import java.sql.*;

/**
 * Description:
 * Date: 2019-08-29
 *
 * @author youzhiyong
 */
public class JDBCTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/demo";
        String username = "root";
        String password = "root";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            String sql = "select * from user where id=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1 , 1);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
