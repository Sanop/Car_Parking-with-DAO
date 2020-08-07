package business.custom.impl;


import business.custom.PaymentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.PaymentDAO;
import entity.Payment;

public class PaymentBOImpl implements PaymentBO {
    @Override
    public boolean add(Payment entity) throws Exception {
        PaymentDAO paymentDAO = DAOFactory.getInstance().getDAO(DAOType.PAYMENT);
        return paymentDAO.add(entity);
    }
}
