package au.bystritskaia;

import au.bystritskaia.actors.Actor;
import au.bystritskaia.actors.Human;
import au.bystritskaia.market.Market;
import au.bystritskaia.orders.Order;
import au.bystritskaia.orders.PromotedOrder;
import au.bystritskaia.promotion.Promotion;

import java.util.List;

/**
 * Старт
 *
 */
public class App 
{
    /**
     * Действующие лица.
     */
    private static List<Actor> actors = List.of(
            new Human("Василий"),
            new Human("Светлана"),
            new Human("Петр"),
            new Human("Василиса"),
            new Human("Евгений"),
            new Human("Анна")
    );

    /**
     * Список акций.
     */
    private static List<Promotion> promotions = List.of(
            new Promotion("Скидка на туфли", 10),
            new Promotion("Скидка на сумки", 20)
    );

    /**
     * Магазин.
     */
    private static final Market market = new Market();

    public static void main( String[] args )
    {
        actors.forEach(market::acceptToMarket);

        actors.get(0).addToOrder(new PromotedOrder(promotions.get(0), "Туфли", 3800.99f));
        actors.get(0).addToOrder(new PromotedOrder(promotions.get(1), "Сумка", 2563.08f));
        market.takeInQueue(actors.get(0));

        actors.get(2).addToOrder(new Order( "Кросовки", 3800.99f));
        actors.get(2).addToOrder(new PromotedOrder(promotions.get(1), "Сумка", 2563.08f));
        market.takeInQueue(actors.get(2));

        actors.get(3).addToOrder(new Order( "Туфли", 3800f));
        actors.get(3).addToOrder(new PromotedOrder(promotions.get(0), "Сумка", 2563.08f));
        market.takeInQueue(actors.get(3));

        actors.get(4).addToOrder(new Order( "Кросовки", 3800.99f));
        actors.get(4).addToOrder(new PromotedOrder(promotions.get(0), "Сумка", 2563.08f));
        market.takeInQueue(actors.get(4));

        actors.get(5).addToOrder(new Order("Платье", 5233.66f));
        actors.get(5).addToOrder(new PromotedOrder(promotions.get(0), "Сумка", 2563.08f));
        market.takeInQueue(actors.get(5));

        market.giveOrder();
        market.takeOrders();
        market.releaseFromQueue();

        market.giveOrder();
        Actor current = market.getCurrentActor();
        current.returnOrders(current.getClientOrders().get(0));
        market.takeOrders();
        market.releaseFromQueue();

        market.giveOrder();
        current = market.getCurrentActor();
        current.returnOrders(current.getClientOrders().get(1));
        market.takeOrders();
        market.releaseFromQueue();

        market.releaseFromMarket(List.of(actors.get(0), actors.get(1), actors.get(2)));
    }
}
