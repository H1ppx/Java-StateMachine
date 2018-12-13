import java.util.ArrayList;

public class Test {

    static FiniteStateMachine finiteStateMachine;
    static double i = 0;

    static FiniteStateMachine.State initialState = new FiniteStateMachine.State() {

        @Override
        public void inState() {
            System.out.println("Start State");
        }

        @Override
        public FiniteStateMachine.State nextState() {
            return acceptState;
        }

        @Override
        public boolean isDone() {
            if(i < 3){
                i++;
                return false;
            }else {
                return true;
            }
        }

        @Override
        public boolean isAcceptState() {
            return false;
        }
    };

    static FiniteStateMachine.State acceptState = new FiniteStateMachine.State() {
        @Override
        public void inState() {
            System.out.println("Accept State");
        }

        @Override
        public FiniteStateMachine.State nextState() {
            return this;
        }

        @Override
        public boolean isDone() {
            if(i < 6){
                i++;
                return false;
            }else{
                return true;
            }
        }

        @Override
        public boolean isAcceptState() {
            return true;
        }
    };


    public static void main(String[] args) {
        finiteStateMachine = new FiniteStateMachine("Test FSM",
                initialState,
                acceptState
        );

        finiteStateMachine.run();
    }
}
