package example.dagger2.configs;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import example.dagger2.services.KanbanSvc;
import example.dagger2.services.TaskSvc;
import javax.annotation.processing.Generated;
import org.jdbi.v3.core.Jdbi;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DaggerExampleComponent {
  private DaggerExampleComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ExampleComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private ExampleModule exampleModule;

    private Builder() {
    }

    public Builder exampleModule(ExampleModule exampleModule) {
      this.exampleModule = Preconditions.checkNotNull(exampleModule);
      return this;
    }

    public ExampleComponent build() {
      if (exampleModule == null) {
        this.exampleModule = new ExampleModule();
      }
      return new ExampleComponentImpl(exampleModule);
    }
  }

  private static final class ExampleComponentImpl implements ExampleComponent {
    private final ExampleComponentImpl exampleComponentImpl = this;

    Provider<Jdbi> jdbiProvider;

    ExampleComponentImpl(ExampleModule exampleModuleParam) {

      initialize(exampleModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ExampleModule exampleModuleParam) {
      this.jdbiProvider = DoubleCheck.provider(ExampleModule_JdbiFactory.create(exampleModuleParam));
    }

    @Override
    public Jdbi jdbi() {
      return jdbiProvider.get();
    }

    @Override
    public KanbanRepo kanbanRepo() {
      return new KanbanRepo(jdbiProvider.get());
    }

    @Override
    public TaskRepo taskRepo() {
      return new TaskRepo(jdbiProvider.get());
    }

    @Override
    public KanbanSvc kanbanSvc() {
      return new KanbanSvc(kanbanRepo(), taskRepo());
    }

    @Override
    public TaskSvc taskSvc() {
      return new TaskSvc(taskRepo());
    }
  }
}
