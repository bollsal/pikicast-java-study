package vendingmachine;

import vendingmachine.item.Beer;
import vendingmachine.item.Item;
import vendingmachine.item.Juice;
import vendingmachine.item.Milk;
import vendingmachine.money.Money;
import vendingmachine.money.Money100;
import vendingmachine.money.Money1000;
import vendingmachine.money.Money500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by bollsal on 2016. 11. 11..
 */
public class VendingMachine {
    public static final String EXIST_ITEM = "준비된 제품이 있습니다.";
    public static final String NO_ITEM = "준비된 제품이 없습니다.";
    public static final String SOLD_OUT = "품절상태입니다.";

    public interface PURCHASE_STATE {
        String SUCCESS = "구매성공";
        String FAIL_MONEY = "구매실패 : 코인을 더 넣어주세요";
        String FAIL_SOLDOUT = "구매실패 : 품절되었습니다.";
        String EVENT_ITEM = "이벤트상품에 당첨되셨습니다";
    }

    private int coin;
    ArrayList<Item> items = new ArrayList<>();

    public VendingMachine() {
        createItems();
    }

    public void createItems() {
        items.addAll(Arrays.asList(new Beer(), new Beer(), new Beer(), new Beer(), new Beer()));
        items.addAll(Arrays.asList(new Juice(), new Juice(), new Juice(), new Juice(), new Juice()));
        items.addAll(Arrays.asList(new Milk(), new Milk(), new Milk(), new Milk(), new Milk()));
    }

    public int setEventItem() {
        Random random = new Random();
        int eventItemIndex = random.nextInt(items.size());
        items.get(eventItemIndex).setEvenItem(true);

        System.out.println("eventItemPos : " + eventItemIndex);
        return eventItemIndex;
    }

    public void clearItems() {
        items.clear();
    }

    public void insertCoin(int coin) {
        this.coin += coin;
    }

    public int getCoin() {
        return coin;
    }

    public String getState() {
        if (getItems().isEmpty()) {
            return NO_ITEM;
        } else {
            return EXIST_ITEM;
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int itemsIndexOf(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType().equals(item.getType())) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Money> refundCoin() {
        ArrayList<Money> refundCoins = new ArrayList<>();
        while (coin != 0) {
            if (coin >= Money1000.WON) {
                coin -= Money1000.WON;
                refundCoins.add(new Money1000());
            } else if (coin >= Money500.WON) {
                coin -= Money500.WON;
                refundCoins.add(new Money500());
            } else {
                coin -= Money100.WON;
                refundCoins.add(new Money100());
            }
        }
        return refundCoins;
    }

    public String purchaseItem(Item item) {
        int itemPrice = item.getPrice();
        int index = items.contains(item) ? items.indexOf(item) : itemsIndexOf(item);

        if (index > -1) {
            if(items.get(index).isEventItem()) {
                // TODO :

                return PURCHASE_STATE.EVENT_ITEM;
            } else if(coin >= itemPrice) {
                coin -= itemPrice;
                items.remove(index);
                return PURCHASE_STATE.SUCCESS;
            } else {
                return PURCHASE_STATE.FAIL_MONEY;
            }
        } else {
            return PURCHASE_STATE.FAIL_SOLDOUT;
        }
    }
}
