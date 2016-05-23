package be.kapture.util.pdf;

import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEvent;

import be.kapture.dao.PersonDAO;
import be.kapture.entities.Person;

public class PDFContentGenerator extends PDFGenerator{

	@Override
	protected void createContent(Document document) throws DocumentException {
		createPersontable(document);
		
		
		
	}

	private void createPersontable(Document document) throws DocumentException {
		PdfPTable table= new PdfPTable(3);
		table.addCell("ID");
		table.addCell("First Name");
		table.addCell("Last Name");
		table.setHeaderRows(1);
		List<Person> personList = new PersonDAO().findAll();
		for(Person p : personList){
			table.addCell(""+p.getId());
			table.addCell(p.getFirstName());
			table.addCell(p.getLastName());
		}
		document.add(table);
		
		
	}

	@Override
	protected PdfPageEvent getPageEvent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
