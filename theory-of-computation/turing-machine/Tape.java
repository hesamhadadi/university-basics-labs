package Turing;

import java.util.Arrays;

public class Tape {
    private char[] data = new char[1000];
    private int head = data.length / 2;
    int leftMost = head;
    int rightMost = head;

    public Tape() {
        Arrays.fill(data, '#');
    }

    public int getHead() {
        return head;
    }

    public void setHead(int i) {
        leftMost = Math.min(leftMost, i);
        rightMost = Math.max(rightMost, i);
        head = i;
    }

    public String desc(int curState) {
        String res = "";

        for (int i = leftMost; i < head; i++) {
            res += data[i];
        }

        res += " q" + curState + " ";

        for (int i = head; i <= rightMost; i++) {
            res += data[i];
        }

        return res;
    }

    public void setData(int pos, char c) {
        leftMost = Math.min(leftMost, pos);
        rightMost = Math.max(rightMost, pos);
        data[pos] = c;
    }

    public char getData(int pos) {
        return data[pos];
    }

}
