package day02.vendingmachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bollsal on 2016. 11. 11..
 */
public class VendingMachine {

    private int coin;
    private List<Cola> colas;

    public VendingMachine() {
        colas = new ArrayList<>();
        colas.add(new Cola());
        colas.add(new Cola());
        colas.add(new Cola());
    }

    public void insertCoin(int coin) {
        this.coin = coin;
    }

    public int getCoin() {
        return coin;
    }

    public Cola getCola() {
        return colas.remove(0);
    }

    public int getColaCount() {
        return colas.size();
    }
}
