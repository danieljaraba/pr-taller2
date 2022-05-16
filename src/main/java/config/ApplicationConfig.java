package config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> res = new HashSet<>();
        res.add(services.TestService.class);
        res.add(services.UserService.class);
        res.add(services.OrderService.class);
        res.add(services.ProductService.class);
        res.add(services.ArticleService.class);
        return res;
    }
}
