package dao.custom;

import dao.CrudDAO;
import entity.CarCell;

import java.sql.ResultSet;

public interface CarCellDAO extends CrudDAO<CarCell,String> {
    public ResultSet getNotReservedCells() throws Exception;
}
