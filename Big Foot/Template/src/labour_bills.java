
import DataAcess.DataAcess;
import Validation.Frontend;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import businesslogic.Labour;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahru
 */
public class labour_bills extends javax.swing.JFrame {

    /**
     * Creates new form labour_bills
     */
    private DataAcess da = new DataAcess();
    private Labour labour;
    private LinkedList<String> invNums = new LinkedList<String>(); 
    private boolean isPrinted = false;
    
    public labour_bills() {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        init();
    }
    public labour_bills(Labour l) {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        init(l);
    }
    
    ///////////////////
    //SELF METHODS
    ////////////////////
        
    private void init(){
        Frontend ft = new Frontend();
        clearFields();
        btnEdit.setVisible(false);
        btnSave.setVisible(false);
        this.txtDate.setText(Frontend.getCurrentDate());
        txtBillNumber.setText(ft.getLabourBillNo());
        txtBillNumber.setEditable(false);
        setcmbInvoiceNum(invNums);
    }

    private void init(Labour l){
        isPrinted = true;
//        setcmbInvoiceNum(invNums);
        btnSave.setVisible(false);
        txtAddress.setText(l.getAddress());
        txtDurationOfWork.setText(l.getCost());
        txtBillNumber.setText(l.getBillNo());
        txtDate.setText(l.getDate());
        txtAmount.setText(l.getDuration());
        txtEmailAddress.setText(l.getEmail());
        txtName.setText(l.getName());
        txtlDescriptionOfWork.setText(l.getDescWork());
        txtphone.setText(l.getPhone());
        
        cmbInvoiceNumber.removeAllItems();
        cmbInvoiceNumber.addItem(l.getInvNo());
        cmbInvoiceNumber.setSelectedItem(l.getInvNo());
        
        setComponentsForOldBill();
        
    }
    
    private void setComponentsForOldBill(){
        txtAddress.setEditable(false);
        txtDurationOfWork.setEditable(false);
        txtBillNumber.setEditable(false);
        txtDate.setEditable(false);
        txtAmount.setEditable(false);
        txtEmailAddress.setEditable(false);
        txtName.setEditable(false);
        txtlDescriptionOfWork.setEditable(false);
        txtphone.setEditable(false);
        cmbInvoiceNumber.setEnabled(false);
        
    }
    
    private void clearFields(){
        this.txtDurationOfWork.setText("");
        this.txtBillNumber.setText("");
        this.txtName.setText("");
        this.txtDate.setText("");
        this.txtAmount.setText("");
        this.txtEmailAddress.setText("");
        this.txtphone.setText("");
        this.txtlDescriptionOfWork.setText("");
        this.txtAddress.setText("");
//        setcmbInvoiceNum(invNums);
        this.cmbInvoiceNumber.setSelectedIndex(0);
    }
    private void setcmbInvoiceNum(LinkedList<String> invNums){
        this.cmbInvoiceNumber.removeAllItems();
        invNums = da.get_LabourInvoices();
        LinkedList<Labour> bills = da.get_labourBills();
        for (String invNum : invNums) {
            if(!bills.isEmpty()){
                for(Labour l : bills){
                    if (!l.getInvNo().equals(invNum)) {
                        this.cmbInvoiceNumber.addItem(invNum);
                    }
                }                
            }
            else{
                this.cmbInvoiceNumber.addItem(invNum);
            }
        }
    }
//    private String getCurrentDate(){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");  
//        LocalDateTime now = LocalDateTime.now();
//        return dtf.format(now);
//    }
    private void printPDF(){
        try {
            
//            BasicConfigurator.configure();
//            JasperReport jr = JasperCompileManager.compileReport("src\\Invoices\\invoice_labour.jrxml");
//            JRDataSource jdata = new JREmptyDataSource();
//            JasperPrint jp = JasperFillManager.fillReport(jr,null,jdata);
//            JasperViewer.viewReport(jp, false);
           
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnDisplayLabourBil = new javax.swing.JButton();
        btnCustomerDashboard = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblBillNumber = new javax.swing.JLabel();
        txtBillNumber = new javax.swing.JTextField();
        lblnvoiceNumber = new javax.swing.JLabel();
        lblDurationOfWork = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        lblDescriptionOfWork = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        lblEmailAddress = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        btnPrintBill = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtlDescriptionOfWork = new javax.swing.JTextArea();
        txtDurationOfWork = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lbldate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        cmbInvoiceNumber = new javax.swing.JComboBox<String>();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));

        jPanel2.setBackground(new java.awt.Color(247, 245, 230));

        btnDisplayLabourBil.setBackground(new java.awt.Color(255, 255, 255));
        btnDisplayLabourBil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDisplayLabourBil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ps-euro-bill.png"))); // NOI18N
        btnDisplayLabourBil.setText("Display Labour Bills");
        btnDisplayLabourBil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnDisplayLabourBil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayLabourBilActionPerformed(evt);
            }
        });

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

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_home.png"))); // NOI18N
        btnHome.setText("  Home               ");
        btnHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
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
            .addComponent(btnDisplayLabourBil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 0, 0)
                .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDisplayLabourBil, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LABOUR");

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

        lblnvoiceNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblnvoiceNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblnvoiceNumber.setText("Invoice No:");

        lblDurationOfWork.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDurationOfWork.setForeground(new java.awt.Color(255, 255, 255));
        lblDurationOfWork.setText("Duration Of Work:");

        txtAmount.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtAmount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAmountFocusLost(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountKeyTyped(evt);
            }
        });

        lblDescriptionOfWork.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDescriptionOfWork.setForeground(new java.awt.Color(255, 255, 255));
        lblDescriptionOfWork.setText("Description Of Work:");

        lblAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblAmount.setText("Amount:");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Company Name:");

        txtName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtphone.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtphone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblPhoneNumber.setText("Phone No:");

        lblEmailAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmailAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailAddress.setText("Email Address:");

        txtEmailAddress.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtEmailAddress.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPrintBill.setBackground(java.awt.SystemColor.window);
        btnPrintBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrintBill.setForeground(new java.awt.Color(112, 112, 112));
        btnPrintBill.setText("Print");
        btnPrintBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillActionPerformed(evt);
            }
        });

        txtlDescriptionOfWork.setColumns(20);
        txtlDescriptionOfWork.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        txtlDescriptionOfWork.setRows(5);
        txtlDescriptionOfWork.setBorder(null);
        jScrollPane1.setViewportView(txtlDescriptionOfWork);

        txtDurationOfWork.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtDurationOfWork.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address:");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        txtAddress.setRows(5);
        txtAddress.setBorder(null);
        jScrollPane2.setViewportView(txtAddress);

        lbldate.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbldate.setForeground(new java.awt.Color(255, 255, 255));
        lbldate.setText("Date:");

        txtDate.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtDate.setForeground(new java.awt.Color(51, 51, 51));
        txtDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        cmbInvoiceNumber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "INV-001", "INV-003", "INV-004" }));
        cmbInvoiceNumber.setBorder(null);

        btnEdit.setBackground(java.awt.SystemColor.window);
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(112, 112, 112));
        btnEdit.setText("Edit");
        btnEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setBackground(java.awt.SystemColor.window);
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(112, 112, 112));
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbldate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1075, 1075, 1075))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(635, 635, 635)
                        .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(1145, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(lblPhoneNumber))
                                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtphone)
                                    .addComponent(txtName)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEmailAddress)
                                    .addComponent(lblAddress))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                    .addComponent(txtEmailAddress)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblBillNumber)
                                    .addComponent(lblnvoiceNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbInvoiceNumber, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBillNumber))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(lblDurationOfWork))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDescriptionOfWork)
                                            .addComponent(lblAmount))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDurationOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtAmount)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1030, 1030, 1030))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEdit, btnPrintBill, btnSave});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbldate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBillNumber)
                    .addComponent(txtBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDurationOfWork)
                    .addComponent(txtDurationOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnvoiceNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescriptionOfWork)
                            .addComponent(lblName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhoneNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmailAddress)
                            .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAmount)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblAddress))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1223, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed

        if (txtAddress.getText().isEmpty() || txtBillNumber.getText().isEmpty() || txtDate.getText().isEmpty()
            || txtAmount.getText().isEmpty() || txtEmailAddress.getText().isEmpty()
            || txtName.getText().isEmpty() || txtlDescriptionOfWork.getText().isEmpty()
            || txtphone.getText().isEmpty() || txtDurationOfWork.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Fill all fields", "Error", 2);
        }
        else{
            if (cmbInvoiceNumber.getSelectedIndex() != -1) {
                String billNo, invNo, phone, email, amount, date, address, duration, desc, pName;
                billNo = txtBillNumber.getText();
                invNo = cmbInvoiceNumber.getSelectedItem().toString();
                phone = txtphone.getText();
                email = txtEmailAddress.getText();
                amount = txtAmount.getText();
                date = txtDate.getText();
                address = txtAddress.getText();
                duration = txtDurationOfWork.getText();
                pName = txtName.getText();
                desc = txtlDescriptionOfWork.getText();

                labour  = new Labour(billNo, invNo, pName, email, phone, address, amount, duration, desc, date);
                //      printPDF();
               if(!isPrinted){
                da.insert_Labour(labour);    
               }
               da.generateLabourPDF(labour);
               
               init();
            }
            else{
                JOptionPane.showMessageDialog(null, "Select invoice Number", "Error", 2);
            }
        }
    }//GEN-LAST:event_btnPrintBillActionPerformed

    private void txtBillNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBillNumberActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Main_Dashboard dashboard = new Main_Dashboard();
        dashboard.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCustomerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDashboardActionPerformed
        // TODO add your handling code here:
        Customer_form customer_form = new Customer_form();
        customer_form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCustomerDashboardActionPerformed

    private void btnDisplayLabourBilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayLabourBilActionPerformed
        // TODO add your handling code here:
        display_labour_bills dl = new display_labour_bills();
        dl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDisplayLabourBilActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        btnSave.setVisible(true);
        txtAddress.setEditable(true);
        txtDurationOfWork.setEditable(true);
        txtBillNumber.setEditable(false);
        txtDate.setEditable(true);
        txtAmount.setEditable(true);
        txtEmailAddress.setEditable(true);
        txtName.setEditable(true);
        txtlDescriptionOfWork.setEditable(true);
        txtphone.setEditable(true);
        cmbInvoiceNumber.setEnabled(true);
        btnPrintBill.setEnabled(false);
        btnEdit.setEnabled(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (txtAddress.getText().isEmpty() || txtBillNumber.getText().isEmpty() || txtDate.getText().isEmpty()
            || txtAmount.getText().isEmpty() || txtEmailAddress.getText().isEmpty()
            || txtName.getText().isEmpty() || txtlDescriptionOfWork.getText().isEmpty()
            || txtphone.getText().isEmpty() || txtDurationOfWork.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Fill all fields", "Error", 2);
        }
        else{
            if (cmbInvoiceNumber.getSelectedIndex() != 0) {
                String billNo, invNo, phone, email, amount, date, address, duration, desc, pName;
                billNo = txtBillNumber.getText().toString();
                invNo = cmbInvoiceNumber.getSelectedItem().toString();
                phone = txtphone.getText().toString();
                email = txtEmailAddress.getText().toString();
                amount = txtDurationOfWork.getText().toString();
                date = txtDate.getText().toString();
                address = txtAddress.getText().toString();
                duration = txtAmount.getText().toString();
                pName = txtName.getText().toString();
                desc = txtlDescriptionOfWork.getText().toString();

                labour  = new Labour(billNo, invNo, pName, email, phone, address, amount, duration, desc, date);
                //      printPDF();
               da.update_Labour(labour);
                init(labour);
            }
            else{
                JOptionPane.showMessageDialog(null, "Select invoice Number", "Error", 2);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyTyped
        // TODO add your handling code here:
        Frontend.onlyDoubleField(evt);
    }//GEN-LAST:event_txtAmountKeyTyped

    private void txtAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusLost
        // TODO add your handling code here:
        if (txtAmount.getText().trim().isEmpty()) {
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
            java.util.logging.Logger.getLogger(labour_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(labour_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(labour_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(labour_bills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new labour_bills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomerDashboard;
    private javax.swing.JButton btnDisplayLabourBil;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPrintBill;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbInvoiceNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBillNumber;
    private javax.swing.JLabel lblDescriptionOfWork;
    private javax.swing.JLabel lblDurationOfWork;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblnvoiceNumber;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBillNumber;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDurationOfWork;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtlDescriptionOfWork;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
