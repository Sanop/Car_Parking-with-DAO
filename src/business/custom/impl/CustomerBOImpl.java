package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.CustomerDAO;
import entity.Customer;

import java.sql.ResultSet;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public String getNewCustomerId() throws Exception {
        CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
        String lastCustomerID = customerDAO.getLastCustomerID();

        lastCustomerID = lastCustomerID.substring(1, 4);

        int newId = Integer.parseInt(lastCustomerID) + 1;
        if (newId < 10) {
            return "C00" + newId;
        } else if (newId < 100) {
            return "C0" + newId;
        } else if(newId < 1000){
            return "C"+newId;
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
        return customerDAO.findAll();
    }

    @Override
    public boolean saveCustomer(String id, String name, String address, String contact, String nic, String carNumber, String carModel) throws Exception {
        CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
        return customerDAO.add(new Customer(id,name,address,contact,nic,carNumber,carNumber));
    }


    @Override
    public boolean deleteCustomer(String customerId) throws Exception {
        CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
        return customerDAO.delete(customerId);
    }

    @Override
    public boolean updateCustomer(String name, String address, String contact, String nic, String carNumber, String carModel, String customerId) throws Exception {
        CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
        return customerDAO.update(new Customer(customerId,name,address,contact,nic,carNumber,carNumber));
    }

    @Override
    public ResultSet getCustomerIdList() throws Exception {
        CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
        return customerDAO.getCustomerIDList();
    }

    @Override
    public Customer getCustomerByID(String cid) throws Exception {
        CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);
        return customerDAO.getCustomerByCID(cid);
    }

}
