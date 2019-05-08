package Tests;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PdfRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			PDDocument pdDocument = PDDocument
					.load(new File("C:\\Users\\sande\\Selenium_Projects\\PDF_Handle\\Umsatzdetails_Konto303568000_EUR_08-05-2019_1046.pdf"));
			pdDocument.getClass();

			if (!pdDocument.isEncrypted()) {
				PDFTextStripperByArea striArea = new PDFTextStripperByArea();
				striArea.setSortByPosition(true);

				PDFTextStripper stripper = new PDFTextStripper();
				String allText = stripper.getText(pdDocument);

				String lines[] = allText.split("\\r?\\t");
				for (String line : lines) {
					System.out.println(line);
				}
				
			}

		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
