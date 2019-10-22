import DataAcess.DataAcess;
import javax.swing.JFrame;
import businesslogic.Pickup;
import java.util.LinkedList;
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
public class display_pickup_bills extends javax.swing.JFrame {

    /**
     * Creates new form display_pickup_bills
     */
    private DataAcess da = new DataAcess();
    private Pickup p;
    private LinkedList<Pickup> pList = new LinkedList<Pickup>();
    public display_pickup_bills() {
        initComponents();
        init();
    }

    ////////////////
    //////////////
    // SELF METHODS
    ////////////////
    ////////////////

    private void init(){
       lblBillNumber.setVisible(false);
       txtBillNumber.setVisible(false);
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setBillList();
        DefaultTableModel model = (DefaultTableModel) tblPickupBill.getModel();
        model.setRowCount(0);
        for (int i = 0; i < pList.size(); i++) {
            model.addRow(new Object[] {pList.get(i).getBillno(),
                    pList.get(i).getInvoiceNo(),pList.get(i).getCompanyName() ,pList.get(i).getDate(),
                    pList.get(i).getLocationOfPickup(), pList.get(i).getLocationOfDrop(),
                    pList.get(i).getAmount()});
        }
    
    }
    private void setBillList(){
        pList = da.get_pickupBills();
        
    }
    
    
    /////////////
    ///////////
    /// EVENTS
    ///////////
    ///////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnCustomerDashboard = new javax.swing.JButton();
        btnGeneratePickupBill = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtBillNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPickupBill = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnShowBill = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblSearchNames = new javax.swing.JLabel();
        txtSearchNames = new javax.swing.JTextField();
        lblBillNumber = new javax.swing.JLabel();
        lblSearchBy = new javax.swing.JLabel();
        cmbSearch = new javax.swing.JComboBox<String>();
        btnDeleteBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(247, 245, 230));

        btnCustomerDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomerDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomerDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mdi-desktop-mac-dashboard.png"))); // NOI18N
        btnCustomerDashboard.setText("Client Dashboard");
        btnCustomerDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCustomerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerDashboardActionPerformed(evt);
            }
        });

        btnGeneratePickupBill.setBackground(new java.awt.Color(255, 255, 255));
        btnGeneratePickupBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGeneratePickupBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ps-euro-bill.png"))); // NOI18N
        btnGeneratePickupBill.setText("Generate Pickup Bill");
        btnGeneratePickupBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnGeneratePickupBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePickupBillActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_home.png"))); // NOI18N
        btnHome.setText("  Home                 ");
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
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGeneratePickupBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 0, 0)
                .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGeneratePickupBill, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCustomerDashboard, btnGeneratePickupBill, btnHome});

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));
        jPanel1.setForeground(new java.awt.Color(51, 58, 86));

        txtBillNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtBillNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search Result:");

        tblPickupBill.setAutoCreateRowSorter(true);
        tblPickupBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PK-001", "INV-001", null, "29/8/2019", "Dubai", "Sharjah", "1000"}
            },
            new String [] {
                "Bill #", "Invoice #", "Company Name", "Date", "From", "To", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPickupBill.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPickupBill);

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
        jLabel1.setText("PICKUP BILLS");

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

        cmbSearch.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        cmbSearch.setForeground(new java.awt.Color(112, 112, 112));
        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bill No", "Invoice No", "Date", "Pickup Location", "Drop Location", "Company Name" }));
        cmbSearch.setBorder(null);

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
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSearchBy)
                                .addGap(46, 46, 46)
                                .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSearchNames)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchNames, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblBillNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBillNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchBy)
                    .addComponent(cmbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchNames)
                    .addComponent(txtSearchNames, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteBill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        DefaultTableModel model = (DefaultTableModel) tblPickupBill.getModel();
        
        if (!txtSearchNames.getText().trim().isEmpty()) {
            String toSearch = txtSearchNames.getText().trim().toUpperCase();
            model.setRowCount(0);
                
            if (cmbSearch.getSelectedItem().equals("Bill No")) {
                for (int i = 0; i < pList.size(); i++) {                        
                    if (toSearch.equals(pList.get(i).getBillno().toUpperCase())) {
                        String v1 = pList.get(i).getBillno();
                        String v2 = pList.get(i).getInvoiceNo();
                        String v3 = pList.get(i).getCompanyName();
                        String v4 = pList.get(i).getDate();
                        String v5 = pList.get(i).getLocationOfPickup();
                        String v6 = pList.get(i).getLocationOfDrop();
                        String v7 = pList.get(i).getAmount();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }        
            }
            else if (cmbSearch.getSelectedItem().equals("Invoice No")) {
                for (int i = 0; i < pList.size(); i++) {                        
                    if (toSearch.equals(pList.get(i).getInvoiceNo().toUpperCase())) {
                        String v1 = pList.get(i).getBillno();
                        String v2 = pList.get(i).getInvoiceNo();
                        String v3 = pList.get(i).getCompanyName();
                        String v4 = pList.get(i).getDate();
                        String v5 = pList.get(i).getLocationOfPickup();
                        String v6 = pList.get(i).getLocationOfDrop();
                        String v7 = pList.get(i).getAmount();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
            else if (cmbSearch.getSelectedItem().equals("Date")) {
                for (int i = 0; i < pList.size(); i++) {                        
                    if (toSearch.equals(pList.get(i).getDate().toUpperCase())) {
                        String v1 = pList.get(i).getBillno();
                        String v2 = pList.get(i).getInvoiceNo();
                        String v3 = pList.get(i).getCompanyName();
                        String v4 = pList.get(i).getDate();
                        String v5 = pList.get(i).getLocationOfPickup();
                        String v6 = pList.get(i).getLocationOfDrop();
                        String v7 = pList.get(i).getAmount();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
            else if(cmbSearch.getSelectedItem().equals("Pickup Location")) {
                for (int i = 0; i < pList.size(); i++) {                        
                    if (toSearch.equals(pList.get(i).getLocationOfPickup().toUpperCase())) {
                        String v1 = pList.get(i).getBillno();
                        String v2 = pList.get(i).getInvoiceNo();
                        String v3 = pList.get(i).getCompanyName();
                        String v4 = pList.get(i).getDate();
                        String v5 = pList.get(i).getLocationOfPickup();
                        String v6 = pList.get(i).getLocationOfDrop();
                        String v7 = pList.get(i).getAmount();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
            else if(cmbSearch.getSelectedItem().equals("Drop Location")) {
                for (int i = 0; i < pList.size(); i++) {                        
                    if (toSearch.equals(pList.get(i).getLocationOfDrop().toUpperCase())) {
                        String v1 = pList.get(i).getBillno();
                        String v2 = pList.get(i).getInvoiceNo();
                        String v3 = pList.get(i).getCompanyName();
                        String v4 = pList.get(i).getDate();
                        String v5 = pList.get(i).getLocationOfPickup();
                        String v6 = pList.get(i).getLocationOfDrop();
                        String v7 = pList.get(i).getAmount();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
            else if(cmbSearch.getSelectedItem().equals("Company Name")) {
                for (int i = 0; i < pList.size(); i++) {                        
                    if (toSearch.equals(pList.get(i).getCompanyName().toUpperCase())) {
                        String v1 = pList.get(i).getBillno();
                        String v2 = pList.get(i).getInvoiceNo();
                        String v3 = pList.get(i).getCompanyName();
                        String v4 = pList.get(i).getDate();
                        String v5 = pList.get(i).getLocationOfPickup();
                        String v6 = pList.get(i).getLocationOfDrop();
                        String v7 = pList.get(i).getAmount();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
        }
        else{
            model.setRowCount(0);
            for (int i = 0; i < pList.size(); i++) {
                Pickup invoice = pList.get(i);
                model.addRow(new Object[] {invoice.getBillno(), invoice.getInvoiceNo(), invoice.getCompanyName(),invoice.getDate(), invoice.getLocationOfPickup(), invoice.getLocationOfDrop(), invoice.getAmount()});
            }
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnShowBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowBillActionPerformed
        // TODO add your handling code here:
        int rowInd = this.tblPickupBill.getSelectedRow();

        if (rowInd != -1) {
            String invNo = (String) tblPickupBill.getValueAt(rowInd, 0);
            System.out.println("Searching Form...");
                    
            for (Pickup pList1 : pList) {
                if (invNo.equals(pList1.getBillno().toUpperCase())) {
                    System.out.println("Opening Form...");
                    Pickip_bills pb = new Pickip_bills(pList1);
                    pb.setVisible(true);
                    this.dispose();
                    break;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select a Bill from the records.");
//            System.out.println("Cannot Open Form");
        }
        
    }//GEN-LAST:event_btnShowBillActionPerformed

    private void btnGeneratePickupBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePickupBillActionPerformed
        // TODO add your handling code here:
        Pickip_bills pickupBill = new Pickip_bills();
        pickupBill.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnGeneratePickupBillActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Main_Dashboard dashboard = new Main_Dashboard();
        dashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCustomerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDashboardActionPerformed
        // TODO add your handling code here:
        Customer_form c = new Customer_form();
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCustomerDashboardActionPerformed

    private void btnDeleteBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBillActionPerformed

        int rowInd = this.tblPickupBill.getSelectedRow();

        if (rowInd != -1) {
            String invNo = (String) tblPickupBill.getValueAt(rowInd, 0);
            System.out.println("Searching Form...");
                    
            for (Pickup pList1 : pList) {
                if (invNo.equals(pList1.getBillno().toUpperCase())) {
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Warning!", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
                    if(dialogResult == JOptionPane.YES_OPTION){
                        da.delete_Pickup(pList1);
                    }
                    break;
                }
            }
            init();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select a Bill from the records.");
//            System.out.println("Cannot Open Form");
        }
        
        
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
            java.util.logging.Logger.getLogger(display_pickup_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(display_pickup_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(display_pickup_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(display_pickup_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new display_pickup_bills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerDashboard;
    private javax.swing.JButton btnDeleteBill;
    private javax.swing.JButton btnGeneratePickupBill;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowBill;
    private javax.swing.JComboBox<String> cmbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblSearchBy;
    private javax.swing.JLabel lblSearchNames;
    private javax.swing.JTable tblPickupBill;
    private javax.swing.JTextField txtBillNumber;
    private javax.swing.JTextField txtSearchNames;
    // End of variables declaration//GEN-END:variables
}
