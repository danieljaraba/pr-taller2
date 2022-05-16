package services;

import entity.Article;
import model.Message;
import provider.ArticleProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
