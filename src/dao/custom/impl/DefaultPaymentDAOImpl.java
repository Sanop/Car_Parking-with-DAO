package dao.custom.impl;

import dao.CrudDAO;
import dao.CrudUtil;
import dao.custom.DefaultPaymentDAO;
import entity.DefaultPayment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DefaultPaymentDAOImpl implements DefaultPaymentDAO {
    @Override
    public List<DefaultPayment> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM defaultPayment");
        List<DefaultPayment> payments = new ArrayList<>();
        while(rst.next()){
            payments.add(new DefaultPayment(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)));
        }

        return payments;
    }

    @Override
    public DefaultPayment find(Integer pk) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM defaultPayment WHERE id = ?", pk);
        DefaultPayment defaultPayment = null;
        if(rst.next()){
            defaultPayment = new DefaultPayment(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5));
        }
        return defaultPayment;
    }


    @Override
    public boolean add(DefaultPayment entity) throws Exception {
        return CrudUtil.execute("INSERT INTO defaultPayment (cid,cellId,inTime,outTime,invoiceNumber)VALUES(?,?,?,?,?)",entity.getCid(),entity.getCellId(),entity.getInTime(),entity.getOutTime(),entity.getInvoiceNumber());
    }

    @Override
    public boolean update(DefaultPayment entity) throws Exception {
        return CrudUtil.execute("UPDATE defaultPayment SET cid = ? ,cellId = ?,inTime = ?,outTime = ? WHERE id = ?",entity.getCid(),entity.getCellId(),entity.getInTime(),entity.getOutTime(),entity.getId());
    }

    @Override
    public boolean delete(Integer pk) throws Exception {
        return CrudUtil.execute("DELETE FROM defaultPayment WHERE id = ?",pk);
    }

    @Override
    public ResultSet searchByInvoice(String invoice) throws Exception {
        return CrudUtil.execute("SELECT * FROM defaultPayment WHERE invoiceNumber = ?",invoice);
    }
}
