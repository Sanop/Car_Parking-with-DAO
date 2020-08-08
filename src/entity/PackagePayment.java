package entity;

public class PackagePayment implements SuperEntity{
    private String id;
    private String price;
    private String cellid;
    private String inDate;
    private String outDate;
    private String invoice;

    public PackagePayment() {
    }

    public PackagePayment(String id, String price, String cellid, String inDate, String outDate, String invoice) {
        this.id = id;
        this.price = price;
        this.cellid = cellid;
        this.inDate = inDate;
        this.outDate = outDate;
        this.invoice = invoice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCellid() {
        return cellid;
    }

    public void setCellid(String cellid) {
        this.cellid = cellid;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "PackagePayment{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", cellid='" + cellid + '\'' +
                ", inDate='" + inDate + '\'' +
                ", outDate='" + outDate + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }
}
