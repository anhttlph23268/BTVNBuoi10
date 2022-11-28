package service.impl;

import java.util.List;
import model.loaiGV;
import repository.loaiGVRepository;
import servcies.loaiGVService;

public class loaiGVServiceImpl implements loaiGVService {

    loaiGVRepository lGVR = new loaiGVRepository();

    @Override
    public List<loaiGV> getAll() {
        return lGVR.getAll();
    }

    @Override
    public loaiGV getOne(String id) {
        return lGVR.getOne(id);
    }

}
