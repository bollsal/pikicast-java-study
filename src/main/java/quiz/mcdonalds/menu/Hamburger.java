package quiz.mcdonalds.menu;

/**
 * Created by bollsal on 2016. 12. 7..
 */
public class Hamburger extends Menu {
    public static final String NAME = "hamburger";
    public static final int PRICE = 3000;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
