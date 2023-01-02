package JDBC.daos;

import JDBC.models.*;
import java.sql.*;
import java.util.*;

public class DivisionDao {
    private Connection conn;

    public DivisionDao(Connection conn) {
        this.conn = conn;
    }

    // get all data from table division
    public List<Division> getAll() {
        List<Division> division = new ArrayList<>();
        String query = "Select d.divisionId, r.regionName, d.divisionName from division d join region r  on d.region_id = r.regionId order by d.divisionId asc";
        try {
            ResultSet resultSet = conn.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return division;
    }

    // get data by id from table division
    public List<Division> getById(int id) {
        List<Division> division = new ArrayList<>();
        String query = "Select d.divisionId, r.regionName, d.divisionName from division d join region r  on d.region_id = r.regionId where divisionId = "
                + id;
        try {
            ResultSet resultSet = conn.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return division;
    }

    // insert data to table division
    public boolean insertData(Division division) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into division(divisionId, divisionName, region_id) values(?,?,?)");
            preparedStatement.setInt(1, division.getDivisionId());
            preparedStatement.setString(2, division.getDivisionName());
            preparedStatement.setString(3, division.getRegionId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    // update data on table division
    public boolean updateData(Division division) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update division set region_id = ? where divisionId = ?");
            preparedStatement.setInt(2, division.getDivisionId());
            preparedStatement.setString(1, division.getRegionId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteData(Division division) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("delete from division where divisionId = ?");
            preparedStatement.setInt(1, division.getDivisionId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

}
