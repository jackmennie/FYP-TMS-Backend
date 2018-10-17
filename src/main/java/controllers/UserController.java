package controllers;

import models.User;
import services.UserService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {
    @Inject
    private UserService userService;

    @GET
    @Path("/")
    @Produces({MediaType.TEXT_PLAIN})
    public Response index() {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity("")
                .build();
    }

    @Path("/get")
    @GET
    @Produces("application/json")
    public JsonArray getAll() {
        JsonArrayBuilder builder = Json.createArrayBuilder();

        for(User user : userService.getAll()) {
            builder.add(Json.createObjectBuilder().add("email", user.getEmail()));
        }


        return builder.build();
    }

    @Path("/add")
    @POST
    @Produces("application/json")
    public Response setUser(String user) {
        String result = "user added: " + user;

        userService.add(new User(user));

        return Response.status(201).entity(result).build();

    }
}
