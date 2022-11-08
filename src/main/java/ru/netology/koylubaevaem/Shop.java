package ru.netology.koylubaevaem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop {

    private final Logger logger = new ConsoleLogger();
    private final Map<String, Integer> products = new HashMap<>(); // HashMap<> -> Map<>

    public Shop() {
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
    }

    public void makePurchases() {
        printGoods();
        logger.log("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket(products.size());
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            basket.addPurchase(product, count);
        }
        long sum = basket.sum(products);
        logger.log("ИТОГО: " + sum);
    }

    private void printGoods() {
        logger.log("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            logger.log(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }
}
