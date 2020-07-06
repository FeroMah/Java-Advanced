package SetsAndMapsAdvanced.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String input = "";
        while (!(input = br.readLine()).equals("Revision")) {
            String[] metaData = input.split(", ");
            String store = metaData[0];
            String product = metaData[1];
            double price = Double.parseDouble(metaData[2]);

            shops.putIfAbsent(store, new LinkedHashMap<>());
            shops.get(store).putIfAbsent(product, price);

        }
        StringBuilder sb = new StringBuilder();
        shops.entrySet().forEach(shop -> {
            sb.append(shop.getKey()).append("->").append(System.lineSeparator());
            shop.getValue().entrySet().forEach(product -> {
                sb.append("Product: ").append(product.getKey())
                        .append(", Price: ").append(String.format("%.1f", product.getValue()))
                        .append(System.lineSeparator());
            });
        });
        System.out.println(sb.toString().trim());
    }
}
