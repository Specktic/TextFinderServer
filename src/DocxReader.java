import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;

public class DocxReader {

    /** Class constructor */
    public DocxReader () {}

    /** Attribute 1, a string */
    private String filePath;

    /** Returns the file specified by the filepath attribute a single string */
    public String docxToString() {

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

    /** Modifies the filepath attribute  */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
