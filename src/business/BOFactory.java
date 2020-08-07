package business;

import business.custom.impl.CarCellBOImpl;
import business.custom.impl.CustomerBOImpl;
import business.custom.impl.DefaultPaymentBOImpl;
import business.custom.impl.PaymentBOImpl;

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
            default:
                return null;
        }
    }
}
