package business.custom.impl;


import business.custom.PaymentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.CarCellDAO;
import dao.custom.DefaultPaymentDAO;
import dao.custom.PaymentDAO;
import db.DBConnection;
import entity.CarCell;
import entity.Payment;

import java.sql.Connection;

public class PaymentBOImpl implements PaymentBO {
    @Override
    public boolean add(Payment entity, CarCell carCell) throws Exception {
        PaymentDAO paymentDAO = DAOFactory.getInstance().getDAO(DAOType.PAYMENT);
        CarCellDAO carCellDAO = DAOFactory.getInstance().getDAO(DAOType.CARCELL);
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            boolean result = paymentDAO.add(entity);
            if(!result){
                connection.rollback();
                return false;
            }

            result = carCellDAO.update(carCell);

            if(!result){
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
    }
}
