package com.AutomacaoGeradorPDF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AutomacaoGeradorPDF.gerarPdf.GerarPdf;

@SpringBootApplication
public class AutomacaoGeradorPdfApplication {

	public static void main(String[] args) {
		
		GerarPdf pdf = new GerarPdf();
		
		pdf.GeradorPDF("C:/Users/samue/Desktop/teste2.pdf", "Alterei a class");
		
		SpringApplication.run(AutomacaoGeradorPdfApplication.class, args);
	}
}
