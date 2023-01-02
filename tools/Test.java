package JDBC.tools;

import JDBC.models.Region;
import JDBC.daos.RegionDao;
// import JDBC.daos.Region;

public class Test {
    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        // System.out.println(conn.getConnection());

        // display all data
        // RegionDao rdao = new RegionDao(conn.getConnection());
        // for (Region region : rdao.getAll()) {
        // System.out.println(region.getRegionId());
        // System.out.println(region.getRegionName());
        // }

        // display data by id
        RegionDao rdaoNew = new RegionDao(conn.getConnection());
        rdaoNew.getById(2)
                .forEach(i -> System.out.println("id = " + i.getRegionId()
                        + " name = " + i.getRegionName()));

        // insert data to database
        // RegionDao insertData = new RegionDao(conn.getConnection());
        // Region regionInsert = new Region();
        // regionInsert.setRegionId(4);
        // regionInsert.setRegionName("Bandung");
        // System.out.println(insertData.insertData(regionInsert));

        // update data on database
        RegionDao updateData = new RegionDao(conn.getConnection());
        Region regionUpdate = new Region();
        regionUpdate.setRegionId(2);
        regionUpdate.setRegionName("Bogor");
        System.out.println(updateData.updateData(regionUpdate));

        // delete data on database by id
        // RegionDao deleteData = new RegionDao(conn.getConnection());
        // Region regionDelete = new Region();
        // regionDelete.setRegionId(3);
        // System.out.println(deleteData.deleteData(regionDelete));

    }
}

// Region newRegion = new Region();
// newRegion.setRegionId(2);
// newRegion.setRegionName("Bali");
// RegionDao updateData = new RegionDao(conn.getConnection());
// updateData.updateData(newRegion);

// RegionDao updateData = new RegionDao(conn.getConnection());
// Region region = new Region();
// region.setRegionId(1);
// region.setRegionName("Lampung");
// updateData.updateData(region);