package services;

import entity.Order;
import entity.Report;
import model.Message;
import provider.OrderProvider;

import javax.ws.rs.*;
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

    @POST
    @Path("update/{order}")
    @Produces("application/json")
    public Response updateOrder(@PathParam("order") int order){
        try{
            OrderProvider provider = new OrderProvider();
            provider.changeStatus(order);
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

    @GET
    @Path("get/{order}")
    @Produces("application/json")
    public Response getInfo(@PathParam("order") int order){
        try{
            OrderProvider provider = new OrderProvider();
            Report report = provider.getInfo(order);
            return Response
                    .status(200)
                    .entity(report)
                    .build();
        }catch(Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Exception",e.getMessage()))
                    .build();
        }
    }
}
