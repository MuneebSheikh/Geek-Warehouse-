/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcess;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author sajja
 */
class MyFooter extends PdfPageEventHelper {
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        int diff = 105;
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, footer(),
            document.leftMargin(),
            document.bottom()+ diff, 0);
        Phrase p = new Phrase("- Cheque is to be issued under the name \"BIGFOOT KONCEPTS LLC\"",new DataAcess().pdf_getNormalFont(12));
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p,
            document.leftMargin(),
            document.bottom()+ diff-15, 0);
        p = new Phrase("- Bank Transfer",new DataAcess().pdf_getNormalFont(12));
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p,
            document.leftMargin(),
            document.bottom()+ diff-30, 0);
        p = new Phrase("Bank Name      : RAK Bank",new DataAcess().pdf_getNormalFont(12));
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p,
            document.leftMargin() + 50,
            document.bottom()+ diff-45, 0);
        p = new Phrase("Branch             : King Faisal Street Branch",new DataAcess().pdf_getNormalFont(12));
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p,
            document.leftMargin() + 50,
            document.bottom()+ diff-60, 0);
        p = new Phrase("Account Title  : BIGFOOT KONCEPTS LLC",new DataAcess().pdf_getNormalFont(12));
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p,
            document.leftMargin() + 50,
            document.bottom()+ diff-75, 0);
        p = new Phrase("Account #        : 0242697546001",new DataAcess().pdf_getNormalFont(12));
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p,
            document.leftMargin() + 50,
            document.bottom()+ diff-90, 0);
        p = new Phrase("IBAN #            : AE130400000242697546001",new DataAcess().pdf_getNormalFont(12));
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, p,
            document.leftMargin() + 50,
            document.bottom()+ diff-105, 0);
        
        
        
    }
    private Phrase footer() {
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 5, Font.ITALIC);
        Phrase p = new Phrase("Payment Terms",new DataAcess().pdf_getboldFont(12));
//        p.setFont(new DataAcess().pdf_getboldFont(8));
        
        return p;
    }
}
