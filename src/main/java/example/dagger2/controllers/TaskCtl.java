package example.dagger2.controllers;

import example.dagger2.repositories.TaskRepo;
import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskCtl {

    private static final Logger LOG = LoggerFactory.getLogger(TaskCtl.class);

    private final TaskRepo taskRepo;

    @Inject
    public TaskCtl(TaskRepo taskRepo){
        LOG.info("Creating TaskCtl");
        this.taskRepo = taskRepo;
    }

    public void list(@NotNull Context context) {
        LOG.debug("list");
        int kanbanId = context
                .pathParamAsClass("kanbanId",Integer.class)
                .getOrDefault(0);
        String q = context
                .pathParamAsClass("q", String.class)
                .getOrDefault("");
        context.json(taskRepo.list(kanbanId, q));
    }

    public void insert(@NotNull Context context) {
        LOG.debug("insert");

    }

    public void get(@NotNull Context context) {
        LOG.debug("get");
    }

    public void update(@NotNull Context context) {
        LOG.debug("update");
    }

    public void delete(@NotNull Context context) {
        LOG.debug("delete");
    }
}
