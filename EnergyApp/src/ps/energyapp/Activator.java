package ps.energyapp;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import ps.energyservice.IEnergyService;

public class Activator implements BundleActivator {

	private ServiceRegistration<IEnergyApp> registration;

	@Override
	public void start(BundleContext context) throws Exception {
		var serviceReference = context.getServiceReference(IEnergyService.class);
		var service = context.getService(serviceReference);

		IEnergyApp app = new EnergyApp(service);
		registration = context.registerService(IEnergyApp.class, app, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}

}
