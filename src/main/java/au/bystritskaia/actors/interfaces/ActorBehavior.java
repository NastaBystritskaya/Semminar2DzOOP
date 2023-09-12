package au.bystritskaia.actors.interfaces;

import au.bystritskaia.orders.Order;

import java.util.List;

/**
 * Интерфейс действий действующего лица
 */
public interface ActorBehavior {

    /**
     * Готово ли действующее лицо сделать заказ
     * @return Готовность
     */
    boolean isMakeOrder();

    /**
     * Забрало ли действующее лицо заказ
     * @return Статус
     */
    boolean isTakeOrder();

    /**
     * Дабваляет заказ действующему лицу
     * @param order Заказ
     */
    void addToOrder(Order order);

    /**
     * Заказы действующего лица.
     * @return Заказы
     */
    List<Order> getClientOrders();

    /**
     * Возвращает товар.
     * @param order Товар на возврат
     */
    void returnOrders(Order order);
}
