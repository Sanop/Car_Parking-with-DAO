package business.custom.impl;

import business.custom.PackageBO;
import business.custom.PackagePaymentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.PackageCellsDAO;
import dao.custom.PackagePaymentDAO;
import dao.custom.PaymentDAO;
import db.DBConnection;
import entity.PackageCells;
import entity.PackagePayment;
import entity.Payment;

import java.sql.Connection;

public class PackagePaymentBOImpl implements PackagePaymentBO {
    @Override
    public boolean add(PackagePayment packagePayment, PackageCells packageCells) throws Exception {
        PackagePaymentDAO packagePaymentDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE_PAYMENT);
        PackageCellsDAO packageCellsDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE_CELLS);
        Connection connection = DBConnection.getInstance().getConnection();

        connection.setAutoCommit(false);

        boolean result = packagePaymentDAO.add(packagePayment);
        if(!result) {
            connection.rollback();
            return false;
        }

        result = packageCellsDAO.update(packageCells);
        if(!result){
            connection.rollback();
            return false;
        }

        connection.commit();
        return true;
    }

    @Override
    public PackagePayment search(String invoice) throws Exception {
        PackagePaymentDAO packagePaymentDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE_PAYMENT);
        return packagePaymentDAO.find(invoice);
    }

    @Override
    public boolean pay(Payment payment, PackageCells packageCells) throws Exception {
        PaymentDAO paymentDAO = DAOFactory.getInstance().getDAO(DAOType.PAYMENT);
        PackageCellsDAO packageCellsDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE_CELLS);

        Connection connection = DBConnection.getInstance().getConnection();

        connection.setAutoCommit(false);

        boolean result = paymentDAO.add(payment);
        if(!result){
            connection.rollback();
            return false;
        }

        result = packageCellsDAO.update(packageCells);

        if(!result){
            connection.rollback();
            return false;
        }

        connection.commit();
        return true;
    }
}
