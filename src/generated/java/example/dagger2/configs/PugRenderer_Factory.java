package example.dagger2.configs;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class PugRenderer_Factory implements Factory<PugRenderer> {
  @Override
  public PugRenderer get() {
    return newInstance();
  }

  public static PugRenderer_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PugRenderer newInstance() {
    return new PugRenderer();
  }

  private static final class InstanceHolder {
    static final PugRenderer_Factory INSTANCE = new PugRenderer_Factory();
  }
}
