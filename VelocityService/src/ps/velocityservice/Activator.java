package ps.velocityservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<IVelocityService> service;

	@Override
	public void start(BundleContext context) throws Exception {
		IVelocityService velocityService = new VelocityService();
		service = context.registerService(IVelocityService.class, velocityService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		service.unregister();
	}

}
