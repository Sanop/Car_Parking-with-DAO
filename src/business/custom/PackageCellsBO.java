package business.custom;

import business.SuperBO;

import java.sql.ResultSet;

public interface PackageCellsBO extends SuperBO {
    public ResultSet getNotReservedCells()throws Exception;

    public boolean updateCarCells(String status,String cellId)throws Exception;
}
