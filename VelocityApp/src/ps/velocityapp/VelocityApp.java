package ps.velocityapp;

import java.util.Scanner;

import ps.velocityservice.IVelocityService;

public class VelocityApp implements IApp {

	private static final int OPTION_VELO = 1, OPTION_VELO_NO_TIME = 2, OPTION_DIS = 3, OPTION_DIS_NO_ACC = 4,
			OPTION_EXIT = 0;

	private Scanner scanner;
	private IVelocityService velocityService;

	public VelocityApp(IVelocityService velocityService) {
		this.velocityService = velocityService;
	}

	@Override
	public void setOutputStream(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void start() {

		while (true) {

			System.out.println();
			System.out.println();
			displayMenu();
			System.out.print("Please select an option: ");

			int input;
			try {
				input = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Invaliid input");
				scanner.nextLine();
				continue;
			}

			if (input == OPTION_EXIT)
				break;

			System.out.println();

			switch (input) {
			case OPTION_VELO:
				calVelo();
				break;

			case OPTION_VELO_NO_TIME:
				calVeloNoTime();
				break;

			case OPTION_DIS:
				calDis();
				break;

			case OPTION_DIS_NO_ACC:
				calDisNoAcc();
				break;

			default:
				System.out.println("Invaliid input");
			}

		}

	}

	private void displayMenu() {
		System.out.println(OPTION_EXIT + " -> Exit");
		System.out.println(OPTION_VELO + " -> Calculate velocity");
		System.out.println(OPTION_VELO_NO_TIME + " -> Calculate velocity without time");
		System.out.println(OPTION_DIS + " -> Calculate displacement");
		System.out.println(OPTION_DIS_NO_ACC + " -> Calculate displacement without acceleration");
	}

	private void calVelo() {
		try {

			var u = getInitialVelocity();
			var a = getAcceleration();
			var t = getTime();

			var v = velocityService.calculateFinalVelocity(u, a, t);
			System.out.printf("Final velocity : %.2f ms-1\n", v);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calVeloNoTime() {
		try {

			var u = getInitialVelocity();
			var a = getAcceleration();
			var s = getDisplacement();

			var v = velocityService.calculateFinalVelocityWihtoutTime(u, a, s);
			System.out.printf("Final velocity : %.2f ms-1\n", v);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calDis() {
		try {

			var u = getInitialVelocity();
			var a = getAcceleration();
			var t = getTime();

			var s = velocityService.calculateDisplacement(u, a, t);
			System.out.printf("Final displacement : %.2f m\n", s);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calDisNoAcc() {
		try {

			var u = getInitialVelocity();
			var v = getFinalVelocity();
			var t = getTime();

			var s = velocityService.calculateDisplacementWihtoutAcceleration(u, v, t);
			System.out.printf("Final displacement : %.2f m\n", s);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private double getInitialVelocity() {
		System.out.print("Enter initial velocity (ms-1) : ");
		return scanner.nextDouble();
	}

	private double getAcceleration() {
		return getDouble("Enter acceleration (ms-2) : ");
	}

	private double getTime() {
		return getDouble("Enter time (s) : ");
	}

	private double getFinalVelocity() {
		return getDouble("Enter final velocity (ms-1) : ");
	}

	private double getDisplacement() {
		return getDouble("Enter displacement (m) : ");
	}

	private double getDouble(String message) {
		System.out.print(message);
		return scanner.nextDouble();
	}

}
