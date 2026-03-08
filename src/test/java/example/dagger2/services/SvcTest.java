package example.dagger2.services;

import example.dagger2.configs.DaggerExampleComponent;
import example.dagger2.configs.ExampleComponent;
import example.dagger2.models.InsertKanban;
import example.dagger2.models.InsertTask;
import example.dagger2.models.State;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SvcTest {

    private static final ExampleComponent exampleComponent = DaggerExampleComponent.builder().build();

    private final KanbanRepo kanbanRepo = exampleComponent.kanbanRepo();
    private final TaskRepo taskRepo = exampleComponent.taskRepo();

    private final KanbanSvc kanbanSvc = exampleComponent.kanbanSvc();

    @BeforeEach
    void setup() {
        kanbanRepo.init();
        taskRepo.init();
    }

    @Test
    void shouldAddKanban() {
        var kanban = new InsertKanban("day-job");
        var task1 = InsertTask.newTask("morning meeting", State.TODO);
        var task2 = InsertTask.newTask("client support", State.TODO);
        var result = kanbanSvc.newKanban(kanban, task1, task2);
        assertThat(result, not(is(0)));
        kanbanRepo.delete(result);
    }

    @Test
    void shouldGetKanban() {
        var kanban = new InsertKanban("day-job");
        var task1 = InsertTask.newTask("morning meeting", State.TODO);
        var task2 = InsertTask.newTask("client support", State.TODO);
        var result = kanbanSvc.newKanban(kanban, task1, task2);
        assertThat(result, not(is(0)));

        var k = kanbanRepo.list("day-job").stream().findFirst();
        assertThat(k.isPresent(), is(true));

        var detail = kanbanSvc.get(k.get().id());
        assertThat(detail.isPresent(), is(true));
        assertThat(detail.get().id(), is(result));
        assertThat(detail.get().name(), is("day-job"));
        assertThat(detail.get().tasks(), notNullValue());
        assertThat(detail.get().tasks().length, is(2));

        kanbanRepo.delete(result);
    }
}
