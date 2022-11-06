package ru.netology.koylubaevaem;

import java.util.Map;

public class Purchase {

    private static final int AVAILABLE_GOODS_COUNT = 4;

    protected String title;
    protected int count;
    protected Purchase[] purchases = new Purchase[AVAILABLE_GOODS_COUNT];// "магическое" число вынесено в статическое финальное поле
    private final Logger logger = new Logger();

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public Purchase() {
    }

    public void addPurchase(String title, int count) { //удалены return
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            } else if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) { // в класс ru.netology.koylubaevaem.Logger вынесен вывод на консоль, считаем только сумму
        logger.log("КОРЗИНА:");
        long sum = 0;
        for (Purchase purchase : purchases) {
            if (purchase != null) { // continue удален для лучшей читаемости
                long itemSum = (long) purchase.count * prices.get(purchase.title);
                sum += itemSum;
                logger.log("\t" + purchase.title + " " + purchase.count + " шт. в сумме " +
                        itemSum + " руб.");
            }
        }
        return sum;
    }
}
