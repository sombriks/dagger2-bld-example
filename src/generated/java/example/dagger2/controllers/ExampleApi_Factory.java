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

  private final Provider<TaskCtl> taskCtlProvider;

  private ExampleApi_Factory(Provider<PugRenderer> pugRendererProvider,
      Provider<KanbanCtl> kanbanCtlProvider, Provider<TaskCtl> taskCtlProvider) {
    this.pugRendererProvider = pugRendererProvider;
    this.kanbanCtlProvider = kanbanCtlProvider;
    this.taskCtlProvider = taskCtlProvider;
  }

  @Override
  public ExampleApi get() {
    return newInstance(pugRendererProvider.get(), kanbanCtlProvider.get(), taskCtlProvider.get());
  }

  public static ExampleApi_Factory create(Provider<PugRenderer> pugRendererProvider,
      Provider<KanbanCtl> kanbanCtlProvider, Provider<TaskCtl> taskCtlProvider) {
    return new ExampleApi_Factory(pugRendererProvider, kanbanCtlProvider, taskCtlProvider);
  }

  public static ExampleApi newInstance(PugRenderer pugRenderer, KanbanCtl kanbanCtl,
      TaskCtl taskCtl) {
    return new ExampleApi(pugRenderer, kanbanCtl, taskCtl);
  }
}
