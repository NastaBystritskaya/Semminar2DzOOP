package au.bystritskaia.market.interfaces;

import au.bystritskaia.actors.Actor;

import java.util.List;

/**
 * Интерфейс работы очереди.
 */
public interface MarketBehavior {

    /**
     * Вход в магазин действующего лица.
     * @param actor Действующее лицо
     */
    void acceptToMarket(Actor actor);

    /**
     * Действующее лицо покинуло магазин.
     * @param actors Действующее лицо
     */
    void releaseFromMarket(List<Actor> actors);
}
