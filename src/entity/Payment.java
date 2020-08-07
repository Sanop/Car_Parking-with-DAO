package entity;

public class Payment implements SuperEntity{
    private String invoice;
    private String payment;
    private String date;

    public Payment() {
    }

    public Payment(String invoice, String payment, String date) {
        this.invoice = invoice;
        this.payment = payment;
        this.date = date;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "invoice='" + invoice + '\'' +
                ", payment='" + payment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
