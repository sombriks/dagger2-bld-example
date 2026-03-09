package example.dagger2.controllers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import example.dagger2.repositories.KanbanRepo;
import example.dagger2.repositories.TaskRepo;
import example.dagger2.services.KanbanSvc;
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
public final class KanbanCtl_Factory implements Factory<KanbanCtl> {
  private final Provider<KanbanSvc> kanbanSvcProvider;

  private final Provider<KanbanRepo> kanbanRepoProvider;

  private final Provider<TaskRepo> taskRepoProvider;

  private KanbanCtl_Factory(Provider<KanbanSvc> kanbanSvcProvider,
      Provider<KanbanRepo> kanbanRepoProvider, Provider<TaskRepo> taskRepoProvider) {
    this.kanbanSvcProvider = kanbanSvcProvider;
    this.kanbanRepoProvider = kanbanRepoProvider;
    this.taskRepoProvider = taskRepoProvider;
  }

  @Override
  public KanbanCtl get() {
    return newInstance(kanbanSvcProvider.get(), kanbanRepoProvider.get(), taskRepoProvider.get());
  }

  public static KanbanCtl_Factory create(Provider<KanbanSvc> kanbanSvcProvider,
      Provider<KanbanRepo> kanbanRepoProvider, Provider<TaskRepo> taskRepoProvider) {
    return new KanbanCtl_Factory(kanbanSvcProvider, kanbanRepoProvider, taskRepoProvider);
  }

  public static KanbanCtl newInstance(KanbanSvc kanbanSvc, KanbanRepo kanbanRepo,
      TaskRepo taskRepo) {
    return new KanbanCtl(kanbanSvc, kanbanRepo, taskRepo);
  }
}
