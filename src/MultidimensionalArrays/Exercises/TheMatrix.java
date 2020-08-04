package MultidimensionalArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int[] matrixDimensions = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(2)
                .toArray();

        final int countOfRows = matrixDimensions[0];
        final int countOfCols = matrixDimensions[1];
        List<List<String>> theMatrix = new ArrayList<>();

        for (int row = 0; row < countOfRows; row++) {
            theMatrix.add(new ArrayList<>());

            String[] inputLine = Arrays.stream(br.readLine().split("\\s+"))
                    .limit(countOfCols)
                    .toArray(String[]::new);
            for (int col = 0; col < countOfCols; col++) {
                theMatrix.get(row).add(inputLine[col]);
            }
        }

        String fillSymbols = br.readLine();

        int[] startingCoordinates = Arrays.stream(br.readLine().split("\\s+"))
                .limit(2)
                .mapToInt(Integer::parseInt)
                .toArray();
        int rowIndex = startingCoordinates[0];
        int colIndex = startingCoordinates[1];

        String toBeChanged = getStringToBeChanged(theMatrix, rowIndex, colIndex);

        recursion(theMatrix, rowIndex, colIndex, toBeChanged, fillSymbols);

        System.out.println(getResultMatrix(theMatrix));

    }

    private static String getResultMatrix(List<List<String>> theMatrix) {
        StringBuilder sb = new StringBuilder();
        theMatrix.forEach(row -> {
            row.forEach(sb::append);
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    private static void recursion(List<List<String>> theMatrix, int rowIndex, int colIndex, String toBeChanged, String fillSymbols) {

        if(areValidCoordinates(rowIndex,colIndex,theMatrix)){
            if(theMatrix.get(rowIndex).get(colIndex).equals(toBeChanged)){
                theMatrix.get(rowIndex).set(colIndex,fillSymbols);

                //move right
                recursion(theMatrix,rowIndex,colIndex+1,toBeChanged,fillSymbols);
                //move left
                recursion(theMatrix,rowIndex,colIndex-1,toBeChanged,fillSymbols);
                //move up
                recursion(theMatrix,rowIndex-1,colIndex,toBeChanged,fillSymbols);
                //move down
                recursion(theMatrix,rowIndex+1,colIndex,toBeChanged,fillSymbols);
            }
        }
    }


    private static String getStringToBeChanged(List<List<String>> theMatrix, int rowIndex, int colIndex) {
        String toBeChanged = "";
        if (areValidCoordinates(rowIndex, colIndex, theMatrix)) {
            toBeChanged = theMatrix.get(rowIndex).get(colIndex);
        }
        return toBeChanged;
    }

    private static boolean areValidCoordinates(int row, int col, List<List<String>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}