package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PackagePaymentDAO;
import entity.PackagePayment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PackagePaymentDAOImpl implements PackagePaymentDAO {
    @Override
    public List<PackagePayment> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM packagePayment");
        List<PackagePayment> payments = new ArrayList<>();
        while(rst.next()){
            payments.add(new PackagePayment(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)));
        }
        return payments;
    }

    @Override
    public PackagePayment find(String pk) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM packagePayment WHERE invoice = ?", pk);
        PackagePayment payment = null;
        if(rst.next()){
            payment = new PackagePayment(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6));
        }
        return payment;
    }

    @Override
    public boolean add(PackagePayment entity) throws Exception {
        return CrudUtil.execute("INSERT INTO packagePayment VALUES(?,?,?,?,?,?,?)",entity.getId(),entity.getPrice(),entity.getCellid(),entity.getInDate(),entity.getOutDate(),entity.getInvoice(),entity.getCid());
    }

    @Override
    public boolean update(PackagePayment entity) throws Exception {
        return CrudUtil.execute("UPDATE packagePayment SET price = ?,cellid = ?,inDate  ?,outDate = ?,invoice = ?",entity.getPrice(),entity.getCellid(),entity.getInDate(),entity.getOutDate(),entity.getInvoice(),entity.getId());
    }

    @Override
    public boolean delete(String pk) throws Exception {
        return CrudUtil.execute("DELETE FROM packagePayment WHERE invoice = ?",pk);
    }
}
