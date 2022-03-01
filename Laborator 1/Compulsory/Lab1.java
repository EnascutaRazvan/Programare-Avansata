package lab1;

public class Lab1 {
    public static void main(String[] args) {

        Lab1 lab1 = new Lab1();
        lab1.compulsory();
    }

    void compulsory() {

        System.out.println("Hello World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1000000);
        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        int result;
        int Ultima_cifra;

        System.out.println(n);
        while (n >= 10){
            Ultima_cifra = n % 10;
            n = n / 10 + Ultima_cifra;
        }


        result = n;
        System.out.println("\nWilly-nilly, this semester I will learn " + languages[result]);
    }
}