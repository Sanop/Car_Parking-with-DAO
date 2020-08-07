package business.custom.impl;

import business.custom.DefaultPaymentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.CarCellDAO;
import dao.custom.DefaultPaymentDAO;
import db.DBConnection;
import entity.CarCell;
import entity.DefaultPayment;

import java.sql.Connection;
import java.sql.ResultSet;

public class DefaultPaymentBOImpl implements DefaultPaymentBO {

    DefaultPaymentDAO defaultPaymentDAO = DAOFactory.getInstance().getDAO(DAOType.DEFAULT_PAYMENT);
    Connection connection = DBConnection.getInstance().getConnection();
    CarCellDAO carCellDAO = DAOFactory.getInstance().getDAO(DAOType.CARCELL);

    @Override
    public boolean add(DefaultPayment entity) throws Exception {

        try {

            connection.setAutoCommit(false);

            boolean result = defaultPaymentDAO.add(entity);

            if(!result){
                connection.rollback();
                return false;
            }

            CarCell carCell = new CarCell(entity.getCellId(),"reserved");
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

    @Override
    public boolean update(DefaultPayment entity) throws Exception {

        try {

            connection.setAutoCommit(false);

            boolean result = defaultPaymentDAO.add(entity);

            if(!result){
                connection.rollback();
                return false;
            }

            CarCell carCell = new CarCell(entity.getCellId(),"not reserved");

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

    @Override
    public ResultSet searchByInvoice(String invoice) throws Exception {
        return defaultPaymentDAO.searchByInvoice(invoice);
    }
}
