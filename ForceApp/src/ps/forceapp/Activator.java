package ps.forceapp;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import ps.forceservice.IForceService;

public class Activator implements BundleActivator {

	private ServiceRegistration<IForceApp> registration;

	@Override
	public void start(BundleContext context) throws Exception {
		var serviceReference = context.getServiceReference(IForceService.class);
		var service = context.getService(serviceReference);

		IForceApp app = new ForceApp(service);
		registration = context.registerService(IForceApp.class, app, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}

}
