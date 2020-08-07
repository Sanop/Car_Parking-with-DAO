package business.custom;

import business.SuperBO;
import entity.DefaultPayment;

import java.sql.ResultSet;

public interface DefaultPaymentBO extends SuperBO {
    public boolean add(DefaultPayment entity)throws Exception;

    public boolean update(DefaultPayment entity)throws Exception;

    public ResultSet searchByInvoice(String invoice)throws Exception;
}
