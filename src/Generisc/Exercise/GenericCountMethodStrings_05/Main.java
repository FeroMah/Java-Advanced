package Generisc.Exercise.GenericCountMethodStrings_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberElements = Integer.parseInt(br.readLine());
        List<GenericBox> list = new ArrayList<>();
        for (int i = 0; i < numberElements; i++) {
            GenericBox<String> gb = new GenericBox<>();
            gb.setContent(br.readLine().trim());
            list.add(gb);
        }

        String toCompareValue = br.readLine().trim();

        System.out.println(countGreater(list, toCompareValue));

    }

    private static  int countGreater(List<GenericBox> list, String value) {
        int count = 0;
        for (GenericBox genericBox : list) {
            int i = genericBox.getContent().compareTo(value);
            if (i >0){
                count++;
            }
        }
        return count;
    }
}
