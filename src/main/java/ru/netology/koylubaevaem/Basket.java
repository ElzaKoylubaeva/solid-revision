package ru.netology.koylubaevaem;

import java.util.Map;

public class Basket {

    private final Logger logger = new ConsoleLogger();

    private Purchase[] purchases;

    public Basket(int goodsCount) {
        purchases = new Purchase[goodsCount];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            } else if (purchases[i].getTitle().equals(title)) {
                purchases[i].sumCount(count);
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) { // в класс ru.netology.koylubaevaem.Logger вынесен вывод на консоль, считаем только сумму
        logger.log("КОРЗИНА:");
        long sum = 0;
        for (Purchase purchase : purchases) {
            if (purchase != null) { // continue удален для лучшей читаемости
                long itemSum = (long) purchase.getCount() * prices.get(purchase.getTitle());
                sum += itemSum;
                logger.log("\t" + purchase.getTitle() + " " + purchase.getCount() + " шт. в сумме " +
                        itemSum + " руб.");
            }
        }
        return sum;
    }
}
