package Turing;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] sigma = new char[2];
        char[] gama = new char[2];
        int finalState = 3;
        TransFunction[] trans = new TransFunction[]{
                new TransFunction(0, '0', 0, '0', 1),
                new TransFunction(0, '1', 1, '1', 1),
                new TransFunction(1, '0', 2, '0', 1),
                new TransFunction(1, '1', 0, '1', 1),
                new TransFunction(2, '0', 1, '0', 1),
                new TransFunction(2, '1', 2, '1', 1),
                new TransFunction(0, '#', 3, '#', -1),
        };
        ArrayList<TransFunction> transFunctions = new ArrayList<>(Arrays.asList(trans));
        String input = "10010";

        TuringMachine turingMachine = new TuringMachine(0, sigma, gama, finalState, transFunctions, input);
        System.out.println(turingMachine.operations() ? "Accepted !" : "Not Accepted !");
        ArrayList<String> desc = turingMachine.getDesc();

        for (int i = 0; i < desc.size() - 1; i++) {
            System.out.print(desc.get(i) + " -> ");
        }
        System.out.print(desc.get(desc.size() - 1));
    }
}
