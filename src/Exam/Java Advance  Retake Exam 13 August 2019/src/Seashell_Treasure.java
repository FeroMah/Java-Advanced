import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seashell_Treasure {
    private static List<List<Character>> beach;
    private static List<Character> collectedSeaShell;
    private static int stolenShells = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputRows = Integer.parseInt(sc.nextLine());

        beach = new ArrayList<>();
        collectedSeaShell = new ArrayList<>();

        for (int i = 0; i < inputRows; i++) {
            beach.add(new ArrayList<>());
            String inputLine = sc.nextLine().replace(" ", "");
            for (int j = 0; j < inputLine.length(); j++) {
                char symbol = inputLine.charAt(j);
                beach.get(i).add(symbol);
            }
        }
        String consoleInput;
        while (!"Sunset".equalsIgnoreCase(consoleInput = sc.nextLine())) {
            String[] data = consoleInput.split("\\s+");
            String command = data[0];
            int rowInput = Integer.parseInt(data[1]);
            int colInput = Integer.parseInt(data[2]);

            switch (command.toLowerCase()) {
                case "collect":
                    if (areRowAndColValid(rowInput, colInput)) {
                        char symbol = beach.get(rowInput).get(colInput);
                        if (isValidShell(symbol)) {
                            collectedSeaShell.add(symbol);
                            beach.get(rowInput).set(colInput, '-');
                        }
                    }
                    break;
                case "steal":
                    String direction = data[3];
                    for (int i = 0; i < 3; i++) {
                        if (areRowAndColValid(rowInput, colInput)) {
                            switch (direction.toLowerCase()) {
                                case "up":
                                    if (areRowAndColValid(rowInput, colInput)) {
                                        if (isValidShell(beach.get(rowInput).get(colInput))) {
                                            beach.get(rowInput).set(colInput, '-');
                                            stolenShells++;
                                        }
                                        rowInput--;
                                    }
                                    break;
                                case "down":
                                    if (areRowAndColValid(rowInput, colInput)) {
                                        if (isValidShell(beach.get(rowInput).get(colInput))) {
                                            beach.get(rowInput).set(colInput, '-');
                                            stolenShells++;
                                        }
                                        rowInput++;
                                    }
                                    break;
                                case "right":
                                    if (areRowAndColValid(rowInput, colInput)) {
                                        if (isValidShell(beach.get(rowInput).get(colInput))) {
                                            beach.get(rowInput).set(colInput, '-');
                                            stolenShells++;
                                        }
                                        colInput++;
                                    }
                                    break;
                                case "left":
                                    if (areRowAndColValid(rowInput, colInput)) {
                                        if (isValidShell(beach.get(rowInput).get(colInput))) {
                                            beach.get(rowInput).set(colInput, '-');
                                            stolenShells++;
                                        }
                                        colInput--;
                                    }
                                    break;
                            }
                        }
                    }

            }
        }

//        Printing
        for (int row = 0; row < beach.size(); row++) {
            for (int col = 0; col < beach.get(row).size(); col++) {
                System.out.print(beach.get(row).get(col) + " ");
            }
            System.out.println();
        }
        if (!collectedSeaShell.isEmpty()) {
            System.out.println(String.format("Collected seashells: %d -> %s", collectedSeaShell.size(),
                    collectedSeaShell.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("Collected seashells: 0");
        }
        System.out.println(String.format("Stolen seashells: %d", stolenShells));
    }

    private static boolean areRowAndColValid(int row, int col) {
        boolean areValid = false;
        if (row < beach.size() && row >= 0
                && col < beach.get(row).size() && col >= 0) {
            areValid = true;
        }
        return areValid;
    }

    private static boolean isValidShell(char shell) {
        switch (shell) {
            case 'C':
            case 'N':
            case 'M':
                return true;
        }
        return false;
    }
}
