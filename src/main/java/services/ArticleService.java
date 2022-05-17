package services;

import entity.Article;
import model.Message;
import provider.ArticleProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("article")
public class ArticleService {

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createArticle(Article article){
        try{
            ArticleProvider provider = new ArticleProvider();
            provider.createArticle(article);
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

    @DELETE
    @Path("{order}/{product}/{amount}")
    @Produces("application/json")
    public Response deleteProduct(@PathParam("order") int order, @PathParam("product") int product, @PathParam("amount") int amount){
        try{
            ArticleProvider provider = new ArticleProvider();
            provider.deleteProduct(order,product,amount);
            return Response
                    .status(200)
                    .entity(new Message("info","Eliminado exitosamente"))
                    .build();
        }catch(Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Exception",e.getMessage()))
                    .build();
        }
    }
}
