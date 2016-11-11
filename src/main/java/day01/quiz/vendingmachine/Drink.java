package day01.quiz.vendingmachine;

/**
 * Created by bollsal on 2016. 11. 10..
 */
public abstract class Drink {
    public final static boolean PROVIDE_DRINK = true;
    public final static boolean GIVE_ME_MONEY = false;

    public abstract String getMenuName();

    int count;
    int price;

    public Drink(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public boolean buyDrink(int money) {
        return money < price ? GIVE_ME_MONEY : PROVIDE_DRINK;
    }
}
