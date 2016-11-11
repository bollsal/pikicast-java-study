package day01.quiz.vendingmachine;

/**
 * Created by bollsal on 2016. 11. 10..
 */
public class Juice extends Drink {

    public Juice(int juiceCount, int juicePrice) {
        super(juiceCount, juicePrice);
    }

    @Override
    public String getMenuName() {
        return "juice";
    }
}
