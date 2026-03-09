package example.dagger2.controllers;

import example.dagger2.configs.PugRenderer;
import io.javalin.apibuilder.ApiBuilder;
import io.javalin.config.JavalinConfig;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleApi {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleApi.class);

    private final PugRenderer pugRenderer;
    private final KanbanCtl  kanbanCtl;

    @Inject
    public ExampleApi(PugRenderer pugRenderer,KanbanCtl  kanbanCtl){
        LOG.info("ExampleApi init");
        this.pugRenderer = pugRenderer;
        this.kanbanCtl = kanbanCtl;
    }

    public void configure(JavalinConfig config) {
        LOG.debug("configure");
        config.concurrency.useVirtualThreads = true;
        config.staticFiles.enableWebjars();

        config.fileRenderer(pugRenderer);

        config.routes.get("/", ctx -> ctx.result("Hello World"));
        config.routes.get("/test", ctx-> ctx.render("/test.pug"));

        config.routes.apiBuilder(() -> {
            ApiBuilder.path("/api", () -> {
                ApiBuilder.path("/kanbans", () -> {
                    ApiBuilder.get(kanbanCtl::list);
                });
            });
        });
    }
}
