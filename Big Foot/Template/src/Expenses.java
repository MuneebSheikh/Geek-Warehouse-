
import DataAcess.DataAcess;
import Validation.Frontend;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import businesslogic.Expences;
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
public class Expenses extends javax.swing.JFrame {

    /**
     * Creates new form Expenses
     */
    
    int rowInd = -1;
    DataAcess da = new DataAcess();
    Expences exp;
    LinkedList<Expences> expences;
    public Expenses() {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        btnSupplier.setVisible(false);
        init();
    }

    ///////////////
    ///////////////
    // SELF METHODS
    ///////////////
    /////////////////
    private void initTable(){
        if (null != da.get_Expense()) {
            expences = da.get_Expense();
            DefaultTableModel model = (DefaultTableModel) tblExp.getModel();
            model.setRowCount(0);
            for (int i = 0; i < expences.size(); i++) {
                try{
                    double amount = Double.valueOf(expences.get(i).getAmount());
                    model.addRow(new Object[] {expences.get(i).getDetail(), 
                    expences.get(i).getClient(), Frontend.DecimalFormat(amount), expences.get(i).getName(), 
                    expences.get(i).getStatus(), expences.get(i).getDate()});       
                }
                catch(Exception e){
                    System.err.println("View->exception: " + e);
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    
                    break;
                }
            }
        }
    }
    
    private void init(){
        
        initTable();
        txtDate.setText(Frontend.getCurrentDate());
        String totExp = Frontend.currency_Format(getTotalExpences());
        lblTotalExpensesResult.setText(totExp);
        btnUpdate.setEnabled(false);
        rowInd = -1;
    }
    
    private String getTotalExpences(){
        double tot = 0;     
        tot = da.getTotalExp();
        return Frontend.DecimalFormat(tot);
//        return String.valueOf(tot);
    }
    
   
    private void clearFields(){
        this.txtAmount.setText("");
        this.txtClient.setText("");
        this.txtDate.setText("");
        this.txtDetail.setText("");
        this.txtName.setText("");
        this.txtDate.setText(Frontend.getCurrentDate());
        this.cmbStatus.setSelectedIndex(0);
    }
    
    ///////////////////
    //EVENTS
    ////////////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomer = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblClient = new javax.swing.JLabel();
        txtClient = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        lblDetail = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblTotalExpenses = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lblTotalExpensesResult = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExp = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 58, 86));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(247, 245, 230));

        btnCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_user_2.png"))); // NOI18N
        btnCustomer.setText("Client");
        btnCustomer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        btnSupplier.setBackground(new java.awt.Color(255, 255, 255));
        btnSupplier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_user_2.png"))); // NOI18N
        btnSupplier.setText("Supplier");
        btnSupplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoo transparent 2.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jLabel10.setIconTextGap(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EXPENCES");

        lblClient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClient.setForeground(new java.awt.Color(255, 255, 255));
        lblClient.setText("Client:");

        txtClient.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtClient.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientActionPerformed(evt);
            }
        });

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

        lblAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblAmount.setText("Amount:");

        lblDetail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDetail.setForeground(new java.awt.Color(255, 255, 255));
        lblDetail.setText("Detail:");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name:");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Status:");

        txtName.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTotalExpenses.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalExpenses.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalExpenses.setText("Total Expenses:");

        btnUpdate.setBackground(java.awt.SystemColor.window);
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(java.awt.SystemColor.window);
        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(102, 102, 102));
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setBackground(java.awt.SystemColor.window);
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(102, 102, 102));
        btnAdd.setText("Add");
        btnAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblTotalExpensesResult.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalExpensesResult.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalExpensesResult.setText("0.0");

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

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Paid", "Unpaid" }));

        tblExp.setAutoCreateRowSorter(true);
        tblExp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Mug Sample", "AQUA & HDAM", "90 ", "Azher", "Paid", "30/08/2019"},
                {"Lunch", "AQUA ABHU DHABI JOB", "56", "Azher", "Paid", "31/82019"}
            },
            new String [] {
                "Detail", "Client", "Amount", "Name", "Status", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblExp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExp.getTableHeader().setReorderingAllowed(false);
        tblExp.setVerifyInputWhenFocusTarget(false);
        tblExp.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblExpInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tblExp);

        jLabel2.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DD / MM /YY");

        btnEdit.setBackground(java.awt.SystemColor.window);
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(102, 102, 102));
        btnEdit.setText("Edit");
        btnEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 121, 156), 3, true));
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtDetail.setColumns(20);
        txtDetail.setRows(5);
        jScrollPane2.setViewportView(txtDetail);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTotalExpenses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTotalExpensesResult))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDetail)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblClient)
                                    .addComponent(lblAmount))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(txtClient, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))))
                        .addGap(198, 198, 198)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblStatus)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblName)
                                    .addGap(20, 20, 20)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDate)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnUpdate});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbStatus, txtName});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lblDetail)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDate)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtClient, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClient)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblName)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblAmount)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalExpenses)
                    .addComponent(lblTotalExpensesResult)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnUpdate});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientActionPerformed
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String status = this.cmbStatus.getSelectedItem().toString();
        if(rowInd != -1){
            if (this.txtDetail.getText().isEmpty() || this.txtName.getText().isEmpty() || this.txtDate.getText().isEmpty() || this.txtClient.getText().isEmpty() || this.txtAmount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Fill all fields", "Warning", 2);
            }
            else{
                expences.get(rowInd).setAmount(txtAmount.getText());
                expences.get(rowInd).setClient(txtClient.getText());
                expences.get(rowInd).setDate(txtDate.getText());
                expences.get(rowInd).setDetail(txtDetail.getText());
                expences.get(rowInd).setName(txtName.getText());
                expences.get(rowInd).setStatus(status);
                da.update_Expense(expences.get(rowInd));
                init();
                System.out.println("Updated Sucessfully");
            }
//            DefaultTableModel model = (DefaultTableModel) tblExp.getModel();
//            double amount = Double.valueOf(txtAmount.getText());
//            model.removeRow(rowInd);
//            model.insertRow(rowInd, new Object[] {this.txtDetail.getText(), this.txtClient.getText(), Frontend.DecimalFormat(amount), this.txtName.getText(), this.cmbStatus.getSelectedItem(), this.txtDate.getText()});       
        }
//        rowInd = -1;
        clearFields();
        init();
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        Customer_form customer_form = new Customer_form();
        customer_form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierActionPerformed
        // TODO add your handling code here:
        Supplier_Form supplier_Form = new Supplier_Form();
        supplier_Form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSupplierActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
         Main_Dashboard dashboard = new Main_Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

   
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String status = this.cmbStatus.getSelectedItem().toString();
        if (this.txtDetail.getText().isEmpty() || this.txtName.getText().isEmpty() || this.txtDate.getText().isEmpty() || this.txtClient.getText().isEmpty() || this.txtAmount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Fill all fields", "Warning", 2);
        }
        else{
            exp = new Expences(txtDetail.getText(), txtAmount.getText(), txtClient.getText(), txtDate.getText(),
                    txtName.getText(), status);
            System.out.println("Expence Inserting...");
            try {
                Double.valueOf(txtAmount.getText());
                da.insert_Expense(exp);
                System.out.println("Expence Inserted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
//            DefaultTableModel model = (DefaultTableModel) tblExp.getModel();
//            double amount = Double.valueOf(txtAmount.getText());
//            model.addRow(new Object[] {exp.getDetail(), exp.getClient(), Frontend.DecimalFormat(amount), 
//                exp.getName(), exp.getStatus(), exp.getDate()});  
        }
        clearFields();
        init();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblExpInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblExpInputMethodTextChanged
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(null, "Mesassda");
    }//GEN-LAST:event_tblExpInputMethodTextChanged

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (this.tblExp.getSelectedRow() != -1) {
            rowInd = this.tblExp.getSelectedRow();
            String detail = this.tblExp.getValueAt(rowInd, 0).toString();           
            String client = this.tblExp.getValueAt(rowInd, 1).toString();
            String amount = this.tblExp.getValueAt(rowInd, 2).toString();
            String pName = this.tblExp.getValueAt(rowInd, 3).toString();
            String status = this.tblExp.getValueAt(rowInd, 4).toString();
            String date = this.tblExp.getValueAt(rowInd, 5).toString();
            
            this.txtDetail.setText(detail);
            this.txtName.setText(pName);
            this.txtClient.setText(client);
            this.txtAmount.setText(amount);
            this.txtDate.setText(date);
            System.out.println(status);
            if (status.toLowerCase().equals("paid")) {
                this.cmbStatus.setSelectedIndex(0);
            }
            else{
                this.cmbStatus.setSelectedIndex(1);
            }
            btnUpdate.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select a row");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        rowInd = this.tblExp.getSelectedRow();
        if (rowInd != -1) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are your Sure you want to delete this row?", "Warning", 1);
            if(dialogResult == JOptionPane.YES_OPTION){
                System.out.println(expences.get(rowInd).getAmount()+ ", id: " + expences.get(rowInd).getId());
                da.delete_Expense(expences.get(rowInd));
                DefaultTableModel model = (DefaultTableModel) tblExp.getModel();
                model.removeRow(rowInd);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select a row to delete");
        }
//        rowInd = -1;
        init();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        this.tblExp.clearSelection();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void txtAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyTyped

        Frontend.onlyDoubleField(evt);
        
    }//GEN-LAST:event_txtAmountKeyTyped

    private void txtAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusLost
        // TODO add your handling code here:
        if(txtAmount.getText().trim().isEmpty())
        {
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
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expenses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTotalExpenses;
    private javax.swing.JLabel lblTotalExpensesResult;
    private javax.swing.JTable tblExp;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtClient;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextArea txtDetail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
