package services;

import entity.User;
import model.Message;
import provider.UserProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("user")
public class UserService {

    @POST
    @Path("create")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUser(User user){
        try{
            UserProvider provider = new UserProvider();
            provider.create(user);
            return Response
                    .status(200)
                    .entity(new Message("info","Operación exitosa"))
                    .build();
        }catch (Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Exception", e.getMessage()))
                    .build();
        }
    }
}
