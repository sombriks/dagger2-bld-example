package example.dagger2.models;

public record SelectTask(int id, int kanbanId, String description, String state) {
    public Task toTask() {
        return new Task(id, description, State.valueOf(state), new Kanban(kanbanId, null));
    }
}
