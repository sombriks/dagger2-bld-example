package example.dagger2.controllers;

import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import example.dagger2.services.KanbanSvc;
import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;
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
        context.result("janbans");
    }
}
