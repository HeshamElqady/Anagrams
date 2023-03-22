import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Dammi la parola");
        String word = in.nextLine();
        System.out.println("dammi il numero di anagrams che vuoi");
        int numAnagrams = in.nextInt();
        permutation(word, numAnagrams);

    }

    public static void permutation(String str, int num) {
        permutation("", str, num);
    }

    private static void permutation(String prefix, String str, int num) {
        int stringNum = 0;
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);


        } else {
            if (stringNum <= num) {
                for (int i = 0; i < n; i++) {
                    permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), num);

                }
                stringNum++;
            }
        }
    }
}




