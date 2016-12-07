package quiz.mcdonalds.menu;

/**
 * Created by bollsal on 2016. 12. 7..
 */
public class Frenchfry extends Menu {
    public static final String NAME = "french_fry";
    public static final int PRICE = 1500;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
