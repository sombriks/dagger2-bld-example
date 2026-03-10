package example.dagger2.controllers;

import example.dagger2.configs.DaggerExampleComponent;
import example.dagger2.configs.ExampleComponent;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CtlTest {

    private static final ExampleComponent exampleComponent = DaggerExampleComponent.builder().build();

    private final KanbanRepo kanbanRepo = exampleComponent.kanbanRepo();
    private final TaskRepo taskRepo = exampleComponent.taskRepo();

    private final ExampleApi exampleApi = exampleComponent.exampleApi();

    private Javalin app;

    @BeforeEach
    void setup() {
        kanbanRepo.init();
        taskRepo.init();
        app = Javalin.create(exampleApi::configure);

    }

    @Test
    void shouldListKanbans() {
        JavalinTest.test(app, (server, client) -> {
            var result = client.get("/");
            assertThat(result.code(), equalTo(200));
        });
    }
}
