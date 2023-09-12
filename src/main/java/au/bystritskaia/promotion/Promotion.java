package au.bystritskaia.promotion;

import au.bystritskaia.orders.Order;

/**
 * Акция
 */
public class Promotion {

    private String name;

    /**
     * Количество участников акции
     */
    private static int discountCount = 5;

    /**
     * Процент скидки
     */
    private final int discountPercent;

    /**
     * Конструктор
     * @param name Нименование
     * @param discountPercent Процент скидки
     */
    public Promotion(String name, int discountPercent) {
        discountCount--;
        this.name = name;
        this.discountPercent = discountPercent;
    }

    /**
     * Проверяет заполнена ли акция
     * @return Статус
     */
    public boolean isClosed() {
        return discountCount < 1;
    }

    /**
     * Получает цену на товар со скидкой
     * @return Цена
     */
    public float getDiscount() {
        return this.discountPercent;
    }

    /**
     * Получает наименовании акции
     * @return Наименование
     */
    public String getName() {
        return this.name;
    }

}
