package ps.velocityapp;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import ps.velocityservice.IVelocityService;

public class Activator implements BundleActivator {

	private ServiceRegistration<IApp> registration;

	@Override
	public void start(BundleContext context) throws Exception {		
		var serviceReference = context.getServiceReference(IVelocityService.class);
		var service = context.getService(serviceReference);
		
		IApp app = new VelocityApp(service);
		registration = context.registerService(IApp.class, app, null);		
	}

	@Override
	public void stop(BundleContext context) throws Exception {		
		registration.unregister();
	}

}
