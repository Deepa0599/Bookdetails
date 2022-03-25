package com.company;

import java.lang.*;
import java.util.*;

class Cosine extends Thread{

    int i;
    Cosine (int i) {
        this.i = i;
    }

    public void run() {

        System.out.println("COSINE OF "+ i +" : "+Math.cos(i));
    }

}

class Tan extends Thread{

    int i;
    Tan (int i) {
        this.i = i;
    }

    public void run() {

        System.out.println("TAN OF "+ i +" : "+Math.tan(i));
    }

}

class Sine extends Thread{

    int i;
    Sine (int i) {
        this.i = i;
    }

    public void run() {

        System.out.println("SINE OF "+ i +" : "+Math.sin(i));
    }

}


class TrigonometricOperations {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value of angle in degree : ");
        int i = sc.nextInt();

        Cosine a = new Cosine(i);
        Tan b = new Tan(i);
        Sine c = new Sine(i);

        a.start();
        b.start();
        c.start();
    }
}















