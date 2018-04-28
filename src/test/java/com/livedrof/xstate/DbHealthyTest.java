package com.livedrof.xstate;

import com.xrosstools.xstate.Event;
import com.xrosstools.xstate.StateMachine;
import com.xrosstools.xstate.StateMachineFactory;
import org.junit.Test;

public class DbHealthyTest {
    @Test
    public void test() {
        try {
            StateMachineFactory f = StateMachineFactory.load("sample.xstate");
            StateMachine sm = f.create("DB Health Lifecycle");

            System.out.println("Start state: " + sm.getCurrentState().getId());
            notify(sm, "initialize");

            notify(sm, "markdown");

            notify(sm, "markup");

            notify(sm, "shutdown");

            System.out.println("End state: " + sm.getCurrentState().getId());

            showSourceAndTargetEvent(sm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void notify(StateMachine sm, String eventId) {
        sm.notify(new Event(eventId));
        System.out.println(sm.getCurrentState().getId());
    }

    void showSourceAndTargetEvent(StateMachine sm) {
//        System.out.println("\n\nShow source and target event ids for each state\n");
//        for (String id : sm.getStateIds()) {
//            System.out.println("State: " + id);
//            System.out.println("Source events: " + sm.findState(id).getSourceEvents());
//            System.out.println("Target events: " + sm.findState(id).getAcceptableEvents());
//        }
    }
}
