package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_01 {
    public static void main(String[] args) {
        String path = "C:\\Users\\FeroMah\\IdeaProjects\\JavaAdvance\\src\\StreamsFilesAndDirectories\\Lab_Resources\\ReadFile_Task01\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();
            while (oneByte>=0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte=fileStream.read();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
