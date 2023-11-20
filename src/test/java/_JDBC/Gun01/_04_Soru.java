package _JDBC.Gun01;

import _JDBC.Gun02.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {
    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");
        while (rs.next())
            System.out.println(rs.getString("city"));
    }
}
