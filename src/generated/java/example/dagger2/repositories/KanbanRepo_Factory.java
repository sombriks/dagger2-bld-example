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
public final class KanbanRepo_Factory implements Factory<KanbanRepo> {
  private final Provider<Jdbi> jdbiProvider;

  private KanbanRepo_Factory(Provider<Jdbi> jdbiProvider) {
    this.jdbiProvider = jdbiProvider;
  }

  @Override
  public KanbanRepo get() {
    return newInstance(jdbiProvider.get());
  }

  public static KanbanRepo_Factory create(Provider<Jdbi> jdbiProvider) {
    return new KanbanRepo_Factory(jdbiProvider);
  }

  public static KanbanRepo newInstance(Jdbi jdbi) {
    return new KanbanRepo(jdbi);
  }
}
