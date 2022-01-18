package com.bill;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/demo")
public class MovieResource {

    public static List<String> movies = new ArrayList<>();


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMovies() {
        return Response.ok(movies).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    public Integer getSize() {
        return movies.size();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response createMovie(String newMovie) {
        movies.add(newMovie);
        return Response.ok(movies).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("{targetMovie}")
    public Response updateMovie(@PathParam("targetMovie") String oldMovie, @QueryParam("movie") String newMovie) {
        movies = movies.stream().map(m -> {
            if (m.equals(oldMovie)) return newMovie;
            return m;
        }).collect(Collectors.toList());
        return Response.ok(movies).build();
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("{targetMovie}")
    public Response removeMovie(@PathParam("targetMovie") String targetMovie) {
        boolean success = movies.remove(targetMovie);
        return success ? Response.noContent().build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
