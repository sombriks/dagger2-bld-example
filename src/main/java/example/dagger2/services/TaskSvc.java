package example.dagger2.services;

import example.dagger2.repositories.TaskRepo;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskSvc {

    private static final Logger LOG = LoggerFactory.getLogger(TaskSvc.class);

    private final TaskRepo taskRepo;

    @Inject
    public TaskSvc(TaskRepo taskRepo) {
        LOG.info("TaskSvc constructor");
        this.taskRepo = taskRepo;
    }
}
