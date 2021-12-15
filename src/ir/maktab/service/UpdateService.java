package ir.maktab.service;

import ir.maktab.dao.UpdateDao;
import ir.maktab.model.Update;

public class UpdateService {
    UpdateDao updateDao = new UpdateDao();

    public Integer save(Update update) {
        return updateDao.save(update);

    }
}
