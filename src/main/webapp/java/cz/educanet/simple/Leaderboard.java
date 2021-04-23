package java.cz.educanet.simple;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
}
