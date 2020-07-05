package SetsAndMapsAdvanced.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountRealNumbers_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] input = Arrays.stream(br.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        Arrays.stream(input).forEach(n -> {
            numbers.putIfAbsent(n, 0);
            numbers.put(n, numbers.get(n) + 1);
        });
        numbers.forEach((key, value) -> System.out.println(String.format("%.1f -> %d", key, value)));
    }
}
