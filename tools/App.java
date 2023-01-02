package JDBC.tools;

import JDBC.daos.DivisionDao;
import JDBC.models.*;;

public class App {
    public static void main(String[] args) {
        DBConnection conn = new DBConnection();

        // display all data
        DivisionDao divAll = new DivisionDao(conn.getConnection());
        // for (Division div : divAll.getAll()) {
        // System.out.println(div.getDivisionId());
        // System.out.println(div.getDivisionName() + " ");
        // System.out.println(" " + div.getRegionId());
        // System.out.println();
        // }

        // insert data to table division
        // Division divisionInsert = new Division();
        // divisionInsert.setDivisionId(6);
        // divisionInsert.setDivisionName("Operational");
        // divisionInsert.setRegionId("4");
        // System.out.println(divAll.insertData(divisionInsert));

        // update data on table division
        // Division divisionUpdate = new Division();
        // divisionUpdate.setDivisionId(2);
        // divisionUpdate.setRegionId("4");
        // System.out.println(divAll.updateData(divisionUpdate));

        // display data by id
        // divAll.getById(1)
        // .forEach(i -> System.out.println("id = " + i.getDivisionId()
        // + " Division name = " + i.getDivisionName() + " Region Name = " +
        // i.getRegionId()));

        // delete data on database by id
        Division divisionDelete = new Division();
        divisionDelete.setDivisionId(6);
        System.out.println(divAll.deleteData(divisionDelete));
    }
}
