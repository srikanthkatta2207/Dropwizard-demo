package test.acx.helloWorld;


import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;
import test.acx.helloWorld.DAO.HelloWorldDao;
import test.acx.helloWorld.configuration.HelloWorldConfiguration;
import test.acx.helloWorld.configuration.HelloWorldDbConfiguration;
import test.acx.helloWorld.resource.CreateResource;
import test.acx.helloWorld.resource.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class HelloWorldApplication extends Application<HelloWorldDbConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldDbConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldDbConfiguration configuration,
                    Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment,configuration.getDb(),"postgresql");
        final HelloWorldDao dao = jdbi.onDemand(HelloWorldDao.class);
        HelloWorldResource helloWorldResource = new HelloWorldResource("hi","stranger",dao);
        final CreateResource createResource = new CreateResource(dao);
        environment.jersey().register(createResource);
        environment.jersey().register(helloWorldResource);

    }





}


