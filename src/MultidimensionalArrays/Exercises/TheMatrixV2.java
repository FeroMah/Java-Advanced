package MultidimensionalArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TheMatrixV2 {
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

        int[] startingCoordinates = Arrays.stream(br.readLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        int rowIndex = startingCoordinates[0];
        int colIndex = startingCoordinates[1];

        String toBeChanged = getStringToBeChanged(theMatrix, rowIndex, colIndex);

        theMatrix.get(rowIndex).set(colIndex, fillSymbols);


        for (int row = 0; row < theMatrix.size(); row++) {
            for (int col = 0; col < theMatrix.get(row).size(); col++) {

                if (theMatrix.get(row).get(col).equals(toBeChanged)) {

                    checkForNeighbor_Verticaly_AndSetItToFillSymbols(theMatrix, fillSymbols, row, col, row - 1);
                    checkForNeighbor_Verticaly_AndSetItToFillSymbols(theMatrix, fillSymbols, row, col, row + 1);
                    checkForNeighbor_Horizontally_AndSetItToFillSymbols(theMatrix, fillSymbols, row, col, col - 1, theMatrix.get(row));
                    checkForNeighbor_Horizontally_AndSetItToFillSymbols(theMatrix, fillSymbols, row, col, col + 1, theMatrix.get(row));
                }
            }
        }
        for (int row = theMatrix.size() - 1; row >= 0; row--) {
            for (int col = theMatrix.get(row).size() - 1; col >= 0; col--) {

                if (theMatrix.get(row).get(col).equals(toBeChanged)) {

                    checkForNeighbor_Verticaly_AndSetItToFillSymbols(theMatrix, fillSymbols, row, col, row - 1);
                    checkForNeighbor_Verticaly_AndSetItToFillSymbols(theMatrix, fillSymbols, row, col, row + 1);
                    checkForNeighbor_Horizontally_AndSetItToFillSymbols(theMatrix, fillSymbols, row, col, col - 1, theMatrix.get(row));
                    checkForNeighbor_Horizontally_AndSetItToFillSymbols(theMatrix, fillSymbols, row, col, col + 1, theMatrix.get(row));
                }
            }
        }


        System.out.println(getResultMatrix(theMatrix));

    }

    private static void checkForNeighbor_Horizontally_AndSetItToFillSymbols(List<List<String>> theMatrix, String fillSymbols, int row, int col, int i, List<String> strings) {
        if (areValidCoordinates(row, i, theMatrix)
                && theMatrix.get(row).get(i).equals(fillSymbols)) {
            strings.set(col, fillSymbols);
        }
    }

    private static void checkForNeighbor_Verticaly_AndSetItToFillSymbols(List<List<String>> theMatrix, String fillSymbols, int row, int col, int i) {
        checkForNeighbor_Horizontally_AndSetItToFillSymbols(theMatrix, fillSymbols, i, col, col, theMatrix.get(row));
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
        theMatrix.get(rowIndex).set(colIndex, fillSymbols);

        if (areValidCoordinates(rowIndex, ++colIndex, theMatrix)) {
            if (theMatrix.get(rowIndex).get(colIndex).equals(toBeChanged)) {
                recursion(theMatrix, rowIndex, colIndex, toBeChanged, fillSymbols);
            } else --colIndex;

        }

        if (areValidCoordinates(rowIndex, --colIndex, theMatrix)) {
            if (theMatrix.get(rowIndex).get(colIndex).equals(toBeChanged)) {
                recursion(theMatrix, rowIndex, colIndex, toBeChanged, fillSymbols);
            } else ++colIndex;

        }
        if (areValidCoordinates(++rowIndex, colIndex, theMatrix)) {
            if (theMatrix.get(rowIndex).get(colIndex).equals(toBeChanged)) {
                recursion(theMatrix, rowIndex, colIndex, toBeChanged, fillSymbols);
            } else --rowIndex;

        }
        if (areValidCoordinates(--rowIndex, colIndex, theMatrix)) {
            if (theMatrix.get(rowIndex).get(colIndex).equals(toBeChanged)) {
                recursion(theMatrix, rowIndex, colIndex, toBeChanged, fillSymbols);
            } else ++rowIndex;

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