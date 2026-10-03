import java.math.BigDecimal;

public class Example {
    public static void main(String[] args) {
        BigDecimal amount1 = new BigDecimal("0");
        BigDecimal amount2 = new BigDecimal("20");
        BigDecimal amount3 = new BigDecimal("30");

        System.out.println(amount1.add(amount2).add(amount3));
    }
}
