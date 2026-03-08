package example.dagger2.services;

import example.dagger2.models.InsertKanban;
import example.dagger2.models.InsertTask;
import example.dagger2.models.SelectKanban;
import example.dagger2.models.SelectTask;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;

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

    public int newKanban(InsertKanban kanban, InsertTask... tasks) {
        LOG.debug("newKanban");
        // validations
        if (Objects.isNull(kanban)) throw new RuntimeException("kanban is null");
        if (Objects.isNull(kanban.name())) throw new RuntimeException("kanban name is null");
        int kanbanId = kanbanRepo.insert(kanban);
        for (InsertTask task : tasks) {
            taskRepo.insert(task.withKanbanId(kanbanId));
        }
        return kanbanId;
    }

    public Optional<SelectKanban> get(int id) {
        LOG.debug("get");
        var k = kanbanRepo.get(id);
        if (k.isEmpty()) throw new RuntimeException("kanban not found");
        var t = taskRepo.list(k.get().id(), "");
        return Optional.of(SelectKanban.from(k.get(), t.toArray(new SelectTask[0])));
    }
}
