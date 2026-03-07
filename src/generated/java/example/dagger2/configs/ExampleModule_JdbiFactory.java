package example.dagger2.configs;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import org.jdbi.v3.core.Jdbi;

@ScopeMetadata("jakarta.inject.Singleton")
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
public final class ExampleModule_JdbiFactory implements Factory<Jdbi> {
  private final ExampleModule module;

  private ExampleModule_JdbiFactory(ExampleModule module) {
    this.module = module;
  }

  @Override
  public Jdbi get() {
    return jdbi(module);
  }

  public static ExampleModule_JdbiFactory create(ExampleModule module) {
    return new ExampleModule_JdbiFactory(module);
  }

  public static Jdbi jdbi(ExampleModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.jdbi());
  }
}
