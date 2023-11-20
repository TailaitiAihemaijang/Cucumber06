package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility  {
    public static Connection connection;
    public static Statement statement;
    public List<List<String>> getDataList(String sql) {
        DBConnectionOpen();
        List<List<String>> dataList = new ArrayList<>();


        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                dataList.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnectionClose();
        return dataList;
    }
    public void DBConnectionOpen()
    {
        String HostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(HostUrl, username, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        catch(Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }
    public void DBConnectionClose()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

}
