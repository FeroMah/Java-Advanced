package SetsAndMapsAdvanced.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class DragonArmy_14 {
    public static void main(String[] args) throws IOException {
//      Type is preserved as in the order of input, but dragons are sorted alphabetically by name.
        Map<String, Map<String, int[]>> catalog = new LinkedHashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberRows = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberRows; i++) {
            String[] dragonInfo = br.readLine().split("\\s+");
            String type = dragonInfo[0];
            String name = dragonInfo[1];

            String damage = dragonInfo[2];
            String health = dragonInfo[3];
            String armor = dragonInfo[4];

            int[] stats = assignDefaultValueIfNull(new String[]{damage, health, armor});

//          Dragons are sorted alphabetically by name.
            catalog.putIfAbsent(type, new TreeMap<>());
            catalog.get(type).put(name, stats);
        }

        System.out.println(getCatalogToString(catalog));

    }

    private static String getCatalogToString(Map<String, Map<String, int[]>> catalog) {
        StringBuilder sb = new StringBuilder();
        final String typeOfDragonsString = "%s::(%.2f/%.2f/%.2f)";
        final String dragonString = "-%s -> damage: %d, health: %d, armor: %d";
        for (Map.Entry<String, Map<String, int[]>> dragonType : catalog.entrySet()) {

            double bufferDMG = 0;
            double bufferHP = 0;
            double bufferAR = 0;


            for (Map.Entry<String, int[]> dragon : dragonType.getValue().entrySet()) {
                bufferDMG += dragon.getValue()[0];
                bufferHP += dragon.getValue()[1];
                bufferAR += dragon.getValue()[2];
            }
            double avgDMG = bufferDMG / dragonType.getValue().size();
            double avgHP = bufferHP / dragonType.getValue().size();
            double avgAR = bufferAR / dragonType.getValue().size();

            sb.append(String.format(typeOfDragonsString, dragonType.getKey(), avgDMG, avgHP, avgAR)).append(System.lineSeparator());

            dragonType.getValue().forEach((key, value) -> {
                sb.append(String.format(dragonString, key,
                        value[0], value[1], value[2]))
                        .append(System.lineSeparator());
            });
        }
        return sb.toString();
    }

    private static int[] assignDefaultValueIfNull(String[] stats) {

//  damage = status[0];    health = status[1];     armor = status[2];
        final int[] defaultValues = {45, 250, 10};
        int[] newStats = new int[stats.length];

        for (int i = 0; i < stats.length; i++) {
            if (stats[i].equals("null")) {
                newStats[i] = defaultValues[i];
            } else {
                newStats[i] = Integer.parseInt(stats[i]);
            }
        }
        return newStats;
    }
}