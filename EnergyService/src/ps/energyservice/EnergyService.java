package ps.energyservice;

public class EnergyService implements IEnergyService {

	@Override
	public double calculateKinerticEnergy(double m, double v) {
		return 0.5 * m * Math.pow(v, 2);
	}

	@Override
	public double calculatePotentialEnergy(double m, double g, double h) {
		return m * g * h;
	}

	@Override
	public double calculatePower(double f, double v) {
		return f * v;
	}

	@Override
	public double calculateWorkDone(double f, double d) {
		return f * d;
	}

}
