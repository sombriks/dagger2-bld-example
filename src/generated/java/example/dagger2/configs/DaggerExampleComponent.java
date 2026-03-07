package example.dagger2.configs;

import dagger.internal.DaggerGenerated;
import javax.annotation.processing.Generated;

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
    private Builder() {
    }

    public ExampleComponent build() {
      return new ExampleComponentImpl();
    }
  }

  private static final class ExampleComponentImpl implements ExampleComponent {
    private final ExampleComponentImpl exampleComponentImpl = this;

    ExampleComponentImpl() {


    }
  }
}
