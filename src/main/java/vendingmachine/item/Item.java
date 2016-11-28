package vendingmachine.item;

/**
 * Created by bollsal on 2016. 11. 24..
 */
public abstract class Item {
    public abstract String getType();
    public abstract int getPrice();

    private boolean eventItem;

    public boolean isEventItem() {
        return eventItem;
    }

    public void setEvenItem(boolean isEventItem) {
        this.eventItem = isEventItem;
    }
}
