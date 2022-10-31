import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfReader {

    private String filePath;

    public PdfReader () {}

    public String pdfToString() throws IOException {

        File file = new File(filePath);
        PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));

        parser.parse();
        COSDocument cosDoc = parser.getDocument();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument pdDoc = new PDDocument(cosDoc);
        pdfStripper.setStartPage(0);
        pdfStripper.setEndPage(pdDoc.getNumberOfPages());

        return pdfStripper.getText(pdDoc);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
