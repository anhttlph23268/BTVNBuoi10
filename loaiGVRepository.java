package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.loaiGV;
import untility.DBContext;

public class loaiGVRepository {

    public List<loaiGV> getAll() {
        String sql = "select * from loai_gv l";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<loaiGV> listLoaiGV = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loaiGV l = new loaiGV(rs.getInt(1), rs.getString(2));
                listLoaiGV.add(l);
            }
            return listLoaiGV;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public loaiGV getOne(String id) {
        String sql = "select * from loai_gv l where l.id = ? ";

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loaiGV loaigv = new loaiGV(rs.getInt(1), rs.getString(2));
                return loaigv;

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        loaiGVRepository lR = new loaiGVRepository();
//           List<loaiGV> list=lR.getAll();
//           for (loaiGV gV : list) {
//               System.out.println(gV);
//        }
        System.out.println(lR.getOne("2"));
    }

}
