package Tema1;

import java.util.Arrays;

public class Tema1 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Subpunct1 begin-------------------------------------
        if (args.length < 3) {
            System.out.println("Please enter the input in the form of the following " +
                    "pattern " + "<N> <P> <Letters>");
            return;
        }
        if (!args[0].matches("[0-9]+")) {
            System.out.print("N must be an integer, the pattern of the input is" +
                    " <N> <P> <Letters>");
            return;
        }

        if (!args[1].matches("[0-9]+")) {
            System.out.print("P must be an integer, the pattern of the input is" +
                    " <N> <P> <Letters>");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);


        // Calculez suma tuturor literelor din args
        int sumOfArgsString = 0;
        for (int i = 2; i < args.length; i++) {
            sumOfArgsString = sumOfArgsString + args[i].length();
        }
        String[] alphabet = new String[sumOfArgsString];

        // Adaug in alphabet toate literele din args, cate o litera pe cate fiecare pozitie din alphabet
        // Se ia in considerare si inputul de genul Java Tema1.java 2 2 abcd e f ghi j
        int pos = 0;
        for (int i = 2; i < args.length; i++) {
            if (Character.isDigit(args[i].charAt(0))) {
                System.out.println("The pattern is <N> <P> <Letters>, character " +
                        "\"" + String.valueOf(args[i].charAt(0)) + "\"" + " is not a letter");
                return;
            }
            alphabet[pos] = String.valueOf(args[i].charAt(0));
            pos++;
            for (int j = 1; j < args[i].length(); j++) {
                if (Character.isDigit(args[i].charAt(j))) {
                    System.out.println("The pattern is <N> <P> <Letters>, character " +
                            "\"" + String.valueOf(args[i].charAt(j)) + "\"" + " is not a letter");
                    return;
                }
                alphabet[pos] = String.valueOf(args[i].charAt(j));
                pos++;

            }
        }

        // Subpunct1 end-------------------------------------

        // Subpunct2 begin -------------------------------------

        // Generez n cuvinte a cate p litere, literele fiind random
        String[] words = new String[n];

        int range = alphabet.length;

        for (int i = 0; i < words.length; i++) {
            words[i] = alphabet[(int) (Math.random() * range)];
            for (int letters = 1; letters < p; letters++) {
                words[i] = words[i].concat(alphabet[(int) (Math.random() * range)]);
            }
        }
        if (n < 300)
            System.out.println(Arrays.toString(words));

        // Subpunct2 end -------------------------------------


        boolean[][] adjacency = new boolean[n][n];
        String[] neighbors;
        neighbors = words.clone();


        // subpunct3 begin ---------------------------------------
        Tema1 subpunct3 = new Tema1();

        // Creez matricea patratica de adiacenta
        subpunct3.createAdjacencyOfNeighbors(words, adjacency);

        // Am pus conditia ca n sa fie mai mic decat 300 pentru ca sa pot rula
        // cu n = 30000 si sa mi afiseze doar nanosecundele
        if (n < 300)
            subpunct3.printAdjacencyList(adjacency);
        if (n < 300) {
            System.out.println("The array that stores the neighbors of each word. First one on every index is the word " +
                    "which is neighbor with" + "the other ones");
            System.out.println(Arrays.toString(subpunct3.createArrayOfNeighbors(neighbors, words, adjacency)));
        }
        // subpunct3 end ---------------------------------------

        // subpunct4 begin ---------------------------------------
        long endTime = System.nanoTime();

        System.out.println("The execution time in nanoseconds is totalTime = " + (endTime - startTime));
        // subpunct4 end ---------------------------------------

        // BONUS begin -----------------------------------------------

        Tema1 bonusSubpunct = new Tema1();

        bonusSubpunct.Bonus(adjacency, n);
    }
        // BONUS end -----------------------------------------------
    void Bonus(boolean[][] adjacency, int n) {
        int firstK = 0;
        int tempK = 1;
        int finalK = 0;

        for (int row = 0; row < adjacency.length - 1; row++) {
            if (adjacency[row][row] == adjacency[row][row + 1])
                tempK++;
            else {
                if (firstK == 0)
                    firstK = tempK;

                if (finalK < tempK)
                    finalK = tempK;

                tempK = 1;
            }
        }
        if (finalK < tempK)
            finalK = tempK;

        if (finalK == n){
            if (adjacency[n - 1][0])
                finalK++;
        }
        if(tempK + firstK > finalK && adjacency[n-1][0])
            finalK = tempK + firstK;



        System.out.println("The largest possible k is k = " + finalK);
    }

    String[] createArrayOfNeighbors(String[] neighbors, String[] arrayOfWords, boolean[][] adjacency) {
        for (int row = 0; row < adjacency.length; row++)
            for (int col = 0; col < adjacency[row].length; col++) {
                if (adjacency[row][col] && row != col) {
                    neighbors[row] = neighbors[row].concat(",");
                    neighbors[row] = neighbors[row].concat(arrayOfWords[col]);
                }
            }
        return neighbors;
    }

    void createAdjacencyOfNeighbors(String[] arrayOfWords, boolean[][] adjacency) {
          for(int i = 0; i < arrayOfWords.length; i++){
            for (int letter = 0; letter < arrayOfWords[i].length(); letter++)
                for(int j = 0 ;j < arrayOfWords.length; j++){
                    if (arrayOfWords[j].contains(arrayOfWords[i].charAt(letter) + "")){
                        adjacency[i][j] = true;
                    }

                }
        }
    }

    void printAdjacencyList(boolean[][] adjacency) {
        for (boolean[] row : adjacency) {
            for (boolean col : row)
                System.out.print(col + " ");
            System.out.println();
        }
    }
}
