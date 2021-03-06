package java.cz.educanet.simple;

import java.cz.educanet.simple.Resources.LoginDatabase;
import java.cz.educanet.simple.Resources.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("login")
public class Login {

    @GET
    public Response getUserLogin(@QueryParam("user") String username, @QueryParam("pass") String password) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).getPassword().equals(password) && LoginDatabase.userList.get(i).getUsername().equals(username))
                return Response.ok(i).build();
        }
        return Response.status(404, "This combination of username and password does not exist.").build();
    }

    @POST
    public Response registerUser(@QueryParam("user") String username, @QueryParam("pass") String password) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).getUsername().equals(username))
                return Response.status(409, "cannot have two users using the same username").build();
        }

        LoginDatabase.userList.add(new User(username, password));
        return Response.status(201).build();
    }

    @DELETE
    public Response removeUser(@QueryParam("user") String username, @QueryParam("pass") String password) {
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).getPassword().equals(password) && LoginDatabase.userList.get(i).getUsername().equals(username)) {

                LoginDatabase.userList.remove(i);
                return Response.ok("removed user " + username).build();
            }
        }
        return Response.status(404, "This combination of username and password does not exist.").build();
    }
}
