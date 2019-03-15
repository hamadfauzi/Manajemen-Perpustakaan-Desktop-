package GUI;

import Controller.Con_EditAnggota;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditAnggota extends javax.swing.JFrame {

    public EditAnggota() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tvEditNamaAnggota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tvEditAlamatAnggota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbEditLaki = new javax.swing.JRadioButton();
        rbEditPerempuan = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        tvEditEmailAnggota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tvEditNoTelpAnggota = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCancelEditAnggota = new javax.swing.JButton();
        btnOkAnggota = new javax.swing.JButton();
        cbIDAnggota = new javax.swing.JComboBox<>();
        btnDeleteAnggota = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(204, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit Anggota");

        jLabel3.setText("ID Anggota");

        jLabel4.setText("Nama");

        jLabel5.setText("Alamat");

        buttonGroup1.add(rbEditLaki);
        rbEditLaki.setText("L");

        buttonGroup1.add(rbEditPerempuan);
        rbEditPerempuan.setText("P");

        jLabel6.setText("Gender");

        jLabel7.setText("Email");

        jLabel8.setText("No Telp");

        btnCancelEditAnggota.setBackground(new java.awt.Color(255, 153, 153));
        btnCancelEditAnggota.setText("Cancel");

        btnOkAnggota.setBackground(new java.awt.Color(153, 255, 153));
        btnOkAnggota.setText("OK");

        btnDeleteAnggota.setBackground(new java.awt.Color(255, 102, 102));
        btnDeleteAnggota.setText("Delete");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(tvEditEmailAnggota)
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rbEditLaki)
                                .addGap(18, 18, 18)
                                .addComponent(rbEditPerempuan)
                                .addGap(60, 60, 60))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tvEditAlamatAnggota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(tvEditNamaAnggota)
                                    .addComponent(cbIDAnggota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(tvEditNoTelpAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnOkAnggota)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteAnggota)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelEditAnggota)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbIDAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvEditNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvEditAlamatAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbEditLaki)
                    .addComponent(rbEditPerempuan))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvEditEmailAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvEditNoTelpAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelEditAnggota)
                    .addComponent(btnOkAnggota)
                    .addComponent(btnDeleteAnggota))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelEditAnggota;
    private javax.swing.JButton btnDeleteAnggota;
    private javax.swing.JButton btnOkAnggota;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbIDAnggota;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rbEditLaki;
    private javax.swing.JRadioButton rbEditPerempuan;
    private javax.swing.JTextField tvEditAlamatAnggota;
    private javax.swing.JTextField tvEditEmailAnggota;
    private javax.swing.JTextField tvEditNamaAnggota;
    private javax.swing.JTextField tvEditNoTelpAnggota;
    // End of variables declaration//GEN-END:variables

    public JButton getButtonOkAnggota(){
        return btnOkAnggota;
    }
    public JButton getButtonDeleteAnggota(){
        return btnDeleteAnggota;
    }
    public JButton getButtonCancelEditAnggota(){
        return btnCancelEditAnggota;
    }
    public JTextField getTextFieldEditNamaAnggota(){
        return tvEditNamaAnggota;
    }
    public JTextField getTextFieldEditAlamatAnggota(){
        return tvEditAlamatAnggota;
    }
    public JTextField getTextFieldEditNoTelpAnggota(){
        return tvEditNoTelpAnggota;
    }
    public JTextField getTextFieldEmailAnggota(){
        return tvEditEmailAnggota;
    }
    public JRadioButton getEditGenderLakiAnggota(){
        return rbEditLaki;
    }
    public JRadioButton getEditGenderPerempuanAnggota(){
        return rbEditPerempuan;
    }
    public JComboBox getComboBoxIDAnggota(){
        return cbIDAnggota;
    }
    public void setActionListener(ActionListener a){
        btnOkAnggota.addActionListener(a);
        btnCancelEditAnggota.addActionListener(a);
        btnDeleteAnggota.addActionListener(a);
    }
    
}
