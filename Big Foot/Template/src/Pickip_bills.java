
import DataAcess.DataAcess;
import Validation.Frontend;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import businesslogic.Pickup;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahru
 */
public class Pickip_bills extends javax.swing.JFrame {

    /**
     * Creates new form Pickip_bills
     */
    private Pickup p;
    private DataAcess da = new DataAcess();
    LinkedList<String> invNums = new LinkedList<String>(); 
    private boolean isPrinted = false;
    public Pickip_bills() {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        init();
    }
    public Pickip_bills(Pickup p) {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        this.p = p;
        init(p);
    }
    



    ///////////////
    ///////////////
    // SELF METHODS
    ///////////////
    /////////////////
        
    
    private void init(){
        btnEdit.setVisible(false);
        btnSave.setVisible(false);
        Frontend ft = new Frontend();
        this.txtDate.setText(Frontend.getCurrentDate());  
        txtBillNumber.setText(ft.getPickupBillNo());
        txtBillNumber.setEditable(false);
        setcmbInvoiceNum(invNums);
    }
    private void init(Pickup p){
//        setcmbInvoiceNum(invNums);
        isPrinted = true;
        btnSave.setVisible(false);  
        cmbInvoiceNumber.removeAllItems();
        cmbInvoiceNumber.addItem(p.getInvoiceNo());
        cmbInvoiceNumber.setSelectedItem(p.getInvoiceNo());
        txtDate.setText(p.getDate());
        txtBillNumber.setText(p.getBillno());
        txtAmount.setText(p.getAmount());
        txtCompanyName.setText(p.getCompanyName());
        txtDropLocation.setText(p.getLocationOfDrop());
        txtPickupLocation.setText(p.getLocationOfPickup());
        txtTypeOfPackage.setText(p.getTypeOfPackage());
        txtEmaiAddress.setText(p.getEmail());
        txtPhoneNumber.setText(p.getPhone());
        setComponentsForOldBill();
    }
    private void setComponentsForOldBill(){
        this.txtAmount.setEditable(false);
        this.txtBillNumber.setEditable(false);
        this.txtCompanyName.setEditable(false);
        this.txtDate.setEditable(false);
        this.txtDropLocation.setEditable(false);
        this.txtEmaiAddress.setEditable(false);
        this.txtPhoneNumber.setEditable(false);
        this.txtPickupLocation.setEditable(false);
        this.txtTypeOfPackage.setEditable(false);
        this.cmbInvoiceNumber.setEnabled(false);
    }
    private void setcmbInvoiceNum(LinkedList<String> invNums){
       this.cmbInvoiceNumber.removeAllItems();
        invNums = da.get_PickupInvoices();
        LinkedList<Pickup> bills = da.get_pickupBills();
        for (String invNum : invNums) {
            if (!bills.isEmpty()) {
                for(Pickup p : bills){
                    if(!p.getInvoiceNo().equals(invNum)){
                        this.cmbInvoiceNumber.addItem(invNum);             
                    }
                }
            }
            else{
                this.cmbInvoiceNumber.addItem(invNum);
            }
        }
    }
    
    private void clearFields(){
        this.txtAmount.setText("");
        this.txtBillNumber.setText("");
        this.txtCompanyName.setText("");
        this.txtDate.setText("");
        this.txtDropLocation.setText("");
        this.txtEmaiAddress.setText("");
        this.txtPhoneNumber.setText("");
        this.txtPickupLocation.setText("");
        this.txtTypeOfPackage.setText("");
        this.cmbInvoiceNumber.setSelectedIndex(0);
    }
    
    
     private void printPDF(){
        try {
            
//            BasicConfigurator.configure();
//            JasperReport jr = JasperCompileManager.compileReport("src\\Invoices\\invoice_pickup.jrxml");
//            JRDataSource jdata = new JREmptyDataSource();
//            JasperPrint jp = JasperFillManager.fillReport(jr,null,jdata);
//            JasperViewer.viewReport(jp);
           
        } 
        catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    ///////////////////
    //EVENTS
    ////////////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomerDashboard = new javax.swing.JButton();
        btnDisplayInvoice = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblBillNumber = new javax.swing.JLabel();
        txtBillNumber = new javax.swing.JTextField();
        lblinvioceNumber = new javax.swing.JLabel();
        lblPickupLocation = new javax.swing.JLabel();
        txtPickupLocation = new javax.swing.JTextField();
        lblDropLocation = new javax.swing.JLabel();
        lblTypeOfPackage = new javax.swing.JLabel();
        lblCompanyName = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        lblEmaiAddressl = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnPrintBill = new javax.swing.JButton();
        lblAmount = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtDropLocation = new javax.swing.JTextField();
        txtEmaiAddress = new javax.swing.JTextField();
        cmbInvoiceNumber = new javax.swing.JComboBox<String>();
        txtTypeOfPackage = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));

        jPanel2.setBackground(new java.awt.Color(247, 245, 230));

        btnCustomerDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomerDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomerDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mdi-desktop-mac-dashboard.png"))); // NOI18N
        btnCustomerDashboard.setText("Client Dashboard       ");
        btnCustomerDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCustomerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerDashboardActionPerformed(evt);
            }
        });

        btnDisplayInvoice.setBackground(new java.awt.Color(255, 255, 255));
        btnDisplayInvoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDisplayInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icomoon-free_display.png"))); // NOI18N
        btnDisplayInvoice.setText("Display All Pickup Bills");
        btnDisplayInvoice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnDisplayInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayInvoiceActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_home.png"))); // NOI18N
        btnHome.setText("  Home                         ");
        btnHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
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
            .addComponent(btnDisplayInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
            .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplayInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DD / MM /YY");

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PICKUP");

        lblBillNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBillNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblBillNumber.setText("Bill No:");

        txtBillNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtBillNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBillNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillNumberActionPerformed(evt);
            }
        });

        lblinvioceNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblinvioceNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblinvioceNumber.setText("Invoice No:");

        lblPickupLocation.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPickupLocation.setForeground(new java.awt.Color(255, 255, 255));
        lblPickupLocation.setText("Pickup Location:");

        txtPickupLocation.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtPickupLocation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDropLocation.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDropLocation.setForeground(new java.awt.Color(255, 255, 255));
        lblDropLocation.setText("Drop Off Location:");

        lblTypeOfPackage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTypeOfPackage.setForeground(new java.awt.Color(255, 255, 255));
        lblTypeOfPackage.setText("Type Of Package:");

        lblCompanyName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCompanyName.setForeground(new java.awt.Color(255, 255, 255));
        lblCompanyName.setText("Company Name:");

        txtCompanyName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtCompanyName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtPhoneNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblPhoneNumber.setText("Phone No:");

        lblEmaiAddressl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmaiAddressl.setForeground(new java.awt.Color(255, 255, 255));
        lblEmaiAddressl.setText("Email Address:");

        txtAmount.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtAmount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAmountFocusLost(evt);
            }
        });
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountKeyTyped(evt);
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

        lblAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblAmount.setText("Amount:");

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date:");

        txtDate.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtDate.setForeground(new java.awt.Color(51, 51, 51));
        txtDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        txtDropLocation.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtDropLocation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDropLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDropLocationActionPerformed(evt);
            }
        });

        txtEmaiAddress.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtEmaiAddress.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbInvoiceNumber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "INV-001", "INV-003", "INV-004" }));
        cmbInvoiceNumber.setBorder(null);

        txtTypeOfPackage.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtTypeOfPackage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTypeOfPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTypeOfPackageActionPerformed(evt);
            }
        });

        btnEdit.setBackground(java.awt.SystemColor.window);
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(102, 102, 102));
        btnEdit.setText("Edit");
        btnEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setBackground(java.awt.SystemColor.window);
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(102, 102, 102));
        btnSave.setText("Save");
        btnSave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCompanyName)
                                    .addComponent(lblinvioceNumber)
                                    .addComponent(lblPickupLocation)
                                    .addComponent(lblDropLocation))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDropLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPickupLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbInvoiceNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCompanyName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblTypeOfPackage)
                                .addComponent(lblDate))
                            .addComponent(lblBillNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmaiAddressl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAmount, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmaiAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTypeOfPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBillNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbInvoiceNumber, txtAmount, txtBillNumber, txtCompanyName, txtDropLocation, txtEmaiAddress, txtPhoneNumber, txtPickupLocation, txtTypeOfPackage});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblDate))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompanyName)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBillNumber))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblinvioceNumber)
                            .addComponent(cmbInvoiceNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPickupLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPickupLocation))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhoneNumber))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmaiAddressl)
                            .addComponent(txtEmaiAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAmount))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTypeOfPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTypeOfPackage)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDropLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDropLocation)))
                .addGap(31, 31, 31)
                .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBillNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillNumberActionPerformed

   
    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed

//       JOptionPane.showMessageDialog(null, "Please Wait");
       
        if (this.txtBillNumber.getText().isEmpty() || this.txtCompanyName.getText().isEmpty() || 
                this.txtPickupLocation.getText().isEmpty() ||
                this.txtDropLocation.getText().isEmpty() || this.txtPhoneNumber.getText().isEmpty() ||
                this.txtEmaiAddress.getText().isEmpty() || this.txtAmount.getText().isEmpty() || 
                this.txtTypeOfPackage.getText().isEmpty() || this.txtDate.getText().isEmpty() ) 
        {
            JOptionPane.showMessageDialog(null, "Please Fill all fields", "Error", 2);
        }
        else{
            
            String billNo, invNo, cName, pLoc, dLoc, phone, email, amount, pType, date;
            billNo = this.txtBillNumber.getText();
            cName = this.txtCompanyName.getText();
            pLoc = this.txtPickupLocation.getText();
            dLoc = this.txtDropLocation.getText();
            phone = this.txtPhoneNumber.getText();
            email = this.txtEmaiAddress.getText();
            amount = this.txtAmount.getText();
            pType = this.txtTypeOfPackage.getText();
            date = this.txtDate.getText();

            if (this.cmbInvoiceNumber.getSelectedIndex() != -1) {
                invNo = this.cmbInvoiceNumber.getSelectedItem().toString();
                Pickup p = new Pickup(billNo, invNo, cName, email, phone, pLoc, pType, dLoc, amount, date);
//                printPDF();
                // yaha pe dataAccese se db me jaega
                if (!isPrinted) {
                   da.insert_Pickup(p);                    
                }
                da.generatePickupPDF(p);
                init(p);
            }
            else{
                JOptionPane.showMessageDialog(null, "Select invoice Number", "Error", 2);
            }

        }
    }//GEN-LAST:event_btnPrintBillActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtDropLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDropLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDropLocationActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void btnCustomerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDashboardActionPerformed
        // TODO add your handling code here:
        Customer_form customer_form = new Customer_form();
        customer_form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCustomerDashboardActionPerformed

    private void btnDisplayInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayInvoiceActionPerformed
        // TODO add your handling code here:
        display_pickup_bills dp = new display_pickup_bills();
        dp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDisplayInvoiceActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Main_Dashboard dashboard = new Main_Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtTypeOfPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTypeOfPackageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTypeOfPackageActionPerformed

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountKeyReleased

    private void txtAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountKeyPressed

    private void txtAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyTyped
        // TODO add your handling code here:
        Frontend.onlyDoubleField(evt);
    }//GEN-LAST:event_txtAmountKeyTyped

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnSave.setVisible(true);
        this.txtAmount.setEditable(true);
        this.txtBillNumber.setEditable(false);
        this.txtCompanyName.setEditable(true);
        this.txtDate.setEditable(true);
        this.txtDropLocation.setEditable(true);
        this.txtEmaiAddress.setEditable(true);
        this.txtPhoneNumber.setEditable(true);
        this.txtPickupLocation.setEditable(true);
        this.txtTypeOfPackage.setEditable(true);
//        this.cmbInvoiceNumber.setEnabled(true);
        btnPrintBill.setEnabled(false);
        btnEdit.setEnabled(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (this.txtBillNumber.getText().isEmpty() || this.txtCompanyName.getText().isEmpty() || 
                this.txtPickupLocation.getText().isEmpty() ||
                this.txtDropLocation.getText().isEmpty() || this.txtPhoneNumber.getText().isEmpty() ||
                this.txtEmaiAddress.getText().isEmpty() || this.txtAmount.getText().isEmpty() || 
                this.txtTypeOfPackage.getText().isEmpty() || this.txtDate.getText().isEmpty() ) 
        {
            JOptionPane.showMessageDialog(null, "Please Fill all fields", "Error", 2);
        }
        else{
            
            String billNo, invNo, cName, pLoc, dLoc, phone, email, amount, pType, date;
            billNo = this.txtBillNumber.getText();
            cName = this.txtCompanyName.getText();
            pLoc = this.txtPickupLocation.getText();
            dLoc = this.txtDropLocation.getText();
            phone = this.txtPhoneNumber.getText();
            email = this.txtEmaiAddress.getText();
            amount = this.txtAmount.getText();
            pType = this.txtTypeOfPackage.getText();
            date = this.txtDate.getText();

            if (this.cmbInvoiceNumber.getSelectedIndex() != -1) {
                invNo = this.cmbInvoiceNumber.getSelectedItem().toString();
                Pickup p = new Pickup(billNo, invNo, cName, email, phone, pLoc, pType, dLoc, amount, date);
//                printPDF();
                // yaha pe dataAccese se db me jaega
                da.update_Pickup(p);
                init(p);
            }
            else{
                JOptionPane.showMessageDialog(null, "Select invoice Number", "Error", 2);
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusLost
        // TODO add your handling code here:
        if(txtAmount.getText().trim().isEmpty()){
            txtAmount.setText("0");
        }
        txtAmount.setText(Frontend.ValidateDouble(txtAmount.getText()));
    }//GEN-LAST:event_txtAmountFocusLost

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
            java.util.logging.Logger.getLogger(Pickip_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pickip_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pickip_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pickip_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pickip_bills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerDashboard;
    private javax.swing.JButton btnDisplayInvoice;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPrintBill;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbInvoiceNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDropLocation;
    private javax.swing.JLabel lblEmaiAddressl;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPickupLocation;
    private javax.swing.JLabel lblTypeOfPackage;
    private javax.swing.JLabel lblinvioceNumber;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBillNumber;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDropLocation;
    private javax.swing.JTextField txtEmaiAddress;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPickupLocation;
    private javax.swing.JTextField txtTypeOfPackage;
    // End of variables declaration//GEN-END:variables
}
