package _JDBC.Gun01;

import _JDBC.Gun02.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent {
    @Test
    public void test1() throws SQLException {
        ResultSet rs=sorguEkrani.executeQuery("select * from language");

        rs.next(); // bir adım ileri
        System.out.println("1.Satır="+ rs.getString(2)); // 2.Column index değil      -ing

        rs.next();  // bir adım ileri
        System.out.println("2.Satır="+ rs.getString("name")); // 2.Column index değil - ital

        rs.previous(); // bir adım geri
        System.out.println("1.Satır="+ rs.getString(2)); // 2.Column index değil      -ing
    }

    @Test
    public void test2() throws SQLException {

        ResultSet rs=sorguEkrani.executeQuery("select * from film");

        rs.absolute(10); // 10 satıra direk git
        System.out.println("10.Satır title="+ rs.getString("title"));

        rs.absolute(5); // 5 satıra direk git
        System.out.println("5.Satır title="+ rs.getString("title"));

        rs.relative(5); // en son nerdeysen, ordan itibaren 5 git.
        System.out.println("10.Satır title="+ rs.getString("title"));
    }

}
