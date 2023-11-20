package _JDBC.Gun02;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _01_GetAllRowColumn extends JDBCParent {

    @Test
    public void test() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city_id,city,country_id from city");
        rs.last();
        String id = rs.getString(1);
        System.out.println(id);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        rs.next();
        for (int i = 1; i < columnCount; i++) {
            System.out.print(rs.getString(i) + " ");
        }
        System.out.println("***********************");
        for (int i = 1; i < columnCount; i++) {
            System.out.print(rsmd.getColumnName(i) + " ");
        }
    }

    @Test
    public void test3() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columCount = rsmd.getColumnCount();
        for (int i = 1; i <= columCount; i++) {
            System.out.printf("%-12s", rsmd.getColumnName(i));
        }
        System.out.println();
        while (rs.next()) {
            for (int i = 1; i <= columCount; i++) {
                System.out.printf("%-12s", rs.getString(i));
            }
            System.out.println();
        }

    }

    @Test
    public void test4() throws SQLException {
        String sql = "select * from language";
        List<List<String>> lists = getListData(sql);
        System.out.println(lists);
    }

    public List<List<String>> getListData(String sql) {
        List<List<String>> table = new ArrayList<>();


        try {
            ResultSet rs = sorguEkrani.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                table.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return table;
    }
}
