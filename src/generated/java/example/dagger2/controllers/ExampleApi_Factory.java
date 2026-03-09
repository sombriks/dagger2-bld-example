package example.dagger2.controllers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import example.dagger2.configs.PugRenderer;
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
  private final Provider<PugRenderer> pugRendererProvider;

  private final Provider<KanbanCtl> kanbanCtlProvider;

  private ExampleApi_Factory(Provider<PugRenderer> pugRendererProvider,
      Provider<KanbanCtl> kanbanCtlProvider) {
    this.pugRendererProvider = pugRendererProvider;
    this.kanbanCtlProvider = kanbanCtlProvider;
  }

  @Override
  public ExampleApi get() {
    return newInstance(pugRendererProvider.get(), kanbanCtlProvider.get());
  }

  public static ExampleApi_Factory create(Provider<PugRenderer> pugRendererProvider,
      Provider<KanbanCtl> kanbanCtlProvider) {
    return new ExampleApi_Factory(pugRendererProvider, kanbanCtlProvider);
  }

  public static ExampleApi newInstance(PugRenderer pugRenderer, KanbanCtl kanbanCtl) {
    return new ExampleApi(pugRenderer, kanbanCtl);
  }
}
