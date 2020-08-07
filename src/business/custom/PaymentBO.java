package business.custom;

import business.SuperBO;
import entity.Payment;

public interface PaymentBO extends SuperBO {
    public boolean add(Payment entity)throws Exception;
}
