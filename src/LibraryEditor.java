import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LibraryEditor {

    /** Class constructor */
    public LibraryEditor(){}

    /** Attribute 1, a String */
    private String filePath;

    /** Adds the specified file to the TextsLibrary directory */
    public void add() throws IOException {

        File file = new File(filePath);

        Path textName = Paths.get(String.valueOf(file));
        Path libraryName = Paths.get("TextsLibrary" + "\\" + file.getName());
        if (!((libraryName.toFile()).exists())){
            Files.copy(textName, libraryName);
        } else {
            int i = 1;
            Path altName = Paths.get("TextsLibrary" + "\\" +
                    file.getName() + " (" + String.valueOf(i) + ")");
            while ((altName.toFile().exists())){
                i++;
                altName = Paths.get("TextsLibrary" + "\\" +
                        file.getName() + " (" + String.valueOf(i) + ")");
            }
            Files.copy(textName, altName);
        }
    }

    /** Removes a specified file from the TextsLibrary directory */
    public void remove(){

        File file = new File(filePath);

        file.delete();
    }

    /** Returns the filePath attribute */
    public String getFilePath() {
        return filePath;
    }

    /** Modifies the filePath attribute */
    public void setFilePath(String filePath) {
        this.filePath = "Texts" + "\\" + filePath;
    }
}
