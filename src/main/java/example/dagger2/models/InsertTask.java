package example.dagger2.models;

public record InsertTask(int kanbanId, String description, String state) {

    public InsertTask withKanbanId(int kanbanId) {
        return new InsertTask(kanbanId, description, state);
    }

    public static InsertTask newTask(String description, State state) {
        return new InsertTask(0, description, state.name());
    }
}
