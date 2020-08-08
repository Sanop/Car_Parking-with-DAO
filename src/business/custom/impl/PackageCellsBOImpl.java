package business.custom.impl;

import business.custom.PackageCellsBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.PackageCellsDAO;
import entity.PackageCells;

import java.sql.ResultSet;

public class PackageCellsBOImpl implements PackageCellsBO {
    @Override
    public ResultSet getNotReservedCells() throws Exception {
        PackageCellsDAO packageCellsDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE_CELLS);
        return packageCellsDAO.getNotReservedCells();
    }

    @Override
    public boolean updateCarCells(String status, String cellId) throws Exception {
        PackageCellsDAO packageCellsDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE_CELLS);
        return packageCellsDAO.update(new PackageCells(cellId,status));
    }
}
