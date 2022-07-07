package ps.velocityservice;

public class VelocityService implements IVelocityService {

	@Override
	public double calculateFinalVelocity(double u, double a, double t) {
		return u + (a * t);
	}

	@Override
	public double calculateFinalVelocityWihtoutTime(double u, double a, double s) {
		return Math.sqrt(Math.pow(u, 2) + (2 * a * s));
	}

	@Override
	public double calculateDisplacement(double u, double a, double t) {
		return (u * t) + (0.5 * a * Math.pow(t, 2));
	}

	@Override
	public double calculateDisplacementWihtoutAcceleration(double u, double v, double t) {
		return 0.5 * t * (u + v);
	}

}
