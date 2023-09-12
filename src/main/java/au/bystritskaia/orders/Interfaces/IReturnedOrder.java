package au.bystritskaia.orders.Interfaces;

import au.bystritskaia.orders.Order;

/**
 * Интерфейс возвращенного товара
 */
public interface IReturnedOrder {
    /**
     * Возврат товара
     * @return Дентги за товар
     */
    float returnOrder();
}
