package ps.forceservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<IForceService> registration;

	@Override
	public void start(BundleContext context) throws Exception {
		IForceService forceService = new ForceService();
		registration = context.registerService(IForceService.class, forceService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}

}
