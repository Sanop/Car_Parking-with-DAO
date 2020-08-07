package business.custom;

import business.SuperBO;
import entity.DefaultPayment;

public interface DefaultPaymentBO extends SuperBO {
    public boolean add(DefaultPayment entity)throws Exception;

    public boolean update(DefaultPayment entity)throws Exception;
}
