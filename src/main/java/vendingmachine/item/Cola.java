package vendingmachine.item;

/**
 * Created by bollsal on 2016. 11. 24..
 */
public class Cola extends Item {
    @Override
    public String getType() {
        return "Cola";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
