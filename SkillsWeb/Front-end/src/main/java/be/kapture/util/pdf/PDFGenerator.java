package be.kapture.util.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class PDFGenerator {

    private PdfWriter writer;

    public PDFGenerator() {
    }

    /**
     * '.pdf' wordt toegevoegd.
     *
     * @param filename
     *            zonder '.pdf'
     * @return generated pdf file
     */
    public File generate(String filename) {
        filename += ".pdf";
        File file = new File(filename);
        try {
            if (!file.createNewFile()) {
                file.delete();
                file.createNewFile();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Document document = new Document(getPageSize(), getLeftMargin(), getRightMargin(), getTopMargin(), getBottomMargin());

        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            writer.setBoxSize("footer", new Rectangle(36, 54, 559, 788));
            PdfPageEvent pageEvent = getPageEvent();
            if (pageEvent != null) {
                writer.setPageEvent(pageEvent);
            }

            PdfPageEvent[] pageEvents = getPageEvents();
            if (pageEvents != null) {
                for (PdfPageEvent pageEvent2 : pageEvents) {
                    if (pageEvent2 != null) {
                        writer.setPageEvent(pageEvent2);
                    }
                }
            }
            document.open();
            createContent(document);
            document.close();
            return file;
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    protected abstract void createContent(Document document) throws DocumentException;

    protected abstract PdfPageEvent getPageEvent();

    protected PdfPageEvent[] getPageEvents() {
        return null;
    }

    /**
     * Default PageSize.A4, kan veranderd worden naar PageSize.A4_LANDSCAPE
     *
     * @return
     */
    protected Rectangle getPageSize() {
        return PageSize.A4;
    }

    protected int getLeftMargin() {
        return 20;
    }

    protected int getRightMargin() {
        return 20;
    }

    protected int getTopMargin() {
        return 20;
    }

    protected int getBottomMargin() {
        return 20;
    }

//    protected PdfContentByte getContentByte() {
//        return writer.getDirectContent();
//    }
}
