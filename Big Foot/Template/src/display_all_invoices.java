
import Validation.Frontend;
import javax.swing.JFrame;
import businesslogic.ClientInvoice;
import businesslogic.Product;
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
public class display_all_invoices extends javax.swing.JFrame {

    /**
     * Creates new form display_all_invoices
     */
    
    
//    private ClientInvoice dummyClient = new ClientInvoice("INV-001", "20/01/19", "5", "Deff", "AQUA SOLS", "111-111-111", "Main street sq", "Last Payment due", "yes", "no", "unpaid", "350.00", "100.00", "Items Cost", "320.00", "350.00", "0", "BK_DN_0001", "BK_PO_0001", "1234123123");
    private DataAcess da = new DataAcess();
    private LinkedList<ClientInvoice> cList = new LinkedList<ClientInvoice>();
   
    private void temp(){
        
    }
    public display_all_invoices() {
        initComponents();
        txtInvoiceNumber.setVisible(false);
        lblInvoiceNumber.setVisible(false);
        btnSupplierDashboard.setVisible(false);
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        LinkedList<Product> prods = new LinkedList<Product>();
        Product p = new Product("DSLR 360D", "320", "5", "Sample Product");
        prods.add(p);
//        dummyClient.setProds(prods);
        init();
    }
   
    //////////////////
    /////////////////
    // SELF METHODS
    //////////////////
    ///////////////////
    
    
    private void init(){
        setInvoiceList();
        DefaultTableModel model = (DefaultTableModel) tblInvoices.getModel();
        model.setRowCount(0);
        for (int i = 0; i < cList.size(); i++) {
            ClientInvoice invoice = cList.get(i);
            System.out.println("INVOICES PROFIT->"+cList.get(i).getProfit()+", "+ cList.get(i).getOwner1()
                    +", "+ cList.get(i).getOwner2()+", "+ cList.get(i).getOwner3()+", "+ cList.get(i).getOwner4()
                    +", "+ cList.get(i).getInvoiceNo());
            model.addRow(new Object[] {invoice.getInvoiceNo(), invoice.getCompanyName(), invoice.getDate(), invoice.getBalance(), invoice.getGrandTotal(), invoice.getStatus()});
        }
    }
    private void setAllProducts(){
        System.out.println("Setting Product List");
        for (int i = 0; i < cList.size(); i++) {
            System.out.println("INVOICE ############"+cList.get(i).getInvoiceNo());
           LinkedList<Product> prods = da.getProds(cList.get(i).getInvoiceNo());
           cList.get(i).setProds(prods);
        }
    }
    private void setInvoiceList(){
        System.out.println("Setting Client List");
        cList = da.getAllClientInvoices();
        setAllProducts();      
    }
    
    /////////////////
    /////////////////
    /// EVENTS
    //////////////
    ////////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomerDashboard = new javax.swing.JButton();
        btnGenerateInvoice = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnSupplierDashboard = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSearchNames = new javax.swing.JLabel();
        txtSearchNames = new javax.swing.JTextField();
        lblInvoiceNumber = new javax.swing.JLabel();
        txtInvoiceNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnShowInvoice = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        lblSearchBy = new javax.swing.JLabel();
        cmbSearchBy = new javax.swing.JComboBox<String>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInvoices = new javax.swing.JTable();
        btnDeleteInvoice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));

        jPanel2.setBackground(new java.awt.Color(247, 245, 230));

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

        btnGenerateInvoice.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerateInvoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerateInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/el-file-new.png"))); // NOI18N
        btnGenerateInvoice.setText("  New Invoice          ");
        btnGenerateInvoice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnGenerateInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateInvoiceActionPerformed(evt);
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

        btnSupplierDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnSupplierDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSupplierDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mdi-desktop-mac-dashboard.png"))); // NOI18N
        btnSupplierDashboard.setText("Supplier Dashboard");
        btnSupplierDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSupplierDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierDashboardActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoo transparent 2.png"))); // NOI18N
        jLabel16.setText("jLabel10");
        jLabel16.setIconTextGap(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGenerateInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnSupplierDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 0, 0)
                .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSupplierDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnGenerateInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INVOICES");

        lblSearchNames.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSearchNames.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchNames.setText("Search Names:");

        txtSearchNames.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtSearchNames.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblInvoiceNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblInvoiceNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblInvoiceNumber.setText("Enter Invoice No:");

        txtInvoiceNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtInvoiceNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search Result");

        btnShowInvoice.setBackground(java.awt.SystemColor.window);
        btnShowInvoice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnShowInvoice.setForeground(new java.awt.Color(153, 153, 153));
        btnShowInvoice.setText("Show Inovice");
        btnShowInvoice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnShowInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowInvoiceActionPerformed(evt);
            }
        });

        btnsearch.setBackground(java.awt.SystemColor.window);
        btnsearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(153, 153, 153));
        btnsearch.setText("Search");
        btnsearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        lblSearchBy.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblSearchBy.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchBy.setText("Search By:");

        cmbSearchBy.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        cmbSearchBy.setForeground(new java.awt.Color(112, 112, 112));
        cmbSearchBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Invoice No", "Name", "Date" }));
        cmbSearchBy.setBorder(null);

        tblInvoices.setAutoCreateRowSorter(true);
        tblInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"INV-001", "IGR", "24/07/2019", null, "AED 100", "PAID"},
                {"INV-002", "AQUA properties", "25/07/2019", null, "AED 2900", "PAID"},
                {"SP-001", "Huzefa", "31/8/2019", null, "AED 500", "PAID"}
            },
            new String [] {
                "Invoice #", "Company Name", "Date", "Balance", "Amount", "Stauts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInvoices.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblInvoices);

        btnDeleteInvoice.setBackground(java.awt.SystemColor.window);
        btnDeleteInvoice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDeleteInvoice.setForeground(new java.awt.Color(153, 153, 153));
        btnDeleteInvoice.setText("Delete Inovice");
        btnDeleteInvoice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnDeleteInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSearchNames)
                                    .addComponent(lblSearchBy))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtSearchNames))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(lblInvoiceNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnShowInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchBy)
                    .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchNames)
                    .addComponent(txtSearchNames, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch))
                .addGap(29, 29, 29)
                .addComponent(btnDeleteInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblInvoiceNumber)
                    .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowInvoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
    
    private void btnShowInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowInvoiceActionPerformed
        // TODO add your handling code here:
        int rowInd = this.tblInvoices.getSelectedRow();
        if (rowInd != -1) {
            String invNo = (String) tblInvoices.getValueAt(rowInd, 0);
            for (int i = 0; i < cList.size(); i++) {
                if (invNo.equals(cList.get(i).getInvoiceNo().toUpperCase())){
                    taxinvoice ti = new taxinvoice(cList.get(i));
                    ti.setVisible(true);
                    this.dispose();
                    break;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select an Invoice from the records.");
//            System.out.println("Cannot Open Form");
        }

    }//GEN-LAST:event_btnShowInvoiceActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
       DefaultTableModel model = (DefaultTableModel) tblInvoices.getModel();
        if (!txtSearchNames.getText().isEmpty()) {
            String toSearch = txtSearchNames.getText().toUpperCase();
            model.setRowCount(0);
            if (cmbSearchBy.getSelectedItem().equals("Invoice No")) {
                
                for (int i = 0; i < cList.size(); i++) {                        
                    if (toSearch.equals(cList.get(i).getInvoiceNo().toUpperCase())) {
                        String v1 = cList.get(i).getInvoiceNo();
                        String v2 = cList.get(i).getCompanyName();
                        String v3 = cList.get(i).getDate();
                        String v4 = cList.get(i).getBalance();
                        String v5 = cList.get(i).getGrandTotal();
                        String v6 = cList.get(i).getStatus();
//                        model.setRowCount(0);
                        model.addRow(new Object[] {v1,v2,v3,v4,v5,v6});
                       
                        
                    }                   
                }
            }
            else if (cmbSearchBy.getSelectedItem().equals("Name")) {
                for (int i = 0; i < cList.size(); i++) {
                    if (toSearch.equals(cList.get(i).getCompanyName().toUpperCase())) {
                        String v1 = cList.get(i).getInvoiceNo();
                        String v2 = cList.get(i).getCompanyName();
                        String v3 = cList.get(i).getDate();
                        String v4 = cList.get(i).getGrandTotal();
                        String v5 = cList.get(i).getStatus();
//                        model.setRowCount(0);
                        model.addRow(new Object[] {v1,v2,v3,v4,v5});
                    }
                }
                
            }
            else if (cmbSearchBy.getSelectedItem().equals("Date")) {
                for (int i = 0; i < cList.size(); i++) {
                    if (toSearch.equals(cList.get(i).getDate().toUpperCase())){
                        String v1 = cList.get(i).getInvoiceNo();
                        String v2 = cList.get(i).getCompanyName();
                        String v3 = cList.get(i).getDate();
                        String v4 = cList.get(i).getGrandTotal();
                        String v5 = cList.get(i).getStatus();
                        model.addRow(new Object[] {v1,v2,v3,v4,v5});
                    }
                }
            }
            
//            
        }
        else{
            model.setRowCount(0);
            for (int i = 0; i < cList.size(); i++) {
                ClientInvoice invoice = cList.get(i);
                model.addRow(new Object[] {invoice.getInvoiceNo(), invoice.getCompanyName(), invoice.getDate(), invoice.getGrandTotal(), invoice.getStatus()});
            }
        }
        
        
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnCustomerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDashboardActionPerformed
        // TODO add your handling code here:
        Customer_form c = new Customer_form();
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCustomerDashboardActionPerformed

    private void btnGenerateInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateInvoiceActionPerformed
        // TODO add your handling code here:
        taxinvoice invoice = new taxinvoice();
        invoice.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnGenerateInvoiceActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Main_Dashboard dashboard = new Main_Dashboard();
        dashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSupplierDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierDashboardActionPerformed
        // TODO add your handling code here:
        Supplier_Form sf = new Supplier_Form();
        sf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSupplierDashboardActionPerformed

    private void btnDeleteInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteInvoiceActionPerformed
        // TODO add your handling code here:
        int rowInd = this.tblInvoices.getSelectedRow();
        if (rowInd != -1) {
            String invNo = (String) tblInvoices.getValueAt(rowInd, 0);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are your Sure you want to delete this Invoice? " + invNo,
                    "Warning", JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                ClientInvoice ci = da.get_ClientInvoice(invNo);
                for(ClientInvoice c: cList){
                    if (invNo.equals(c.getInvoiceNo())) {
                        da.delete_ClientInvoice(ci);
                    }        
                }
                init();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select Invoice.");
        }

    }//GEN-LAST:event_btnDeleteInvoiceActionPerformed

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
            java.util.logging.Logger.getLogger(display_all_invoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(display_all_invoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(display_all_invoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(display_all_invoices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new display_all_invoices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerDashboard;
    private javax.swing.JButton btnDeleteInvoice;
    private javax.swing.JButton btnGenerateInvoice;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnShowInvoice;
    private javax.swing.JButton btnSupplierDashboard;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox<String> cmbSearchBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblInvoiceNumber;
    private javax.swing.JLabel lblSearchBy;
    private javax.swing.JLabel lblSearchNames;
    private javax.swing.JTable tblInvoices;
    private javax.swing.JTextField txtInvoiceNumber;
    private javax.swing.JTextField txtSearchNames;
    // End of variables declaration//GEN-END:variables
}
