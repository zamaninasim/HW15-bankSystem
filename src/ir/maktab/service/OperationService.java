package ir.maktab.service;

import ir.maktab.dao.OperationDao;
import ir.maktab.model.Operation;

public class OperationService {
    OperationDao operationDao = new OperationDao();

    public void saveOperationService(Operation operation) {
        operationDao.saveOperation(operation);
    }

}
