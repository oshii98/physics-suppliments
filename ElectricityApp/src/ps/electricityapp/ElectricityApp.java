package ps.electricityapp;

import java.util.Scanner;

import ps.electricityservice.IElectricityService;

public class ElectricityApp implements IElectricityApp {

	private static final int OPTION_POWER = 1, OPTION_VOLTAGE = 2, OPTION_CHARGE = 3, OPTION_ENERGY = 4,
			OPTION_ENERGY_NO_CHARGE = 5, OPTION_EXIT = 0;

	private Scanner scanner;
	private IElectricityService electricityService;

	public ElectricityApp(IElectricityService electricityService) {
		this.electricityService = electricityService;
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
			case OPTION_POWER:
				calPower();
				break;

			case OPTION_VOLTAGE:
				calVol();
				break;

			case OPTION_CHARGE:
				calCharge();
				break;

			case OPTION_ENERGY:
				calEnergy();
				break;

			case OPTION_ENERGY_NO_CHARGE:
				calEnergyNoCharge();
				break;

			default:
				System.out.println("Invaliid input");
			}

		}

	}

	private void displayMenu() {
		System.out.println(OPTION_EXIT + " -> Exit");
		System.out.println(OPTION_POWER + " -> Calculate power");
		System.out.println(OPTION_VOLTAGE + " -> Calculate voltage");
		System.out.println(OPTION_CHARGE + " -> Calculate charge");
		System.out.println(OPTION_ENERGY + " -> Calculate energy");
		System.out.println(OPTION_ENERGY_NO_CHARGE + " -> Calculate energy without charge");
	}

	private void calPower() {
		try {

			var v = getVoltage();
			var c = getCurrent();

			var p = electricityService.calculatePower(v, c);
			System.out.printf("Power : %.2f W\n", p);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calVol() {
		try {

			var c = getCurrent();
			var r = getResistance();

			var v = electricityService.calculateVoltage(c, r);
			System.out.printf("Voltage : %.2f V\n", v);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calCharge() {
		try {

			var c = getCurrent();
			var t = getTime();

			var charge = electricityService.calculateCharge(c, t);
			System.out.printf("Charge : %.2f C\n", charge);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calEnergy() {
		try {

			var v = getVoltage();
			var c = getCharge();

			var e = electricityService.calculateEnergy(v, c);
			System.out.printf("Energy : %.2f J\n", e);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private void calEnergyNoCharge() {
		try {

			var v = getVoltage();
			var c = getCurrent();
			var t = getTime();

			var e = electricityService.calculateEnergy(v, c, t);
			System.out.printf("Energy : %.2f J\n", e);

		} catch (Exception e) {
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	private double getVoltage() {
		return getDouble("Enter voltage (V) : ");
	}

	private double getCurrent() {
		return getDouble("Enter current (A) : ");
	}

	private double getResistance() {
		return getDouble("Enter resistance (ohm) : ");
	}

	private double getTime() {
		return getDouble("Enter time (s) : ");
	}

	private double getCharge() {
		return getDouble("Enter charge (C) : ");
	}

	private double getDouble(String msg) {
		System.out.print(msg);
		return scanner.nextDouble();
	}

}
