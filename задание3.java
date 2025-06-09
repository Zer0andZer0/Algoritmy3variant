import java.util.HashMap;
import java.util.Map;

public class FibonacciDigits {

    private static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] result = matrixPower(matrix, n - 1);
        
        return result[0][0]; // f(n) находится в результатирующей матрице [0][0]
    }

    private static long[][] matrixPower(long[][] matrix, int n) {
        long[][] result = {{1, 0}, {0, 1}}; // единичная матрица
        while (n > 0) {
            if (n % 2 == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            n /= 2;
        }
        return result;
    }

    private static long[][] matrixMultiply(long[][] a, long[][] b) {
        return new long[][] {
            {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
            {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }

    private static int[] findMostFrequentDigit(long number) {
        String numberStr = Long.toString(number);
        Map<Character, Integer> digitCount = new HashMap<>();

        for (char c : numberStr.toCharArray()) {
            digitCount.put(c, digitCount.getOrDefault(c, 0) + 1);
        }

        char mostFrequentDigit = '0';
        int maxFrequency = 0;

        for (Map.Entry<Character, Integer> entry : digitCount.entrySet()) {
            char digit = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency || (frequency == maxFrequency && digit < mostFrequentDigit)) {
                mostFrequentDigit = digit;
                maxFrequency = frequency;
            }
        }
        return new int[] {maxFrequency, mostFrequentDigit - '0'};
    }

    // Главный метод
    public static void main(String[] args) {
        int i = 10; // замените 10 на любое число в диапазоне [10, 100000]
        
        if (i < 10 || i > 100000) {
            System.out.println("Введите значение i в диапазоне [10, 100000]");
            return;
        }

        long fibNumber = fibonacci(i);
        int[] result = findMostFrequentDigit(fibNumber);
        
        System.out.printf("Результат для f(%d) = %d: [%d, %d]%n", i, fibNumber, result[0], result[1]);
    }
}