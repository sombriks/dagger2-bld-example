package example.dagger2.configs;

import dagger.Module;
import dagger.Provides;
import jakarta.inject.Singleton;
import org.jdbi.v3.core.Jdbi;

@Module
public class ExampleModule {

    @Provides
    @Singleton
    public Jdbi jdbi(){
        return Jdbi.create("jdbc:sqlite:./kanban.db");
    }
}
