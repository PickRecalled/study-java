package com.pickrecalled.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.*;

public class PdfUtil {

	public static void pdf2word() throws IOException {
		String pdfFile = "/Users/shuang/Downloads/大话数据结构.pdf";
		PDDocument doc = PDDocument.load(new File(pdfFile));
		int pageNumber = doc.getNumberOfPages();
		pdfFile = pdfFile.substring(0, pdfFile.lastIndexOf("."));
		String fileName = pdfFile + ".doc";
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(fileName);
		Writer writer = new OutputStreamWriter(fos, "UTF-8");
		PDFTextStripper stripper = new PDFTextStripper();
		stripper.setSortByPosition(true);// 排序
		stripper.setStartPage(1);// 设置转换的开始页
		stripper.setEndPage(pageNumber);// 设置转换的结束页
		stripper.writeText(doc, writer);
		writer.close();
		doc.close();
		System.out.println("pdf转换word成功！");
	}

	public static void main(String[] args) throws IOException {
		pdf2word();
	}
}
