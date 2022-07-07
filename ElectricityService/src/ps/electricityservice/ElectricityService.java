package ps.electricityservice;

public class ElectricityService implements IElectricityService {

	@Override
	public double calculatePower(double v, double c) {
		return v * c;
	}

	@Override
	public double calculateVoltage(double c, double r) {
		return c * r;
	}

	@Override
	public double calculateCharge(double c, double t) {
		return c * t;
	}

	@Override
	public double calculateEnergy(double v, double c) {
		return v * c;
	}

	@Override
	public double calculateEnergy(double v, double c, double t) {
		return v * calculateCharge(c, t);
	}

}
