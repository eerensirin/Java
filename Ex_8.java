import java.util.Scanner;

public class Ex_8 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your first value : ");
		int num1 = keyboard.nextInt();
		System.out.print("Enter your second value : ");
		int num2 = keyboard.nextInt();
		System.out.print("Enter your third value : ");
		int num3 = keyboard.nextInt();
		largest_func(num1, num2, num3);

		keyboard.close();
	}

	private static int largest_func(int num1, int num2, int num3) {
		int first = Math.max(num2, num3);
		int second = Math.max(num1, first);
		return second;
		
	}

}
