package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOType daoType){
        switch (daoType){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case CARCELL:
                return (T) new CarCellDAOImpl();
            case DEFAULT_PAYMENT:
                return (T) new DefaultPaymentDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
            case PACKAGE:
                return (T) new PackageDAOImpl();
            case PACKAGE_CELLS:
                return (T) new PackageCellsDAOImpl();
            default:
                return null;
        }
    }
}
