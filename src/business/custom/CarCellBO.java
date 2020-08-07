package business.custom;

import business.SuperBO;
import entity.CarCell;
import entity.Customer;

import java.sql.ResultSet;
import java.util.List;

public interface CarCellBO extends SuperBO {

    public ResultSet getNotReservedCells()throws Exception;

    public boolean updateCarCells(String status,String cellId)throws Exception;

    public List<CarCell> getAllCells()throws Exception;
}
