package Abstract;

public record Transition(String name, State exitState, State enterState, Runnable action) {
}
