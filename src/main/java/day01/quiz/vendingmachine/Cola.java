package day01.quiz.vendingmachine;

/**
 * Created by bollsal on 2016. 11. 10..
 */
public class Cola extends Drink {

    public Cola(int colaCount, int colaPrice) {
        super(colaCount, colaPrice);
    }

    @Override
    public String getMenuName() {
        return "cola";
    }
}
