package example.dagger2;

import example.dagger2.configs.DaggerExampleComponent;
import example.dagger2.configs.ExampleComponent;
import example.dagger2.models.*;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleTest {

    private static final ExampleComponent exampleComponent = DaggerExampleComponent.builder().build();

    private final KanbanRepo kanbanRepo = exampleComponent.kanbanRepo();
    private final TaskRepo taskRepo = exampleComponent.taskRepo();

    @BeforeEach
    void setup() {
        kanbanRepo.init();
        taskRepo.init();
    }

    @Test
    @Order(1)
    void shouldInsertKanban() {
        var result = kanbanRepo.insert(new InsertKanban("TEST"));
        assertThat(result, is(1));
    }

    @Test
    @Order(2)
    void shouldListKanban() {
        var result = kanbanRepo.list("TEST").size();
        assertThat(result, is(1));
    }

    @Test
    @Order(3)
    void shouldUpdateKanban() {
        var k = kanbanRepo.list("TEST").stream().findFirst();
        if (k.isPresent()) {
            var kanban = new Kanban(k.get().id(), "TEST2");
            var result = kanbanRepo.update(kanban);
            assertThat(result, is(1));
            var result2 = kanbanRepo.get(kanban.id());
            assertThat(result2.isPresent(), is(true));
            assertThat(result2.get().name(), is("TEST2"));
        }
    }

    @Test
    @Order(4)
    void shouldInsertTask() {
        var k = kanbanRepo.list("TEST").stream().findFirst();
        assertThat(k.isPresent(), is(true));
        var task = new InsertTask(k.get().id(), "walk the dog", State.TODO.name());
        var result = taskRepo.insert(task);
        assertThat(result, is(1));
    }

    @Test
    @Order(5)
    void shouldUpdateTask() {
        var k = kanbanRepo.list("TEST").stream().findFirst();
        assertThat(k.isPresent(), is(true));
        var task = new InsertTask(k.get().id(), "walk the dog", State.TODO.name());
        var result = taskRepo.insert(task);
        assertThat(result, is(1));
        var t = taskRepo.list(k.get().id(), "walk the dog").stream().findFirst();
        assertThat(t.isPresent(), is(true));
        var task2 = t.get();
        var result2 = taskRepo.update(new UpdateTask(task2.id(), task2.kanbanId(), task2.description(), State.DOING.name()));
        assertThat(result2, is(1));
    }

    @Test
    @Order(6)
    void shouldDeleteTask() {
        var t = taskRepo.list(0, "").stream().findFirst();
        assertThat(t.isPresent(), is(true));
        t = taskRepo.get(t.get().kanbanId(), t.get().id());
        assertThat(t.isPresent(), is(true));
        var result = taskRepo.delete(t.get().kanbanId(), t.get().id());
        assertThat(result, is(1));
    }


    @Test
    @Order(7)
    void shouldDeleteKanban() {
        var k = kanbanRepo.list("TEST2").stream().findFirst();
        if (k.isPresent()) {
            var result = kanbanRepo.delete(k.get().id());
            assertThat(result, is(1));
        }
    }
}
