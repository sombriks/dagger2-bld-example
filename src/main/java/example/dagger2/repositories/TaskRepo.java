package example.dagger2.repositories;

import example.dagger2.models.InsertTask;
import example.dagger2.models.SelectTask;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class TaskRepo {

    private static final Logger LOG = LoggerFactory.getLogger(TaskRepo.class);

    private final Jdbi jdbi;

    @Inject
    public TaskRepo(Jdbi jdbi) {
        LOG.info("Creating TaskRepo");
        this.jdbi = jdbi;
    }

    public void init() {
        jdbi.useHandle(handle -> handle
                .execute("""
                        create table if not exists task(
                            id integer primary key autoincrement,
                            kanban_id integer not null references kanban(id) on delete cascade,
                            description varchar(255) not null,
                            state varchar(255) not null
                        );
                        """));
    }

    public List<SelectTask> list(int kanbanId, String q) {
        return jdbi.withHandle(handle -> handle
                .createQuery("""
                        select id, kanban_id, description, state
                          from task
                         where kanban_id = :id
                           and lower(concat(' ',description,' '))
                          like lower(concat('%',:q,'%')
                        """)
                .bind("id", kanbanId)
                .bind("q", q)
                .mapTo(SelectTask.class)
                .list());
    }

    public Optional<SelectTask> get(int kanbanId, int id) {
        return Optional.empty();
    }

    public int insert(InsertTask task) {
        return jdbi.withHandle(handle -> handle
                .createUpdate("""
                        insert into task (kanban_id, description, state)
                        values (:kanbanId, :description, :state)
                        """)
                .bindMethods(task)
                .execute());
    }

    public int update() {
        return 0;
    }

    public int delete(int id) {
        return 0;
    }

}
