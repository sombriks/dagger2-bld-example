package example.dagger2.repositories;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KanbanRepo {

    private static final Logger LOG = LoggerFactory.getLogger(KanbanRepo.class);

    private final Jdbi jdbi = Jdbi.create("jdbc:sqlite:./kanban.db");

    public int hello() {
        LOG.debug("hello");
        return jdbi.withHandle(handle -> handle
                .createQuery("select 1 + 1")
                .mapTo(Integer.class)
                .findFirst()
                .get());
    }
}
