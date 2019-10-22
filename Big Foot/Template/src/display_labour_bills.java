
import DataAcess.DataAcess;
import businesslogic.Labour;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahru
 */
public class display_labour_bills extends javax.swing.JFrame {

    /**
     * Creates new form display_labour_bills
     */
    private DataAcess da = new DataAcess();
    Labour l;
    private LinkedList<Labour> lList = new LinkedList<Labour>();
    public display_labour_bills() {
        initComponents();
//        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
//        model.setRowCount(0);
        init();
    }
    ///////////////
    ///////////////
    // SELF METHODS
    ///////////////
    /////////////////

    private void init(){
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        txtBillNumber.setVisible(false);
        lblBillNumber.setVisible(false);
        setBillList();
        DefaultTableModel model = (DefaultTableModel) tblBills.getModel();
        setTableModel(model);
    }
    
    private void setTableModel(DefaultTableModel model){
        model.setNumRows(0);
        for (int i = 0; i < lList.size(); i++) {
            model.addRow(new Object[] {lList.get(i).getName(),lList.get(i).getBillNo(),
                    lList.get(i).getInvNo(),lList.get(i).getDate(),lList.get(i).getCost(),
                    lList.get(i).getDuration()});
        }
    }
    private void setBillList(){
       lList = da.get_labourBills();
    }
    ///////////////
    ///////////////
    // EVENTS
    ///////////////
    /////////////////
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBillNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBills = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnShowBill = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblSearchNames = new javax.swing.JLabel();
        txtSearchNames = new javax.swing.JTextField();
        lblBillNumber = new javax.swing.JLabel();
        lblSearchBy = new javax.swing.JLabel();
        cmbSearchBy = new javax.swing.JComboBox<String>();
        btnDeleteBill = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCustomerDashboard = new javax.swing.JButton();
        btnGenerateLabourBill = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));

        txtBillNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtBillNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search Result:");

        tblBills.setAutoCreateRowSorter(true);
        tblBills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "LB-001", "INV-001", "31/8/2019", "50", "5 hrs"}
            },
            new String [] {
                "Company Name", "Bill #", "Invoice #", "Date", "Amount", "Duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBills.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBills);

        btnSearch.setBackground(java.awt.SystemColor.window);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(102, 102, 102));
        btnSearch.setText("Search");
        btnSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnShowBill.setBackground(java.awt.SystemColor.window);
        btnShowBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnShowBill.setForeground(new java.awt.Color(102, 102, 102));
        btnShowBill.setText("Show Bill");
        btnShowBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnShowBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowBillActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LABOUR BILLS");

        lblSearchNames.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSearchNames.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchNames.setText("Search Names:");

        txtSearchNames.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtSearchNames.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblBillNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBillNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblBillNumber.setText("Enter Bill No:");

        lblSearchBy.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblSearchBy.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchBy.setText("Search By:");

        cmbSearchBy.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        cmbSearchBy.setForeground(new java.awt.Color(112, 112, 112));
        cmbSearchBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bill No", "Company Name", "Invoice No", "Date" }));
        cmbSearchBy.setBorder(null);

        btnDeleteBill.setBackground(java.awt.SystemColor.window);
        btnDeleteBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDeleteBill.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteBill.setText("Delete Bill");
        btnDeleteBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnDeleteBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(lblSearchBy)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblSearchNames)
                        .addGap(20, 20, 20)
                        .addComponent(txtSearchNames)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(lblBillNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBillNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDeleteBill, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 620, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(lblSearchBy)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSearchNames)
                            .addComponent(txtSearchNames, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteBill)
                        .addGap(5, 5, 5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowBill)
                    .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBillNumber))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(234, 234, 234)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel3.setBackground(new java.awt.Color(247, 245, 230));

        btnCustomerDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomerDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomerDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_user_2.png"))); // NOI18N
        btnCustomerDashboard.setText(" Client                    ");
        btnCustomerDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCustomerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerDashboardActionPerformed(evt);
            }
        });

        btnGenerateLabourBill.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerateLabourBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerateLabourBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ps-euro-bill.png"))); // NOI18N
        btnGenerateLabourBill.setText("Generate Labour Bill");
        btnGenerateLabourBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnGenerateLabourBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateLabourBillActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_home.png"))); // NOI18N
        btnHome.setText(" Home                  ");
        btnHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoo transparent 2.png"))); // NOI18N
        jLabel16.setText("jLabel10");
        jLabel16.setIconTextGap(0);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGenerateLabourBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 0, 0)
                .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnGenerateLabourBill, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblBills.getModel();
        if (!txtSearchNames.getText().trim().isEmpty()) {
            String toSearch = txtSearchNames.getText().trim().toUpperCase();
            model.setRowCount(0);
            if (cmbSearchBy.getSelectedItem().equals("Bill No")){
                for (int i = 0; i < lList.size(); i++) {
                    if (toSearch.equals(lList.get(i).getBillNo().toUpperCase())) {
                        model.addRow(new Object[] {lList.get(i).getName(),lList.get(i).getBillNo(),
                        lList.get(i).getInvNo(),lList.get(i).getDate(),lList.get(i).getCost(),
                        lList.get(i).getDuration()});                        
                    }
                }
            }
            else if(cmbSearchBy.getSelectedItem().equals("Company Name")){
                for (int i = 0; i < lList.size(); i++) {
                    if (toSearch.equals(lList.get(i).getName().toUpperCase())) {
                        model.addRow(new Object[] {lList.get(i).getName(),lList.get(i).getBillNo(),
                        lList.get(i).getInvNo(),lList.get(i).getDate(),lList.get(i).getCost(),
                        lList.get(i).getDuration()});                        
                    }
                }
            }
            else if(cmbSearchBy.getSelectedItem().equals("Invoice No")){
                for (int i = 0; i < lList.size(); i++) {
                    if (toSearch.equals(lList.get(i).getInvNo().toUpperCase())) {
                        model.addRow(new Object[] {lList.get(i).getName(),lList.get(i).getBillNo(),
                        lList.get(i).getInvNo(),lList.get(i).getDate(),lList.get(i).getCost(),
                        lList.get(i).getDuration()});                        
                    }
                }
            }
            else if(cmbSearchBy.getSelectedItem().equals("Date")){
                for (int i = 0; i < lList.size(); i++) {
                    if (toSearch.equals(lList.get(i).getDate().toUpperCase())) {
                        model.addRow(new Object[] {lList.get(i).getName(),lList.get(i).getBillNo(),
                        lList.get(i).getInvNo(),lList.get(i).getDate(),lList.get(i).getCost(),
                        lList.get(i).getDuration()});                        
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Option");
            }
        }
        else{
            setTableModel(model);  
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnShowBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowBillActionPerformed
        // TODO add your handling code here:
        int rowInd = this.tblBills.getSelectedRow();

        if (rowInd != -1) {
            String billNo = (String) tblBills.getValueAt(rowInd, 1);
            System.out.println("Searching Form...");
            for(Labour l: lList){
                if (l.getBillNo().toUpperCase().equals(billNo)) {
                    System.out.println("Opening Form...");
                    labour_bills lb = new labour_bills(l);
                    lb.setVisible(true);
                    this.dispose();
                    break;

                }
            }
        }
       
        
    }//GEN-LAST:event_btnShowBillActionPerformed

    private void btnCustomerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDashboardActionPerformed
        // TODO add your handling code here:
        Customer_form customer_form = new Customer_form();
        customer_form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCustomerDashboardActionPerformed

    private void btnGenerateLabourBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateLabourBillActionPerformed
        // TODO add your handling code here:
        labour_bills lb = new labour_bills();
        lb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnGenerateLabourBillActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Main_Dashboard dashboard = new Main_Dashboard();
        dashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnDeleteBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBillActionPerformed
        int rowInd = this.tblBills.getSelectedRow();
        if (rowInd != -1) {
            String billNo = (String) tblBills.getValueAt(rowInd, 1);
            System.out.println("Searching Form...");
            for(Labour l: lList){
                if (l.getBillNo().toUpperCase().equals(billNo)) {
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Warning!", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        da.delete_Labour(l);  
                    }
                    break;
                }
            }
        }
       init();
    }//GEN-LAST:event_btnDeleteBillActionPerformed

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
            java.util.logging.Logger.getLogger(display_labour_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(display_labour_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(display_labour_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(display_labour_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new display_labour_bills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerDashboard;
    private javax.swing.JButton btnDeleteBill;
    private javax.swing.JButton btnGenerateLabourBill;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowBill;
    private javax.swing.JComboBox<String> cmbSearchBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblSearchBy;
    private javax.swing.JLabel lblSearchNames;
    private javax.swing.JTable tblBills;
    private javax.swing.JTextField txtBillNumber;
    private javax.swing.JTextField txtSearchNames;
    // End of variables declaration//GEN-END:variables
}
