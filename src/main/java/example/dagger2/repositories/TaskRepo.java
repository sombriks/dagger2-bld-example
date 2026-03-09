package example.dagger2.repositories;

import example.dagger2.models.InsertTask;
import example.dagger2.models.SelectTask;
import example.dagger2.models.UpdateTask;
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
        LOG.debug("Init");
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
        LOG.debug("list");
        return jdbi.withHandle(handle -> handle
                .createQuery("""
                        select id, kanban_id, description, state
                          from task
                         where (:id = 0 or kanban_id = :id)
                           and lower(concat(' ',description,' '))
                          like lower(concat('%',:q,'%'))
                      order by id;
                        """)
                .bind("id", kanbanId)
                .bind("q", q)
                .mapTo(SelectTask.class)
                .list());
    }

    public Optional<SelectTask> get(int kanbanId, int id) {
        LOG.debug("get");
        return jdbi.withHandle(handle -> handle
                .createQuery("""
                        select id, kanban_id, description, state
                          from task
                         where id = :id
                           and kanban_id = :kanbanId;
                        """)
                .bind("id", id)
                .bind("kanbanId", kanbanId)
                .mapTo(SelectTask.class)
                .findOne());
    }

    public int insert(InsertTask task) {
        LOG.debug("insert");
        return jdbi.withHandle(handle -> handle
                .createUpdate("""
                        insert into task (kanban_id, description, state)
                        values (:kanbanId, :description, :state)
                        """)
                .bindMethods(task)
                .executeAndReturnGeneratedKeys()
                .mapTo(Integer.class)
                .first());
    }

    public int update(UpdateTask task) {
        LOG.debug("update");
        return jdbi.withHandle(handle -> handle
                .createUpdate("""
                        update task
                           set description = :description,
                               state = :state
                         where  id = :id
                           and kanban_id = :kanbanId
                        """)
                .bindMethods(task)
                .execute());
    }

    public int delete(int kanbanId, int id) {
        LOG.debug("delete");
        return jdbi.withHandle(handle -> handle
                .createUpdate("""
                        delete from task
                         where  id = :id
                           and kanban_id = :kanbanId
                        """)
                .bind("id", id)
                .bind("kanbanId", kanbanId)
                .execute());
    }

}
