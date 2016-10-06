package edu.evt.admin.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Wheeler on 10/3/2016.
 */

@Path("/calculate")
public class Calculator {

    Set<String> operators = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] {"+", "-", "/", "*"})));

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{leftOperand}/{operator}/{rightOperand}")
    public String calculate(@PathParam("leftOperand") String leftOperand, @PathParam("operator") String operator, @PathParam("rightOperand") String rightOperand){
        if(!operators.contains(operator)){
            throw new BadRequestException(Response
                .status(Response.Status.BAD_REQUEST)
                .entity("Illegal calculator operator")
                .build());
        }
        int[] operands = new int[2];
        try {
            operands[0] = Integer.parseInt(leftOperand);
        } catch (NumberFormatException e) {
            throw new BadRequestException(Response
                .status(Response.Status.BAD_REQUEST)
                .entity("\""+leftOperand+"\" is not a valid number.")
                .build());
        }
        try {
            operands[1] = Integer.parseInt(rightOperand);
        } catch (NumberFormatException e) {
            throw new BadRequestException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("\""+rightOperand+"\" is not a valid number.")
                    .build());
        }

        if(operator.equals("+")){
            return String.valueOf(operands[0] + operands[1]);
        }else if(operator.equals("-")){
            return String.valueOf(operands[0] - operands[1]);
        }else if(operator.equals("/")){
            return String.valueOf(operands[0] / operands[1]);
        }else{
            return String.valueOf(operands[0] * operands[1]);
        }
    }
}
