package ps.velocityservice;

public interface IVelocityService {
	
	/**
	 * Calculate final velocity
	 * @param u Initial velocity (ms-1)
	 * @param a Acceleration (ms-2)
	 * @param t Time (s)
	 * @return Velocity (ms-1)
	 */
	double calculateFinalVelocity(double u, double a, double t);
	
	/**
	 * Calculate final velocity
	 * @param u Initial velocity (ms-1)
	 * @param a Acceleration (ms-2)
	 * @param s Displacement (m)
	 * @return Final velocity (ms-1)
	 */
	double calculateFinalVelocityWihtoutTime(double u, double a, double s);
	
	/**
	 * Calculate displacement
	 * @param u Initial velocity (ms-1)
	 * @param a Acceleration (ms-2)
	 * @param t Time (s)
	 * @return Displacement (m)
	 */
	double calculateDisplacement(double u, double a, double t);
	
	/**
	 * Calculate displacement
	 * @param u Initial velocity (ms-1)
	 * @param v Final velocity (ms-1)
	 * @param t Time (s)
	 * @return Displacement (m)
	 */
	double calculateDisplacementWihtoutAcceleration(double u, double v, double t);

}
