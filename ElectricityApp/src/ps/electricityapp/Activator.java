package ps.electricityapp;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import ps.electricityservice.IElectricityService;

public class Activator implements BundleActivator {

	private ServiceRegistration<IElectricityApp> registration;

	@Override
	public void start(BundleContext context) throws Exception {
		var serviceReference = context.getServiceReference(IElectricityService.class);
		var service = context.getService(serviceReference);

		IElectricityApp app = new ElectricityApp(service);
		registration = context.registerService(IElectricityApp.class, app, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}

}
