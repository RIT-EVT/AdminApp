package edu.evt.admin.resource;

import edu.evt.admin.App;
import edu.evt.admin.TaskI;
import edu.evt.admin.tasks.Wiki;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by wheeler on 11/6/16.
 */

@Path("/task")
public class Task {

    @GET
    @Path("/{taskName}/{action}")
    public String executeAction(@PathParam("taskName") String taskName, @PathParam("action") String action){
        try {
            Class<? extends TaskI> taskClass = App.tasks.get(taskName);
            TaskI task = taskClass.getDeclaredConstructor().newInstance();
            task.setUp();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return "it worked!";
        }

    }

}
