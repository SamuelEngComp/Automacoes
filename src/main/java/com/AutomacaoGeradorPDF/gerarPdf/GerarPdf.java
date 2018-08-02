package com.AutomacaoGeradorPDF.gerarPdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * @author Samuel Farias
 * 	Classe para gerar pdf, ainda em desenvolvimento...
 */
public class GerarPdf {

	private Document documento;

	public void GeradorPDF(String caminho, String paragrafo) {
		
		documento = new Document();

		try {
			PdfWriter.getInstance(documento, 
					new FileOutputStream(caminho));

			documento.open();

			// adicionando um parágrafo ao documento
			documento.add(new Paragraph(paragrafo));

			// adicionando um parágrafo com fonte diferente ao arquivo
			documento.add(new Paragraph("Adicionando outro paragrafo", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12)));

		} catch (IOException e) {
			System.err.println(e.getMessage());

		} catch (DocumentException e) {
			System.err.println(e.getMessage());

		}finally {
			documento.close();
		}
	}

	public Document getDocumento() {
		return documento;
	}

	public void setDocumento(Document documento) {
		this.documento = documento;
	}

}
