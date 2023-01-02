package JDBC.models;

public class Division {
    private int divisionId;
    private String divisionName, region_id;

    public int getDivisionId() {
        return divisionId;
    }

    public String getRegionId() {
        return region_id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public void setRegionId(String region_id) {
        this.region_id = region_id;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
