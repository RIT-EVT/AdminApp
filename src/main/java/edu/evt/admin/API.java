package edu.evt.admin;

import edu.evt.admin.resource.Calculator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import javax.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

public class API{
	public static void main(String[] args) throws Exception{
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		Server server = new Server(8080);
		server.setHandler(context);

		ServletHolder servlet = context.addServlet(ServletContainer.class, "/*");
		servlet.setInitOrder(0);

		Map<String, String> servletParams = new HashMap<>();
		servletParams.put(Application.class.getCanonicalName(), App.class.getCanonicalName());
		servlet.setInitParameters(servletParams);

		try {
			server.start();
			server.join();
		}finally{
			server.destroy();
		}

	}

}