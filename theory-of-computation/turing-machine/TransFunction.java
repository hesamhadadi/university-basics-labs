package Turing;

public class TransFunction {
    int curState, nextState, direction;
    char curChar, nextChar;

    public TransFunction(int curState, char curChar, int nextState, char nextChar, int direction) {
        this.curState = curState;
        this.curChar = curChar;
        this.nextState = nextState;
        this.nextChar = nextChar;
        this.direction = direction;
    }
}
