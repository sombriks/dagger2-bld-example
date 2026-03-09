package example.dagger2;

import example.dagger2.configs.DaggerExampleComponent;
import example.dagger2.configs.ExampleComponent;
import example.dagger2.controllers.ExampleApi;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import io.javalin.Javalin;

public class Example {
    public static void main(String[] args) {
        ExampleComponent exampleComponent = DaggerExampleComponent.builder().build();
        ExampleApi exampleApi = exampleComponent.exampleApi();
        KanbanRepo kanbanRepo = exampleComponent.kanbanRepo();
        TaskRepo taskRepo = exampleComponent.taskRepo();

        kanbanRepo.init();
        taskRepo.init();

        Javalin.create(exampleApi::configure)
                .start(7070);
    }
}
