import java.util.Scanner;

public class Ex_6 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your first value : ");
		int radius = keyboard.nextInt();
		sphereVolume(radius);
		System.out.println(sphereVolume(radius));
		System.out.println(sphereSurface(radius));
		keyboard.close();
	}
	private static double sphereVolume(int radius) {
		double V = 4/3 * 3.14 * radius *radius*radius ;
		return V;
	}
	private static double sphereSurface(int radius) {
		double S = 4 * 3.14 * radius *radius ;
		return S;
	}
}
