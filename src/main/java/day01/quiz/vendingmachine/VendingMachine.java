package day01.quiz.vendingmachine;

import day01.quiz.vendingmachine.model.Menu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bollsal on 2016. 11. 9..
 * <p>
 * VendingMachine 클래스는 특정 금액을 지불하면 반환해주는 Cola, Juice 아이템 객체들을 가지고 있다.
 * - 일정 금액을 넣고 구매할 아이템을 선택하면 해당 아이템 객체를 반환하는 자판기 클래스를 설계하고 테스트를 만들어 보자.
 * - 테스트 예)
 * - 테스트1 >> 금액을 넣으면 그 금액이 잘 유지되는지?
 * - 테스트2 >> 자판기가 아이템을 적절히 가지고 있는지? (자판기 객체는 처음에 아이템 리스트가 비어있으면 안됨)
 * - 테스트3 >> 자판기가 특정 아이템을 잘 반환해 주는지?
 * - 테스트4 >> 자판기가 금액과 특정 아이템을 선택 했을 때 금액에 맞는 아이템을 반환해 주는지?
 */
public class VendingMachine {

//    public static void main(String... args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("돈을 넣어주세요 : ");
//        int money = scanner.nextInt();
//
//        System.out.println("insert Coin : " + money);
//
//        Cola cola = new Cola(10, 1000);
//        Juice juice = new Juice(20, 2000);
//
//        System.out.println("자판기 상태 ");
//        System.out.println("Cola " + cola.getCount() + " 개 [" + cola.getPrice() + "]원");
//        System.out.println("Juice " + juice.getCount() + " 개 [" + juice.getPrice() + "]원");
//    }

    Menu menu;
    int insertMoney;

    public VendingMachine() {
        createCevdingMachine();
    }

    public void createCevdingMachine() {
        Cola cola = new Cola(10, 1000);
        Juice juice = new Juice(20, 2000);

        menu = new Menu(cola, juice);
    }

    public Menu getMenu() {
        return menu;
    }

    public void insertMoney(int money) {
        this.insertMoney = money;
    }

    public int getInsertMoney() {
        return this.insertMoney;
    }

    public boolean buyDrink(String drinkName) {
        if (drinkName.equals(menu.getCola().getMenuName())) {
            return updateChange(menu.getCola().buyDrink(insertMoney), menu.getCola());
        } else if (drinkName.equals(menu.getJuice().getMenuName())) {
            return updateChange(menu.getJuice().buyDrink(insertMoney), menu.getJuice());
        } else {
            System.out.println("해당 메뉴는 자판기에서 안판다.");
            return false;
        }
    }

    public boolean updateChange(boolean result, Drink drink) {
        if (result) {
            System.out.println(drink.getMenuName() + " 구매성공 - 남은돈 : " + (insertMoney - drink.getPrice()));
            return true;
        } else {
            System.out.println("사먹기엔 돈이 부족합니다.");
            return false;
        }
    }
}
