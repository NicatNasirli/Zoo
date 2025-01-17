package test.utils;

import lombok.Getter;
import test.buildings.Zoo;

import java.io.*;

@Getter
public class FileUtil {
    private final File file;

    public FileUtil() {
        this.file = createFile();
    }

    public File createFile() {
        try {
            File file = new File("zoo.txt");
            if (file.createNewFile()) {
                System.out.println("File created!" + file.getName());
            }
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void writeObjectToFile(File file,Zoo zoo) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(zoo);
            oos.flush();
        }
    }

    public Zoo readObjectFromFile(File file) throws IOException, ClassNotFoundException {
        Zoo zoo;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            zoo = (Zoo) ois.readObject();
        }
        return zoo;
    }
}
