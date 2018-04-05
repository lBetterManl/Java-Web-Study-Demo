package com.yhc.pdf;

import java.io.File;
import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.AreaBreakType;
public class C01E01_HelloWorld {
	
	 public static final String DEST = "test/hello_world.pdf";
	 
	    public static void main(String args[]) throws IOException {
	        File file = new File(DEST);
	        file.getParentFile().mkdirs();
	        new C01E01_HelloWorld().createPdf(DEST);
	    }
	 
	    public void createPdf(String dest) throws IOException {
	    	
	        //Initialize PDF writer
	        PdfWriter writer = new PdfWriter(dest);
	 
	        //Initialize PDF document
	        PdfDocument pdf = new PdfDocument(writer);
	 
	        // Initialize document
	        Document document = new Document(pdf);
	 
	        //Add paragraph to the document
	        document.add(new Paragraph("Hello World!"));
	        document.add(new AreaBreak(AreaBreakType.NEXT_AREA));
	        document.add(new Paragraph("男神!"));
	        //Close document
	        document.close();
	    }
}
