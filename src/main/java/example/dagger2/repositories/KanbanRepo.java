package example.dagger2.repositories;

import example.dagger2.models.InsertKanban;
import example.dagger2.models.Kanban;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class KanbanRepo {

    private static final Logger LOG = LoggerFactory.getLogger(KanbanRepo.class);

    private final Jdbi jdbi;

    @Inject
    public KanbanRepo(Jdbi jdbi) {
        LOG.info("Creating KanbanRepo");
        this.jdbi = jdbi;
    }

    public void init() {
        LOG.debug("init");
        jdbi.useHandle(handle -> {
            handle.execute("""
                    create table if not exists kanban (
                        id integer primary key autoincrement,
                        name varchar(255) not null unique
                    );
                    """);
        });
    }

    public List<Kanban> list(String q) {
        LOG.debug("list");
        return jdbi.withHandle(handle -> handle
                .createQuery("""
                          select id, name
                            from kanban
                           where lower(concat(' ', name, ' '))
                            like lower(concat('%', :q, '%'))
                        order by name;
                        """)
                .bind("q", q)
                .mapTo(Kanban.class)
                .list());
    }

    public Optional<Kanban> get(int id) {
        LOG.debug("get");
        return jdbi.withHandle(handle -> handle
                .createQuery("""
                        select id,name
                        from kanban
                        where id = :id
                        """)
                .bind("id", id)
                .mapTo(Kanban.class)
                .findFirst());
    }

    public int insert(InsertKanban kanban) {
        LOG.debug("insert");
        return jdbi.withHandle(handle -> handle
                .createUpdate("""
                        insert into kanban (name) values (:name)
                        """)
                .bindMethods(kanban)
                .execute());
    }

    public int update(Kanban kanban) {
        LOG.debug("update");
        return jdbi.withHandle(handle -> handle
                .createUpdate("""
                        update kanban
                           set name = :name
                         where id = :id
                        """)
                .bindMethods(kanban)
                .execute());
    }

    public int delete(int id) {
        LOG.debug("delete");
        return jdbi.withHandle(handle -> handle
                .createUpdate("""
                        delete from kanban
                              where id = :id
                        """)
                .bind("id", id)
                .execute());
    }
}
