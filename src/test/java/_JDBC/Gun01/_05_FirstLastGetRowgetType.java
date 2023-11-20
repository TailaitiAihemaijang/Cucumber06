package _JDBC.Gun01;

import _JDBC.Gun02.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_FirstLastGetRowgetType extends JDBCParent {
    @Test
    public void tets() throws SQLException {

        ResultSet rs = sorguEkrani.executeQuery("select city from city");
        rs.last();
        System.out.println(rs.getString(1));

        rs.first();
        System.out.println(rs.getString(1));
        rs.last();
        int kacinciSarirdayim = rs.getRow();
        System.out.println(kacinciSarirdayim);

    }
}
