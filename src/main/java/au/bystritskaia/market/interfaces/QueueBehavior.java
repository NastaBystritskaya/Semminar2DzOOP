package au.bystritskaia.market.interfaces;

import au.bystritskaia.actors.Actor;

public interface QueueBehavior {
    /**
     * Действующее лицо встает в очередь.
     * @param actor Действующее лицо
     */
    void takeInQueue(Actor actor);

    /**
     * Действующее лицо получает заказ.
     */
    void takeOrders();

    /**
     * Действующее лицо заказывает.
     */
    void giveOrder();

    /**
     * Действующее лицо покидает очередь.
     */
    void releaseFromQueue();

}
