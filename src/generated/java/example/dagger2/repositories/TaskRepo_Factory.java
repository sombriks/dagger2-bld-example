package example.dagger2.repositories;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import org.jdbi.v3.core.Jdbi;

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
public final class TaskRepo_Factory implements Factory<TaskRepo> {
  private final Provider<Jdbi> jdbiProvider;

  private TaskRepo_Factory(Provider<Jdbi> jdbiProvider) {
    this.jdbiProvider = jdbiProvider;
  }

  @Override
  public TaskRepo get() {
    return newInstance(jdbiProvider.get());
  }

  public static TaskRepo_Factory create(Provider<Jdbi> jdbiProvider) {
    return new TaskRepo_Factory(jdbiProvider);
  }

  public static TaskRepo newInstance(Jdbi jdbi) {
    return new TaskRepo(jdbi);
  }
}
