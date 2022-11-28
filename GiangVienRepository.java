package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GiangVien;
import model.loaiGV;
import untility.DBContext;

public class GiangVienRepository {
public List<GiangVien> getAll() {
        String sql = " SELECT giang_vien.manv , dbo.giang_vien.ten, dbo.giang_vien.tuoi, dbo.giang_vien.bac, dbo.giang_vien.gioiTinh, dbo.loai_gv.ten AS loaiGV"
                + " FROM     dbo.giang_vien INNER JOIN"
                + "                  dbo.loai_gv ON dbo.giang_vien.id = dbo.loai_gv.id";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<GiangVien> listGiangVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loaiGV l = new loaiGV(rs.getString(6));
                GiangVien gv = new GiangVien(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5), l);
                listGiangVien.add(gv);
            }
            return listGiangVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public GiangVien getOne(String maNV) {
        String sql = "SELECT   manv,giang_vien.ten, tuoi, bac, gioiTinh, loai_gv.ten AS loaiGV"
                + "FROM     dbo.giang_vien INNER JOIN"
                + "                  loai_gv ON giang_vien.id = dbo.loai_gv.id where manv = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loaiGV l = new loaiGV(rs.getString(6));
                GiangVien gv = new GiangVien(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5), l);
                return gv;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(GiangVien gv) {
        String sql = "insert into giang_vien (ten ,tuoi,bac,gioiTinh,id) values (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, gv.getTenGV());
            ps.setObject(2, gv.getTuoi());
            ps.setObject(3, gv.getBac());
            ps.setObject(4, gv.isGioiTinh());
            ps.setObject(5, gv.getLoaigv().getId());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(GiangVien gv, String maNV) {
        String sql = "UPDATE [dbo].[giang_vien]"
                + "   SET [ten] = ?"
                + "      ,[tuoi] = ?"
                + "      ,[bac] = ?"
                + "      ,[gioiTinh] = ?"
                + "      ,[id] = ?"
                + " WHERE manv = ? ";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, gv.getTenGV());
            ps.setObject(2, gv.getTuoi());
            ps.setObject(3, gv.getBac());
            ps.setObject(4, gv.isGioiTinh());
            ps.setObject(5, gv.getLoaigv().getId());
            ps.setObject(6, maNV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maNV) {
        String sql = "DELETE FROM [dbo].[giang_vien]"
                + "      WHERE manv= ? ";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maNV);

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<GiangVien> sort() {
        String sql = "SELECT   manv,giang_vien.ten, tuoi, bac, gioiTinh, loai_gv.ten AS loaiGV"
                + "  FROM     giang_vien INNER JOIN"
                + "                  loai_gv ON giang_vien.id = dbo.loai_gv.id order by ten asc";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<GiangVien> listGiangVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loaiGV l = new loaiGV(rs.getString(6));
                GiangVien gv = new GiangVien(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5), l);
                listGiangVien.add(gv);
            }

            return listGiangVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<GiangVien> fulltime() {
        String sql = "SELECT   manv,giang_vien.ten, tuoi, bac, gioiTinh, loai_gv.ten AS loaiGV"
                + " FROM    giang_vien INNER JOIN"
                + "                  loai_gv ON giang_vien.id = dbo.loai_gv.id where  loai_gv.ten = 'fulltime'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<GiangVien> listGiangVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loaiGV l = new loaiGV(rs.getString(6));
                GiangVien gv = new GiangVien(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5), l);
                listGiangVien.add(gv);
            }

            return listGiangVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
//        loaiGV loaigv = new loaiGV();
//        loaigv.setId(1);
        GiangVienRepository gvR = new GiangVienRepository();
//        GiangVien gv = new GiangVien(0, "ahahâh", 45, 4, true, loaigv);
//       boolean giangVien = gvR.add(new GiangVien(0, "HUNG", 21, 2, true, loaigv));
//        System.out.println("" + giangVien);
        List<GiangVien> giangVien = gvR.sort();
        // System.out.println(gvR.getOne("1"));
        for (GiangVien giangVien1 : giangVien) {
            System.out.println(giangVien1);
        }

    }
}
