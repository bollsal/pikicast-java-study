package quiz.mcdonalds;

/**
 * Created by bollsal on 2016. 12. 7..
 */
public class PurchaseResult {
    public interface PURCHASE_STATE {
        String SUCCESS = "구매 성공";
        String FAIL_MONEY = "구매 실패 : 금액이 부족합니다.";
        String FAIL_SOLDOUT = "구매 실패 : 품절되었습니다.";
        String UNKNOWN = "???";
    }

    private String msg;
    // TODO : 거스름돈

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}
