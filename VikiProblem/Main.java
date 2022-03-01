import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How long does Viki the Frog has to Jump (in meters)?");
		int travelDistance = sc.nextInt();
		int timeTaken = calDistance(travelDistance, 0, 5);
		System.out.println(
				"It would take approximately " + timeTaken + " seconds to jump " + travelDistance + " meters.");
	}

	public static int calDistance(int distance, int time, int call) {
		if (distance > 0) {
			if (call == 5) {
				time = calDistance(distance - 5, time + 1, 3);
			}
			if (call == 3) {
				time = calDistance(distance - 3, time + 2, 1);
			}
			if (call == 1) {
				time = calDistance(distance - 1, time + 3, 5);
			}
			return time;
		} else {
			return time;
		}
	}
}
