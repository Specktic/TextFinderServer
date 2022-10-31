import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;

public class DocxReader {

    private String filePath;

    public DocxReader () {}

    public String docxToString() throws IOException {

        XWPFWordExtractor extractor;
        XWPFDocument xwpfDoc;

        try {
            FileInputStream fi = new FileInputStream(filePath);

            xwpfDoc = new XWPFDocument(OPCPackage.open(fi));
            extractor = new XWPFWordExtractor(xwpfDoc);

            return extractor.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
