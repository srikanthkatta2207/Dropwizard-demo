package test.acx.helloWorld.resource;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import test.acx.helloWorld.DAO.HelloWorldDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_XML)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private HelloWorldDao helloWorldDao;

    public HelloWorldResource(String template, String defaultName, HelloWorldDao dao) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.helloWorldDao = dao;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("id") int id) {
        String userName = helloWorldDao.findContentById(id);
        final String value = template + userName;
        return new Saying(id, value);
    }

    @POST
    @Timed
    public int insertValue(@QueryParam("name") Optional<String> name) {
       helloWorldDao.insert((int)counter.getAndIncrement(),name.or(defaultName));
       return counter.intValue()-1;
    }
}
