package services;

import entity.Order;
import model.Message;
import provider.OrderProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("order")
public class OrderService {

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createOrder(Order order){
        try{
            OrderProvider provider = new OrderProvider();
            provider.create(order);
            return Response
                    .status(200)
                    .entity(new Message("info","Operación exitosa"))
                    .build();
        }catch(Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Exception",e.getMessage()))
                    .build();
        }
    }
}
