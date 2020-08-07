package dao.custom;

import dao.CrudDAO;
import entity.DefaultPayment;

import java.sql.ResultSet;

public interface DefaultPaymentDAO extends CrudDAO<DefaultPayment, Integer> {
    public ResultSet searchByInvoice(String invoice)throws Exception;
}
