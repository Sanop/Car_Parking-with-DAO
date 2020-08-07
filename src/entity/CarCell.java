package entity;

public class CarCell implements SuperEntity{
    private String cellId;
    private String status;

    public CarCell() {
    }

    public CarCell(String cellId, String status) {
        this.cellId = cellId;
        this.status = status;
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CarCell{" +
                "cellId='" + cellId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
