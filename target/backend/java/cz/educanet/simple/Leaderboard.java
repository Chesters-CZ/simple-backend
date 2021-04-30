package java.cz.educanet.simple;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.cz.educanet.simple.Resources.LoginDatabase;
import java.cz.educanet.simple.Resources.User;
import java.util.Collections;
import java.util.List;

@Path("/leaderboard")
public class Leaderboard {
    @GET
    public Response getSortedUsers(@QueryParam("max") @DefaultValue("20") int howmany) {
        User[] output = new User[howmany];
        List<User> kopie = LoginDatabase.userList;
        Collections.sort(kopie);
        for (int i = 0; i < output.length; i++) {
            output[i] = kopie.get(i);
        }
        return Response.ok(output).build();
    }

    @PUT
    public Response setUserScore(@QueryParam("user") String username, @QueryParam("pass") String password, @QueryParam("score") int score){
        for (int i = 0; i < LoginDatabase.userList.size(); i++) {
            if (LoginDatabase.userList.get(i).getPassword().equals(password) && LoginDatabase.userList.get(i).getUsername().equals(username)) {
                LoginDatabase.userList.get(i).setScore(score);
            return Response.ok(LoginDatabase.userList.get(i).getUsername()+"'s score has been updated.").build();
            }
        }
        return Response.status(404, "This combination of username and password does not exist.").build();
    }
}
