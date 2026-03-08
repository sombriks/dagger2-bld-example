package example.dagger2.models;

public record DetailTask(int id, String description, State state) {
    public static DetailTask from(SelectTask task) {
        return new DetailTask(task.id(), task.description(), State.valueOf(task.state()));
    }
}
