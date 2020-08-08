package business;

import business.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory == null) ?boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case CARCELL:
                return (T) new CarCellBOImpl();
            case DEFAULT_PAYMENT:
                return (T) new DefaultPaymentBOImpl();
            case PAYMENT:
                return (T) new PaymentBOImpl();
            case PACKAGE:
                return (T) new PackageBOImpl();
            case PACKAGE_CELLS:
                return (T) new PackageCellsBOImpl();
            case PACKAGE_PAYMENT:
                return (T) new PackagePaymentBOImpl();
            case USERS:
                return (T) new UsersBOImpl();
            default:
                return null;
        }
    }
}
