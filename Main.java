import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to generate permutations: ");
        String word = scanner.nextLine();

        System.out.print("Enter the number of permutations to generate: ");
        int n = scanner.nextInt();

        String[] permutations = generatePermutations(word, n);

        System.out.println("Generated Permutations:");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static String[] generatePermutations(String word, int n) {

        String[] permutations = new String[n];
        int count = 0;

        while (count < n) {
            char[] characters = word.toCharArray();
            int len = characters.length;

            for (int i = 0; i < len - 1; i++) {
                int j = i + (int) (Math.random() * (len - i));
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;
            }

            String permutation = new String(characters);
            if (!contains(permutations, permutation)) {
                permutations[count] = permutation;
                count++;
            }
        }

        return permutations;
    }

    public static boolean contains(String[] array, String str) {
        for (String s : array) {
            if (s != null && s.equals(str)) {
                return true;
            }
        }
        return false;
    }
}


