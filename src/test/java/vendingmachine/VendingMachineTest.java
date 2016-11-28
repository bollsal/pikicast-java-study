package vendingmachine;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vendingmachine.item.Beer;
import vendingmachine.item.Cola;
import vendingmachine.item.Item;
import vendingmachine.money.Money;
import vendingmachine.money.Money1000;
import vendingmachine.money.Money500;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by bollsal on 2016. 11. 11..
 * <p>
 * 테스트 항목.
 *  1. 돈 테스트
 *          - 넣은 돈 잘 유지되는지
 *          - 거스름돈 : 잔액없이 다 주는지
 *                      주화단위에 맞게 주는지
 *  2. item 테스트
 *          - 자판기 상품 : 없으면 없다고 알려주는지
 *                      있으면 갯수 확인
 *          - 해당상품을 요청 : 제대로 구매되는지.
 *                      구매후 돈계산이 제대로 됬는지.
 *                      해당상품이 있는지
 *  3. 이벤트 테스트
 *          - 몇번째 구매시 이벤트 당첨
 */
public class VendingMachineTest {

    private VendingMachine vm;

    @Before
    public void setUp() {
        vm = new VendingMachine();
    }

    @Test
    public void 돈테스트_넣은돈_유지되는지() {
        vm.insertCoin(500);
        assertThat(vm.getCoin(), is(500));

        vm.insertCoin(100);
        assertThat(vm.getCoin(), is(600));
    }

    @Test
    public void 돈테스트_거스름돈_잘반환되는지() {
        vm.insertCoin(3900);
        assertThat(vm.getCoin(), is(3900));
        vm.refundCoin();
        assertThat(vm.getCoin(), is(0));

    }

    @Test
    public void 돈테스트_거스름돈_주화단위에_맞게주는지() {
        vm.insertCoin(3900);
        assertThat(vm.getCoin(), is(3900));

        int money1000Count = 0;
        int money500Count = 0;
        int money100Count = 0;
        for (Money money : vm.refundCoin()) {
            if (money instanceof Money1000) {
                money1000Count++;
            } else if (money instanceof Money500) {
                money500Count++;
            } else {
                money100Count++;
            }
        }
        assertThat(money1000Count, is(3));
        assertThat(money500Count, is(1));
        assertThat(money100Count, is(4));

        assertThat(vm.getCoin(), is(0));
    }

    @Test
    public void item테스트_자판기상품_없는경우() {
        vm.clearItems();
        String itemState = vm.getState();
        assertThat(itemState, is(VendingMachine.NO_ITEM));
    }

    @Test
    public void item테스트_자판기상품_갯수확인() {
        assertThat(vm.getItems().size(), is(15));
    }

    @Test
    public void item테스트_제대로_구매되는지_돈을_안넣고_시도() {
        assertThat(vm.purchaseItem(new Beer()), is(VendingMachine.PURCHASE_STATE.FAIL_MONEY));
    }

    @Test
    public void item테스트_제대로_구매되는지_돈을_넣고_시도() {
        System.out.println("구매전 " + vm.getItems().size());

        Beer beer = new Beer();
        vm.insertCoin(beer.getPrice());

        assertThat(vm.getCoin(), is(beer.getPrice()));
        assertThat(vm.getItems().size(), is(15));

        assertThat(vm.purchaseItem(beer), is(VendingMachine.PURCHASE_STATE.SUCCESS));

        assertThat(vm.getItems().size(), is(14));
        assertThat(vm.getCoin(), is(0));

        System.out.println("구매후 " + vm.getItems().size() + "  잔액 : " + vm.getCoin());
    }

    @Test
    public void item테스트_품절된_상품을_구매시도할경우_체크() {
        assertThat(vm.purchaseItem(new Cola()), is(VendingMachine.PURCHASE_STATE.FAIL_SOLDOUT));
    }

    @Test
    public void 이벤트테스트_잘동작하는가() {
        int eventItemPos = vm.setEventItem();
        vm.insertCoin(5000);
        assertThat(vm.purchaseItem(vm.getItems().get(eventItemPos)), is(VendingMachine.PURCHASE_STATE.EVENT_ITEM));
    }
}
