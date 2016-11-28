package vendingmachine.item;

/**
 * Created by bollsal on 2016. 11. 24..
 */
public class Juice extends Item {
    @Override
    public String getType() {
        return "Juice";
    }

    @Override
    public int getPrice() {
        return 1500;
    }
}
