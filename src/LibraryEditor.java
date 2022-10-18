import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LibraryEditor {

    /** constructor */
    public LibraryEditor(){}

    public void add(File file) throws IOException {
        if (file != null){
            Path textName = Paths.get(String.valueOf(file));
            Path libraryName = Paths.get("TextsLibrary" + "\\" + file.getName());
            if (!((libraryName.toFile()).exists())){    //text file to add isn't already in library
                Files.copy(textName, libraryName);
            } else {                                    //text file to add is already in library
                int i = 1;
                Path altName = Paths.get("TextsLibrary" + "\\" +
                        file.getName() + " (" + String.valueOf(i) + ")");   //adds repeat file suffix
                while ((altName.toFile().exists())){
                    i++;
                    altName = Paths.get("TextsLibrary" + "\\" +
                            file.getName() + " (" + String.valueOf(i) + ")");   //updates repeat file suffix
                }
                Files.copy(textName, altName);
            }
        } else {
            System.out.println("no file selected");
        }
    }
}
