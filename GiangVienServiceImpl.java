package service.impl;

import java.util.List;
import model.GiangVien;
import repository.GiangVienRepository;
import servcies.GiangVienService;

public class GiangVienServiceImpl implements GiangVienService {

    GiangVienRepository giangVienR = new GiangVienRepository();

    @Override
    public List<GiangVien> getAll() {
        return giangVienR.getAll();
    }

    @Override
    public String add(GiangVien gv) {
        boolean add = giangVienR.add(gv);
        if (add) {
            return "Add thành công";
        } else {
            return "Add không thành công";
        }
    }

    @Override
    public String update(GiangVien gv, String maNV) {
        boolean add = giangVienR.update(gv, maNV);
        if (add) {
            return "Update thành công";
        } else {
            return "Update không thành công";
        }
    }

    @Override
    public String delete(String maNV) {
        boolean add = giangVienR.delete(maNV);
        if (add) {
            return "Delete thành công";
        } else {
            return "Delete không thành công";
        }
    }

    @Override
    public List<GiangVien> sort() {
        return giangVienR.sort();
    }

    @Override
    public List<GiangVien> fulltime() {
        return giangVienR.fulltime();
    }

}
