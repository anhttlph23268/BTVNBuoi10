
package servcies;

import java.util.List;
import model.GiangVien;




public interface GiangVienService {
      List<GiangVien> getAll();
       String add(GiangVien gv);
       String update(GiangVien gv,String maNV);
       String delete(String maNV);
       List<GiangVien> sort();
       List<GiangVien> fulltime();
}
