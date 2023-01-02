package JDBC.daos;

import JDBC.models.Region;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// import com.mysql.cj.protocol.Resultset;

public class RegionDao {
    private Connection conn;

    public RegionDao(Connection conn) {
        this.conn = conn;
    }

    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        String query = "Select regionId, regionName from Region";
        try {
            ResultSet resultSet = conn.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return regions;
    }

    public List<Region> getById(int id) {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM region WHERE regionId = " + id;

        try {
            ResultSet resultSet = conn
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setRegionId(resultSet.getInt(1));
                region.setRegionName(resultSet.getString(2));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }

    public boolean insertData(Region region) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into region(regionId, regionName) values(?,?)");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateData(Region region) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update region set regionName = ? where regionId = ?");
            preparedStatement.setInt(2, region.getRegionId());
            preparedStatement.setString(1, region.getRegionName());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteData(Region region) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("delete from region where regionId = ?");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    public List<Region> getDataByRegionName() {
        List<Region> region = new ArrayList<>();
        String query = "Select regionName from region where regionName = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, ((Region) region).getRegionName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return region;
    }
}
