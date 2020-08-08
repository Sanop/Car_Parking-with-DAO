package business.custom;

import business.SuperBO;
import entity.PackageCells;

import java.sql.ResultSet;
import java.util.List;

public interface PackageCellsBO extends SuperBO {
    public ResultSet getNotReservedCells()throws Exception;

    public boolean updateCarCells(String status,String cellId)throws Exception;

    public List<PackageCells> getAllCells()throws Exception;
}
