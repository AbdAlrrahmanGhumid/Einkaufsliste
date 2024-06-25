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
        List<Transition> transition = transitions.stream()
                .filter(t -> t.exitState() == currentState && t.name() == name)
                .toList();
        if (transition.size() == 0) {
            try {
                throw new IllegalArgumentException("No transiotn with name " + name);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                runTransition("loopTransition"); // it runs a loop transition. is important for onEnter & onLeave, if
                                                 // they
                                                 // should be excuted for loops. is also important when to keep program
                                                 // running.
                                                 // loopTransition should be defined in the instance automaton.
            }
        }else{
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
}
