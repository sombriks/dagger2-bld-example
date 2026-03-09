package example.dagger2.configs;

import dagger.Module;
import dagger.Provides;
import example.dagger2.models.Kanban;
import example.dagger2.models.SelectTask;
import example.dagger2.models.Task;
import io.javalin.Javalin;
import jakarta.inject.Singleton;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Module
public class ExampleModule {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleModule.class);

    @Provides
    @Singleton
    public Jdbi jdbi() {
        LOG.debug("Creating Jdbi");
        return Jdbi.create("jdbc:sqlite:./kanban.db")
                .registerRowMapper(ConstructorMapper.factory(Kanban.class))
                .registerRowMapper(ConstructorMapper.factory(SelectTask.class));
    }

}
