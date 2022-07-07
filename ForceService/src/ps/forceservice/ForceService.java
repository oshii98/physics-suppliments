package ps.forceservice;

public class ForceService implements IForceService {

	@Override
	public double calculateForce(double m, double a) {
		return m * a;
	}

	@Override
	public double calculateUpthrust(double m, double a) {
		return m * a;
	}

	@Override
	public double calculateUpthrust(double v, double d, double a) {
		return v * d * a;
	}

	@Override
	public double calculateFrictionalForce(double f0, double f) {
		return f0 * f;
	}

}
