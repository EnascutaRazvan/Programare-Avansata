package lab1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
	
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
    }

    void compulsory(){
        System.out.println("Hello World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
		n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        int result = 0;
        while(n>=10)
            n=n/10+n%10;
        result = n;
        System.out.println("\nWilly-nilly, this semester I will learn " + languages[result]);
    }