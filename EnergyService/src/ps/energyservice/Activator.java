package ps.energyservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<IEnergyService> registration;

	@Override
	public void start(BundleContext context) throws Exception {
		IEnergyService energyService = new EnergyService();
		registration = context.registerService(IEnergyService.class, energyService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}

}
