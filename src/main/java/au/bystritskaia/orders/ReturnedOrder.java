package au.bystritskaia.orders;

import au.bystritskaia.orders.Interfaces.IReturnedOrder;

/**
 * Возвращенный товар.
 */
public class ReturnedOrder extends Order implements IReturnedOrder {
    /**
     * Конструктор товара
     *
     * @param name  Наименование
     * @param price Цена
     */
    public ReturnedOrder(String name, float price) {
        super(name, price);
    }

    /**
     * Возврат товара
     *
     */
    @Override
    public float returnOrder() {
        System.out.println(this.getName() + " возвращен клиентом");
        return this.getPrice();
    }
}
