package au.bystritskaia.market;

import au.bystritskaia.actors.Actor;
import au.bystritskaia.market.interfaces.MarketBehavior;
import au.bystritskaia.market.interfaces.QueueBehavior;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.*;

public class Market implements MarketBehavior, QueueBehavior {
    /**
     * Список действующих лиц магазина.
     */
    private List<Actor> actors = new LinkedList<>();
    /**
     * Очередь клиентов
     */
    private Deque<Actor> actorDeque = new ArrayDeque<>();
    /**
     * Обслуживаемый клиент
     */
    private Actor currentClient;

    /**
     * Вход в магазин действующего лица.
     *
     * @param actor Действующее лицо
     */
    @Override
    public void acceptToMarket(Actor actor) {
        out.println(actor.getName() + " вошел в магазин");
        this.actors.add(actor);
    }

    /**
     * Получает обслуживаемого клиента.
     * @return Клиент
     */
    public Actor getCurrentActor() {
        return this.currentClient;
    }

    /**
     * Действующее лицо покинуло магазин.
     *
     * @param actors Действующее лицо
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        actors.forEach(actor -> {
            out.println(actor.getName() + " покинул магазин");
            this.actors.remove(actor);
        });
    }

    /**
     * Действующее лицо встает в очередь.
     *
     * @param actor Действующее лицо
     */
    @Override
    public void takeInQueue(Actor actor) {
        out.println(actor.getName() + " встал в очередь");
        actorDeque.addLast(actor);
        actor.setMakeOrder(true);
    }

    /**
     * Действующее лицо получает заказ.
     */
    @Override
    public void takeOrders() {
        Actor actor = actorDeque.getFirst();
        actor.setMakeOrder(true);
        this.currentClient = actor;
        out.println(actor.getName() + " сделал заказы:");
        actor.getClientOrders().forEach(order -> out.println(order.getName() + ": " + order.getPrice()));
    }

    /**
     * Действующее лицо заказывает.
     */
    @Override
    public void giveOrder() {
        Actor actor = actorDeque.getFirst();
        actor.setMakeOrder(false);
        out.println(actor.getName() + " забрал заказ");
    }

    /**
     * Действующее лицо покидает очередь.
     */
    @Override
    public void releaseFromQueue() {
        Actor actor = actorDeque.getFirst();
        actorDeque.removeFirst();
        out.println(actor.getName() + " покинул очередь");
    }
}
