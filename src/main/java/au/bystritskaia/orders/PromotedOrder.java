package au.bystritskaia.orders;

import au.bystritskaia.promotion.Promotion;

public class PromotedOrder extends Order {

    private Promotion promotion;

    /**
     * Конструктор товара
     *
     * @param promotion Акция
     * @param name  Наименование
     * @param price Цена
     */
    public PromotedOrder(Promotion promotion, String name, float price) {
        super(name, price);
        this.promotion = promotion;
    }

    /**
     * Получает цену товара
     * @return Цена
     */
    @Override
    public float getPrice() {
        if(promotion.isClosed()) {
            System.out.println("Акция закончилась. Товар продется по обычной цене" + this.getPrice());
            super.getPrice();
        }

        float price = super.getPrice() - (super.getPrice() * (this.promotion.getDiscount() / 100));
        System.out.println("Акционный товар(" + this.promotion.getName() + "). Цена: " + price);
        return price;
    }
}
