package example.dagger2.models;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record SelectKanban(int id, String name, DetailTask... tasks) {
    public static SelectKanban from(Kanban kanban, SelectTask... tasks) {
        return new SelectKanban(kanban.id(), kanban.name(),
                Stream.of(tasks)
                        .map(DetailTask::from)
                        .toArray(DetailTask[]::new));
    }
}
