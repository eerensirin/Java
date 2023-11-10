import java.util.Scanner;

public class Ex_1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your first value : ");
		int num1 = keyboard.nextInt();
		System.out.print("Enter your second value : ");
		int num2 = keyboard.nextInt();
		larger_value(num1, num2);

		keyboard.close();
	}

	private static void larger_value(int num1, int num2) {
		if (num1 > num2) {
			System.out.printf("Your number %d is largest value", num1);
		} else {
			System.out.printf("Your number %d is largest value", num2);
		}
	}

}
