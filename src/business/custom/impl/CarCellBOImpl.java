package business.custom.impl;

import business.custom.CarCellBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.CarCellDAO;
import entity.CarCell;

import java.sql.ResultSet;
import java.util.List;

public class CarCellBOImpl implements CarCellBO {
    @Override
    public ResultSet getNotReservedCells() throws Exception {
        CarCellDAO carCellDAO = DAOFactory.getInstance().getDAO(DAOType.CARCELL);
        return carCellDAO.getNotReservedCells();
    }

    @Override
    public boolean updateCarCells(String status, String cellId) throws Exception {
        CarCellDAO carCellDAO = DAOFactory.getInstance().getDAO(DAOType.CARCELL);
        return carCellDAO.update(new CarCell(cellId,status));
    }

    @Override
    public List<CarCell> getAllCells() throws Exception {
        CarCellDAO carCellDAO = DAOFactory.getInstance().getDAO(DAOType.CARCELL);
        return carCellDAO.findAll();
    }
}
