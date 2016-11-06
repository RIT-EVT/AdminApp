package edu.evt.admin.resource;

import edu.evt.admin.tasks.Wiki;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @Path("/")
    public Response getFile(){
        StreamingOutput fileStream = new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                try{
                    Wiki task = new Wiki();
                    byte[] data = task.setup();
                    task.teardown();

                    output.write(data);
                    output.flush();
                }catch (Exception e){
                    e.printStackTrace();
                    throw new WebApplicationException("Error processing page!");
                }
            }
        };
        return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename = screenshot.png")
                .build();
    }

}
