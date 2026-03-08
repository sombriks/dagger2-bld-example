package example.dagger2.services;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class TaskSvc_Factory implements Factory<TaskSvc> {
  private final Provider<TaskRepo> taskRepoProvider;

  private TaskSvc_Factory(Provider<TaskRepo> taskRepoProvider) {
    this.taskRepoProvider = taskRepoProvider;
  }

  @Override
  public TaskSvc get() {
    return newInstance(taskRepoProvider.get());
  }

  public static TaskSvc_Factory create(Provider<TaskRepo> taskRepoProvider) {
    return new TaskSvc_Factory(taskRepoProvider);
  }

  public static TaskSvc newInstance(TaskRepo taskRepo) {
    return new TaskSvc(taskRepo);
  }
}
