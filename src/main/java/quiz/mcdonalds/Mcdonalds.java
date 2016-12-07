package quiz.mcdonalds;

import quiz.mcdonalds.customer.Customer;
import quiz.mcdonalds.menu.Hamburger;
import quiz.mcdonalds.menu.Menu;

import java.util.ArrayList;

/**
 * Created by bollsal on 2016. 12. 7..
 */
public class Mcdonalds {

    private static ArrayList<Menu> menus;
    private Customer customer;

    private static void prepareMenus(boolean isTest) {
        if (menus == null) {
            menus = new ArrayList<>();
        } else {
            menus.clear();
        }

        if (!isTest) {
            menus.add(new Hamburger());
            menus.add(new Hamburger());
        }
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void enterCustomer(Customer customer) {
        this.customer = customer;
    }

    public PurchaseResult takeAnOrder() {
        boolean itemCheck = false;
        boolean moneyCheck = false;
        for (Menu menu : menus) {
            if (menu.getName().equals(customer.getOrderMenuName())) {
                itemCheck = true;

                if (menu.getPrice() <= customer.getHaveMoney()) {
                    moneyCheck = true;
                }
                break;
            }
        }

        PurchaseResult pr = new PurchaseResult();
        if(itemCheck && moneyCheck) {
            pr.setMessage(PurchaseResult.PURCHASE_STATE.SUCCESS);
        } else if(!itemCheck) {
            pr.setMessage(PurchaseResult.PURCHASE_STATE.FAIL_SOLDOUT);
        } else if(!moneyCheck) {
            pr.setMessage(PurchaseResult.PURCHASE_STATE.FAIL_MONEY);
        } else {
            pr.setMessage(PurchaseResult.PURCHASE_STATE.UNKNOWN);
        }
        return pr;
    }

    public static Mcdonalds create(boolean isTest) {
        Mcdonalds.prepareMenus(isTest);
        return new Mcdonalds();
    }
}
