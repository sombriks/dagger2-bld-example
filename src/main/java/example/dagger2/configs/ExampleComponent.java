package example.dagger2.configs;

import dagger.Component;
import example.dagger2.controllers.ExampleApi;
import example.dagger2.controllers.KanbanCtl;
import example.dagger2.controllers.TaskCtl;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import example.dagger2.services.KanbanSvc;
import jakarta.inject.Singleton;
import org.jdbi.v3.core.Jdbi;

@Singleton
@Component(modules = ExampleModule.class)
public interface ExampleComponent {

    Jdbi jdbi();

    PugRenderer pugRenderer();

    KanbanRepo kanbanRepo();

    TaskRepo taskRepo();

    KanbanSvc kanbanSvc();

    KanbanCtl kanbanCtl();

    TaskCtl taskCtl();

    ExampleApi exampleApi();
}
