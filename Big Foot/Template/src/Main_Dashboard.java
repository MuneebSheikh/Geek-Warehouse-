
import DataAcess.DBHelper;
import DataAcess.DataAcess;
import Validation.Frontend;
import businesslogic.ClientInvoice;
import businesslogic.Expences;
import businesslogic.Finance;
import businesslogic.Product;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class Main_Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Main_Dashboard
     */
    
//    private double totCost = 147303;
//    private double totSales = 250748;
//    private double totExpences = 116;
//    private double totProfit;
    private LinkedList<Expences> expences;
    private DataAcess db = new DataAcess();
    private LinkedList<ClientInvoice> cList = new LinkedList<ClientInvoice>();
    private Finance fin = new Finance();
    
    private void temp(){
//        DBHelper.connect();
//        db = new DataAcess();
//        LinkedList<ClientInvoice> cl = db.getAllClientInvoices();
//        if (null == cl) {
//            System.out.println("client is null");
//            return;
//        }
//        for (int i = 0; i < cl.size(); i++) {
//            System.out.println("invoice: "+cl.get(i).getDate());
//        }
    }
    
    public Main_Dashboard() {
        
            initComponents();
            btnSupplier.setVisible(false);
            init();
            
            temp();
        
        
        
    }

    ////////////////////
    ///////////////////
    // SELF METHODS
    ////////////////
    /////////////////
    
    //////////// FINANCE SECTION ////////////////////////
    
    private void setFinanceSection(){
        String profit = fin.getProfit();
        String azher = fin.getAzherProfit();
        String rameez = fin.getRameezProfit();
        String investor = fin.getInvestorProfit();
        String company = fin.getCompanyProfit();
        String totalCost = fin.getTotalCost();
        String totalSales = fin.getTotalSales();
        
        lblProfitResult.setText(Frontend.currency_Format(profit));
        lblSalesResult.setText(Frontend.currency_Format(totalSales));
        lblTotalCostResult.setText(Frontend.currency_Format(totalCost));
        DefaultTableModel model = (DefaultTableModel) tblEarning.getModel();
            model.setRowCount(0);
            model.addRow(new Object[] {Frontend.currency_Format(azher), Frontend.currency_Format(rameez), 
                Frontend.currency_Format(investor), Frontend.currency_Format(company)});            
    }
    //////////// FINANCE SECTION END////////////////////////
    
    
    
    ///////////// EXPENCE FUNCS //////////////////
    private void initExpenceTable(){
        if (null != db.get_Expense()) {
            expences = db.get_Expense();
            DefaultTableModel model = (DefaultTableModel) tblExp.getModel();
            model.setRowCount(0);
            for (int i = 0; i < expences.size(); i++) {
                double amount = Double.valueOf(expences.get(i).getAmount());
                model.addRow(new Object[] {expences.get(i).getDetail(),Frontend.DecimalFormat(amount)});       
            }
        }
    }
   private String getTotalExpences(){
        double tot = 0;     
        tot = db.getTotalExp();
        return Frontend.DecimalFormat(tot);
//        return String.valueOf(tot);
    }
    
    private void setExpenceSection(){
        System.out.println("DASHBOARD: Setting Expence Section..");    
        initExpenceTable();
        String totExp = Frontend.currency_Format(getTotalExpences());
        System.out.println("DASHBOARD: Setting Expence label: " + totExp);    
        
        lblTotalExpences.setText(totExp);
        
    }

//////// EXPENCE FUNCS END/////////////

    ////////// CLIENT INVOICES FUNC /////////////////////
    private void setClientInvSection(){
        System.out.println("DASHBOARD: Setting Client_Invoice Section..");
        lbltotalBalance.setText(Frontend.currency_Format(db.getTotalBalance()));
        lbltotalAmount.setText(Frontend.currency_Format(db.getTotalCol("c_invoice", "ci_grandtotal")));
        setClientInvTable();
    }
    private void setClientInvTable(){
         System.out.println("Setting Client List");
        cList = db.getAllClientInvoices();
        setAllProducts();
        DefaultTableModel model = (DefaultTableModel) tblInvoices.getModel();
        model.setRowCount(0);
        for (int i = 0; i < cList.size(); i++) {
            ClientInvoice invoice = cList.get(i);
//            System.out.println("INVOICES PROFIT->"+cList.get(i).getProfit()+", "+ cList.get(i).getOwner1()
//                    +", "+ cList.get(i).getOwner2()+", "+ cList.get(i).getOwner3()+", "+ cList.get(i).getOwner4()
//                    +", "+ cList.get(i).getInvoiceNo());
            model.addRow(new Object[] {invoice.getInvoiceNo(), invoice.getCompanyName(), invoice.getDate(), invoice.getBalance(), invoice.getGrandTotal(), invoice.getStatus()});
        }
    }
    private void setAllProducts(){
        System.out.println("Setting Product List");
        for (int i = 0; i < cList.size(); i++) {
//            System.out.println("INVOICE #"+cList.get(i).getInvoiceNo());
           LinkedList<Product> prods = db.getProds(cList.get(i).getInvoiceNo());
           cList.get(i).setProds(prods);
        }
    }
    
    ////////// CLIENT INVOICES FUNC END /////////////////////
    
    private void init(){
        setExpenceSection();
        setClientInvSection();
        setFinanceSection();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setIconOnJlabel("expand.png", lblExpandIcon);
        setIconOnJlabel("expand.png", lblExpandIcon_clientInv);
//        lblSalesResult.setText(Frontend.currency_Format(String.valueOf(totSales)));
//        lblTotalCostResult.setText(Frontend.currency_Format(String.valueOf(totCost)));
//        lblProfitResult.setText(calTotalProfit());
//       lblTotalExpences.setText(Frontend.currency_Format(String.valueOf(totExpences)));
        
    }
//    
//    private String calTotalProfit(){
//        String profit = String.valueOf(totSales - totCost);
//        return Frontend.currency_Format(profit);
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnTaxInvoice = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTotalCost = new javax.swing.JLabel();
        lblTotalCostResult = new javax.swing.JLabel();
        lblSales = new javax.swing.JLabel();
        lblSalesResult = new javax.swing.JLabel();
        lblProfit = new javax.swing.JLabel();
        lblProfitResult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExp = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblTotalExpences = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEarning = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInvoices = new javax.swing.JTable();
        lblExpandIcon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblExpandIcon_clientInv = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbltotalBalance = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbltotalAmount = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(22, 52, 64));
        jLabel6.setText("Search Result:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(22, 52, 64));
        jLabel7.setText("Search Result:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));

        jPanel2.setBackground(new java.awt.Color(247, 245, 230));

        btnTaxInvoice.setBackground(new java.awt.Color(255, 255, 255));
        btnTaxInvoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaxInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_user_2.png"))); // NOI18N
        btnTaxInvoice.setText("Client");
        btnTaxInvoice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnTaxInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaxInvoiceActionPerformed(evt);
            }
        });

        btnSupplier.setBackground(new java.awt.Color(255, 255, 255));
        btnSupplier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_user_2.png"))); // NOI18N
        btnSupplier.setText("Supplier");
        btnSupplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoo transparent 2.png"))); // NOI18N
        jLabel14.setText("jLabel10");
        jLabel14.setIconTextGap(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaxInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnTaxInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(427, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MAIN DASHBOARD");

        lblTotalCost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalCost.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalCost.setText("Total Cost:");

        lblTotalCostResult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalCostResult.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalCostResult.setText("147303.00");

        lblSales.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSales.setForeground(new java.awt.Color(255, 255, 255));
        lblSales.setText("Total Sales:");

        lblSalesResult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSalesResult.setForeground(new java.awt.Color(255, 255, 255));
        lblSalesResult.setText("250748.00");

        lblProfit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblProfit.setForeground(new java.awt.Color(255, 255, 255));
        lblProfit.setText("Total Profit:");

        lblProfitResult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblProfitResult.setForeground(new java.awt.Color(255, 255, 255));
        lblProfitResult.setText("103445.00");

        tblExp.setAutoCreateRowSorter(true);
        tblExp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Mug Sample", "90"},
                {"Lunch", "56"}
            },
            new String [] {
                "Details", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tblExp);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Customer Invoices:");

        lblTotalExpences.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalExpences.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalExpences.setText("AED 146");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Expenses:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Expenses:");

        tblEarning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"AED 31500", "AED 31500", "AED 20688.95", "AED 20688.95"}
            },
            new String [] {
                "Remeez", "Azher", "Investor", "Company"
            }
        ));
        jScrollPane2.setViewportView(tblEarning);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Earning:");

        tblInvoices.setAutoCreateRowSorter(true);
        tblInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"BK_INV-001", "IGR", "24/07/2019", null, "100.00", "PAID"},
                {"BK_INV-002", "AQUA properties", "25/07/2019", null, "2900.00", "PAID"}
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

        lblExpandIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExpandIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExpandIconMouseClicked(evt);
            }
        });

        lblExpandIcon_clientInv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExpandIcon_clientInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExpandIcon_clientInvMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Balance:");

        lbltotalBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbltotalBalance.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalBalance.setText("AED 0.00");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Amount:");

        lbltotalAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbltotalAmount.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalAmount.setText("AED 0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblProfit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblProfitResult))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblTotalCost)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblTotalCostResult))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSales)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblSalesResult)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblExpandIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotalExpences)
                                        .addGap(8, 8, 8))))
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblExpandIcon_clientInv, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalBalance)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalAmount)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalCost)
                            .addComponent(lblTotalCostResult))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSales)
                            .addComponent(lblSalesResult))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProfit)
                            .addComponent(lblProfitResult))
                        .addGap(89, 89, 89)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExpandIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)
                                .addComponent(lblTotalExpences)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(lblExpandIcon_clientInv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lbltotalAmount))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbltotalBalance))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblExpandIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExpandIconMouseClicked
        // TODO add your handling code here:
        Expenses expenses = new Expenses();
        expenses.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblExpandIconMouseClicked

    private void btnSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierActionPerformed
        // TODO add your handling code here:
        Supplier_Form supplier_Form = new Supplier_Form();
        supplier_Form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSupplierActionPerformed

    private void btnTaxInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaxInvoiceActionPerformed
        // TODO add your handling code here:
        Customer_form customer_form = new Customer_form();
        customer_form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTaxInvoiceActionPerformed

    private void lblExpandIcon_clientInvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExpandIcon_clientInvMouseClicked
        // TODO add your handling code here:
        display_all_invoices di = new display_all_invoices();
        di.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblExpandIcon_clientInvMouseClicked

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
            java.util.logging.Logger.getLogger(Main_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnTaxInvoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblExpandIcon;
    private javax.swing.JLabel lblExpandIcon_clientInv;
    private javax.swing.JLabel lblProfit;
    private javax.swing.JLabel lblProfitResult;
    private javax.swing.JLabel lblSales;
    private javax.swing.JLabel lblSalesResult;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JLabel lblTotalCostResult;
    private javax.swing.JLabel lblTotalExpences;
    private javax.swing.JLabel lbltotalAmount;
    private javax.swing.JLabel lbltotalBalance;
    private javax.swing.JTable tblEarning;
    private javax.swing.JTable tblExp;
    private javax.swing.JTable tblInvoices;
    // End of variables declaration//GEN-END:variables

    private void setIconOnJlabel(String iconName, JLabel label) { 
        ImageIcon userIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconName)));
        Image userImg = userIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        userIcon = new ImageIcon(userImg);
        label.setIcon(userIcon);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
