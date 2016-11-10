package day01.quiz.calculator;

/**
 * Created by bollsal on 2016. 11. 9..
 * <p>
 * 사칙연산이 되는 계산기 클래스 Calculator 를 만들고 각각의 메소드를 테스트하는 CalculatorTest 만들어 보기.
 */
public class Calculator {

    public int plus(int x, int y) {
        return x + y;
    }

    public long plusLong(long x, long y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int division(int x, int y) {
        if(y == 0) {
            throw new ArithmeticException("/ by zero : y를 0보다 큰 숫자 쓰셈");
        }
        return x / y;
    }

    public int multiple(int x, int y) {
        return x * y;
    }
}
