package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public String getLastCustomerID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id FROM customer ORDER BY id DESC LIMIT 1");
        if(rst.next()){
            return rst.getString(1);
        }else{
            return null;
        }
    }

    @Override
    public List<Customer> findAll() throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT * FROM customer");
        List<Customer> customerList = new ArrayList<>();

        while (rst.next()){
            customerList.add(new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)));
        }
        return customerList;
    }

    @Override
    public Customer find(String pk) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer WHERE id = ?",pk);
        Customer customer = null;
        if(rst.next()){
            customer = new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7));
        }
        return customer;
    }

    @Override
    public boolean add(Customer entity) throws Exception {
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?,?,?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getContact(),entity.getNic(),entity.getCarNumber(),entity.getCarModel());
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return CrudUtil.execute("UPDATE customer SET name = ? ,address = ? , contact = ?,nic = ?,carNumber = ?,CarModel = ? WHERE id = ?",entity.getName(),entity.getAddress(),entity.getContact(),entity.getNic(),entity.getCarNumber(),entity.getCarModel(),entity.getId());
    }

    @Override
    public boolean delete(String pk) throws Exception {
        return CrudUtil.execute("DELETE FROM customer WHERE id = ?",pk);
    }
}
