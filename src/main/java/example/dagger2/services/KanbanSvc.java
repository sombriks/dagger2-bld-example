package example.dagger2.services;

import example.dagger2.models.InsertKanban;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class KanbanSvc {

    private static final Logger LOG = LoggerFactory.getLogger(KanbanSvc.class);

    private final KanbanRepo kanbanRepo;
    private final TaskRepo taskRepo;

    @Inject
    public KanbanSvc(KanbanRepo kanbanRepo, TaskRepo taskRepo) {
        LOG.info("KanbanSvc constructor");
        this.kanbanRepo = kanbanRepo;
        this.taskRepo = taskRepo;
    }

    public int newKanban(InsertKanban kanban) {
        LOG.debug("newKanban");
        // validations
        if(Objects.isNull(kanban)) throw new RuntimeException("kanban is null");
        if(Objects.isNull(kanban.name())) throw new RuntimeException("kanban name is null");
        return kanbanRepo.insert(kanban);
    }
}
