package vendingmachine.item;

/**
 * Created by bollsal on 2016. 11. 24..
 */
public class Beer extends Item {
    @Override
    public String getType() {
        return "Beer";
    }

    @Override
    public int getPrice() {
        return 2500;
    }
}
