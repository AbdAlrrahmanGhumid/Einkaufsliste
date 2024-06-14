package Abstract;

import java.util.LinkedList;
import java.util.List;

public class Automaton {
    List<Transition> transitions = new LinkedList<>();
    State currentState;

    public List<Transition> getTransitions() {
        return transitions;
    }

    public Automaton(State state1) {
        this.currentState = state1;
    }

    public Automaton addTransition(String name, State exitState, State enterState, Runnable action) {
        transitions.add(new Transition(name, exitState, enterState, action));
        return this;
    }

    public void runTransition(String name) {
        if (true) {
        }
        List<Transition> transition = transitions.stream()
                .filter(t -> t.exitState() == currentState && t.name() == name)
                .toList();

        if (transition.isEmpty()) {
            throw new IllegalArgumentException("No transiotn with name ....");
        }

        State newState = transition.get(0).enterState();

        // boolean callOnLeaveAndOnEnter = newState != currentState;

        currentState.onLeave(); // if onLeave method is not apporpriate for self-loop use
                                // if(callOnLeaveAndOnEnter)
        transition.get(0).action().run();
        newState.onEnter(); // if onEnter method is not apporpriate for self-loop use
                            // if(callOnLeaveAndOnEnter)

        currentState = newState;
    }
}
