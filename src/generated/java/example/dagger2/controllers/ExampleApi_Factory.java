package example.dagger2.controllers;

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
public final class ExampleApi_Factory implements Factory<ExampleApi> {
  @Override
  public ExampleApi get() {
    return newInstance();
  }

  public static ExampleApi_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ExampleApi newInstance() {
    return new ExampleApi();
  }

  private static final class InstanceHolder {
    static final ExampleApi_Factory INSTANCE = new ExampleApi_Factory();
  }
}
