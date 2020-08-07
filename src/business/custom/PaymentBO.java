package business.custom;

import business.SuperBO;
import entity.CarCell;
import entity.Payment;

public interface PaymentBO extends SuperBO {
    public boolean add(Payment entity, CarCell carCell)throws Exception;
}
