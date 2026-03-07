package example.dagger2;

import example.dagger2.configs.DaggerExampleComponent;
import example.dagger2.configs.ExampleComponent;
import example.dagger2.models.InsertKanban;
import example.dagger2.models.Kanban;
import example.dagger2.repositories.KanbanRepo;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleTest {

    private static final ExampleComponent exampleComponent = DaggerExampleComponent.builder().build();
    private final KanbanRepo kanbanRepo = exampleComponent.kanbanRepo();

    @Test
    @Order(1)
    void shouldInsertKanban() {
        kanbanRepo.init();
        var result = kanbanRepo.insert(new InsertKanban("TEST"));
        assertThat(result, is(1));
    }

    @Test
    @Order(2)
    void shouldListKanban() {
        kanbanRepo.init();
        var result = kanbanRepo.list("TEST").size();
        assertThat(result, is(1));
    }

    @Test
    @Order(3)
    void shouldUpdateKanban() {
        kanbanRepo.init();
        var k = kanbanRepo.list("TEST").stream().findFirst();
        if (k.isPresent()) {
            var kanban = new Kanban(k.get().id(),"TEST2");
            var result = kanbanRepo.update(kanban);
            assertThat(result, is(1));
            var result2 = kanbanRepo.get(kanban.id());
            assertThat(result2.isPresent(), is(true));
            assertThat(result2.get().name(), is("TEST2"));
        }
    }

    @Test
    @Order(4)
    void shouldDeleteKanban() {
        kanbanRepo.init();
        var k = kanbanRepo.list("TEST2").stream().findFirst();
        if (k.isPresent()) {
            var result = kanbanRepo.delete(k.get().id());
            assertThat(result, is(1));
        }
    }
}
