package JDBC.test;

import JDBC.daos.RegionDao;
import JDBC.models.Region;
import JDBC.tools.DBConnection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainRegionTest {
    DBConnection conn = new DBConnection();

    @Test
    public void insert() {
        // Arrange
        Integer id = 6;
        String Name = "Solo";
        boolean result = true;

        // Act & Assert
        RegionDao insertRegD = new RegionDao(conn.getConnection());
        Region region = new Region();
        region.setRegionId(id);
        region.setRegionName(Name);

        assertEquals(result, insertRegD.insertData(region));
    }

    @Test
    public void update() {
        // Arrange
        Integer id = 2;
        String Name = "Bogor";
        boolean result = true;
        // Act & Assert
        RegionDao updateData = new RegionDao(conn.getConnection());
        Region regionUpdate = new Region();
        regionUpdate.setRegionId(id);
        regionUpdate.setRegionName(Name);
        assertEquals(result, updateData.updateData(regionUpdate));
    }

    @Test
    public void delete() {
        // Arrange
        Integer id = 5;
        boolean result = true;

        // Act & Assert
        RegionDao deleteData = new RegionDao(conn.getConnection());
        Region regionDelete = new Region();
        regionDelete.setRegionId(id);
        assertEquals(result, deleteData.deleteData(regionDelete));
    }

    @Test
    public void getById() {
        // Arrange
        Integer id = 1;
        boolean result = true;

        // // Act & Assert
        RegionDao rdao = new RegionDao(conn.getConnection());
        Region region = new Region();
        region.setRegionId(id);
        assertEquals(result, rdao.getById(region));
    }

    @Test
    public void getAllData() {

        String name = "Jakarta";
        String result = "Jakarta";
        RegionDao rdao = new RegionDao(conn.getConnection());
        for (Region region : rdao.getAll()) {
            System.out.println(region.getRegionId());
            System.out.println(region.getRegionName());
        }
        assertEquals(result, rdao.getAll(name));
    }
}
