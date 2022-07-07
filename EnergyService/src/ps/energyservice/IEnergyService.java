package ps.energyservice;

public interface IEnergyService {
	
	/**
	 * Calculate kinertic energy
	 * @param m Mass (kg)
	 * @param v Velocity (ms-1)
	 * @return Kinertic energy (J)
	 */
	double calculateKinerticEnergy(double m, double v);
	
	/**
	 * Calculate potential energy
	 * @param m Mass (kg)
	 * @param g Acceleration due to gravity (ms-2)
	 * @param h Height of the object position object placed (m)
	 * @return Potential energy (J)
	 */
	double calculatePotentialEnergy(double m, double g, double h);
	
	/**
	 * Calculate power
	 * @param f Force (N)
	 * @param v Velocity (ms-1)
	 * @return Power (W)
	 */
	double calculatePower(double f, double v);
	
	/**
	 * Calculate work done
	 * @param f Force applied (N)
	 * @param d Displacement (m)
	 * @return Work done (J)
	 */
	double calculateWorkDone(double f, double d);

}
