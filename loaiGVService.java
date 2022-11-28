package servcies;

import java.util.List;
import model.loaiGV;

public interface loaiGVService {

    List<loaiGV> getAll();

    loaiGV getOne(String id);
}
