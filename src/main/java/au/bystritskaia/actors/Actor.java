package au.bystritskaia.actors;

import au.bystritskaia.actors.interfaces.ActorBehavior;
import au.bystritskaia.orders.Order;
import au.bystritskaia.orders.ReturnedOrder;

import java.util.LinkedList;
import java.util.List;

/**
 * Действующее лицо
 */
public abstract class Actor implements ActorBehavior {
    /**
     * Заказы клиента
     */
    private List<Order> orders = new LinkedList<>();

    /**
     * Имя
     */
    protected String name;
    /**
     * Готов ли сделать заказ
     */
    protected  boolean isMakeOrder;
    /**
     * Поличил ли заказ
     */
    protected boolean isTakeOrder;

    /**
     * Является ли действующее лицо участником акции
     */
    protected boolean isPromoted;

    /**
     * Получает имя действующего лица
     * @return Имя
     */
    public String getName() {
        return name;
    }

    /**
     * Задает имя действующего лица.
     * @param name Имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Проверяет получил ли заказ действующее лицо
     * @return Статус получения
     */
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    /**
     /**
     * Задает получил ли заказ действующее лицо
     * @param makeOrder Статус получения
     */
    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    /**
     * Проверяет получило ли действующее лицо заказ
     * @return Статус готовности
     */
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    /**
     * Задает получило ли действующее лицо заказ
     * @param getOrder Статус готовности
     */
    public void setTakeOrder(boolean getOrder) {
        isTakeOrder = getOrder;
    }

    /**
     * Дабваляет заказ действующему лицу
     * @param order Заказ
     */
    @Override
    public void addToOrder(Order order) {
        System.out.println(this.name + " взял заказ");
        this.orders.add(order);
    }

    /**
     * Заказы действующего лица.
     * @return Заказы
     */
    @Override
    public List<Order> getClientOrders() {
        return this.orders;
    }

    /**
     * Возвращает товар.
     * @param order Товар на возврат
     */
    public void returnOrders(Order order) {
        ReturnedOrder returnedOrder = new ReturnedOrder(order.getName(), order.getPrice());
        System.out.println(returnedOrder.returnOrder());
        this.orders.remove(order);
    }
}
