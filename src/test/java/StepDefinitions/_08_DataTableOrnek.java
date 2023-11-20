package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _08_DataTableOrnek {
    @io.cucumber.java.en.When("Write usename {string}")
    public void writeUsename(String arg0) {
        System.out.println("username " + arg0);
    }

    @io.cucumber.java.en.And("Write username anPassword {string} and {string}")
    public void writeUsernameAnPasswordAnd(String arg0, String arg1) {
        System.out.println(arg0 + " " + arg1);
    }

    @And("Write username as DataTable1")
    public void writeUsernameAsDataTable(DataTable userlar) {
        List<String> stringUserlar = userlar.asList(String.class);

        for (String user: stringUserlar)
            System.out.println(user);

    }

    @And("Write username and Pssword ad DataTable")
    public void writeUsernameAndPsswordAdDataTable(DataTable Users_Pas) {
        List<List<String>> list_user_pas = Users_Pas.asLists(String.class);

        for (int i = 0;i < list_user_pas.size();i++){
            System.out.println(list_user_pas.get(i).get(0)+ " " + list_user_pas.get(i).get(1));
        }
    }
}
