package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import model.GiangVien;
import model.loaiGV;
import servcies.GiangVienService;
import servcies.loaiGVService;
import service.impl.GiangVienServiceImpl;
import service.impl.loaiGVServiceImpl;

public class ViewGV extends javax.swing.JFrame {

    private DefaultComboBoxModel DCBMBac = new DefaultComboBoxModel();
    private DefaultComboBoxModel DCBMLoai    = new DefaultComboBoxModel();
    //

    //
    private loaiGVService loaiGVService = new loaiGVServiceImpl();
    private GiangVienService giangVienService = new GiangVienServiceImpl();
    // 
    private DefaultTableModel dtm = new DefaultTableModel();
    //
    List<GiangVien> listGiangVien = new ArrayList<>();
    List<loaiGV> listloaiGV = new ArrayList<>();
    //

    public ViewGV() {
        initComponents();
        CBBBAC.setModel(DCBMBac);
        CBBLoai.setModel(DCBMLoai);
        jTable1.setModel(dtm);
        //
        String[] header = {"Mã GV", "Tên", "Tuổi", "Bậc GV", "Giới Tính", "Loại Giảng Viên"};
        dtm.setColumnIdentifiers(header);
        listGiangVien = giangVienService.getAll();
        listloaiGV = loaiGVService.getAll();
        //
        listGiangVien.forEach(bacgv -> {
            CBBBAC.addItem(String.valueOf(bacgv.getBac()));
        });
        listloaiGV.forEach(loaigv -> {
            CBBLoai.addItem(String.valueOf(loaigv.getId()));
        });

        loaiGV loaigv = loaiGVService.getOne(CBBLoai.getSelectedItem().toString());
        jLabel8.setText(loaigv.getTen());
        showDaTable(listGiangVien);
        fillDaTa(0);
    }

    private void showDaTable(List<GiangVien> lists) {
        dtm.setRowCount(0);
        for (GiangVien list : lists) {
            dtm.addRow(list.toDataRow());
        }
    }

    private void fillDaTa(int index) {
        GiangVien gv = listGiangVien.get(index);
        //
        txtMa.setText(String.valueOf(gv.getMaNV()));
        txtTen.setText(gv.getTenGV());
        txtTuoi.setText(String.valueOf(gv.getTuoi()));
        CBBBAC.setSelectedItem(String.valueOf(gv.getBac()));
        if (gv.isGioiTinh()) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }

        if (gv.getLoaigv().getTen().equalsIgnoreCase("fulltime")) {
            CBBLoai.setSelectedIndex(0);
        } else {
            CBBLoai.setSelectedIndex(1);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btClear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        CBBBAC = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CBBLoai = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        rdoNu = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        btAdd = new javax.swing.JButton();
        btFullTime = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btSapXep = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Giảng Viên");

        btClear.setText("Clear Form");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Tên");

        jLabel4.setText("Tuổi");

        CBBBAC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBBBAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBBBACActionPerformed(evt);
            }
        });

        jLabel5.setText("Bậc");

        jLabel6.setText("Loại Giảng Viên");

        CBBLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBBLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBBLoaiActionPerformed(evt);
            }
        });

        jLabel7.setText("Giới Tính");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btFullTime.setText("FullTime");
        btFullTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFullTimeActionPerformed(evt);
            }
        });

        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btSapXep.setText("Sắp Xếp");
        btSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSapXepActionPerformed(evt);
            }
        });

        btThoat.setText("Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btClear)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAdd))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CBBBAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CBBLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btFullTime)
                                                .addGap(18, 18, 18)
                                                .addComponent(btSua)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btXoa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btSapXep))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(btThoat)
                                                .addGap(51, 51, 51))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btClear))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBBBAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CBBLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(jLabel8))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btFullTime)
                    .addComponent(btSua)
                    .addComponent(btXoa)
                    .addComponent(btSapXep)
                    .addComponent(btThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CBBLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBBLoaiActionPerformed
        loaiGV loaigv = loaiGVService.getOne(CBBLoai.getSelectedItem().toString());
        jLabel8.setText(loaigv.getTen());
    }//GEN-LAST:event_CBBLoaiActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btThoatActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fillDaTa(jTable1.getSelectedRow());

    }//GEN-LAST:event_jTable1MouseClicked

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
            String id = txtMa.getText();
        String ten = txtTen.getText();
        String tuoi = txtTuoi.getText();
        String bac = CBBBAC.getSelectedItem().toString();
        boolean gioiTinh = rdoNam.isSelected();
        loaiGV loaiGv = new loaiGV();
        loaiGv.setId(Integer.valueOf(CBBLoai.getSelectedItem().toString()));
        GiangVien gv = new GiangVien(Integer.valueOf(id), ten, Integer.valueOf(tuoi), Integer.valueOf(bac), gioiTinh, loaiGv);
        JOptionPane.showMessageDialog(this, giangVienService.add(gv));
        listGiangVien = giangVienService.getAll();
        showDaTable(listGiangVien);
    }//GEN-LAST:event_btAddActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        String id = txtMa.getText();
        String ten = txtTen.getText();
        String tuoi = txtTuoi.getText();
        String bac = CBBBAC.getSelectedItem().toString();
        boolean gioiTinh = rdoNam.isSelected();
        loaiGV loaiGv = new loaiGV();
        loaiGv.setId(Integer.valueOf(CBBLoai.getSelectedItem().toString()));
        GiangVien gv = new GiangVien(Integer.valueOf(id), ten, Integer.valueOf(tuoi), Integer.valueOf(bac), gioiTinh, loaiGv);
        JOptionPane.showMessageDialog(this, giangVienService.update(gv, id));
        listGiangVien = giangVienService.getAll();
        showDaTable(listGiangVien);
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        String id = txtMa.getText();
        JOptionPane.showMessageDialog(this, giangVienService.delete(id));
        listGiangVien = giangVienService.getAll();
        showDaTable(listGiangVien);

    }//GEN-LAST:event_btXoaActionPerformed

    private void btSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSapXepActionPerformed
        listGiangVien = giangVienService.sort();

        showDaTable(listGiangVien);
    }//GEN-LAST:event_btSapXepActionPerformed

    private void btFullTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFullTimeActionPerformed
        listGiangVien = giangVienService.fulltime();

        showDaTable(listGiangVien);
    }//GEN-LAST:event_btFullTimeActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        txtMa.setText("");
        txtTen.setText("");
        txtTuoi.setText("");
        CBBBAC.setSelectedItem("1");
        CBBLoai.setSelectedItem("1");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_btClearActionPerformed

    private void CBBBACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBBBACActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBBBACActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBBBAC;
    private javax.swing.JComboBox<String> CBBLoai;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btFullTime;
    private javax.swing.JButton btSapXep;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
