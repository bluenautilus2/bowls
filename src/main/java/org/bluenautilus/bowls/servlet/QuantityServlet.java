package org.bluenautilus.bowls.servlet;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * User: bluenautilus2
 * Date: 5/6/13
 * Time: 12:54 PM
 */

@Path("/quantity")
public class QuantityServlet{

    @GET
    public Response getQuantity(@QueryParam(value="id") final String id) {

        String output = "Jersey say : " + id;

        return Response.status(200).entity(output).build();
    }

    @POST
    public Response updateQuantity(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }

    @DELETE
    public Response deleteQuantity(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }

}
