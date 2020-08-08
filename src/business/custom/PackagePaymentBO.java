package business.custom;

import business.SuperBO;
import entity.PackageCells;
import entity.PackagePayment;
import entity.Payment;

public interface PackagePaymentBO extends SuperBO {
    public boolean add(PackagePayment packagePayment, PackageCells packageCells)throws Exception;

    public PackagePayment search(String invoice)throws Exception;

    public boolean pay(Payment payment,PackageCells packageCells)throws Exception;
}
