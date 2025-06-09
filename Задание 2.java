import java.util.Scanner;

public class SquaresOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите первое число: ");
        int firstNumber = scanner.nextInt();
        
        System.out.print("Введите второе число: ");
        int secondNumber = scanner.nextInt();
        
        int start = Math.min(firstNumber, secondNumber);
        
        // Выводим квадраты чисел
        for (int i = start; i <= (start * 5); i += start) { // Например, выводим до 5 * start
            System.out.println(i * i);
        }
        
        scanner.close();
    }
}