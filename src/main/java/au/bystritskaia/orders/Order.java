package au.bystritskaia.orders;

/**
 * Заказы.
 */
public class Order {
    /**
     * Наименовние
     */
    private String name;

    /**
     * Цена
     */
    private float price;

    /**
     * Конструктор товара
     * @param name Наименование
     * @param price Цена
     */
    public Order(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Получает наименование товара
     * @return Название
     */
    public String getName() {
        return name;
    }

    /**
     * Задает название товара
     * @param name Наименование
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает цену заказа
     * @return Цена
     */
    public float getPrice() {
        System.out.println("Цена товара: " + this.price);
        return this.price;
    }

    /**
     * Задает цену заказа
     * @param price Цена
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
