
import DataAcess.DataAcess;
import Validation.Frontend;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import businesslogic.Bill;
import businesslogic.BankDetails;
import businesslogic.ChequeDetails;
import businesslogic.ClientInvoice;
import businesslogic.SupplierInvoice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali Raza
 */
public class billing extends javax.swing.JFrame {

    /**
     * Creates new form billing
     */
    Bill bill;
    ChequeDetails cd;
    BankDetails bd;
    ClientInvoice ci;
    SupplierInvoice si;
    String flagBillType = "";
    DataAcess da = new DataAcess();
    Frontend ft = new Frontend();
    
    boolean isPrinted = false;
    
    
    public billing() {
       initComponents();
        txtBalance.setText("1.0");
        init();
        String bilNo = ft.getBillNo();
        txtBillNumber.setText(bilNo);
        
    }
    public billing(SupplierInvoice si){
        initComponents();
        flagBillType = "supplier";
        init();
        
    }
    public billing(ClientInvoice ci){
        initComponents();
//        isPrinted = true;
        this.ci = ci;
        flagBillType = "client";
        txtClientSupplierName.setText(ci.getCompanyName());
        txtClientSupplierName.setEditable(false);
        txtBalance.setText(Frontend.DecimalFormat(Double.valueOf(ci.getBalance())));
        txtBalance.setEditable(false);
        txtInvoiceNo.setText(ci.getInvoiceNo());
        txtInvoiceNo.setEditable(false);
        String bilNo = ft.getBillNo();
        txtBillNumber.setText(bilNo);
        txtBillNumber.setEditable(false);
        init();        
        bill = new Bill(bilNo, txtInvoiceNo.getText(), txtClientSupplierName.getText(), txtRecieverName.getText(), 
                txtDate.getText(), txtBalance.getText(), txtAmountToPay.getText(), "");
    }
    public billing(Bill bill){
        initComponents();
        isPrinted = true;
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        flagBillType = "bill";
//        btnPrintBill.setEnabled(false);
        this.bill = bill;
        txtBalance.setText(bill.getBalance());
        init();
        txtClientSupplierName.setText(bill.getCompanyName());
        txtInvoiceNo.setText(bill.getInvoiceNo());
        txtBillNumber.setText(bill.getBillNo());
        txtDate.setText(bill.getDate());
        txtAmountToPay.setText(bill.getAmmount());
        txtRecieverName.setText(bill.getYourName());
        if (bill.getPaymentMethod().equals("cheque")) {
//            plnBankTransfer.setVisible(false);
            chkPaymentMethod.setSelectedItem("Cheque");
            cd = da.get_ChecquedDetails(bill.getBillNo());
            bill.setChequeDetails(cd); 
            txtChequeAmount.setText(bill.getChequeDetails().getAmmount());
            txtChequeDetails.setText(bill.getChequeDetails().getDetails());
            txtChequeIssuedTo.setText(bill.getChequeDetails().getIssuedTo());
            txtChequeNum.setText(bill.getChequeDetails().getChequeNumber()); 
            txtChequeDate.setText(bill.getChequeDetails().getDate());
        }
        else if(bill.getPaymentMethod().toLowerCase().equals("bank transfer")){
            chkPaymentMethod.setSelectedItem("Bank Transfer");
            bd = da.get_Banktransfer(bill.getBillNo());
            bill.setBankDetails(bd);
            txtAccountNum.setText(bill.getBankDetails().getAccountNumber());
            txtAccountTitle.setText(bill.getBankDetails().getAccountTitle());
            txtBankName.setText(bill.getBankDetails().getBankName());
            txtBranchName.setText(bill.getBankDetails().getBranch());
            txtIBAN.setText(bill.getBankDetails().getIBAN());
        }
        else{
            chkPaymentMethod.setSelectedItem("Cash");
        }
        
        
        txtRecieverName.setEditable(false);
        txtAmountToPay.setEditable(false);
        txtDate.setEditable(false);
        txtClientSupplierName.setEditable(false);
        txtBalance.setEditable(false);
        txtInvoiceNo.setEditable(false);
        chkPaymentMethod.setEnabled(false);
        
//        init();
    }

    
    public billing(String name, String invoiceNo, String balance, String type) {
        initComponents();
        txtClientSupplierName.setText(name);
        txtClientSupplierName.setEditable(false);
        txtBalance.setText(balance);
        txtBalance.setEditable(false);
        txtInvoiceNo.setText(invoiceNo);
        txtInvoiceNo.setEditable(false);
        if (null != type) switch (type) {
            case "client":{
                String bilNo = "CLBL-".concat(generateBillNo());
                txtBillNumber.setText(bilNo);
                break;
                }
            case "supplier":{
                String bilNo = "SPBL-".concat(generateBillNo());
                txtBillNumber.setText(bilNo);
                break;
                }
        }
        init();
    }
    //////////////
    /////////////
    //SELF METHODS
    /////////////
    /////////////
    
    private void init(){
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        btnSupplierDashboard.setVisible(false);
        plnBankTransfer.setVisible(false);
        plnChequeDetails.setVisible(false);
        txtDate.setText(Frontend.getCurrentDate());
        if (Double.valueOf(txtBalance.getText()) <= 0) {
            btnPrintBill.setEnabled(false);
        }
    }
    
    private String generateBillNo(){
        Random rand = new Random();
        int num = rand.nextInt(1000);
        if (num < 10) {
            return "00".concat(String.valueOf(num));
        }
        else if (num < 100) {
            return "0".concat(String.valueOf(num));
        } 
        else {
            return String.valueOf(num);
        }
    }
    private void printPDF(){
        try {
//            BasicConfigurator.configure();
//            JasperReport jr = JasperCompileManager.compileReport("src\\Invoices\\invoice_billing.jrxml");
//            JRDataSource jdata = new JREmptyDataSource();
//            JasperPrint jp = JasperFillManager.fillReport(jr,null,jdata);
//            JasperViewer.viewReport(jp, false);
            } 
        catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    private String getPaymentMethod(){
        if (chkPaymentMethod.getSelectedItem().equals("Cheque")) {
            if (txtChequeAmount.getText().isEmpty() || txtChequeDetails.getText().isEmpty() 
                    || txtChequeNum.getText().isEmpty() || txtChequeIssuedTo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Fill out the Checque Details");
                return "";
            }
            else{
                cd = new ChequeDetails(txtChequeNum.getText(), txtChequeIssuedTo.getText(), txtDate.getText(), txtChequeAmount.getText(), txtChequeDetails.getText());
                return "cheque";
            }
        }
        else if(chkPaymentMethod.getSelectedItem().equals("Bank Transfer")){
            if (txtAccountNum.getText().isEmpty() || txtAccountTitle.getText().isEmpty() 
                    || txtBankName.getText().isEmpty() || txtBranchName.getText().isEmpty()
                    || txtIBAN.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Fill out the Bank Details");
                return "";
            }
            else{
                bd = new BankDetails(txtBankName.getText(), txtBranchName.getText(), txtAccountTitle.getText(), txtAccountNum.getText(), txtIBAN.getText());
                return "bank transfer";
            }
        }
        else{
            return "cash";
        }
    }
    private void updateInvoice(){
        if ("client".equals(flagBillType)) {
            double newBal = Double.valueOf(bill.getBalance()) - Double.valueOf(bill.getAmmount());
            double gt = Double.valueOf(ci.getGrandTotal());
            String newBalance = String.valueOf(newBal);
            ci.setBalance(newBalance);
            ci.setProfit();
            if (newBal == 0) {
                ci.setStatus("paid");
            }
            else if (newBal == gt) {
                ci.setStatus("unpaid");
            }
            else{
                ci.setStatus("partially paid");
            }
            ci.setOwnersProfit();
            System.out.println("Azher: " + ci.getOwner1() + "Rameez: " + ci.getOwner2() 
                    + "Investor: " + ci.getOwner3() + "Company: "+ ci.getOwner4());
            System.out.println("New Profit: ".concat(ci.getProfit()));
            System.out.println("New Balance: ".concat(ci.getBalance()));
            
            da.update_ClientInvoice(ci);
        }
        else{
            ///set Supplier Invoice
        }
        
    }
    private void reloadForm(){
        if ("client".equals(flagBillType)) {
            billing newForm = new billing(this.ci);
            newForm.setVisible(true);
            this.dispose();
        }
        else{
            
        }
    }
    ////////////
    ////////////
    //EVENTS
    ////////////
    ///////////
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomerDashboard = new javax.swing.JButton();
        btnDisplayBills = new javax.swing.JButton();
        btnDisplayInvoices = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnSupplierDashboard = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblClientSupplierName = new javax.swing.JLabel();
        txtClientSupplierName = new javax.swing.JTextField();
        lblBillNumber = new javax.swing.JLabel();
        txtInvoiceNo = new javax.swing.JTextField();
        lblInvoiceNumber = new javax.swing.JLabel();
        lblPaymentMethod = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblRecieverName = new javax.swing.JLabel();
        txtRecieverName = new javax.swing.JTextField();
        txtBalance = new javax.swing.JTextField();
        lblBalance = new javax.swing.JLabel();
        lblAmountToPay = new javax.swing.JLabel();
        txtAmountToPay = new javax.swing.JTextField();
        btnPrintBill = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        chkPaymentMethod = new javax.swing.JComboBox<String>();
        txtBillNumber = new javax.swing.JTextField();
        plnChequeDetails = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtChequeNum = new javax.swing.JTextField();
        txtChequeIssuedTo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtChequeAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtChequeDetails = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtChequeDate = new javax.swing.JTextField();
        plnBankTransfer = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBankName = new javax.swing.JTextField();
        txtBranchName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtAccountTitle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAccountNum = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtIBAN = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));

        jPanel2.setBackground(new java.awt.Color(247, 245, 230));

        btnCustomerDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomerDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomerDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mdi-desktop-mac-dashboard.png"))); // NOI18N
        btnCustomerDashboard.setText("Client Dashboard   ");
        btnCustomerDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCustomerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerDashboardActionPerformed(evt);
            }
        });

        btnDisplayBills.setBackground(new java.awt.Color(255, 255, 255));
        btnDisplayBills.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDisplayBills.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ps-euro-bill.png"))); // NOI18N
        btnDisplayBills.setText("  Display All Bills       ");
        btnDisplayBills.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnDisplayBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayBillsActionPerformed(evt);
            }
        });

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

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoo transparent 2.png"))); // NOI18N
        jLabel16.setText("jLabel10");
        jLabel16.setIconTextGap(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSupplierDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDisplayInvoices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnDisplayBills, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupplierDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplayBills, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplayInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BILLING");

        lblClientSupplierName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClientSupplierName.setForeground(new java.awt.Color(255, 255, 255));
        lblClientSupplierName.setText("Name:");

        txtClientSupplierName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtClientSupplierName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblBillNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBillNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblBillNumber.setText("Bill No:");

        txtInvoiceNo.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtInvoiceNo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblInvoiceNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblInvoiceNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblInvoiceNumber.setText("Invoice No:");

        lblPaymentMethod.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        lblPaymentMethod.setText("Payment Method:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Check,Bank Transfer,Cash");

        lblRecieverName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRecieverName.setForeground(new java.awt.Color(255, 255, 255));
        lblRecieverName.setText("Reciever Name:");

        txtRecieverName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtRecieverName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtBalance.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtBalance.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBalance.setForeground(new java.awt.Color(255, 255, 255));
        lblBalance.setText("Balance:");

        lblAmountToPay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAmountToPay.setForeground(new java.awt.Color(255, 255, 255));
        lblAmountToPay.setText("Amount To Pay:");

        txtAmountToPay.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtAmountToPay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAmountToPay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAmountToPayFocusLost(evt);
            }
        });
        txtAmountToPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountToPayKeyTyped(evt);
            }
        });

        btnPrintBill.setBackground(java.awt.SystemColor.window);
        btnPrintBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrintBill.setForeground(new java.awt.Color(102, 102, 102));
        btnPrintBill.setText("Print");
        btnPrintBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillActionPerformed(evt);
            }
        });

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date:");

        txtDate.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        chkPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Cheque", "Bank Transfer" }));
        chkPaymentMethod.setBorder(null);
        chkPaymentMethod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkPaymentMethodItemStateChanged(evt);
            }
        });

        txtBillNumber.setEditable(false);
        txtBillNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtBillNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        plnChequeDetails.setBackground(new java.awt.Color(51, 58, 86));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CHEQUE ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cheque #");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Issued To");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Amount");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Details");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date:");

        javax.swing.GroupLayout plnChequeDetailsLayout = new javax.swing.GroupLayout(plnChequeDetails);
        plnChequeDetails.setLayout(plnChequeDetailsLayout);
        plnChequeDetailsLayout.setHorizontalGroup(
            plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plnChequeDetailsLayout.createSequentialGroup()
                .addGroup(plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plnChequeDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(plnChequeDetailsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plnChequeDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plnChequeDetailsLayout.createSequentialGroup()
                        .addGroup(plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChequeIssuedTo)
                            .addComponent(txtChequeAmount)
                            .addComponent(txtChequeDetails)
                            .addComponent(txtChequeNum, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(2, 2, 2))
                    .addComponent(txtChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        plnChequeDetailsLayout.setVerticalGroup(
            plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plnChequeDetailsLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtChequeNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtChequeIssuedTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtChequeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plnChequeDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtChequeDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plnChequeDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        plnBankTransfer.setBackground(new java.awt.Color(51, 58, 86));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("BANK TRANSFER");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Bank Name");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Branch Name");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Account Title");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Account #");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("IBAN");

        javax.swing.GroupLayout plnBankTransferLayout = new javax.swing.GroupLayout(plnBankTransfer);
        plnBankTransfer.setLayout(plnBankTransferLayout);
        plnBankTransferLayout.setHorizontalGroup(
            plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plnBankTransferLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plnBankTransferLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(plnBankTransferLayout.createSequentialGroup()
                        .addGroup(plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAccountTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtBranchName, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtBankName, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAccountNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIBAN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        plnBankTransferLayout.setVerticalGroup(
            plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plnBankTransferLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBankName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(11, 11, 11)
                .addGroup(plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(11, 11, 11)
                .addGroup(plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(11, 11, 11)
                .addGroup(plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccountNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plnBankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(0, 43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblClientSupplierName)
                                    .addComponent(lblBillNumber))
                                .addGap(125, 125, 125)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBillNumber)
                                    .addComponent(txtClientSupplierName)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPaymentMethod)
                                    .addComponent(lblInvoiceNumber))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                    .addComponent(chkPaymentMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtInvoiceNo, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblBalance)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblDate)
                                        .addComponent(lblRecieverName))
                                    .addGap(24, 24, 24)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAmountToPay)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAmountToPay)
                            .addComponent(txtBalance)
                            .addComponent(txtRecieverName)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 100, Short.MAX_VALUE))
                            .addComponent(btnPrintBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(plnChequeDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(plnBankTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {plnBankTransfer, plnChequeDetails});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientSupplierName)
                    .addComponent(txtClientSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRecieverName)
                    .addComponent(txtRecieverName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblBillNumber)
                    .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBalance)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInvoiceNumber)
                    .addComponent(lblAmountToPay)
                    .addComponent(txtAmountToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentMethod))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(plnBankTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plnChequeDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed
           if (txtRecieverName.getText().isEmpty() || txtInvoiceNo.getText().isEmpty() || txtBillNumber.getText().isEmpty()
                   || txtDate.getText().isEmpty() || txtBalance.getText().isEmpty() || txtAmountToPay.getText().isEmpty()
                   || txtClientSupplierName.getText().isEmpty()) 
            {
               JOptionPane.showMessageDialog(null, "Please fill all required fields");
            }
           else{
               String paymentMethod = getPaymentMethod();
               if (!"".equals(paymentMethod)) {
                   bill.setPaymentMethod(paymentMethod);
                   if (Double.valueOf(txtAmountToPay.getText()) > Double.valueOf(txtBalance.getText())) {
                       txtAmountToPay.setText(txtBalance.getText());
                   }
                   
                   bill.setAmmount(Frontend.DecimalFormat(Double.valueOf(txtAmountToPay.getText())));
                   bill.setBalance(Frontend.DecimalFormat(Double.valueOf(txtBalance.getText())));
                   bill.setBillNo(txtBillNumber.getText());
                   bill.setDate(txtDate.getText());
                   bill.setInvoiceNo(txtInvoiceNo.getText());
                   bill.setCompanyName(txtClientSupplierName.getText());
                   bill.setYourName(txtRecieverName.getText());
                   System.out.println("Payment Method: " + bill.getPaymentMethod() + "\n Amount: " + bill.getAmmount());
                   if ("cheque".equals(paymentMethod)) {
                       cd.setBillNo(bill.getBillNo());
                       bill.setChequeDetails(cd);
                   }
                   else if("bank transfer".equals(paymentMethod)){
                       bd.setBillNo(bill.getBillNo());
                       bill.setBankDetails(bd);
                   }

//                   printPDF();
                   // insert and update database
                   if (!isPrinted) {
                       System.out.println("Bill generated. "+ bill.getBillNo()+" updating Invoice...".concat(ci.getInvoiceNo()));
                       updateInvoice();   // update balance and profit
                       da.insert_Bill(bill);
                   }
//                       System.err.println("null wala");
                    da.generateBillPDF(bill);    
                   reloadForm();
               }


           }
    }//GEN-LAST:event_btnPrintBillActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnCustomerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDashboardActionPerformed
        // TODO add your handling code here:      
        Customer_form c = new Customer_form();
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCustomerDashboardActionPerformed

    private void btnDisplayBillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayBillsActionPerformed
        // TODO add your handling code here:
        display_all_bills db = new display_all_bills();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDisplayBillsActionPerformed

    private void btnDisplayInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayInvoicesActionPerformed
        // TODO add your handling code here:       
        display_all_invoices di = new display_all_invoices();
        di.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDisplayInvoicesActionPerformed

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

    private void chkPaymentMethodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkPaymentMethodItemStateChanged
        // TODO add your handling code here:
        String method = chkPaymentMethod.getSelectedItem().toString();
        if (method == "Cheque") {
            plnChequeDetails.setVisible(true);
            plnBankTransfer.setVisible(false);
        }
        else if (method == "Bank Transfer") {
            plnBankTransfer.setVisible(true);
            plnChequeDetails.setVisible(false);
        }
        else{
            plnBankTransfer.setVisible(false);
            plnChequeDetails.setVisible(false);
        }
        
    }//GEN-LAST:event_chkPaymentMethodItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void txtAmountToPayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountToPayKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtAmountToPayKeyTyped

    private void txtAmountToPayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountToPayFocusLost
        // TODO add your handling code here:
         txtChequeAmount.setText(txtAmountToPay.getText());
    }//GEN-LAST:event_txtAmountToPayFocusLost

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
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerDashboard;
    private javax.swing.JButton btnDisplayBills;
    private javax.swing.JButton btnDisplayInvoices;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPrintBill;
    private javax.swing.JButton btnSupplierDashboard;
    private javax.swing.JComboBox<String> chkPaymentMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAmountToPay;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblClientSupplierName;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblInvoiceNumber;
    private javax.swing.JLabel lblPaymentMethod;
    private javax.swing.JLabel lblRecieverName;
    private javax.swing.JPanel plnBankTransfer;
    private javax.swing.JPanel plnChequeDetails;
    private javax.swing.JTextField txtAccountNum;
    private javax.swing.JTextField txtAccountTitle;
    private javax.swing.JTextField txtAmountToPay;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBankName;
    private javax.swing.JTextField txtBillNumber;
    private javax.swing.JTextField txtBranchName;
    private javax.swing.JTextField txtChequeAmount;
    private javax.swing.JTextField txtChequeDate;
    private javax.swing.JTextField txtChequeDetails;
    private javax.swing.JTextField txtChequeIssuedTo;
    private javax.swing.JTextField txtChequeNum;
    private javax.swing.JTextField txtClientSupplierName;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtIBAN;
    private javax.swing.JTextField txtInvoiceNo;
    private javax.swing.JTextField txtRecieverName;
    // End of variables declaration//GEN-END:variables
}
