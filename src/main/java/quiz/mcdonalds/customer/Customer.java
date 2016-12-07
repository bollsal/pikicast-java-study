package quiz.mcdonalds.customer;

import quiz.mcdonalds.PurchaseResult;

/**
 * Created by bollsal on 2016. 12. 7..
 */
public class Customer {

    private String orderMenuName;
    private int haveMoney;
    private PurchaseResult result;

    public void setOrderMenu(String orderMenu) {
        this.orderMenuName = orderMenu;
    }

    public String getOrderMenuName() {
        return orderMenuName;
    }

    public void setHaveMoney(int haveMoney) {
        this.haveMoney = haveMoney;
    }

    public int getHaveMoney() {
        return haveMoney;
    }

    public PurchaseResult getPurchaseResult() {
        return result;
    }

    public void setPurchaseResult(PurchaseResult result) {
        this.result = result;
    }
}
