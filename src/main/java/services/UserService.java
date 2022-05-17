package services;

import entity.History;
import entity.User;
import model.Message;
import provider.UserProvider;

import javax.ws.rs.*;
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

    @GET
    @Path("history/{user}")
    @Produces("application/json")
    public Response getHistory(@PathParam("user") String user){
        try{
            UserProvider provider = new UserProvider();
            History history = provider.getInfo(user);
            return Response
                    .status(200)
                    .entity(history)
                    .build();
        }catch (Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Exception", e.getMessage()))
                    .build();
        }
    }
}
