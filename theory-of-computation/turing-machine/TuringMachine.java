package Turing;

import java.util.ArrayList;

public class TuringMachine {
    Tape tape = new Tape();
    char[] sigma;
    char[] gama;
    int finalState, curState;
    ArrayList<TransFunction> transitions;
    private ArrayList<String> desc;
    String input;

    public TuringMachine(int curState, char[] sigma, char[] gama, int finalState, ArrayList<TransFunction> transitions, String input) {
        this.sigma = sigma;
        this.gama = gama;
        this.finalState = finalState;
        this.transitions = transitions;
        this.input = input;
        this.curState = curState;
        int pointer = tape.getHead();
        for (int i = 0; i < input.length(); i++) {
            tape.setData(pointer + i, input.charAt(i));
        }
        desc = new ArrayList<>();
        desc.add(tape.desc(curState));
    }

    public boolean operations() {
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 0; i < transitions.size(); i++) {
                TransFunction rule = transitions.get(i);
                if (rule.curState == curState && tape.getData(tape.getHead()) == rule.curChar) {
                    curState = rule.nextState;
                    tape.setData(tape.getHead(), rule.nextChar);
                    tape.setHead(tape.getHead() + rule.direction);
                    found = true;
                    desc.add(tape.desc(curState));
                    break;
                }
            }
        }
        return curState == finalState;
    }

    public ArrayList<String> getDesc() {
        return desc;
    }
}
