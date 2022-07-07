package ps.forceservice;

public interface IForceService {
	
	/**
	 * Calculate force using equation F= ma
	 * @param m Mass (kg)
	 * @param a Acceleration (ms-2)
	 * @return Force (N)
	 */
	double calculateForce(double m, double a);
	
	/**
	 * Calculate up thrust using amount of water displaced
	 * @param m Mass of water displaced (kg)
	 * @param a Acceleration due to gravity (ms-2)
	 * @return Up thrust (N)
	 */
	double calculateUpthrust(double m, double a);
	
	/**
	 * Calculate up thrust using amount of water displaced
	 * @param v Volume of water displaced (ms-3)
	 * @param d Density of water displaced (kg m-3)
	 * @param a Acceleration due to gravity (ms-2)
	 * @return Up thrust (N)
	 */
	double calculateUpthrust(double v, double d, double a);
	
	/**
	 * Calculate frictional force acting on an object
	 * @param f0 Coefficient of friction between two objects (ratio)
	 * @param f Force applied on object (N)
	 * @return Frictional force acting on object (N)
	 */
	double calculateFrictionalForce(double f0, double f);

}
