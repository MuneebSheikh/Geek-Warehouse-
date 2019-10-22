
import javax.swing.JFrame;
import businesslogic.Bill;
import businesslogic.ClientInvoice;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import DataAcess.DataAcess;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali Raza
 */
public class display_all_bills extends javax.swing.JFrame {

    /**
     * Creates new form display_all_bills
     */
    private Bill bill ;
    private LinkedList<Bill> bList = new LinkedList<Bill>();
    private DataAcess da = new DataAcess();
    public display_all_bills() {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        init();
    }
    public display_all_bills(ClientInvoice ci) {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        init(ci.getInvoiceNo());
    }
    ///////////////////
    ////////////////
    // SELF METHODS
    ///////////////
    /////////////////
    private void commonInit(){
        setBillList();
        txtBillNumber.setVisible(false);
        lblBillNumber.setVisible(false);
        btnSupplierDashboard.setVisible(false);
    }
    private void init(){
        commonInit();
        DefaultTableModel model = (DefaultTableModel) tblBills.getModel();
        model.setRowCount(0);
        for (int i = 0; i < bList.size(); i++) {
            model.addRow(new Object[] {bList.get(i).getBillNo(), bList.get(i).getInvoiceNo(),bList.get(i).getCompanyName(),
            bList.get(i).getDate(),bList.get(i).getBalance(), bList.get(i).getAmmount(), bList.get(i).getPaymentMethod()});
        }
    }
    private void init(String invNo){
        commonInit();
        cmbSearchBy.setSelectedItem("Invoice No");
        txtSearchNames.setText(invNo);
        search();
    }
    private void setBillList(){
        bList = da.getAllBills();
    }
    
    private void search(){
        DefaultTableModel model = (DefaultTableModel) tblBills.getModel();
        model.setRowCount(0);
        if (!txtSearchNames.getText().trim().toUpperCase().isEmpty()) {
            String toSearch = txtSearchNames.getText().trim().toUpperCase();    
           
            if (cmbSearchBy.getSelectedItem().equals("Bill No")) {
                for (int i = 0; i < bList.size(); i++) {                        
                    if (toSearch.equals(bList.get(i).getBillNo().toUpperCase())) {
                        String v1 = bList.get(i).getBillNo();
                        String v2 = bList.get(i).getInvoiceNo();
                        String v3 = bList.get(i).getCompanyName();
                        String v4 = bList.get(i).getDate();
                        String v5 = bList.get(i).getBalance();
                        String v6 = bList.get(i).getAmmount();
                        String v7 = bList.get(i).getPaymentMethod();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
            else if (cmbSearchBy.getSelectedItem().equals("Invoice No")) {
                for (int i = 0; i < bList.size(); i++) {                        
                    if (toSearch.equals(bList.get(i).getInvoiceNo().toUpperCase())) {
                        String v1 = bList.get(i).getBillNo();
                        String v2 = bList.get(i).getInvoiceNo();
                        String v3 = bList.get(i).getCompanyName();
                        String v4 = bList.get(i).getDate();
                        String v5 = bList.get(i).getBalance();
                        String v6 = bList.get(i).getAmmount();
                        String v7 = bList.get(i).getPaymentMethod();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
            else if (cmbSearchBy.getSelectedItem().equals("Date")) {
                for (int i = 0; i < bList.size(); i++) {                        
                    if (toSearch.equals(bList.get(i).getDate().toUpperCase())) {
                        String v1 = bList.get(i).getBillNo();
                        String v2 = bList.get(i).getInvoiceNo();
                        String v3 = bList.get(i).getCompanyName();
                        String v4 = bList.get(i).getDate();
                        String v5 = bList.get(i).getBalance();
                        String v6 = bList.get(i).getAmmount();
                        String v7 = bList.get(i).getPaymentMethod();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
            else if (cmbSearchBy.getSelectedItem().equals("Company Name")) {
                for (int i = 0; i < bList.size(); i++) {                        
                    if (toSearch.equals(bList.get(i).getCompanyName().toUpperCase())) {
                        String v1 = bList.get(i).getBillNo();
                        String v2 = bList.get(i).getInvoiceNo();
                        String v3 = bList.get(i).getCompanyName();
                        String v4 = bList.get(i).getDate();
                        String v5 = bList.get(i).getBalance();
                        String v6 = bList.get(i).getAmmount();
                        String v7 = bList.get(i).getPaymentMethod();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6,v7});
                    }                   
                }
            }
        }
        else{
            for (int i = 0; i < bList.size(); i++) {
                model.addRow(new Object[] {bList.get(i).getBillNo(), bList.get(i).getInvoiceNo(),bList.get(i).getCompanyName(),
                bList.get(i).getDate(),bList.get(i).getBalance(), bList.get(i).getAmmount(), bList.get(i).getPaymentMethod()});
            }
        }
        
    }
    /////////////
    ///////////
    // EVENTS
    //////////
    ///////////
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomerDashboard = new javax.swing.JButton();
        btnSupplierDashboard = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnDisplayInvoices = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblSearchNames = new javax.swing.JLabel();
        txtSearchNames = new javax.swing.JTextField();
        lblBillNumber = new javax.swing.JLabel();
        txtBillNumber = new javax.swing.JTextField();
        lblsearchresult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBills = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnShowBill = new javax.swing.JButton();
        lblSearchBy = new javax.swing.JLabel();
        cmbSearchBy = new javax.swing.JComboBox<String>();
        btnDeleteBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));

        jPanel2.setBackground(new java.awt.Color(247, 245, 230));

        btnCustomerDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomerDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomerDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_user_2.png"))); // NOI18N
        btnCustomerDashboard.setText("  Client Dashboard");
        btnCustomerDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCustomerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerDashboardActionPerformed(evt);
            }
        });

        btnSupplierDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnSupplierDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSupplierDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_user_2.png"))); // NOI18N
        btnSupplierDashboard.setText("Supplier");
        btnSupplierDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSupplierDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierDashboardActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_home.png"))); // NOI18N
        btnHome.setText("  Home   ");
        btnHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoo transparent 2.png"))); // NOI18N
        jLabel16.setText("jLabel10");
        jLabel16.setIconTextGap(0);

        btnDisplayInvoices.setBackground(new java.awt.Color(255, 255, 255));
        btnDisplayInvoices.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDisplayInvoices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ps-euro-bill.png"))); // NOI18N
        btnDisplayInvoices.setText("  Invoices                ");
        btnDisplayInvoices.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnDisplayInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayInvoicesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSupplierDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDisplayInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDisplayInvoices, btnHome});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupplierDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplayInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCustomerDashboard, btnDisplayInvoices, btnHome, btnSupplierDashboard});

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BILLS");

        lblSearchNames.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSearchNames.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchNames.setText("Search:");

        txtSearchNames.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtSearchNames.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblBillNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBillNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblBillNumber.setText("Enter Bill No:");

        txtBillNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtBillNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblsearchresult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblsearchresult.setForeground(new java.awt.Color(255, 255, 255));
        lblsearchresult.setText("Search Result:");

        tblBills.setAutoCreateRowSorter(true);
        tblBills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"CLBL-001", "INV-001", "AQUA Properties", "11/8/2019", "500", "500", "Cash"},
                {"CLBL-002", "INV-001", "AQUA Properties", "12/9/2019", "0", "500", "Cash"},
                {"SPBL-001", "SP-002", "Huzefa", "13/8/2019", "100", "400", null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Bill No", "Invoice No", "Name", "Date", "Balance", "Amount Paid", "Payment Method"
            }
        ));
        tblBills.setFocusable(false);
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

        lblSearchBy.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblSearchBy.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchBy.setText("Search By:");

        cmbSearchBy.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        cmbSearchBy.setForeground(new java.awt.Color(112, 112, 112));
        cmbSearchBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bill No", "Invoice No", "Date", "Company Name" }));
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDeleteBill, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(lblsearchresult, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                                        .addComponent(lblBillNumber))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSearchBy)
                                            .addComponent(lblSearchNames))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtSearchNames, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSearch, btnShowBill});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(lblSearchBy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSearchNames)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSearchNames, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(lblsearchresult))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(txtBillNumber))))
                    .addComponent(lblBillNumber)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDeleteBill, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowBill, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowBillActionPerformed
        // TODO add your handling code here:
        int rowInd = this.tblBills.getSelectedRow();
        if (rowInd != -1) {
            String toSearch = (String) tblBills.getValueAt(rowInd, 0);
            System.out.println("ShowBill: " + toSearch);
            for (Bill bill : bList) {
                if (toSearch.equals(bill.getBillNo())) {
                    billing b = new billing(bill);
                    b.setVisible(true);
                    this.dispose();
                    break;
                }
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select a Bill from the records.");
        }

        
//        if (!txtBillNumber.getText().trim().isEmpty()) {
//            String toSearch = txtBillNumber.getText().trim().toUpperCase();
//            for (int i = 0; i < bList.size(); i++) {
//                if (toSearch.equals(bList.get(i).getBillNo())) {
//                    billing b = new billing(bList.get(i));
//                    b.setVisible(true);
//                    this.dispose();
//                    break;
//                }
//            }
//        }

    }//GEN-LAST:event_btnShowBillActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        search();

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Main_Dashboard dashboard = new Main_Dashboard();
        dashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSupplierDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierDashboardActionPerformed
        // TODO add your handling code here:
        Supplier_Form supplier_Form = new Supplier_Form();
        supplier_Form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSupplierDashboardActionPerformed

    private void btnCustomerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDashboardActionPerformed
        // TODO add your handling code here:
        Customer_form c = new Customer_form();
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCustomerDashboardActionPerformed

    private void btnDeleteBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBillActionPerformed
        // TODO add your handling code here:
//        String billNo = txtBillNumber.getText().trim().toUpperCase();
        int rowInd = this.tblBills.getSelectedRow();
        if (rowInd != -1 ) {
            String billNo = (String) tblBills.getValueAt(rowInd, 0);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are your Sure you want to delete this Bill? " + billNo,
                    "Warning", 1);
            if(dialogResult == JOptionPane.YES_OPTION){
                bill = da.get_Bill(billNo);
                for(Bill b: bList){
                    if (billNo.equals(b.getBillNo())) {
                        da.delete_Bill(bill);  
                    }        
                }
                init();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select Bill.");
        }

    }//GEN-LAST:event_btnDeleteBillActionPerformed

    private void btnDisplayInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayInvoicesActionPerformed
        // TODO add your handling code here:
        display_all_invoices di = new display_all_invoices();
        di.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDisplayInvoicesActionPerformed

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
            java.util.logging.Logger.getLogger(display_all_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(display_all_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(display_all_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(display_all_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new display_all_bills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerDashboard;
    private javax.swing.JButton btnDeleteBill;
    private javax.swing.JButton btnDisplayInvoices;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowBill;
    private javax.swing.JButton btnSupplierDashboard;
    private javax.swing.JComboBox<String> cmbSearchBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblSearchBy;
    private javax.swing.JLabel lblSearchNames;
    private javax.swing.JLabel lblsearchresult;
    private javax.swing.JTable tblBills;
    private javax.swing.JTextField txtBillNumber;
    private javax.swing.JTextField txtSearchNames;
    // End of variables declaration//GEN-END:variables
}
