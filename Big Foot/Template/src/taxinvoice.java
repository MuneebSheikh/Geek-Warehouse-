
import Validation.Frontend;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import businesslogic.ClientInvoice;
import businesslogic.Product;
import java.util.LinkedList;
import DataAcess.DataAcess;
import businesslogic.Bill;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class taxinvoice extends javax.swing.JFrame {

    
    /**
     * Creates new form taxinvoice
     */
    ClientInvoice clientInvoice = new ClientInvoice();
    DataAcess da = new DataAcess();
    Frontend ft = new Frontend();
    
    public taxinvoice() {
        initComponents();
        lblBalanceValue.setVisible(false);
        lblBalance.setVisible(false);
        btnEdit.setVisible(false);
        btnSave.setVisible(false);
        init();
    }
    public taxinvoice(ClientInvoice ci){
         initComponents();
         isPrinted = true;
         clientInvoice = ci;
         init(ci);
    }
    //////////////
    /////////////
    //SELF METHODS
    ////////////
    /////////////
    
    boolean isPrinted = false;
    
    private void setPreText(){
        txtDate.setText(Frontend.getCurrentDate());
        txtInvoiceNumber.setText(ft.getClientInvoiceNo());
        txtDnNumber.setText(Frontend.getDnFormat());
        txtPoNumber.setText(Frontend.getPoFormat());
    }
    
    private void init(){
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setPreText();
        txtInvoiceNumber.setEditable(false);
        if(!isPrinted){
            btnGenerateBill.setEnabled(false);
            btnShowBill.setEnabled(false);
        }
        else{
            btnGenerateBill.setEnabled(true);
            btnShowBill.setEnabled(true);
        }
    }
    private void init(ClientInvoice ci){
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        txtAddress.setText(ci.getAddress());
        txtTrnNumber.setText(ci.getTRN());
        txtCharges.setText(ci.getCharges());
        txtCompanyName.setText(ci.getCompanyName());
        txtCompanyTrnNumber.setText(ci.getCompanyTRN());
        txtCostDetail.setText(ci.getCostDetails());
        txtDate.setText(ci.getDate());
        txtInvoiceNumber.setText(ci.getInvoiceNo());
//        txtPersonName.setText(ci.getPersonName());
        txtDnNumber.setText(ci.getDnNumber());
        txtPoNumber.setText(ci.getPoNumber());
        txtTermsAndConditions.setText(ci.getTermsAndConditions());
        txtTotalCost.setText(ci.getCostAmount());
        txtVat.setText(ci.getVAT());
        lblStatusValue.setText(ci.getStatus());
        lblNetResult.setText(ci.getNetTotal());
        lblGrandTotalResult.setText(ci.getGrandTotal());
        lblBalanceValue.setText(Frontend.currency_Format(ci.getBalance()));
        if (ci.getPickupService().equals("yes")) {
            chkPickup.setSelected(true);
        }
        if (ci.getLabourService().equals("yes")) {
            chkLabour.setSelected(true);
        }
        
        LinkedList<Product> prods = ci.getProds();
       
        DefaultTableModel model = (DefaultTableModel) tblProds.getModel();
        model.setRowCount(0);
        for (Product p : prods) {
            model.addRow(new Object[] {p.getProdName(), p.getDesc(), p.getQuantity(), p.getCost()});
        }
        setComponentsForOldInvoice();
    }
    private void reloadForm_c(){
        taxinvoice newForm = new taxinvoice(this.clientInvoice);
        newForm.setVisible(true);
        this.dispose();
    }
    private void setComponentsForOldInvoice(){
        txtTrnNumber.setEditable(false);
        txtCompanyTrnNumber.setEditable(false);
        txtDnNumber.setEditable(false);
        txtAddress.setEditable(false);
        txtCharges.setEditable(false);
        txtCompanyName.setEditable(false);
        txtCostDetail.setEditable(false);
        txtDate.setEditable(false);
        txtInvoiceNumber.setEditable(false);
//        txtPersonName.setEditable(false);
        txtDnNumber.setEditable(false);
        txtPoNumber.setEditable(false);
        txtPrice.setEditable(false);
        txtProductDescription.setEditable(false);
        txtProductName.setEditable(false);
        txtQuantity.setEditable(false);
        txtTermsAndConditions.setEditable(false);
        txtTotalCost.setEditable(false);
        txtVat.setEditable(false);
        btnAdd.setEnabled(false);
        btnRemove.setEnabled(false);
        chkPickup.setEnabled(false);
        chkLabour.setEnabled(false);
        btnEdit.setVisible(true);
        btnSave.setVisible(false);
    }
    private void setComponentsForEditInvoice(){
        
        LinkedList<Bill> bills = da.getAllBills(clientInvoice.getInvoiceNo());
        txtTrnNumber.setEditable(true);
        txtCompanyTrnNumber.setEditable(true);
        txtDnNumber.setEditable(true);
        txtAddress.setEditable(true);
        txtCompanyName.setEditable(true);
        txtDnNumber.setEditable(true);
        txtPoNumber.setEditable(true);
        txtTermsAndConditions.setEditable(true);
        
        if (bills.isEmpty()) {
//            System.out.println("Bill is already generated for this invoice!");
            txtCharges.setEditable(true);
            txtCostDetail.setEditable(true);
            txtDate.setEditable(true);
            txtPrice.setEditable(true);
            txtProductDescription.setEditable(true);
            txtProductName.setEditable(true);
            txtQuantity.setEditable(true);
            txtTotalCost.setEditable(true);
            txtVat.setEditable(true);
            btnAdd.setEnabled(true);
            btnRemove.setEnabled(true);
            chkPickup.setEnabled(true);
            chkLabour.setEnabled(true);        
        }
        else{
            JOptionPane.showMessageDialog(null, "Bill is already generated for this invoice!\nYou will not be able to modify some fields.",
                    "!", JOptionPane.INFORMATION_MESSAGE);
        }
        btnPrint.setEnabled(false);
        btnGenerateBill.setEnabled(false);
        btnShowBill.setEnabled(false);
        
    }
    private LinkedList<Product> getAllProducts(){
        
        int rowCount = tblProds.getRowCount();
        LinkedList<Product> prods = new LinkedList<Product>();
        for (int i = 0; i < rowCount; i++) {
            Product p = new Product();  
            p.setProdName(tblProds.getValueAt(i, 0).toString());
            p.setDesc(tblProds.getValueAt(i, 1).toString());
            p.setQuantity(tblProds.getValueAt(i, 2).toString());
            p.setCost(tblProds.getValueAt(i, 3).toString());
            p.setInvoiceNo(txtInvoiceNumber.getText());
            prods.add(p);
        }
        return prods;
    }
    
    private String getGrandTot(){
        
        double netTot = Double.valueOf(lblNetResult.getText());
        double vat = 0, charges = 0, grand = 0;
        if (!txtVat.getText().trim().isEmpty()) {
            vat = Double.valueOf(txtVat.getText());
            vat = vat / 100;
           // txtVat.setText(String.valueOf(vat));
        }
        if (!txtCharges.getText().trim().isEmpty()) {
            charges = Double.valueOf(txtCharges.getText());
        }
        
        grand = netTot + charges + (netTot)*vat;
        return Frontend.DecimalFormat(grand);
//        return String.valueOf(grand);
    }
    private String getNetTotal(){
        int rowCount = tblProds.getRowCount();
        double tot = 0;
        for (int i = 0; i < rowCount; i++) {
            String temp = this.tblProds.getValueAt(i, 3).toString();
            tot += Double.valueOf(temp);
        }
        return Frontend.DecimalFormat(tot);
//        return String.valueOf(tot);
    }

    
    private void printPDF(){
        try {
//            BasicConfigurator.configure();
//            JasperReport jr = JasperCompileManager.compileReport("src\\Invoices\\invoice_tax_cus.jrxml");
//            JRDataSource jdata = new JREmptyDataSource();
//            JasperPrint jp = JasperFillManager.fillReport(jr,null,jdata);
//            JasperViewer.viewReport(jp, false);
            
            
        } 
        catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    private boolean areAllFieldsValid(){
        if (txtAddress.getText().isEmpty() || txtDnNumber.getText().isEmpty() || txtCompanyName.getText().isEmpty() 
                || txtCostDetail.getText().isEmpty() || txtDate.getText().isEmpty() || txtInvoiceNumber.getText().isEmpty() 
                /*|| txtPersonName.getText().isEmpty()*/ || txtVat.getText().isEmpty() || txtTotalCost.getText().isEmpty()
                || txtTermsAndConditions.getText().isEmpty()) 
        {
            return false;
        }
        else{
            if (tblProds.getRowCount() < 1) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want No products in this invoice?", "Warning", 1);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    return true;
                }
                else return false;
            }
            if (txtCharges.getText().isEmpty()) {
                txtCharges.setText("0");
            }
            return true;
        }
    }
    
    private void updateInvoice(){
        if (areAllFieldsValid()) {
            isPrinted = true;
            
//            ClientInvoice ci = new ClientInvoice();
           double totalBalance = Double.valueOf(clientInvoice.getGrandTotal());
           int count = 0;
//           for(ClientInvoice ci : da.getAllClientInvoices()){
//               if(ci.getInvoiceNo().equals(clientInvoice.getInvoiceNo())){
//               }
//           }
            for(Bill b: da.getAllBills(clientInvoice.getInvoiceNo())){
                count++;
                totalBalance -= Double.valueOf(b.getAmmount());
            }
            clientInvoice.setBalance(String.valueOf(totalBalance));
            System.err.println("New Status: " + clientInvoice.getStatus());;
            System.out.println("NEW BALANCE: " + totalBalance + " No of Bills: " + count);
            LinkedList<Product> prods = getAllProducts();
            clientInvoice.setAddress(txtAddress.getText());
            clientInvoice.setCharges(txtCharges.getText());
            clientInvoice.setCompanyName(txtCompanyName.getText());
            clientInvoice.setCostAmount(txtTotalCost.getText());
            clientInvoice.setCostDetails(txtCostDetail.getText());
            clientInvoice.setDate(txtDate.getText());
            clientInvoice.setGrandTotal(lblGrandTotalResult.getText());
            clientInvoice.setInvoiceNo(txtInvoiceNumber.getText());
            clientInvoice.setNetTotal(lblNetResult.getText());
//            clientInvoice.setPersonName(txtPersonName.getText());
//            clientInvoice.setStatus(lblStatusValue.getText());
            clientInvoice.setTRN(txtTrnNumber.getText());
            clientInvoice.setTermsAndConditions(txtTermsAndConditions.getText());
            clientInvoice.setVAT(txtVat.getText());
            clientInvoice.setCompanyTRN(txtCompanyTrnNumber.getText());
            clientInvoice.setPoNumber(txtPoNumber.getText());
            clientInvoice.setDnNumber(txtDnNumber.getText());
//            System.out.println("BALANCE UPDATED->>" + lblBalanceValue.getText());
//            clientInvoice.setBalance(lblBalanceValue.getText());
            clientInvoice.setProds(prods);
            if (chkLabour.isSelected()) {
                clientInvoice.setLabourService("yes");
            }
            else{
                clientInvoice.setLabourService("no");
            }
            if (chkPickup.isSelected()) {
                clientInvoice.setPickupService("yes");
            }
            else{
                clientInvoice.setPickupService("no");
            }
            
            da.update_ClientInvoice(clientInvoice);
            da.update_Products(clientInvoice.getProds());
            
            // insert
//            printPDF();
            reloadForm_c();
            //init();            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Fill all the fields");
        }
    }
    
    //////////////
    /////////////
    //EVENTS
    ////////////
    /////////////
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomerDashboard = new javax.swing.JButton();
        btnDisplayInvoice = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDnNumber = new javax.swing.JTextField();
        lblTrnNumber = new javax.swing.JLabel();
        lblInvoivceNumber = new javax.swing.JLabel();
        txtInvoiceNumber = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        lblTotalCost = new javax.swing.JLabel();
        lblCostDetail = new javax.swing.JLabel();
        lblTermsAndConditions = new javax.swing.JLabel();
        txtTotalCost = new javax.swing.JTextField();
        lblNetTotal = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProds = new javax.swing.JTable();
        btnGenerateBill = new javax.swing.JButton();
        btnShowBill = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        lblNetResult = new javax.swing.JLabel();
        lblGrandTotalResult = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblVat = new javax.swing.JLabel();
        txtVat = new javax.swing.JTextField();
        chkPickup = new javax.swing.JCheckBox();
        chkLabour = new javax.swing.JCheckBox();
        lblCompanyName = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        lblCharges = new javax.swing.JLabel();
        txtCharges = new javax.swing.JTextField();
        lblGrandAED = new javax.swing.JLabel();
        lblNetAED = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        txtTrnNumber = new javax.swing.JTextField();
        lblDrNumber = new javax.swing.JLabel();
        txtCompanyTrnNumber = new javax.swing.JTextField();
        lblCompanyTrnNumber = new javax.swing.JLabel();
        txtPoNumber = new javax.swing.JTextField();
        lblPoNumber = new javax.swing.JLabel();
        lblStatusName = new javax.swing.JLabel();
        lblStatusValue = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblBalanceValue = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtTermsAndConditions = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCostDetail = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtProductDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

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

        btnDisplayInvoice.setBackground(new java.awt.Color(255, 255, 255));
        btnDisplayInvoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDisplayInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mdi-desktop-mac-dashboard.png"))); // NOI18N
        btnDisplayInvoice.setText("Display Invoices");
        btnDisplayInvoice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnDisplayInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayInvoiceActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_home.png"))); // NOI18N
        btnHome.setText("Home              ");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDisplayInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnCustomerDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDisplayInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TAX INVOICE");

        txtDnNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtDnNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTrnNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTrnNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblTrnNumber.setText("TRN No:");

        lblInvoivceNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblInvoivceNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblInvoivceNumber.setText("Invoice No:");

        txtInvoiceNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtInvoiceNumber.setText("BGKT_INV_");
        txtInvoiceNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address:");

        lblTotalCost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalCost.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalCost.setText("Total Cost:");

        lblCostDetail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCostDetail.setForeground(new java.awt.Color(255, 255, 255));
        lblCostDetail.setText("Cost Details:");

        lblTermsAndConditions.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTermsAndConditions.setForeground(new java.awt.Color(255, 255, 255));
        lblTermsAndConditions.setText("Terms \n& \nConditions:");

        txtTotalCost.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtTotalCost.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTotalCost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalCostFocusLost(evt);
            }
        });
        txtTotalCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalCostKeyTyped(evt);
            }
        });

        lblNetTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNetTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblNetTotal.setText("Net Total:");

        lblGrandTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGrandTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblGrandTotal.setText("Grand Total:");

        txtProductName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtProductName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtQuantity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        txtPrice.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtPrice.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        btnAdd.setBackground(java.awt.SystemColor.window);
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(112, 121, 156));
        btnAdd.setText("Add");
        btnAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblProds.setAutoCreateRowSorter(true);
        tblProds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Description", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProds.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProds.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProds);

        btnGenerateBill.setBackground(java.awt.SystemColor.window);
        btnGenerateBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerateBill.setForeground(new java.awt.Color(112, 112, 112));
        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });

        btnShowBill.setBackground(java.awt.SystemColor.window);
        btnShowBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnShowBill.setForeground(new java.awt.Color(112, 112, 112));
        btnShowBill.setText("Show All Bills");
        btnShowBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnShowBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowBillActionPerformed(evt);
            }
        });

        btnPrint.setBackground(java.awt.SystemColor.window);
        btnPrint.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(112, 121, 156));
        btnPrint.setText("Print");
        btnPrint.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        lblNetResult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNetResult.setForeground(new java.awt.Color(255, 255, 255));
        lblNetResult.setText("0");

        lblGrandTotalResult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGrandTotalResult.setForeground(new java.awt.Color(255, 255, 255));
        lblGrandTotalResult.setText("0");

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

        lblVat.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblVat.setForeground(new java.awt.Color(255, 255, 255));
        lblVat.setText("VAT:");

        txtVat.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtVat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtVat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVatFocusLost(evt);
            }
        });
        txtVat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVatActionPerformed(evt);
            }
        });
        txtVat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVatKeyTyped(evt);
            }
        });

        chkPickup.setBackground(new java.awt.Color(51, 58, 86));
        chkPickup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkPickup.setForeground(new java.awt.Color(255, 255, 255));
        chkPickup.setText("Pickup");
        chkPickup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPickupActionPerformed(evt);
            }
        });

        chkLabour.setBackground(new java.awt.Color(51, 58, 86));
        chkLabour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkLabour.setForeground(new java.awt.Color(255, 255, 255));
        chkLabour.setText("Labour");

        lblCompanyName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCompanyName.setForeground(new java.awt.Color(255, 255, 255));
        lblCompanyName.setText("Company Name:");

        txtCompanyName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtCompanyName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCharges.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCharges.setForeground(new java.awt.Color(255, 255, 255));
        lblCharges.setText("Charges:");

        txtCharges.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtCharges.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCharges.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtChargesFocusLost(evt);
            }
        });
        txtCharges.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtChargesKeyTyped(evt);
            }
        });

        lblGrandAED.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGrandAED.setForeground(new java.awt.Color(255, 255, 255));
        lblGrandAED.setText("AED");

        lblNetAED.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNetAED.setForeground(new java.awt.Color(255, 255, 255));
        lblNetAED.setText("AED");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Name");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Description");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price");

        btnRemove.setBackground(java.awt.SystemColor.window);
        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(112, 112, 112));
        btnRemove.setText("Remove");
        btnRemove.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        txtTrnNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtTrnNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDrNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDrNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblDrNumber.setText("D.N No:");

        txtCompanyTrnNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtCompanyTrnNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCompanyTrnNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCompanyTrnNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblCompanyTrnNumber.setText("Company TRN No:");

        txtPoNumber.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtPoNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPoNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPoNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblPoNumber.setText("P.O No:");

        lblStatusName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblStatusName.setForeground(new java.awt.Color(255, 255, 255));
        lblStatusName.setText("Invoice Status: ");

        lblStatusValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblStatusValue.setForeground(new java.awt.Color(255, 255, 255));
        lblStatusValue.setText("N/A");

        lblBalance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBalance.setForeground(new java.awt.Color(255, 255, 255));
        lblBalance.setText("Balance: ");

        lblBalanceValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBalanceValue.setForeground(new java.awt.Color(255, 255, 255));
        lblBalanceValue.setText("N/A");

        btnEdit.setBackground(java.awt.SystemColor.window);
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(112, 121, 156));
        btnEdit.setText("Edit");
        btnEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setBackground(java.awt.SystemColor.window);
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(112, 121, 156));
        btnSave.setText("Save");
        btnSave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane3.setViewportView(txtAddress);

        txtTermsAndConditions.setColumns(20);
        txtTermsAndConditions.setRows(5);
        jScrollPane4.setViewportView(txtTermsAndConditions);

        txtCostDetail.setColumns(20);
        txtCostDetail.setRows(5);
        jScrollPane5.setViewportView(txtCostDetail);

        txtProductDescription.setColumns(20);
        txtProductDescription.setRows(5);
        jScrollPane6.setViewportView(txtProductDescription);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGenerateBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnShowBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(269, 269, 269)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtPrice))))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTrnNumber)
                                    .addComponent(lblCompanyName)
                                    .addComponent(lblDrNumber)
                                    .addComponent(lblCompanyTrnNumber)
                                    .addComponent(lblAddress)
                                    .addComponent(lblInvoivceNumber)
                                    .addComponent(lblPoNumber))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCompanyName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                    .addComponent(txtTrnNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDnNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCompanyTrnNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPoNumber)
                                    .addComponent(jScrollPane3))
                                .addGap(33, 33, 33))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCharges)
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(131, 131, 131)
                                                .addComponent(lblDate))
                                            .addComponent(lblTermsAndConditions)
                                            .addComponent(lblCostDetail))
                                        .addGap(23, 23, 23)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                .addGap(94, 94, 94)
                                                .addComponent(lblVat))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCharges)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chkPickup, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(chkLabour, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtVat, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                .addGap(44, 44, 44))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotalCost, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(25, 25, 25))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTotalCost)
                                .addGap(0, 502, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblNetTotal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblNetAED))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblGrandTotal)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblGrandAED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblGrandTotalResult))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblNetResult))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblBalance)
                                            .addComponent(lblStatusName))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblStatusValue)
                                            .addComponent(lblBalanceValue))))
                                .addGap(81, 81, 81))))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtProductName, txtQuantity});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDate)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnSave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVat)
                            .addComponent(txtVat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCharges, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkPickup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkLabour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInvoivceNumber)
                    .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalCost)
                    .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCompanyName)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrnNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrnNumber, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCostDetail))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTermsAndConditions)
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNetTotal)
                            .addComponent(lblNetResult)
                            .addComponent(lblNetAED))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGrandTotal)
                            .addComponent(lblGrandTotalResult)
                            .addComponent(lblGrandAED))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatusName)
                            .addComponent(lblStatusValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBalance)
                            .addComponent(lblBalanceValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCompanyTrnNumber)
                            .addComponent(txtCompanyTrnNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDnNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDrNumber))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPoNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(lblAddress))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblPoNumber)
                                        .addGap(92, 92, 92)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(39, 39, 39)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerateBill)
                    .addComponent(btnShowBill)
                    .addComponent(btnPrint))
                .addGap(29, 29, 29))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1328, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtVatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVatActionPerformed

    private void chkPickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPickupActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_chkPickupActionPerformed

    private void btnCustomerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerDashboardActionPerformed
        // TODO add your handling code here:
        Customer_form c = new Customer_form();
        c.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCustomerDashboardActionPerformed

    private void btnDisplayInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayInvoiceActionPerformed
        // TODO add your handling code here:
        display_all_invoices di = new display_all_invoices();
        di.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDisplayInvoiceActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        Main_Dashboard dashboard = new Main_Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed

        billing bill = new billing(clientInvoice);
        bill.setVisible(true); // this to be called with invoice no
        this.dispose();
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void btnShowBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowBillActionPerformed
        // TODO add your handling code here:
        display_all_bills db = new display_all_bills(this.clientInvoice);
        db.setVisible(true); // this to be called with invoice no
        this.dispose();
    }//GEN-LAST:event_btnShowBillActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String prodName = this.txtProductName.getText();
        String desc = this.txtProductDescription.getText();
        String qty = this.txtQuantity.getText();
        String price = this.txtPrice.getText();
        if (prodName.isEmpty() || desc.isEmpty() || qty.isEmpty() || price.isEmpty()) {
            JOptionPane.showMessageDialog(null, "fill out the required fields to add product");
        }
        else{
            DefaultTableModel model = (DefaultTableModel) tblProds.getModel();
            model.addRow(new Object[] {prodName, desc, qty, price});
            lblNetResult.setText(getNetTotal());
            lblGrandTotalResult.setText(getGrandTot());            
        }
        

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        if (areAllFieldsValid()) {
            
//            ClientInvoice ci = new ClientInvoice();
            LinkedList<Product> prods = getAllProducts();
            clientInvoice.setAddress(txtAddress.getText());
            clientInvoice.setCharges(txtCharges.getText());
            clientInvoice.setCompanyName(txtCompanyName.getText());
            clientInvoice.setCostAmount(txtTotalCost.getText());
            clientInvoice.setCostDetails(txtCostDetail.getText());
            clientInvoice.setDate(txtDate.getText());
            clientInvoice.setGrandTotal(lblGrandTotalResult.getText());
            clientInvoice.setInvoiceNo(txtInvoiceNumber.getText());
            clientInvoice.setNetTotal(lblNetResult.getText());
//            clientInvoice.setPersonName(txtPersonName.getText());
            clientInvoice.setStatus("unpaid");
            clientInvoice.setTRN(txtTrnNumber.getText());
            clientInvoice.setTermsAndConditions(txtTermsAndConditions.getText());
            clientInvoice.setVAT(txtVat.getText());
            clientInvoice.setCompanyTRN(txtCompanyTrnNumber.getText());
            clientInvoice.setPoNumber(txtPoNumber.getText());
            clientInvoice.setDnNumber(txtDnNumber.getText());
            clientInvoice.setBalance(lblGrandTotalResult.getText());
            clientInvoice.setProds(prods);
            if (chkLabour.isSelected()) {
                clientInvoice.setLabourService("yes");
            }
            else{
                clientInvoice.setLabourService("no");
            }
            if (chkPickup.isSelected()) {
                clientInvoice.setPickupService("yes");
            }
            else{
                clientInvoice.setPickupService("no");
            }
            if (!isPrinted) {
                da.insert_ClientInv(clientInvoice);
                da.insert_Product(clientInvoice.getProds());                
            }
            da.generateInvPDF(clientInvoice, clientInvoice.getProds());
            // insert
//            printPDF();
            reloadForm_c();
            //init();            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Fill all the fields");
        }
        // insert if new invoice
        // update if old invoice

// TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtChargesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtChargesFocusLost
        // TODO add your handling code here:
        if(txtCharges.getText().trim().isEmpty())
        {
            txtCharges.setText("0");
        }
        txtCharges.setText(Frontend.ValidateDouble(txtCharges.getText()));
        System.out.println("CHARGES");    
        
        lblGrandTotalResult.setText(getGrandTot());            
            
//        try{
//            lblGrandTotalResult.setText(getGrandTot());            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "invalid Input");
//            txtCharges.setText("0");
//            lblGrandTotalResult.setText(getGrandTot());
//        }
    }//GEN-LAST:event_txtChargesFocusLost

    private void txtVatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVatFocusLost
        // TODO add your handling code here:
        if(txtVat.getText().trim().isEmpty())
        {
            txtVat.setText("0");
        }    
        txtVat.setText(Frontend.ValidateDouble(txtVat.getText()));
            System.out.println("VAT");    
            
            lblGrandTotalResult.setText(getGrandTot());            
            
    }//GEN-LAST:event_txtVatFocusLost

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int rowInd = this.tblProds.getSelectedRow();
        if (rowInd != -1) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are your Sure you want to remove this product?", "Warning", 1);
            if(dialogResult == JOptionPane.YES_OPTION){
                DefaultTableModel model = (DefaultTableModel) tblProds.getModel();
                model.removeRow(rowInd);
                lblNetResult.setText(getNetTotal());
                lblGrandTotalResult.setText(getGrandTot());
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select a product to delete");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnSave.setVisible(true);
        btnEdit.setEnabled(false);
        setComponentsForEditInvoice();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        btnSave.setVisible(false);
        btnEdit.setEnabled(true);
        updateInvoice();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtChargesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChargesKeyTyped
        Frontend.onlyDoubleField(evt);
    }//GEN-LAST:event_txtChargesKeyTyped

    private void txtVatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVatKeyTyped
        // TODO add your handling code here:
         Frontend.onlyDoubleField(evt);
    }//GEN-LAST:event_txtVatKeyTyped

    private void txtTotalCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalCostKeyTyped
         Frontend.onlyDoubleField(evt);
    }//GEN-LAST:event_txtTotalCostKeyTyped

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        Frontend.onlyDoubleField(evt);
    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        Frontend.onlyIntField(evt);
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtTotalCostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalCostFocusLost
        if (txtTotalCost.getText().trim().isEmpty()) {
            txtTotalCost.setText("0");
        }
        txtTotalCost.setText(Frontend.ValidateDouble(txtTotalCost.getText()));
       
    }//GEN-LAST:event_txtTotalCostFocusLost

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        if(txtPrice.getText().trim().isEmpty())
        {
            txtPrice.setText("0");
        }
        txtPrice.setText(Frontend.ValidateDouble(txtPrice.getText()));
    }//GEN-LAST:event_txtPriceFocusLost

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
            java.util.logging.Logger.getLogger(taxinvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(taxinvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(taxinvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(taxinvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new taxinvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCustomerDashboard;
    private javax.swing.JButton btnDisplayInvoice;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShowBill;
    private javax.swing.JCheckBox chkLabour;
    private javax.swing.JCheckBox chkPickup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBalanceValue;
    private javax.swing.JLabel lblCharges;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblCompanyTrnNumber;
    private javax.swing.JLabel lblCostDetail;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDrNumber;
    private javax.swing.JLabel lblGrandAED;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblGrandTotalResult;
    private javax.swing.JLabel lblInvoivceNumber;
    private javax.swing.JLabel lblNetAED;
    private javax.swing.JLabel lblNetResult;
    private javax.swing.JLabel lblNetTotal;
    private javax.swing.JLabel lblPoNumber;
    private javax.swing.JLabel lblStatusName;
    private javax.swing.JLabel lblStatusValue;
    private javax.swing.JLabel lblTermsAndConditions;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JLabel lblTrnNumber;
    private javax.swing.JLabel lblVat;
    private javax.swing.JTable tblProds;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCharges;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtCompanyTrnNumber;
    private javax.swing.JTextArea txtCostDetail;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDnNumber;
    private javax.swing.JTextField txtInvoiceNumber;
    private javax.swing.JTextField txtPoNumber;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextArea txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextArea txtTermsAndConditions;
    private javax.swing.JTextField txtTotalCost;
    private javax.swing.JTextField txtTrnNumber;
    private javax.swing.JTextField txtVat;
    // End of variables declaration//GEN-END:variables
}
