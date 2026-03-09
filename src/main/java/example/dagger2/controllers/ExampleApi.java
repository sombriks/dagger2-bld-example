package example.dagger2.controllers;

import io.javalin.config.JavalinConfig;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleApi {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleApi.class);

    @Inject
    public ExampleApi(){
        LOG.info("ExampleApi init");
    }

    public void configure(JavalinConfig config) {
        LOG.debug("configure");
        config.concurrency.useVirtualThreads = true;
        config.staticFiles.enableWebjars();

//        config.fileRenderer();

        config.routes.get("/", ctx -> ctx.result("Hello World"));
        config.routes.get("/test", ctx-> ctx.render("/test.pug"));
    }
}
