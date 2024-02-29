package com.bdqn.test01;

public class Grade {
/**
 * @author liuziyang
 * @data 2024-02-29-16:04
 */
private int low;
private int upp;
private char rank;

    @Override
    public String toString() {
        return "Grade{" +
                "low=" + low +
                ", upp=" + upp +
                ", rank=" + rank +
                '}';
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getUpp() {
        return upp;
    }

    public void setUpp(int upp) {
        this.upp = upp;
    }

    public char getRank() {
        return rank;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }

    public Grade(int low, int upp, char rank) {
        this.low = low;
        this.upp = upp;
        this.rank = rank;
    }

    public Grade() {
    }
}
