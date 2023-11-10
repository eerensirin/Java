import java.util.Scanner;

public class Ex_4 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your first value : ");
		int num1 = keyboard.nextInt();
		System.out.print("Enter your second value : ");
		int num2 = keyboard.nextInt();
		System.out.print("Enter your third value : ");
		int num3 = keyboard.nextInt();
		equal(num1, num2, num3);

		keyboard.close();
	}

	private static void equal(int num1, int num2, int num3) {
		if ((num1 == num2) || (num1 == num3)) {
			System.out.printf("Your numbers %d are eqaual", num1);

		} else {
			System.out.printf("Your numbers %d %d %d are different ", num1, num2, num3);

		}
	}
}
