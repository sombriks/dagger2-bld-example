package example.dagger2.controllers;

import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import example.dagger2.services.KanbanSvc;
import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KanbanCtl {

    private static final Logger LOG = LoggerFactory.getLogger(KanbanCtl.class);

    private final KanbanSvc kanbanSvc;
    private final KanbanRepo kanbanRepo;
    private final TaskRepo taskRepo;

    @Inject
    public KanbanCtl(
            KanbanSvc kanbanSvc,
            KanbanRepo kanbanRepo,
            TaskRepo taskRepo) {
        LOG.info("Creating KanbanCtl");
        this.kanbanSvc = kanbanSvc;
        this.kanbanRepo = kanbanRepo;
        this.taskRepo = taskRepo;
    }

    public void list(Context context) {
        LOG.debug("list");
        String q = context
                .pathParamAsClass("q", String.class)
                .getOrDefault("");
        var result = kanbanRepo.list(q);
        context.json(result);
    }

    public void insert(Context context) {
        LOG.debug("insert");
    }

    public void get(Context context) {
        LOG.debug("get");
        int kanbanId = context
                .pathParamAsClass("kanbanId", Integer.class)
                .getOrDefault(0);
    }

    public void update(Context context) {
        LOG.debug("update");
    }

    public void delete(Context context) {
        LOG.debug("delete");
    }
}
