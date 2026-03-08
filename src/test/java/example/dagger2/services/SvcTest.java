package example.dagger2.services;

import example.dagger2.configs.DaggerExampleComponent;
import example.dagger2.configs.ExampleComponent;
import example.dagger2.models.InsertKanban;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class SvcTest {

    private static final ExampleComponent exampleComponent = DaggerExampleComponent.builder().build();

    private final KanbanRepo kanbanRepo = exampleComponent.kanbanRepo();
    private final TaskRepo taskRepo = exampleComponent.taskRepo();

    private final KanbanSvc kanbanSvc = exampleComponent.kanbanSvc();
    private final TaskSvc taskSvc = exampleComponent.taskSvc();

    @BeforeEach
    void setup() {
        kanbanRepo.init();
        taskRepo.init();
    }

    @Test
    void shouldAddKanban() {
        var kanban = new InsertKanban("dayjob");
        var result = kanbanSvc.newKanban(kanban);
        assertThat(result, not(is(0)));
        kanbanRepo.delete(result);
    }

    @Test
    void shouldUpdateKanban() {
        var kanban = new InsertKanban("dayjob");
        var result = kanbanSvc.newKanban(kanban);
        assertThat(result, not(is(0)));
        kanbanRepo.delete(result);
    }

    @Test
    void shouldListKanbans() {
    }

    @Test
    void shouldAddTask() {
    }

    @Test
    void shouldUpdateTaskState() {
    }

    @Test
    void shoouldDeleteTask() {
    }

    @Test
    void shouldDeleteKanban() {
    }
}
