package dao.custom;

import dao.CrudDAO;
import entity.PackageCells;

import java.sql.ResultSet;

public interface PackageCellsDAO extends CrudDAO<PackageCells,String> {
    public ResultSet getNotReservedCells() throws Exception;
}
