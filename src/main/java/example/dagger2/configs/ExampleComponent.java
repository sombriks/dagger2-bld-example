package example.dagger2.configs;

import dagger.Component;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import example.dagger2.services.KanbanSvc;
import example.dagger2.services.TaskSvc;
import jakarta.inject.Singleton;
import org.jdbi.v3.core.Jdbi;

@Singleton
@Component(modules = ExampleModule.class)
public interface ExampleComponent {

    Jdbi jdbi();

    KanbanRepo kanbanRepo();

    TaskRepo taskRepo();

    KanbanSvc kanbanSvc();

    TaskSvc taskSvc();
}
