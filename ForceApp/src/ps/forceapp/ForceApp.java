package ps.forceapp;

import java.util.Scanner;

import ps.forceservice.IForceService;

public class ForceApp implements IForceApp {

	private static final int OPTION_FORCE = 1, OPTION_UPTHRUST_MASS = 2, OPTION_UPTHRUST_VOL = 3, OPTION_FRICTION = 4,
			OPTION_EXIT = 0;

	private Scanner scanner;
	private IForceService forceService;

	public ForceApp(IForceService forceService) {
		this.forceService = forceService;
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
			case OPTION_FORCE:
				calForce();
				break;

			case OPTION_UPTHRUST_MASS:
				calUpthrustWithMass();
				break;

			case OPTION_UPTHRUST_VOL:
				calUpthrustWithVol();
				break;

			case OPTION_FRICTION:
				calFriction();
				break;

			default:
				System.out.println("Invaliid input");
			}

		}

	}

	private void displayMenu() {
		System.out.println(OPTION_EXIT + " -> Exit");
		System.out.println(OPTION_FORCE + " -> Calculate force");
		System.out.println(OPTION_UPTHRUST_MASS + " -> Calculate upthrust with mass");
		System.out.println(OPTION_UPTHRUST_VOL + " -> Calculate upthrust with volume");
		System.out.println(OPTION_FRICTION + " -> Calculate frictional force");
	}

	private void calForce() {
		try {

			var m = getMass();
			var a = getAcceleration();

			var f = forceService.calculateForce(m, a);
			System.out.printf("Force : %.2f N\n", f);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calUpthrustWithMass() {
		try {

			var m = getWaterMass();
			var g = getGravAcc();

			var f = forceService.calculateUpthrust(m, g);
			System.out.printf("Upthrust : %.2f N\n", f);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calUpthrustWithVol() {
		try {

			var v = getWaterVolume();
			var d = getWaterDensity();
			var g = getGravAcc();

			var f = forceService.calculateUpthrust(v, d, g);
			System.out.printf("Upthrust : %.2f N\n", f);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calFriction() {
		try {

			var f = getForce();
			var f0 = getCoefficientOfFric();

			var fric = forceService.calculateFrictionalForce(f0, f);
			System.out.printf("Frictional force : %.2f N\n", fric);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private double getMass() {
		return getDouble("Enter mass (kg) : ");
	}

	private double getWaterMass() {
		return getDouble("Enter mass of water displaced (kg) : ");
	}

	private double getAcceleration() {
		return getDouble("Enter acceleration (ms-2) : ");
	}
	
	private double getGravAcc() {
		return getDouble("Enter acceleration due to gravity (ms-2) : ");
	}

	private double getForce() {
		return getDouble("Enter force (N) : ");
	}

	private double getWaterVolume() {
		return getDouble("Enter volume of water displaced (m3) : ");
	}

	private double getWaterDensity() {
		return getDouble("Enter density of water displaced (kg m-3) : ");
	}

	private double getCoefficientOfFric() {
		return getDouble("Enter coefficient of friction : ");
	}

	private double getDouble(String msg) {
		System.out.print(msg);
		return scanner.nextDouble();
	}

}
