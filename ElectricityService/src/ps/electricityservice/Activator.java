package ps.electricityservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<IElectricityService> registration;

	@Override
	public void start(BundleContext context) throws Exception {
		IElectricityService electricityService = new ElectricityService();
		registration = context.registerService(IElectricityService.class, electricityService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}

}
