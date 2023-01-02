package JDBC.test;

import JDBC.daos.DivisionDao;
import JDBC.models.Division;
import JDBC.tools.DBConnection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class MainDivisionTest {
    DBConnection conn = new DBConnection();

    @Test
    public void insert() {
        // Arrange
        Integer id = 6;
        String Name = "Operational";
        String regionId = "4";
        boolean result = true;

        // Act & Assert
        DivisionDao insertData = new DivisionDao(conn.getConnection());
        Division div = new Division();
        div.setDivisionId(id);
        div.setDivisionName(Name);
        div.setRegionId(regionId);

        assertEquals(result, insertData.insertData(div));
    }

    @Test
    public void update() {
        // Arrange
        Integer id = 2;
        String regionId = "1";
        boolean result = true;
        // Act & Assert
        DivisionDao div = new DivisionDao(conn.getConnection());
        Division divisionUpdate = new Division();
        divisionUpdate.setDivisionId(id);
        divisionUpdate.setRegionId(regionId);
        assertEquals(result, div.updateData(divisionUpdate));
    }

    @Test
    public void delete() {
        // Arrange
        Integer id = 6;
        boolean result = true;

        // Act & Assert
        DivisionDao div = new DivisionDao(conn.getConnection());
        Division divisionDelete = new Division();
        divisionDelete.setDivisionId(id);
        assertEquals(result, div.deleteData(divisionDelete));
    }

    @Test
    public void getById() {
        // Arrange
        Integer id = 1;
        boolean result = true;

        // // Act & Assert
        DivisionDao div = new DivisionDao(conn.getConnection());
        Division division = new Division();
        division.setDivisionId(id);
        assertEquals(result, div.getById(division));
    }

    @Test
    public void getAllData() {

        List<String> name = new ArrayList<>();
        String result = "Jakarta";
        DivisionDao division = new DivisionDao(conn.getConnection());
        for (Division div : division.getAll()) {
            System.out.println(div.getRegionId());
            System.out.println(div.getDivisionName());
            System.out.println(div.getRegionId());
        }
        assertEquals(result, division.getAll(name));
    }
}
