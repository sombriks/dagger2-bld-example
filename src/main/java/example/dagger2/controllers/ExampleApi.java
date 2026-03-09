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
    private final TaskCtl taskCtl;

    @Inject
    public ExampleApi(
            PugRenderer pugRenderer,
            KanbanCtl  kanbanCtl,
            TaskCtl taskCtl){
        LOG.info("ExampleApi init");
        this.pugRenderer = pugRenderer;
        this.kanbanCtl = kanbanCtl;
        this.taskCtl = taskCtl;
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
                    ApiBuilder.post(kanbanCtl::insert);
                    ApiBuilder.path("/{kanbanId}", () -> {
                        ApiBuilder.get(kanbanCtl::get);
                        ApiBuilder.put(kanbanCtl::update);
                        ApiBuilder.delete(kanbanCtl::delete);
                        ApiBuilder.path("/tasks", () -> {
                            ApiBuilder.get(taskCtl::list);
                            ApiBuilder.post(taskCtl::insert);
                            ApiBuilder.path("/{taskId}", () -> {
                                ApiBuilder.get(taskCtl::get);
                                ApiBuilder.put(taskCtl::update);
                                ApiBuilder.delete(taskCtl::delete);
                            });

                        });
                    });
                });
            });
        });
    }
}
