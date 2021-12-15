package ir.maktab.service;

import ir.maktab.dao.UpdateDao;
import ir.maktab.model.Updates;

public class UpdateService {
    UpdateDao updateDao = new UpdateDao();

    public Integer save(Updates updates) {
        return updateDao.save(updates);

    }
}
