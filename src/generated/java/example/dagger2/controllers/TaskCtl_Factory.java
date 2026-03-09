package example.dagger2.controllers;

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
public final class TaskCtl_Factory implements Factory<TaskCtl> {
  private final Provider<TaskRepo> taskRepoProvider;

  private TaskCtl_Factory(Provider<TaskRepo> taskRepoProvider) {
    this.taskRepoProvider = taskRepoProvider;
  }

  @Override
  public TaskCtl get() {
    return newInstance(taskRepoProvider.get());
  }

  public static TaskCtl_Factory create(Provider<TaskRepo> taskRepoProvider) {
    return new TaskCtl_Factory(taskRepoProvider);
  }

  public static TaskCtl newInstance(TaskRepo taskRepo) {
    return new TaskCtl(taskRepo);
  }
}
