package example.dagger2.models;

public record Task(int id, String description, State state, Kanban kanban) {
}
