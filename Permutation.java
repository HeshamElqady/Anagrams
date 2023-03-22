/*public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Dammi la parola");
        String word=in.nextLine();
        System.out.println("dammi il numero di anagrams che vuoi");
        int numAnagrams = in.nextInt();
        ArrayList<String> anagrams = new ArrayList<>();
        anagrams=printPermutn(word,"");
        for (int i=1; i<=numAnagrams;i++){
        System.out.println(anagrams.get(i));
        }

        }

public static ArrayList<String> printPermutn(String str, String ans)
        {

        ArrayList<String> anagrams = new ArrayList<>();
        if (str.length() == 0) {
        //System.out.print(ans + " ");
        anagrams.add(ans);
        return anagrams ;
        }

        for (int i = 0; i < str.length(); i++) {

        // ith character of str
        char ch = str.charAt(i);

        // Rest of the string after excluding
        // the ith character
        String ros = str.substring(0, i) +
        str.substring(i + 1);

        // Recursive call
        printPermutn(ros, ans + ch);
        }
        return anagrams;
        }


        }*/