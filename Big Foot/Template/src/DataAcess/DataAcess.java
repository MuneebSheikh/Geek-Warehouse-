/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcess;
import Validation.Frontend;
import com.itextpdf.text.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import businesslogic.BankDetails;
import businesslogic.Bill;
import businesslogic.ChequeDetails;
import businesslogic.Client;
import java.sql.Statement;
import businesslogic.ClientInvoice;
import businesslogic.Expences;
import businesslogic.Labour;
import businesslogic.Pickup;
import businesslogic.Product;
import businesslogic.Supplier;
import businesslogic.SupplierInvoice;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sajja
 */
public class DataAcess {

    
    
    private DBHelper db;
    private Statement stmt;
    
    public DataAcess() {
        db = new DBHelper();
 
    }
    public Font pdf_getboldFont (int size){
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, size, Font.BOLD);
        return boldFont;
    }
    public Font pdf_getNormalFont (int size){
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, size, Font.NORMAL);
        return font;
    }
    public String pdf_dateFormat(String inputFormat, String outputFormat, String date) throws ParseException{
      return  new SimpleDateFormat(outputFormat).format(new SimpleDateFormat(inputFormat).parse(date));
    }
    
    private void openPDF(String path){
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(path);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }
    
    public void generatePickupPDF(Pickup bill){
        Document doc = new Document(PageSize.A4);
        int colNo = 2;
        String path = "pdf/bills/"+bill.getBillno()+"_PickUpbill.pdf";
        PdfPTable header = new PdfPTable(2);
        PdfPTable dataTable = new PdfPTable(colNo);
        try {
            PdfWriter pw = PdfWriter.getInstance(doc, new FileOutputStream(path));
            header.setWidthPercentage(100);
            
            Image image = Image.getInstance("images/logoo transparent 2.png");
            image.setAlignment(Element.ALIGN_LEFT);
            
            doc.open();
            
            PdfPCell img = new PdfPCell(image);
            img.setBorder(0);
            img.setHorizontalAlignment(Element.ALIGN_LEFT);            
            header.addCell(img);
            //BILL TITLE
            Chunk CKinv = new Chunk("PICKUP BILL \t");
            CKinv.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            CKinv.setFont(pdf_getboldFont(18));
            Paragraph pt = new Paragraph(CKinv); //ckinv -> pt
            pt.setSpacingAfter(10);
            PdfPCell title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_MIDDLE);
            title.setLeft(10);
            header.addCell(title);
            
                        // Date            
//            String df = pdf_dateFormat("dd-MM-YY", "dd MMM, YYYY", ci.getDate());
//            System.err.println("df: "+df);
            pt = new Paragraph("Date: "+bill.getDate()); //ckinv -> pt
            pt.setSpacingAfter(10);
            title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_LEFT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
//            title.setLeft(10);
            header.addCell(title);
            
            //BILL NUMBER
            pt = new Paragraph("BILL.#: "+bill.getBillno()); //ckinv -> pt
            pt.setSpacingAfter(10);
            pt.setFont(pdf_getboldFont(12));
            title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
//            title.setLeft(10);
            header.addCell(title);
            
            
            
            /////// DATA TABLE ///////
            dataTable.setWidthPercentage(80);
            PdfPCell dt;
            int fontSize = 12;
            dt = new PdfPCell(new Phrase("Company Name: " + bill.getCompanyName(), pdf_getNormalFont(fontSize)));
            dt.setBorder(0);
            dataTable.addCell(dt);

            dt = new PdfPCell(new Phrase("Phone Num: " + bill.getPhone(), pdf_getNormalFont(fontSize)));
            dt.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dt.setBorder(0);
            dataTable.addCell(dt);            

            
            dt = new PdfPCell(new Phrase("Invoice#: " + bill.getInvoiceNo(), pdf_getNormalFont(fontSize)));
            dt.setBorder(0);
            dataTable.addCell(dt);

            dt = new PdfPCell(new Phrase("Email: " + bill.getEmail(), pdf_getNormalFont(fontSize)));
            dt.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dt.setBorder(0);
            dataTable.addCell(dt);            

            
            dt = new PdfPCell(new Phrase("Pickup Location: " + bill.getLocationOfPickup(), pdf_getNormalFont(fontSize)));
            dt.setBorder(0);
            dataTable.addCell(dt);

            dt = new PdfPCell(new Phrase("Amount Paid: " + bill.getAmount(), pdf_getNormalFont(fontSize)));
            dt.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dt.setBorder(0);
            dataTable.addCell(dt);

            dt = new PdfPCell(new Phrase("Drop Location: " + bill.getLocationOfDrop(), pdf_getNormalFont(fontSize)));
            dt.setBorder(0);
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase("Type Of Package: " + bill.getTypeOfPackage(), pdf_getNormalFont(fontSize)));
            dt.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dt.setBorder(0);
            dataTable.addCell(dt);
            
            /////////// DOC ADD//////////////
            doc.add(header);
            doc.add(new Paragraph("\n \n"));
            doc.add(dataTable);
            doc.add(new Paragraph("\n \n"));
//            Rectangle ps = doc.getPageSize();
//            float ph = ps.getHeight();
          pw.setPageEvent(new MyFooter());
            doc.close();
            openPDF(path);
            //Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
            
        } catch (Exception e) {
            System.err.println("DataAccess->Exception: " + e);
        }
    
    }
 
    public void generateLabourPDF(Labour bill){
        Document doc = new Document(PageSize.A4);
        int colNo = 2;
        String path = "pdf/bills/"+bill.getBillNo()+"_LabourBill.pdf";
        PdfPTable header = new PdfPTable(2);
        PdfPTable dataTable = new PdfPTable(colNo);
        try {
            PdfWriter pw = PdfWriter.getInstance(doc, new FileOutputStream(path));
            header.setWidthPercentage(100);
            
            Image image = Image.getInstance("images/logoo transparent 2.png");
            image.setAlignment(Element.ALIGN_LEFT);
            
            doc.open();
            
            PdfPCell img = new PdfPCell(image);
            img.setBorder(0);
            img.setHorizontalAlignment(Element.ALIGN_LEFT);            
            header.addCell(img);
            //BILL TITLE
            Chunk CKinv = new Chunk("LABOUR BILL \t");
            CKinv.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            CKinv.setFont(pdf_getboldFont(18));
            Paragraph pt = new Paragraph(CKinv); //ckinv -> pt
            pt.setSpacingAfter(10);
            PdfPCell title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_MIDDLE);
            title.setLeft(10);
            header.addCell(title);
            
                        // Date            
//            String df = pdf_dateFormat("dd-MM-YY", "dd MMM, YYYY", ci.getDate());
//            System.err.println("df: "+df);
            pt = new Paragraph("Date: "+bill.getDate()); //ckinv -> pt
            pt.setSpacingAfter(10);
            title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_LEFT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
//            title.setLeft(10);
            header.addCell(title);
            
            //BILL NUMBER
            pt = new Paragraph("BILL.#: "+bill.getBillNo()); //ckinv -> pt
            pt.setSpacingAfter(10);
            pt.setFont(pdf_getboldFont(12));
            title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
//            title.setLeft(10);
            header.addCell(title);
            
            
            
            /////// DATA TABLE ///////
            dataTable.setWidthPercentage(80);
            PdfPCell dt;
            int fontSize = 12;

            dt = new PdfPCell(new Phrase("Name", pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase(bill.getName(), pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase("Invoice#: ", pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase(bill.getInvNo(), pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase("Phone Number: ", pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase(bill.getPhone(), pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase("Email: ", pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase(bill.getEmail(), pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase("Address: ", pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase(bill.getAddress(), pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase("Duration Of Work#: ", pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase(bill.getDuration(), pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase("Description of Work: ", pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase(bill.getDescWork(), pdf_getNormalFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase("Amount: ", pdf_getboldFont(fontSize)));
            dataTable.addCell(dt);
            
            dt = new PdfPCell(new Phrase(Frontend.currency_Format(bill.getCost()), pdf_getboldFont(fontSize)));
            dataTable.addCell(dt);
            
            /////////// DOC ADD//////////////
            doc.add(header);
            doc.add(new Paragraph("\n \n"));
            doc.add(dataTable);
            doc.add(new Paragraph("\n \n"));
            
            pw.setPageEvent(new MyFooter());
            doc.close();
            openPDF(path);
//            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
            
        } catch (Exception e) {
            System.err.println("DataAccess PDF->Exception: " + e);
        }
    
    }
    
    public void generateBillPDF(Bill bill){
        Document doc = new Document(PageSize.A4);
        int colNo = 2;
        String path = "pdf/bills/"+bill.getBillNo()+"_bill.pdf";
        PdfPTable header = new PdfPTable(2);
        PdfPTable dataTable = new PdfPTable(colNo);
        try {
            PdfWriter pw = PdfWriter.getInstance(doc, new FileOutputStream(path));
            header.setWidthPercentage(100);
            
            Image image = Image.getInstance("images/logoo transparent 2.png");
            image.setAlignment(Element.ALIGN_LEFT);
            
            doc.open();
            
            PdfPCell img = new PdfPCell(image);
            img.setBorder(0);
            img.setHorizontalAlignment(Element.ALIGN_LEFT);            
            header.addCell(img);
            //BILL TITLE
            Chunk CKinv = new Chunk("BILL \t");
            CKinv.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            CKinv.setFont(pdf_getboldFont(18));
            Paragraph pt = new Paragraph(CKinv); //ckinv -> pt
            pt.setSpacingAfter(10);
            PdfPCell title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_MIDDLE);
            title.setLeft(10);
            header.addCell(title);
            
                        // Date            
//            String df = pdf_dateFormat("dd-MM-YY", "dd MMM, YYYY", ci.getDate());
//            System.err.println("df: "+df);
            pt = new Paragraph("Date: "+bill.getDate()); //ckinv -> pt
            pt.setSpacingAfter(10);
            title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_LEFT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
//            title.setLeft(10);
            header.addCell(title);
            
            //BILL NUMBER
            pt = new Paragraph("BILL.#: "+bill.getBillNo()); //ckinv -> pt
            pt.setSpacingAfter(10);
            pt.setFont(pdf_getboldFont(12));
            title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
//            title.setLeft(10);
            header.addCell(title);
            
            
            
            /////// DATA TABLE ///////
            dataTable.setWidthPercentage(80);
            PdfPCell dt;
            int fontSize = 12;
            dt = new PdfPCell(new Phrase("Company Name: " + bill.getCompanyName(), pdf_getNormalFont(fontSize)));
            dt.setBorder(0);
            dataTable.addCell(dt);

            dt = new PdfPCell(new Phrase("Reciever Name: " + bill.getYourName(), pdf_getNormalFont(fontSize)));
            dt.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dt.setBorder(0);
            dataTable.addCell(dt);            

            
            dt = new PdfPCell(new Phrase("Invoice#: " + bill.getInvoiceNo(), pdf_getNormalFont(fontSize)));
            dt.setBorder(0);
            dataTable.addCell(dt);

            dt = new PdfPCell(new Phrase("Balance: " + bill.getBalance(), pdf_getNormalFont(fontSize)));
            dt.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dt.setBorder(0);
            dataTable.addCell(dt);            

            
            dt = new PdfPCell(new Phrase("Payment Method: " + bill.getPaymentMethod(), pdf_getNormalFont(fontSize)));
            dt.setBorder(0);
            dataTable.addCell(dt);

            dt = new PdfPCell(new Phrase("Amount Paid: " + bill.getAmmount(), pdf_getNormalFont(fontSize)));
            dt.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dt.setBorder(0);
            dataTable.addCell(dt);

            
            
            /////////  PAYMENT TABLE ////////////////
            PdfPTable PaymentTable = new PdfPTable(2);
            PaymentTable.setWidthPercentage(80);
            
            PdfPCell cel;
            if (bill.getChequeDetails()!= null) {
                ChequeDetails cd = bill.getChequeDetails();
                cel = new PdfPCell(new Phrase("CHEQUE DETAILS", pdf_getboldFont(14)));
                cel.setColspan(2);
                cel.setBorder(1);
                PaymentTable.addCell(cel);
                
                
                cel = new PdfPCell(new Phrase("Cheque#: ", pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(2);
                PaymentTable.addCell(cel);
                cel = new PdfPCell(new Phrase(cd.getChequeNumber(), pdf_getNormalFont(fontSize)));
                cel.setBorder(2);
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                PaymentTable.addCell(cel);

                cel = new PdfPCell(new Phrase("Issued To: " , pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(2);
                PaymentTable.addCell(cel);
                cel = new PdfPCell(new Phrase(cd.getIssuedTo(), pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(2);
                PaymentTable.addCell(cel);
 
                cel = new PdfPCell(new Phrase("Amount: " , pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(2);
                PaymentTable.addCell(cel);
                cel = new PdfPCell(new Phrase(cd.getAmmount(), pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(2);
                PaymentTable.addCell(cel);
 
               cel = new PdfPCell(new Phrase("Details: ", pdf_getNormalFont(fontSize)));
               cel.setHorizontalAlignment(Element.ALIGN_LEFT);
               cel.setBorder(2);
               PaymentTable.addCell(cel);
                cel = new PdfPCell(new Phrase(cd.getDetails(), pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(2);
                PaymentTable.addCell(cel);
 
          
            }
            else if(bill.getBankDetails() != null){
                BankDetails bd = bill.getBankDetails();
                cel = new PdfPCell(new Phrase("BANK DETAILS", pdf_getboldFont(14)));
                cel.setColspan(2);
                cel.setBorder(1);
                PaymentTable.addCell(cel);
                
                cel = new PdfPCell(new Phrase("Bank Name: " + bd.getBankName(), pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(0);
                PaymentTable.addCell(cel);
                
                cel = new PdfPCell(new Phrase("Branch: " + bd.getBranch(), pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(0);
                PaymentTable.addCell(cel);
 
                cel = new PdfPCell(new Phrase("Account #: " + bd.getAccountNumber(), pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(0);
                PaymentTable.addCell(cel);
                
                cel = new PdfPCell(new Phrase("Account Title: " + bd.getAccountTitle(), pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(0);
                PaymentTable.addCell(cel);
                
                cel = new PdfPCell(new Phrase("IBAN #: " + bd.getIBAN() ,pdf_getNormalFont(fontSize)));
                cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                cel.setBorder(0);
                PaymentTable.addCell(cel);
            }
            else{
                System.err.println("Payment Method: Direct Cash");
            }
            
            /////////// DOC ADD//////////////
            doc.add(header);
            doc.add(new Paragraph("\n \n"));
            doc.add(dataTable);
            doc.add(new Paragraph("\n \n"));
            doc.add(PaymentTable);
//            Rectangle ps = doc.getPageSize();
//            float ph = ps.getHeight();
          pw.setPageEvent(new MyFooter());
            doc.close();
          openPDF(path);  
//            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
            
        } catch (Exception e) {
            System.err.println("DataAccess->Exception: " + e);
        }
    
    }

    
    public void generateInvPDF(ClientInvoice ci, LinkedList<Product> prods){
        Document doc = new Document(PageSize.A4);
        int colNo = 4;
        String path = "pdf/invoices/"+ci.getInvoiceNo()+"_invoice.pdf";
        PdfPTable header = new PdfPTable(2);
        PdfPTable dataTable = new PdfPTable(colNo);
        try {
            PdfWriter pw = PdfWriter.getInstance(doc, new FileOutputStream(path));
            header.setWidthPercentage(100);
            
            Image image = Image.getInstance("images/logoo transparent 2.png");
            image.setAlignment(Element.ALIGN_LEFT);
            
            doc.open();
            
            PdfPCell img = new PdfPCell(image);
            img.setBorder(0);
            img.setHorizontalAlignment(Element.ALIGN_LEFT);            
            header.addCell(img);
            //INVOICE TITLE
            Chunk CKinv = new Chunk("INVOICE \t");
            CKinv.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            CKinv.setFont(pdf_getboldFont(18));
            Paragraph pt = new Paragraph(CKinv); //ckinv -> pt
            pt.setSpacingAfter(10);
            PdfPCell title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_MIDDLE);
            title.setLeft(10);
            header.addCell(title);
            
            ////// VAT ///////////
            title = new PdfPCell(new Paragraph(""));
            title.setBorder(0);
            header.addCell(title);
 
            title = new PdfPCell(new Paragraph("VAT: "+ci.getVAT()+"%", pdf_getNormalFont(10)));
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
            header.addCell(title);
            // Date            
//            String df = pdf_dateFormat("dd-MM-YY", "dd MMM, YYYY", ci.getDate());
//            System.err.println("df: "+df);
            pt = new Paragraph("Date: "+ci.getDate(), pdf_getNormalFont(12)); //ckinv -> pt
            pt.setSpacingAfter(10);
            title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_LEFT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
//            title.setLeft(10);
            header.addCell(title);
            
            //INVOICE NUMBER
            pt = new Paragraph("INV.#: "+ci.getInvoiceNo(),pdf_getboldFont(12)); //ckinv -> pt
            pt.setSpacingAfter(10);
            
            title = new PdfPCell(pt); // pt -> title
            title.setBorder(0);
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
//            title.setLeft(10);
            header.addCell(title);
            
            title = new PdfPCell(new Paragraph(""));
            title.setBorder(0);
            header.addCell(title);

            title = new PdfPCell(new Paragraph("TRN#: "+ci.getTRN(), pdf_getNormalFont(12)));
            title.setHorizontalAlignment(Element.ALIGN_RIGHT);
            title.setVerticalAlignment(Element.ALIGN_TOP);
            title.setBorder(0);
            header.addCell(title);

            
            
            ////// COMPANY DETAILS /////////////
            PdfPTable companyTable = new PdfPTable(1);
            companyTable.setWidthPercentage(100);
            
            int fontsize = 10;
            title = new PdfPCell(new Paragraph("DN#: "+ci.getDnNumber(), pdf_getNormalFont(fontsize)));
            title.setBorder(0);
            
            companyTable.addCell(title);

            title = new PdfPCell(new Paragraph("PO#: "+ci.getPoNumber(), pdf_getNormalFont(fontsize)));
            title.setBorder(0);
            companyTable.addCell(title);
            
            
            title = new PdfPCell(new Paragraph("Company Name: "+ci.getCompanyName(), pdf_getNormalFont(fontsize)));
            title.setBorder(0);
            companyTable.addCell(title);
            
            title = new PdfPCell(new Paragraph("TRN#: "+ci.getCompanyTRN(), pdf_getNormalFont(fontsize)));
            title.setBorder(0);
            companyTable.addCell(title);

            title = new PdfPCell(new Paragraph(ci.getAddress(), pdf_getNormalFont(fontsize)));
            title.setBorder(0);
            companyTable.addCell(title);
            
            
            /////// DATA TABLE ///////
//                dataTable.addCell("ITEM DESC");
//                dataTable.addCell("QTY");
//                dataTable.addCell("TOTAL PRICE");
            Chunk ck = new Chunk("Item Description");
            ck.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            ck.setFont(pdf_getboldFont(12));
            Paragraph p = new Paragraph(ck);
            p.setFont(pdf_getboldFont(12));
            PdfPCell hDesc = new PdfPCell(p);
            hDesc.setHorizontalAlignment(Element.ALIGN_CENTER);
            hDesc.setColspan(2);
            dataTable.addCell(hDesc);
            
                
            ck = new Chunk("Qty");
            ck.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            ck.setFont(pdf_getboldFont(12));
            p = new Paragraph(ck);
            p.setFont(pdf_getboldFont(12));
            PdfPCell hQty = new PdfPCell(new Paragraph(p));
            hQty.setHorizontalAlignment(Element.ALIGN_CENTER);
            dataTable.addCell(hQty);

            ck = new Chunk("Total Price");
            ck.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            ck.setFont(pdf_getboldFont(12));
            p = new Paragraph(ck);
            p.setFont(pdf_getboldFont(12));
            PdfPCell hTprice = new PdfPCell(new Paragraph(p));
            hTprice.setHorizontalAlignment(Element.ALIGN_CENTER);
            dataTable.addCell(hTprice);
            
                
            for(Product pa: prods){
                PdfPCell c1 = new PdfPCell(new Paragraph(pa.getProdName() + "\n" + pa.getDesc(), pdf_getNormalFont(12)));
                c1.setColspan(2);
                PdfPCell c2 = new PdfPCell(new Paragraph(pa.getQuantity(), pdf_getNormalFont(12)));
                c2.setHorizontalAlignment(Element.ALIGN_CENTER);
                c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                PdfPCell c3 = new PdfPCell(new Paragraph(Frontend.currency_Format(pa.getCost()), pdf_getNormalFont(12)));
                c3.setHorizontalAlignment(Element.ALIGN_CENTER);
                c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                dataTable.addCell(c1);
                dataTable.addCell(c2);
                dataTable.addCell(c3);
            }
            PdfPCell gT;
            int fontSize = 10;
            gT = new PdfPCell(new Phrase("NET TOTAL", pdf_getboldFont(fontSize)));
            gT.setColspan(3);
            gT.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dataTable.addCell(gT);
            gT = new PdfPCell(new Phrase(Frontend.currency_Format(ci.getNetTotal()), pdf_getboldFont(fontSize)));
            gT.setHorizontalAlignment(Element.ALIGN_CENTER);
            dataTable.addCell(gT);

            
            gT = new PdfPCell(new Phrase("CHARGES", pdf_getNormalFont(fontSize)));
            gT.setColspan(3);
            gT.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dataTable.addCell(gT);
            gT = new PdfPCell(new Phrase(Frontend.currency_Format(ci.getCharges()), pdf_getNormalFont(fontSize)));
            gT.setHorizontalAlignment(Element.ALIGN_CENTER);
            dataTable.addCell(gT);

          
            gT = new PdfPCell(new Phrase("GRAND TOTAL", pdf_getboldFont(fontSize)));
            gT.setColspan(3);
            gT.setHorizontalAlignment(Element.ALIGN_RIGHT);
            dataTable.addCell(gT);
            gT = new PdfPCell(new Phrase(Frontend.currency_Format(ci.getGrandTotal()), pdf_getboldFont(fontSize)));
            gT.setHorizontalAlignment(Element.ALIGN_CENTER);
            dataTable.addCell(gT);


            
            ////////// DOC ADD /////////////////
            doc.add(header);
//            doc.add(new Paragraph("\n \n"));
            doc.add(companyTable);
            doc.add(new Paragraph("\n \n"));
            doc.add(dataTable);
//            Rectangle ps = doc.getPageSize();
//            float ph = ps.getHeight();
          pw.setPageEvent(new MyFooter());
            doc.close();
            openPDF(path);
//            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
            
        } catch (Exception e) {
            System.err.println("DataAccess->Exception: " + e);
//            if(e.equals("java.io.FileNotFoundException: pdf\\invoices\\BK_INV_0063_invoice.pdf (The requested operation cannot be performed on a file with a user-mapped section open)")){
//                JOptionPane.showMessageDialog(null, "File is in use. Please Make sure to close the File before Print!.", "Warning!", JOptionPane.WARNING_MESSAGE);
//            }
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            
        }
    
    }
    
    
    
    public ResultSet getLastValue(String tableName, String ...colNames){
        return db.getColLastValue(tableName, colNames);
    }
    public String getTotalCol(String tableName,String colName){
        ResultSet rs =  db.getSumAllCol(tableName, colName);
        String total = "0.0";
        try {
            while (rs.next()) {                
                if(rs.getString(1) != null){
                    total = rs.getString(1);                
                }     
                return total;
            }
        } catch (Exception e) {
            System.err.println("DataAccess->Exception: " + e);
        }
        return total;
        
    }
    
    public String getTotalBalance(){
        ResultSet rs =  db.getSumAllCol("c_invoice", "CI_BALANCE");
        String total_balance = "0.0";
        try {
            while (rs.next()) {                
                if(rs.getString(1) != null){
                    total_balance = rs.getString(1);                
                }
                System.out.println(total_balance);            
                return total_balance;
            }
        } catch (Exception e) {
            System.err.println("DataAccess->Exception: " + e);
        }
        return total_balance;
    }
    
    
    
    public int getBillNo(){
        int id = db.getlastID("BILL");
        if (id < 0) {
            return id;
        }
        System.out.println("DataAcess: BillNO: " + id);
        return ++id;
    }
    public int getPickupBillNo(){
        int id = db.getlastID("pickup");
        if (id < 0) {
            return id;
        }
        System.out.println("DataAcess: PB Bill: " + id);
        return ++id;
    }
    public int getLabourBillNo(){
        int id = db.getlastID("labour");
        if (id < 0) {
            return id;
        }
        System.out.println("DataAcess: PB Bill: " + id);
        return ++id;
    }
    public int getClientInvoiceNo(){
        int id = db.getlastID("c_invoice");
        if (id < 0) {
            return id;
        }
        System.out.println("DataAcess: invNO: " + id);
        return ++id;
    }
    public static int getSupplierInvoiceNo() {
        LinkedList<String> ids = new LinkedList<>();
//        ids = db.getAllData("Supplier_invoice", id);
        int id = -1; // remove this when data base is attached
        if (!ids.isEmpty()) {
            id = Integer.valueOf(ids.getLast());
        }
        return id++;
    }
    
    //******************    GET ALL DATA DEFINITIONS    **********
    
//    public LinkedList<BankDetails> getAll_BankDetails(){
//        LinkedList<BankDetails> ls = new LinkedList<>();
//        String BN_NAME,
//            BN_BRANCH,
//            BN_ACCTTITLE,
//            BN_ACCNO,
//            BN_IBANNO;
//        ResultSet rs = db.getAllData("BANKTRANSFER","\0");
//        try {
//            while (rs.next()) {
//                System.out.println(BN_NAME = rs.getObject(3).toString()+"bachodi");
//                BankDetails bd = new BankDetails(rs.getNString('BN_NAME'), rs., BN_ACCTTITLE, BN_IBANNO, BN_IBANNO);
//                ls.add(bd);
//            }
//            return 
//        } catch (SQLException ex) {
//            Logger.getLogger(DataAcess.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//        return ls;
//    }
   
public double getTotalExp(){
    double total = 0;
    try {
        
        ResultSet rs = db.getAllData("expense", "E_AMOUNT");
        while(rs.next()){
            total += Double.valueOf(rs.getString("E_AMOUNT"));
        }
        return total;

    } catch (Exception e) {
        System.err.println("DataAccess: " + e);
    }
    return -1;
}
    
public LinkedList<Product> getProds (String invoiceNo){    
    LinkedList<Product> prods = db.getProds(invoiceNo);
    return prods;
}
public LinkedList<Bill> getAllBills(String invoiceNo){
    LinkedList<Bill> bills = new LinkedList<>();
    ResultSet rs = db.getAllData("BILL","ci_no", invoiceNo);
    try {
        while(rs.next()){
            Bill bill = new Bill(rs.getString("B_ID_NO"), rs.getString("CI_NO"), rs.getString("B_NAME"), rs.getString("B_USERNAME"), rs.getString("B_DATE"), rs.getString("B_BALANCE"), rs.getString("B_AMOUNT"), rs.getString("B_PAYMENTMETHOD"));
            bills.add(bill);
        }
    } catch (Exception e) {
        System.err.println("DataAcess->Exception: " + e);
    }
    
    return bills;
}
    
public LinkedList<Bill> getAllBills(){
    LinkedList<Bill> bills = new LinkedList<>();
    ResultSet rs = db.getAllData("BILL","\0");
    try {
        while(rs.next())
        {
            Bill bill = new Bill(rs.getString("B_ID_NO"), rs.getString("CI_NO"), rs.getString("B_NAME"), rs.getString("B_USERNAME"), rs.getString("B_DATE"), rs.getString("B_BALANCE"), rs.getString("B_AMOUNT"), rs.getString("B_PAYMENTMETHOD"));
            bills.add(bill);
        }
        return bills;
    } catch (Exception e) {
        System.err.println("DataAccess->Exception: " + e);
    }
    return null;
}    
public LinkedList<ClientInvoice> getAllClientInvoices(){
    LinkedList<ClientInvoice> invoices = new LinkedList<>();
    ResultSet rs = db.getAllData("C_INVOICE","\0");
    try {
        while(rs.next())
        {
          System.out.println("dataAccess: "+rs.getString("CI_ID_NO")+ "," +rs.getString("rowid"));
          ClientInvoice cl = new ClientInvoice(rs.getString("CI_ID_NO"), rs.getString("CI_VAT"), 
                    rs.getString("CI_DATE"), rs.getString("CI_NETTOTAL"), rs.getString("CI_COMPANYNAME"), 
                    rs.getString("CI_TRN"), rs.getString("CI_ADDRESS"), rs.getString("CI_COSTDETAIL"), 
                    rs.getString("CI_PICKUPSERVICE"),
                    rs.getString("CI_TOTALCOST"), rs.getString("CI_CHARGES"), rs.getString("CI_LABOURSERVICE"), 
                    rs.getString("CI_STATUS"),rs.getString("CI_GRANDTOTAL"), rs.getString("CI_BALANCE"),
                  rs.getString("CI_TERMSCONDITION"), rs.getString("CI_DNNO"),rs.getString("CI_PONO"),
                  rs.getString("CI_COMPANYTRN"));
//          cl.setProfit(rs.getString("CI_PROFIT"));
//          cl.setOwners(rs.getString("CI_OWNER1"), rs.getString("CI_OWNER2"), rs.getString("CI_OWNER3"), rs.getString("CI_OWNER4"));
          cl.setProfit();
          cl.setOwnersProfit();
          invoices.add(cl);
        }
        return invoices;
    } catch (Exception e) {
        System.out.println(e);
    }
    return null;
}    
    //******************    SPECIFIC FUNCTIONS  ****************
    
    
    public void getPaymentMethod(int id){
        try {
            String query = "SELECT B_PAYMENTMETHOD FROM BILL"; 
            ResultSet rs = stmt.executeQuery(query);
            if (null!=rs) {
                if("cheque"==rs.getString("B_PAYMENTMETHOD")){
                    ChequeDetails c = null;
                    Bill b = new Bill(rs.getString("b_id_no"), rs.getString("ci_no"), rs.getString("b_name"), 
                    rs.getString("b_username"), rs.getString("b_date"), rs.getString("b_balance"), 
                    rs.getString("b_amount"), c);
                }
                else if("bank"==rs.getString("B_PAYMENTMETHOD")){
//                    BankDetails bd = null;
//                    Bill b = new Bill(rs.getNString("b_id_no"), rs.getNString("ci_no"), rs.getNString("b_name"), 
//                    rs.getNString("b_username"), rs.getNString("b_date"), rs.getNString("b_balance"), 
//                    rs.getNString("b_amount"), bd);
                    
                }
            }
            else{
                Bill b = new Bill(rs.getString("b_id_no"), rs.getString("ci_no"), rs.getString("b_name"), 
                    rs.getString("b_username"), rs.getString("b_date"), rs.getString("b_balance"), 
                    rs.getString("b_amount"),rs.getString("b_paymentmethod"));
                
            }
            
        } catch (Exception e) {
            System.err.println("DbHelper->Exception: " + e);
        }
        
    }
    
    
    
    //***************** CRUD FUNCTIONS **************************
    
    //************************** INSERTION METHODS **********************
    
    public void insert_Pickup(Pickup p){
        db.insertData("pickup", p.getBillno(),p.getCompanyName(),p.getEmail(),p.getPhone(),p.getLocationOfPickup(),p.getLocationOfDrop(),p.getTypeOfPackage(),p.getInvoiceNo(),p.getAmount(),p.getDate());
    }

//    public void insertUser(User u){
//        db.insertData("user_person", u.name,u.email,u.pass); 
//    }
    
    public void insert_Bill(Bill b){
        db.insertData("bill", b.getInvoiceNo(), b.getBillNo(), b.getCompanyName(), b.getPaymentMethod(), b.getYourName(),
                b.getDate(), b.getBalance(), b.getAmmount());
        if ("cheque".equals(b.getPaymentMethod().toLowerCase())) {
            insert_ChecqueDetails(b.getChequeDetails());
        }
        else if("bank transfer".equals(b.getPaymentMethod().toLowerCase())){
            insert_BankDetails(b.getBankDetails());
        }
        
    }
    public void insert_Product(LinkedList<Product> prods){
        for (Product prod : prods) {
            db.insertData("PRODUCT", prod.getProdName(),prod.getDesc(), prod.getQuantity(), prod.getCost(), 
                prod.getInvoiceNo());        
        }
    }
    public void insert_ClientInv(ClientInvoice ci){
        db.insertData("c_invoice", ci.getInvoiceNo(),ci.getVAT(),ci.getDate(),ci.getNetTotal(),
                ci.getCompanyName(),ci.getTRN(),ci.getAddress(),ci.getCostDetails(),ci.getCostAmount(),
                ci.getPickupService(),ci.getCharges(),ci.getLabourService(),ci.getStatus(),ci.getGrandTotal(),
                ci.getBalance(),ci.getTermsAndConditions(),ci.getProfit(),"0","0","0","0",ci.getDnNumber(),
                ci.getPoNumber(),ci.getCompanyTRN()); //owner fields
    }
    
    public void insert_ChecqueDetails(ChequeDetails cd){
        db.insertData("ChecqueDetails", cd.getChequeNumber(),cd.getIssuedTo(),cd.getDate(),cd.getAmmount(),cd.getDetails(),cd.getBillNo());
    }
    
    public void insert_Expense(Expences e){
        db.insertData("expense", e.getDetail(),e.getClient(),e.getAmount(),e.getDate(),e.getName(),e.getStatus());
    }
    
    public void insert_Labour(Labour l){
        db.insertData("Labour", l.getBillNo(),l.getName(),l.getEmail(),l.getPhone(),l.getInvNo(),l.getCost(),l.getDate(),l.getDuration(),l.getDescWork(),l.getAddress());
    }
    
    public void insert_BankDetails(BankDetails bd){
        db.insertData("banktransfer",bd.getBankName(), bd.getBranch(),bd.getAccountTitle(),bd.getAccountNumber(),bd.getIBAN(), bd.getBillNo());
    }
    public void insert_Supplier(Supplier s){
        db.insertData("supplier", s.getAddress(),s.getEmail(),s.getTRN(),s.getCompanyName()); 
    }
    public void insert_Client(Client c){
        db.insertData("customer",c.getVAT(), c.getEmail(),c.getAddress(),c.getCompanyName(),c.getTRN(),c.getPhone()); // bad debt and debt not iclude and bad cebt and debt noy in db
    }
    public void insert_SupplierInv(SupplierInvoice s){
        //db.insertData("s_invoice",s.getInvNo,s.getPersonName(),s.getDate(),s.getNetTotal(),s.getCompanyName(),s.getTRN(),s.getAddress(),s.getCostDetails(),s.getCostAmount(),s.getCourierService(),s.getStatus(),s.getGrandTotal(),s.getBalance(),s.getTermsAndConditions() ); //courier charges is missing from class
    }
    
    //************************** UPDATEION METHODS **********************
    
    public void update_Bill(Bill b){
        db.updateData("bill","b_id_no",b.getBillNo(),"ci_no",b.getInvoiceNo(),"b_name",b.getCompanyName(),
                "b_paymentmethod",b.getPaymentMethod(),"b_username", b.getYourName(),
                "b_date",b.getDate(),"b_balance",b.getBalance(),"b_amount",b.getAmmount() );
        if ("cheque".equals(b.getPaymentMethod().toLowerCase())) {
            ResultSet rs = db.getAllData("CHECQUEDETAILS", "CH_BILLNO", b.getBillNo());
            try {//DELETE BANKDETAILS IF EXISTS
                if (rs.next()) {
                    update_ChecquedDetails(b.getChequeDetails());
                }
                else{
                    insert_ChecqueDetails(b.getChequeDetails());
                }
                
            } catch (Exception e) {
                System.err.println("DataAcess->Exception: " + e);
            }
        }
        else if("bank transfer".equals(b.getPaymentMethod().toLowerCase())){
            
            ResultSet rs = db.getAllData("BANKTRANSFER", "BN_BILLNO", b.getBillNo());
            try {//DELETE CHECKDETAILS IF EXISTS
                if (rs.next()) {
                    update_Banktransfer(b.getBankDetails());
                }
                else{
                    insert_BankDetails(b.getBankDetails());
                }
                
            } catch (Exception e) {
                System.err.println("DataAcess->Exception: " + e);
            }
        }
    }
    
    public void update_Pickup(Pickup p){
        db.updateData("pickup","pic_id_no",p.getBillno(),"pic_companyname",p.getCompanyName(),"pic_email",p.getEmail(),"pic_phone",p.getPhone(),"pic_pickuplocation",p.getLocationOfPickup(),"pic_droplocation",p.getLocationOfDrop(),"pic_packagetype",p.getTypeOfPackage(),"pic_invoice",p.getInvoiceNo(),"pic_amount",p.getAmount(),"pic_date",p.getDate()); 
    }
    
    public void update_ClientInvoice(ClientInvoice c){
        
        db.updateData("c_invoice", "CI_ID_NO",c.getInvoiceNo(),"CI_VAT",c.getVAT()," CI_DATE",c.getDate()
                ,"CI_NETTOTAL",c.getNetTotal(),"CI_COMPANYNAME",c.getCompanyName(),"CI_TRN",c.getTRN()
                ,"CI_ADDRESS",c.getAddress(),"CI_COSTDETAIL",c.getCostDetails(),"CI_PICKUPSERVICE"
                ,c.getPickupService(),"CI_TOTALCOST",c.getCostAmount(),"CI_CHARGES",c.getCharges()
                ," CI_LABOURSERVICE",c.getLabourService(),"CI_STATUS",c.getStatus(),"CI_GRANDTOTAL",c.getGrandTotal()
                ,"CI_BALANCE",c.getBalance(),"CI_TERMSCONDITION",c.getTermsAndConditions(),"CI_PROFIT",c.getProfit()
                ,"CI_PONO",c.getPoNumber(),"CI_DNNO",c.getDnNumber(),"CI_COMPANYTRN",c.getCompanyTRN()
                , "CI_OWNER1", c.getOwner1(), "CI_OWNER2", c.getOwner2(), "CI_OWNER3", c.getOwner3(),"CI_OWNER4", c.getOwner4()); //owner missing
//        LinkedList<Bill> bills = getAllBills();
        
        
        
    }
    public void update_Products(LinkedList<Product> prods){
        db.deleteData("PRODUCT", "P_INVOICENO", prods.get(0).getInvoiceNo());
        insert_Product(prods);
//        for(Product prod : prods){
//            db.updateData("PRODUCT", "P_INVOICENO", prod.getInvoiceNo(), "P_NAME", prod.getProdName(), "P_DESC", prod.getDesc(),
//                    "P_QUANTITY", prod.getQuantity(), "P_COST", prod.getCost());
//        }
    }
    public void update_ChecquedDetails(ChequeDetails c){
        db.updateData("ChecqueDetails",  
        "CH_CHEQUENO",c.getChequeNumber(),
        "CH_ISSUEDTO",c.getIssuedTo(),
        "CH_ISSUEDATE",c.getDate(),
        "CH_AMOUNT",c.getAmmount(),
        "CH_DETAILS",c.getDetails(),
        "CH_BILLNO",c.getBillNo());
    }
    
    public void update_Client(Client c){
        db.updateData("client",
        "C_PHONE",c.getPhone(),
        "C_EMAIL",c.getEmail(),
        "C_ADDRESS",c.getAddress(),
        "C_TRN",c.getTRN(),
        "C_VAT", c.getVAT(),
        "C_COMPANYNAME",c.getCompanyName());
    }
    
    public void update_Expense(Expences e){
        db.updateData("expense","rowid",e.getId(),
        "E_DETAIL",e.getDetail(),
        "E_CLIENT",e.getClient(),
        "E_AMOUNT",e.getAmount(),
        "E_DATE",e.getDate(),
        "E_NAME",e.getName(),
        "E_STATUS",e.getStatus());
    }
    
//    public void update_SupplierInvoice(SupplierInvoice s){
//        db.updateData("s_invoice", 
// "SI_ID_NO",s.getInvoiceNo(),
// "SI_PERSONNAME",s.getPersonName(),
// "SI_DATE",s.getDate(),
// "SI_NETTOTAL",s.getNetTotal(),
// "SI_COMPANYNAME",s.getCompanyName(),
// "SI_TRN",s.getTRN(),
// "SI_ADDRESS",s.getAddress(),
// "SI_COSTDETAIL",s.getCostDetails(),
// "SI_TOTALCOST",s.getCostAmount(),
// "SI_COURIERSERVICE",s.getCourierService(),
// "SI_STATUS",s.getStatus(),
// "SI_GRANDTOTAL",s.getGrandTotal(),
// "SI_BALANCE",s.getBalance(),
// "SI_TERMSCONDITION",s.getTermsAndConditions());       
//    }
    
    public void update_Labour(Labour l){ //paidby missing
        db.updateData("labour",
 "L_ID_NO",l.getBillNo(),
 "L_COMPANYNAME",l.getName(),
 "L_EMAIL",l.getEmail(),
 "L_PHONE",l.getPhone(),
 "L_INVOICE",l.getInvNo(),
 "L_AMOUNT",l.getCost(),
 "L_DATE",l.getDate(),
 "L_DURATION",l.getDuration(),
 "L_DESC",l.getDescWork(),
 "L_ADDRESS",l.getAddress());
    }
    
    public void update_Banktransfer(BankDetails b){
        db.updateData("banktransfer","BN_ID","1", //banktransfer id_no missing
 "BN_NAME",b.getBankName(),
 "BN_BRANCH",b.getBranch(),
 "BN_ACCTTITLE",b.getAccountTitle(),
 "BN_ACCNO",b.getAccountNumber(),
 "BN_IBANNO",b.getIBAN(),
 "BN_BILLNO", b.getBillNo());
    }
    
    public void update_Supplier(Supplier b){ //supplier_id_no & phoneno missing 
        db.updateData("Supplier","S_ID","1", 
 "S_EMAIL",b.getEmail(),
 "S_ADDRESS",b.getAddress(),
 "S_TRN",b.getTRN(),
 "S_COMPANYNAME",b.getCompanyName());
    }
    
    
     //************************** Deletion METHODS **********************
    
    public void delete_Bill(Bill b){
        
        ClientInvoice c = get_ClientInvoice(b.getInvoiceNo());
        double oldBal = Double.valueOf(c.getBalance());
        double newBal = oldBal + Double.valueOf(b.getAmmount());
        
        System.out.println("Deleting Bill " + b.getBillNo() + "...");
        boolean isDeleted = db.deleteData("bill", "b_id_no",b.getBillNo());
        if(isDeleted){
            System.out.println("updating Taxinvoice " + b.getInvoiceNo()+ "...");
            System.out.println("DataAccess->old Bal: " +oldBal+" New bal: " +newBal);
            c.setBalance(String.valueOf(newBal));
            System.out.println("DataAccess->old Profit: " +c.getProfit());
            c.setProfit();
            c.setOwnersProfit();
            System.out.println("DataAccess->new Profit: " +c.getProfit());
            System.out.println("DataAccess->Grand Total: " +c.getGrandTotal());
            
            if (newBal == Double.valueOf(c.getGrandTotal())) {
                c.setStatus("unpaid");
            }
            else if (newBal == 0){
                c.setStatus("paid");
            }
            else{
                c.setStatus("partially paid");
            }
            System.out.println("New Status: " + c.getStatus());
            update_ClientInvoice(c);
            if ("cheque".equals(b.getPaymentMethod().toLowerCase())) {
                b.setChequeDetails(get_ChecquedDetails(b.getBillNo()));
                if (b.getChequeDetails() != null) {
                    System.err.println("DATAACCESS: BILLNO "+b.getBillNo());
                    System.err.println("DATAACCESS: Cheque_BILLNO "+b.getChequeDetails().getBillNo());

                    delete_ChecquedDetails(b.getChequeDetails());                              

                }
                else{
                    System.err.println("DATAACCESS: cheque NULL ARA HY BILLNO "+b.getBillNo());
                }
            }
            else if("bank transfer".equals(b.getPaymentMethod().toLowerCase())){
                b.setBankDetails(get_Banktransfer(b.getBillNo()));
//                b.getBankDetails().setBillNo(b.getBillNo());
                if (b.getBankDetails() != null) {
                    System.err.println("DATAACCESS: BILLNO "+b.getBillNo());
                    System.err.println("DATAACCESS: BANK_BILLNO "+b.getBankDetails().getBillNo());
                    delete_Banktransfer(b.getBankDetails());
                }
                else{
                    System.err.println("DATAACCESS: bank NULL ARA HY BILLNO"+b.getBillNo());
                }
            }            
        }
        else{
            JOptionPane.showMessageDialog(null, "Unable to Delete");
        }
        
    }
    
    public void delete_Pickup(Pickup p){
        db.deleteData("pickup", "pic_id_no",p.getBillno()); 
    }
    
    public void delete_ClientInvoice(ClientInvoice c){
//        ResultSet rs = db.getAllData("BILL", "CI_NO", c.getInvoiceNo());
        LinkedList<Bill> bills = getAllBills();
        for(Bill b : bills){
            if (b.getInvoiceNo().equals(c.getInvoiceNo())) {
                delete_Bill(b);
            }
        }
        db.deleteData("Product", "P_invoiceno", c.getInvoiceNo());
       boolean isdeleted = db.deleteData("c_invoice", "CI_ID_NO",c.getInvoiceNo());
        if (!isdeleted) {
            JOptionPane.showMessageDialog(null, "Unable to delete Invoice");
        }
    }
    
    public void delete_ChecquedDetails(ChequeDetails c){
        db.deleteData("ChecqueDetails", "CH_BILLNO",c.getBillNo());
    }
    
    public void delete_Client(Client c){
        db.deleteData("client", "C_TRN",c.getTRN());
    }
    
    public void delete_Expense(Expences e){
        db.deleteData("expense", "rowid",e.getId());
    }
    
    public void delete_SupplierInvoice(SupplierInvoice s){
//        db.deleteData("s_invoice", "SI_ID_NO",s.getInvoiceNo());       
    }
    
    public void delete_Labour(Labour l){ 
        db.deleteData("labour","L_ID_NO",l.getBillNo());
    }
    
    public void delete_Banktransfer(BankDetails b){
        db.deleteData("banktransfer","BN_BILLNO",b.getBillNo()); //id_no missing
    }
    
    public void delete_Supplier(Supplier b){ 
        db.deleteData("Supplier","S_ID","1"); //id_no missing
    }
    
    
    //************************** Selection METHODS **********************
    public LinkedList<String> get_LabourInvoices(){
        ResultSet rs = db.getAllData("c_invoice", "CI_LABOURSERVICE", "yes");
        LinkedList<String> invs = new LinkedList<>();
        try {
            while (rs.next()) {
                invs.add(rs.getString("CI_ID_NO"));
            }
            return invs;
        } catch (Exception e) {
            System.err.println("DataAccess->Exception: " + e);
        }
        return null;
    }
    
    public LinkedList<String> get_PickupInvoices(){
        ResultSet rs = db.getAllData("c_invoice", "CI_PICKUPSERVICE", "yes");
        LinkedList<String> invs = new LinkedList<>();
        try {
            while (rs.next()) {
                invs.add(rs.getString("CI_ID_NO"));
            }
            return invs;
        } catch (Exception e) {
            System.err.println("DataAccess->Exception: " + e);
        }
        return null;
    }
    
    public double[] get_totalsFinance(){
        ResultSet rs = db.getColumnData("c_invoice", "ci_totalcost", "ci_grandtotal", "ci_balance");
//        double total = 0.0;
        double[] totals = new double[3]; 
        totals[0] = 0.0;
        totals[1] = 0.0;
        totals[2] = 0.0;
        try{
            while(rs.next()){
//                String str = rs.getNString("ci_totalcost");
//                System.out.println("cost: " + str);
//                total += Double.valueOf(str);
                totals[0] += Double.valueOf(rs.getString("ci_totalcost"));
                totals[1] += Double.valueOf(rs.getString("ci_grandtotal"));
                totals[2] += Double.valueOf(rs.getString("ci_balance"));
            }
            
            return totals;
        }catch(Exception e){
            System.err.println("DataAccess->Exception: " + e);
        }
        return null;
    }
    
    
    public Bill get_Bill(String billNo){
        ResultSet rs = db.getAllData("bill","B_ID_NO", billNo);
        try {
            
            if(rs.next()){
                Bill b = new Bill(rs.getString("b_id_no"), rs.getString("ci_no"), rs.getString("b_name"), 
                    rs.getString("b_username"), rs.getString("b_date"), rs.getString("b_balance"), 
                    rs.getString("b_amount"),rs.getString("b_paymentmethod"));
                return b;
            }
            rs.close();
        } catch (Exception e) {
            System.err.println("DataAcess->Exception: " + e);
        }
        finally{

        }
        return null;
    }

        public LinkedList<Labour> get_labourBills(){
        ResultSet rs = db.getAllData("labour", "\0");
       LinkedList<Labour> bills = new LinkedList<>();
        try {
            while (rs.next()) {                
                Labour l = new Labour(rs.getString("L_ID_NO"), rs.getString("L_INVOICE"), 
                        rs.getString("L_COMPANYNAME"), rs.getString("L_EMAIL"), rs.getString("L_PHONE"), 
                        rs.getString("L_ADDRESS"), rs.getString("L_AMOUNT"), rs.getString("L_DURATION"), 
                        rs.getString("L_DESC"), rs.getString("L_DATE"));
                bills.add(l);
            }
            return bills;
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        return null;
    }

    
    public LinkedList<Pickup> get_pickupBills(){
        ResultSet rs = db.getAllData("pickup", "\0");
       LinkedList<Pickup> bills = new LinkedList<>();
        try {
            while (rs.next()) {                
                Pickup p = new Pickup(rs.getString("PIC_ID_NO"), rs.getString("PIC_INVOICE"), 
                        rs.getString("PIC_COMPANYNAME"), rs.getString("PIC_EMAIL"), rs.getString("PIC_PHONE"), 
                        rs.getString("PIC_PICKUPLOCATION"), rs.getString("PIC_PACKAGETYPE"), rs.getString("PIC_DROPLOCATION"), 
                        rs.getString("PIC_AMOUNT"), rs.getString("PIC_DATE"));
                bills.add(p);
            }
            return bills;
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        return null;
    }
//    public Pickup get_Pickup(){
//        try {
//            ResultSet rs = db.getAllData("pickup","pic_id_no","pic_companyname","pic_email","pic_phone","pic_pickuplocation","pic_droplocation","pic_packagetype","pic_invoice","pic_amount","pic_date");
//            if(rs.next()){
//                Pickup p = new Pickup(rs.getNString("CI_ID_NO"), rs.getNString("pic_invoice"), rs.getNString("CI_COMPANYNAME"), 
//                    rs.getNString("pic_email"), rs.getNString("pic_phone"), rs.getNString("pic_pickuplocation"), 
//                    rs.getNString("pic_packagetype"),rs.getNString("pic_droplocation"), rs.getNString("pic_amount"), rs.getNString("pic_date"));
//                return p;
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//            System.err.println("Exception: " + e);
//        }
//        return null;
//    }
//    
    public ClientInvoice get_ClientInvoice(String invoiceNo){
        try {
            ResultSet rs = db.getAllData("c_invoice", "CI_ID_NO", invoiceNo);
            if(rs.next()){
                
                ClientInvoice c = new ClientInvoice(rs.getString("CI_ID_NO"), rs.getString("CI_VAT"), 
                    rs.getString("CI_DATE"), rs.getString("CI_NETTOTAL"), rs.getString("CI_COMPANYNAME"), 
                    rs.getString("CI_TRN"), rs.getString("CI_ADDRESS"), rs.getString("CI_COSTDETAIL"), 
                    rs.getString("CI_PICKUPSERVICE"), rs.getString("CI_TOTALCOST"), rs.getString("CI_CHARGES"), 
                    rs.getString("CI_LABOURSERVICE"), rs.getString("CI_STATUS"),rs.getString("CI_GRANDTOTAL"), 
                    rs.getString("CI_BALANCE"), rs.getString("CI_TERMSCONDITION"), rs.getString("CI_DNNO"),
                    rs.getString("CI_PONO"), rs.getString("CI_COMPANYTRN"));
                c.setProfit(rs.getString("CI_PROFIT"));
                c.setOwners(rs.getString("CI_OWNER1"), rs.getString("CI_OWNER2"), rs.getString("CI_OWNER3"), rs.getString("CI_OWNER4"));
//                c.setProfit();
//                c.setOwnersProfit();
                return c;
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
            System.err.println("Exception: " + e);
        }
        return null;
    }
    
    public ChequeDetails get_ChecquedDetails(String billNo){
        try {
            ResultSet rs = db.getAllData("ChecqueDetails", "CH_BILLNO", billNo);
            if(rs.next()){
                ChequeDetails c = new ChequeDetails(rs.getString("CH_CHEQUENO"), rs.getString("CH_ISSUEDTO"), rs.getString("CH_ISSUEDATE"), 
                    rs.getString("CH_AMOUNT"),rs.getString("CH_DETAILS"));
                    c.setBillNo(rs.getString("CH_BILLNO"));
                return c;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.err.println("DataAcess->Exception: " + e);
        }
        return null;
    }
    
    public Client get_Client(){
        try {
            ResultSet rs = db.getAllData("client",
        "C_ID_NO",
        "C_PHONE",
        "C_EMAIL",
        "C_ADDRESS",
        "C_TRN",
        "C_VAT",
        "C_COMPANYNAME");
            if(null!=rs){
                //Client c = new Client(rs.getNString("C_ID_NO"), rs.getNString("C_PHONE"), rs.getNString("C_EMAIL"), rs.getNString("C_ADDRESS"), rs.getNString("C_TRN"), rs.getNString("C_VAT"), rs.getNString("C_COMPANYNAME"));
                //return c;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.err.println("Exception: " + e);
        }
        return null;
    }
    
    public LinkedList<Expences> get_Expense(){
        try {
            LinkedList<Expences> exps = new LinkedList<>();
            ResultSet rs = db.getAllData("expense", "\0");            
            while(rs.next()){
                Expences e = new Expences(rs.getString("E_DETAIL"), rs.getString("E_AMOUNT"), rs.getString("E_CLIENT"), 
                    rs.getString("E_DATE"), rs.getString("E_NAME"), rs.getString("E_STATUS"));
                e.setId(rs.getString("rowid"));
                exps.add(e);
            }
            return exps;

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
            System.err.println("DataAcess->Exception:bb " + e);
        }
        return null;
    }
    
    public void get_SupplierInvoice(SupplierInvoice s){
        try {
            ResultSet rs = db.getAllData("s_invoice", 
 "SI_ID_NO",
 "SI_PERSONNAME",
 "SI_DATE",
 "SI_NETTOTAL",
 "SI_COMPANYNAME",
 "SI_TRN",
 "SI_ADDRESS",
 "SI_COSTDETAIL",
 "SI_TOTALCOST",
 "SI_COURIERSERVICE",
 "SI_STATUS",
 "SI_GRANDTOTAL",
 "SI_BALANCE",
 "SI_TERMSCONDITION");
            if (null!=rs){
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.err.println("Exception: " + e);
        }
       
    }
    
    public Labour get_Labour(){ //paidby missing
        try {
            ResultSet rs = db.getAllData("labour",
                "L_ID_NO",
                "L_COMPANYNAME",
                "L_EMAIL",
                "L_PHONE",
                "L_INVOICE",
                "L_AMOUNT",
                "L_DATE",
                "L_DURATION",
                "L_DESC",
                "L_ADDRESS");
            if (null != rs) {
                Labour l = new Labour(rs.getString("L_ID_NO"), rs.getString("L_INVOICE"), rs.getString("L_COMPANYNAME"), 
                    rs.getString("L_EMAIL"), rs.getString("L_PHONE"), rs.getString("L_ADDRESS"), 
                    rs.getString("L_AMOUNT"), rs.getString("L_DURATION"), rs.getString("L_DESC"), rs.getString("L_DATE"));
                return l;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.err.println("Exception: " + e);
        }
        return null;
    }
    
    public BankDetails get_Banktransfer(String billNo){
        try{
            ResultSet rs = db.getAllData("banktransfer","BN_BILLNO", billNo);
            if(rs.next()){
                BankDetails bd = new BankDetails(rs.getString("BN_NAME"), rs.getString("BN_BRANCH"), rs.getString("BN_ACCTTITLE"), rs.getString("BN_ACCNO"), rs.getString("BN_IBANNO"));
                bd.setBillNo(rs.getString("BN_BILLNO"));
                return bd;
            }    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.err.println("Exception: " + e);
        }
        return null;
    }
    
    public void get_Supplier(Supplier b){ //supplier_id_no & phoneno missing 
        db.getAllData("Supplier","S_ID","1", 
 "S_EMAIL",
 "S_ADDRESS",
 "S_TRN",
 "S_COMPANYNAME");
    }

}

