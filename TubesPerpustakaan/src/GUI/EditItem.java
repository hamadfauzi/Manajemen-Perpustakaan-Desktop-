package GUI;

import Controller.Con_EditItem;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditItem extends javax.swing.JFrame {

    public EditItem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbEditBuku = new javax.swing.JRadioButton();
        rbEditCD = new javax.swing.JRadioButton();
        btnCancelEditItem = new javax.swing.JButton();
        btnOkItem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tvEditJudulItem = new javax.swing.JTextField();
        tvEditPenerbit = new javax.swing.JTextField();
        tvEditJumlahItem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbIDItem = new javax.swing.JComboBox<>();
        btnDeleteItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(204, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit Item");

        jLabel3.setText("ID Item");

        buttonGroup1.add(rbEditBuku);
        rbEditBuku.setText("Buku");
        rbEditBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEditBukuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbEditCD);
        rbEditCD.setText("CD/DVD");

        btnCancelEditItem.setBackground(new java.awt.Color(255, 153, 153));
        btnCancelEditItem.setText("Cancel");

        btnOkItem.setBackground(new java.awt.Color(153, 255, 153));
        btnOkItem.setText("OK");

        jLabel9.setText("Judul");

        jLabel10.setText("Penerbit");

        jLabel11.setText("Kategori");

        jLabel12.setText("Jumlah");

        btnDeleteItem.setBackground(new java.awt.Color(255, 102, 102));
        btnDeleteItem.setText("Delete");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnOkItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelEditItem))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tvEditJumlahItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rbEditBuku)
                                .addGap(18, 18, 18)
                                .addComponent(rbEditCD)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tvEditPenerbit)
                            .addComponent(tvEditJudulItem, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(cbIDItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbIDItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEditBuku)
                    .addComponent(jLabel11)
                    .addComponent(rbEditCD))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tvEditJudulItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tvEditPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvEditJumlahItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelEditItem)
                    .addComponent(btnOkItem)
                    .addComponent(btnDeleteItem))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbEditBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEditBukuActionPerformed

    }//GEN-LAST:event_rbEditBukuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelEditItem;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnOkItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbIDItem;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rbEditBuku;
    private javax.swing.JRadioButton rbEditCD;
    private javax.swing.JTextField tvEditJudulItem;
    private javax.swing.JTextField tvEditJumlahItem;
    private javax.swing.JTextField tvEditPenerbit;
    // End of variables declaration//GEN-END:variables

    public void setActionListener(ActionListener a){
        btnOkItem.addActionListener(a);
        btnCancelEditItem.addActionListener(a);
        btnDeleteItem.addActionListener(a);
    }
    public JButton getButtonOkItem(){
        return btnOkItem;
    }
    public JButton getButtonCancelEditItem(){
        return btnCancelEditItem;
    }
    public JButton getButtonDeleteItem(){
        return btnDeleteItem;
    }
    public JTextField getTextFieldEditJudulItem(){
        return tvEditJudulItem;
    }
    public JTextField getTextFieldEditJumlahItem(){
        return tvEditJumlahItem;
    }
    public JTextField getTextFieldEditPenerbitItem(){
        return tvEditPenerbit;
    }
    public JRadioButton getRadioButtonEditBuku(){
        return rbEditBuku;
    }
    public JRadioButton getRadioButtonEditCD(){
        return rbEditCD;
    }
    public JComboBox getComboBoxIDItem(){
        return cbIDItem;
    }
}
