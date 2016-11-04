package edu.evt.admin;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jongo.Jongo;


public class App extends ResourceConfig{

    public static MongoClient mongo;
    public static MongoDatabase db;

    public static CredentialProvider credentialProvider;

	/**
	 * When the App is run as a servlet.
	 */
	public App(){
		packages("edu.evt.admin.resource");
        App.mongo = new MongoClient();
        App.db = App.mongo.getDatabase("admin");

        App.credentialProvider = new CredentialProvider();

	}

	/**
	 * This app can be run within it's own context in addition to running as a servlet in a container.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		Server server = new Server(8080);
		server.setHandler(context);

		ServletHolder apiHolder = new ServletHolder("api", new ServletContainer(new App()));
		ServletHolder staticHolder = new ServletHolder("static", new DefaultServlet());
		staticHolder.setInitParameter("resourceBase", "./src/ui");

		context.addServlet(apiHolder, "/api/*");
		context.addServlet(staticHolder, "/");

		try {
			server.start();
			server.join();
		}finally{
			server.destroy();
		}

	}

}