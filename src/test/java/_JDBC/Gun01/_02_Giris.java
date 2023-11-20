package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static _JDBC.Gun02.JDBCParent.sorguEkrani;

public class _02_Giris {
    @Test
    public void test1() throws SQLException {
        ResultSet sonuc= sorguEkrani.executeQuery("select * from customer");

        sonuc.next();

        System.out.println(sonuc.getString("first_name"));
        System.out.println(sonuc.getString("last_name"));

        sonuc.next();

        System.out.println(sonuc.getString("first_name"));
        System.out.println(sonuc.getString("last_name"));

    }
}
