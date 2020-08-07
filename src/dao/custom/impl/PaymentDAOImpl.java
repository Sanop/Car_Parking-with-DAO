package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PaymentDAO;
import entity.Payment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public List<Payment> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM payment");
        List<Payment> payments = new ArrayList<>();
         while(rst.next()){
             payments.add(new Payment(rst.getString(1),
                     rst.getString(2),
                     rst.getString(3)));
         }
        return payments;
    }

    @Override
    public Payment find(String pk) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM payment WHERE invoice = ?", pk);
        Payment payment = null;
        if(rst.next()){
            payment = new Payment(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }
        return payment;
    }

    @Override
    public boolean add(Payment entity) throws Exception {
        return CrudUtil.execute("INSERT INTO payment VALUES(?,?,?)",entity.getInvoice(),entity.getPayment(),entity.getDate());
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        return CrudUtil.execute("UPDATE payment SET payment = ?,date = ? WHERE invoice = ?",entity.getPayment(),entity.getDate(),entity.getInvoice());
    }

    @Override
    public boolean delete(String pk) throws Exception {
        return CrudUtil.execute("DELETE FROM payment WHERE invoice = ?",pk);
    }
}
