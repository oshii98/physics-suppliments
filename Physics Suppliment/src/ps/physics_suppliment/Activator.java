package ps.physics_suppliment;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import ps.electricityapp.IElectricityApp;
import ps.energyapp.*;
import ps.forceapp.IForceApp;
import ps.velocityapp.IApp;

public class Activator implements BundleActivator {

	private static final int OPTION_EXIT = 0, OPTION_VELO = 1, OPTION_FORCE = 2, OPTION_ENERGY = 3, OPTION_ELEC = 4;

	private IApp velocityApp;
	private IForceApp forceApp;
	private IEnergyApp energyApp;
	private IElectricityApp electricityApp;

	@Override
	public void start(BundleContext context) throws Exception {
		var veloAppRef = context.getServiceReference(IApp.class);
		velocityApp = context.getService(veloAppRef);

		var forceAppRef = context.getServiceReference(IForceApp.class);
		forceApp = context.getService(forceAppRef);

		var energyAppRef = context.getServiceReference(IEnergyApp.class);
		energyApp = context.getService(energyAppRef);

		var electricityAppRef = context.getServiceReference(IElectricityApp.class);
		electricityApp = context.getService(electricityAppRef);

		start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {

	}

	private void start() {
		System.out.println("Welcome to Physics Supplement!");
		System.out.println("Solve all your physics problems with US");

		var scanner = new Scanner(System.in);
		setScanner(scanner);

		while (true) {

			System.out.println();
			System.out.println();
			displayMenu();
			System.out.print("Please select an option : ");

			int input;
			try {
				input = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid input");
				scanner.nextLine();
				continue;
			}

			if (input == OPTION_EXIT)
				break;

			switch (input) {
			case OPTION_VELO:
				velocityApp.start();
				break;

			case OPTION_FORCE:
				forceApp.start();
				break;

			case OPTION_ENERGY:
				energyApp.start();
				break;

			case OPTION_ELEC:
				electricityApp.start();
				break;

			default:
				System.out.println("Invalid input");
				break;
			}

		}
	}

	private void displayMenu() {

		System.out.println(OPTION_EXIT + " -> Exit");
		System.out.println(OPTION_VELO + " -> Velocity equations");
		System.out.println(OPTION_FORCE + " -> Force equations");
		System.out.println(OPTION_ENERGY + " -> Energy equations");
		System.out.println(OPTION_ELEC + " -> Electricity equations");

	}

	private void setScanner(Scanner scanner) {
		velocityApp.setOutputStream(scanner);
		energyApp.setOutputStream(scanner);
		electricityApp.setOutputStream(scanner);
		forceApp.setOutputStream(scanner);
	}

}
