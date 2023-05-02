import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FileArray {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(System.in);
        FileArray file;
        System.out.println("iserisci il path del file indifferentemente se esista o meno");
        String filePathName = in.nextLine();
        System.out.println("per inserire il file stesso premi 1 \n per creare un nuovo file con n elementi inserire 2");
        int choice = in.nextInt();
        int n;
        if (choice == 1) {
            file = new FileArray(filePathName);
        } else if (choice == 2) {
            System.out.println("inserici il numero di elementi del file");
            n = in.nextInt();
            file = new FileArray(filePathName, n);

        } else {
            System.out.println("scelta non disponibile");
            return;
        }
        System.out.println("To print insert P, to increment insert I");
        String operation = in.next();
        if (operation.toUpperCase().equals("P")) {
            print(file);
        } else if (operation.toUpperCase().equals(("I"))) {
            incrementAll(file);

        } else System.out.println("scelta non disponibile");
    }

    private String filePathName;

    public String getFilePathName() {
        return filePathName;
    }

    public FileArray(String filePathName) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(filePathName);
        this.filePathName = filePathName;
    }

    public FileArray(String filePathName, int n) throws FileNotFoundException, IOException {
        this.filePathName = filePathName;
        FileOutputStream os = new FileOutputStream(filePathName);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(2 ^ 5);
            bos.write(randomNumber);
        }
        bos.close();
        os.close();
    }

    static void print(FileArray file) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file.getFilePathName());
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            for (int i=0; i<line.length();i++) {

                if (i%5==0 & i!=0) System.out.println("");
                int num = line.charAt(i); // Converte ogni token in un intero
                System.out.print(num + " "); // Visualizza l'intero letto dal file
            }
        }

        bufferedReader.close();
    }


    static void incrementAll(FileArray file) throws FileNotFoundException, IOException {
        FileInputStream is = new FileInputStream(file.getFilePathName());
        FileOutputStream os = new FileOutputStream(file.getFilePathName());
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) != -1) {
            for (int i = 0; i < length; i++) {
                buffer[i] += 1;
            }
            os.write(buffer, 0, length);
        }
        is.close();
        os.close();
    }
}



