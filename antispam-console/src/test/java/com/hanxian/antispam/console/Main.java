package com.hanxian.antispam.console;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Main {

    @Test
    public void test1() {
        String number1 = "1.7";
        String number2 = "12313.341323";

        String result = addDecimalStrings(number1, number2);
        assert result.equals("12315.041323");
    }

    @Test
    public void test2() {
        String number1 = "12313.341323";
        String number2 = "1.0";
        String result = addDecimalStrings(number1, number2);
        System.out.println(result);
        assert result.equals("12314.341323");
    }

    @Test
    public void test3() {
        String number1 = "12313.341323";
        String number2 = "2";
        String result = addDecimalStrings(number1, number2);
        assert result.equals("12315.341323");
    }


    private static String addDecimalStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String dummy = num1;
            num1 = num2;
            num2 = dummy;
        }

        int decimalIndex1 = num1.indexOf('.');

        if (decimalIndex1 == -1) {
            num1 += '.';
            decimalIndex1 = num2.length();

        }

        int decimalIndex2 = num2.indexOf('.');
        if (decimalIndex2 == -1) {
            num2 += '.';
            decimalIndex2 = num2.indexOf('.');
        }

        if (decimalIndex1 != decimalIndex2) {
            int distance = decimalIndex1 - decimalIndex2;
            num2 = "0".repeat(distance) + num2;
            decimalIndex2 = decimalIndex1;
        }

        // 将小数点后的位数补齐，不足的位数用零补齐
        int maxDecimalDigits = Math.max(num1.length() - decimalIndex1 - 1, num2.length() - decimalIndex2 - 1);
        num1 = padDecimalDigits(num1, decimalIndex1, maxDecimalDigits);
        num2 = padDecimalDigits(num2, decimalIndex2, maxDecimalDigits);

        // 将字符串转换为字符数组方便逐位相加
        char[] digits1 = num1.toCharArray();
        char[] digits2 = num2.toCharArray();

        StringBuilder sb = new StringBuilder();
        int carry = 0; // 进位

        // 从后向前逐位相加
        for (int i = digits1.length - 1; i >= 0; i--) {
            if (digits1[i] == '.') {
                sb.insert(0, '.');
                continue;
            }

            int sum = (digits1[i] - '0') + (digits2[i] - '0') + carry;
            carry = sum / 10;
            int digit = sum % 10;
            sb.insert(0, digit);
        }

        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }

    private static String padDecimalDigits(String num, int decimalIndex, int targetDigits) {
        int actualDigits = num.length() - decimalIndex - 1;
        if (actualDigits < targetDigits) {
            return num + "0".repeat(Math.max(0, targetDigits - actualDigits));
        }
        return num;
    }
}