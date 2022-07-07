package ps.electricityservice;

public interface IElectricityService {
	
	/**
	 * Calculate power
	 * @param v Voltage (V)
	 * @param c Current (A)
	 * @return Power (W)
	 */
	double calculatePower(double v, double c);
	
	/**
	 * Calculate voltage
	 * @param c Current (A)
	 * @param r Resistance (ohm)
	 * @return Voltage (V)
	 */
	double calculateVoltage(double c, double r);
	
	/**
	 * Calculate charge
	 * @param c Current (A)
	 * @param t Time (s)
	 * @return Charge (C)
	 */
	double calculateCharge(double c, double t);
	
	/**
	 * Calculate energy
	 * @param v Voltage (V)
	 * @param c Charge (C)
	 * @return Energy (J)
	 */
	double calculateEnergy(double v, double c);
	
	/**
	 * Calculate energy
	 * @param v Voltage (V)
	 * @param c Current (A)
	 * @param t Time (s)
	 * @return Energy (J)
	 */
	double calculateEnergy(double v, double c, double t);

}
