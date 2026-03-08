package example.dagger2.services;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
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
public final class KanbanSvc_Factory implements Factory<KanbanSvc> {
  private final Provider<KanbanRepo> kanbanRepoProvider;

  private final Provider<TaskRepo> taskRepoProvider;

  private KanbanSvc_Factory(Provider<KanbanRepo> kanbanRepoProvider,
      Provider<TaskRepo> taskRepoProvider) {
    this.kanbanRepoProvider = kanbanRepoProvider;
    this.taskRepoProvider = taskRepoProvider;
  }

  @Override
  public KanbanSvc get() {
    return newInstance(kanbanRepoProvider.get(), taskRepoProvider.get());
  }

  public static KanbanSvc_Factory create(Provider<KanbanRepo> kanbanRepoProvider,
      Provider<TaskRepo> taskRepoProvider) {
    return new KanbanSvc_Factory(kanbanRepoProvider, taskRepoProvider);
  }

  public static KanbanSvc newInstance(KanbanRepo kanbanRepo, TaskRepo taskRepo) {
    return new KanbanSvc(kanbanRepo, taskRepo);
  }
}
