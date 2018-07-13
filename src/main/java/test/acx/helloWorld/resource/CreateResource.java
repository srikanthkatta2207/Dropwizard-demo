package test.acx.helloWorld.resource;
import com.codahale.metrics.annotation.Timed;
import test.acx.helloWorld.DAO.HelloWorldDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/createdb")
public class CreateResource {

    public HelloWorldDao helloWorldDao;

    public CreateResource(HelloWorldDao helloWorldDao) {
        this.helloWorldDao = helloWorldDao;
    }

    @GET
    @Timed
    public void createTable() {
        helloWorldDao.createSayingTable();
    }
}