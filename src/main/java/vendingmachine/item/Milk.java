package vendingmachine.item;

/**
 * Created by bollsal on 2016. 11. 24..
 */
public class Milk extends Item {
    @Override
    public String getType() {
        return "Milk";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
