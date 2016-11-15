package day02.quiz.rockpaperscissors;

import java.util.Random;

/**
 * Created by bollsal on 2016. 11. 15..
 */
public class Rockpaperscissors {

    /**
     * - 가위, 바위, 보 게임을 만들어 보세요.
     * - 테스트는 가위, 바위, 보 각각 3개씩 만드세요. (이기는 경우, 지는 경우, 비기는 경우)
     * - 가위, 바위, 보 각각을 객체로 만들어서 설계해 보세요.
     */

//    public static void main(String... args) {
//        Random random = new Random();
//        int computer = random.nextInt(3);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("가위바위보 - !!!!");
//
//        String userInput = scanner.nextLine();
//        int user = -1;
//
//        switch (userInput) {
//            case "가위":
//                user = 0;
//                break;
//            case "바위":
//                user = 1;
//                break;
//            case "보":
//                user = 2;
//                break;
//            default:
//                System.out.println("가위바위보 중에 내라");
//                break;
//        }
//
//        if (user == computer) {
//            System.out.println("draw");
//        } else if ((user == 0 && computer == 2) || (user == 1 && computer == 0) || (user == 2 && computer == 1)) {
//            System.out.println("win");
//        } else {
//            System.out.println("lose");
//        }
//
//        switch (computer) {
//            case 0:
//                System.out.println("computer = 가위");
//                break;
//            case 1:
//                System.out.println("computer = 바위");
//                break;
//            case 2:
//                System.out.println("computer = 보");
//                break;
//        }
//    }

    int computerValue;
    String userInput;
    Common common;

    public void createComputerValue() {
        Random random = new Random();
        computerValue = random.nextInt(3);
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        switch (userInput) {
            case Common.VALUE.SCISSOR:
                common = new Scissor();
                break;
            case Common.VALUE.ROCK:
                common = new Rock();
                break;
            case Common.VALUE.PAPERS:
                common = new Papers();
                break;
            default:
                common = null;
                break;
        }

        if (common != null) {
            System.out.println(common.getResult(computerValue));
        }
    }

    public String getResult() {
        if (common != null) {
            return common.getResult(computerValue);
        } else {
            return null;
        }
    }
}
