package entity;

public class DefaultPayment implements SuperEntity{
    private int id;
    private String cid;
    private String cellId;
    private String inTime;
    private String outTime;
    private String invoiceNumber;

    public DefaultPayment() {
    }

    public DefaultPayment(int id, String cid, String cellId, String inTime, String outTime) {
        this.id = id;
        this.cid = cid;
        this.cellId = cellId;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public DefaultPayment(String cid, String cellId, String inTime, String outTime, String invoiceNumber) {
        this.cid = cid;
        this.cellId = cellId;
        this.inTime = inTime;
        this.outTime = outTime;
        this.invoiceNumber = invoiceNumber;
    }

    public DefaultPayment(int id, String cid, String cellId, String inTime, String outTime, String invoiceNumber) {
        this.id = id;
        this.cid = cid;
        this.cellId = cellId;
        this.inTime = inTime;
        this.outTime = outTime;
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return "DefaultPayment{" +
                "id=" + id +
                ", cid='" + cid + '\'' +
                ", cellId='" + cellId + '\'' +
                ", inTime='" + inTime + '\'' +
                ", outTime='" + outTime + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                '}';
    }
}
