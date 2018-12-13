import java.util.ArrayList;

/**
 * Finite State Machine
 * Defined by a name, array of states.
 *
 * @author Will Chu
 * @version 1.0
 *
 */
public class FiniteStateMachine {

    /**
     * Interface for all States in FSM
     */
    public interface State{

        /**
         * Method while state is running
         */
        public void inState();

        /**
         * Returns the next state in FSM
         * @return State
         */
        public State nextState();

        /**
         * If state is completed
         * @return boolean
         */
        public boolean isDone();

        /**
         * If this state is an accept state
         * @return boolean
         */
        public boolean isAcceptState();
    }

    private String name;
    private ArrayList<State> states = new ArrayList<>();
    private State currentState;
    private boolean running = false;

    /**
     * @param name String name of FSM
     * @param startState Initial start state of FSM
     * @param states States not including start state of FSM
     */
    public FiniteStateMachine(String name, State startState, State ... states){
        this.name = name;
        this.states.add(startState);
        this.currentState = startState;
        for (State state : states) {
            this.states.add(state);
        }
    }

    /**
     * Runs the FSM until accept state is reached
     * If accept state does not exist, runs till termination of program
     */
    public void run(){
        running = true;

        while(running){
            if (currentState.isDone()){
                if(currentState.isAcceptState()){
                    running = false;
                    System.out.print("State Machine Done");
                }
                currentState = currentState.nextState();
            }else{
                currentState.inState();
            }
        }
    }

    /**
     * @return String name of FSM
     */
    public String getName() {
        return name;
    }

    /**
     * Returns current state in FSM
     * @return State
     */
    public State getCurrentState() {
        return currentState;
    }

}
