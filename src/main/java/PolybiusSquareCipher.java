package main.java;

import java.util.Scanner;
public class PolybiusSquareCipher {
    private static final char[][] SQUARE = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'}, // 'J' eshte sikur 'I'
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displaySquare();

        while (true) {
            displayMenu();
            System.out.print("Zgjedhja juaj: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    encryptMessage(scanner);
                    break;
                case 2:
                    decryptMessage(scanner);
                    break;
                case 3:
                    System.out.println("Duke u mbyllur programi...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Zgjedhje e pavlefshme. Provoni përsëri.");
            }

            System.out.println();
        }
    }

    private static void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║      POLYBIUS SQUARE CIPHER TOOL               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("1 - Enkriptim");
        System.out.println("2 - Dekriptim");
        System.out.println("3 - Dalje");
    }

    private static void displaySquare() {
        System.out.println("\n┌─────────────── Polybius Square ────────────┐");
        for (int i = 0; i < 5; i++) {
            System.out.print("│ ");
            for (int j = 0; j < 5; j++) {
                System.out.printf("%c → %d%d │ ", SQUARE[i][j], i + 1, j + 1);
            }
            System.out.println();
        }
        System.out.println("└────────────────────────────────────────────┘");
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║              Përmbledhje                         ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ • Zëvendësohet 'J' me 'I'                        ║");
        System.out.println("║ • Hiqen të gjitha karakteret jo-alfabetike       ║");
        System.out.println("║ • Çdo shkronjë zëvendësohet me koordinatat e saj ║");
        System.out.println("║   në tabelën Polybius (rresht+kolonë)            ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    private static void encryptMessage(Scanner scanner) {
        System.out.print("\nShkruani mesazhin që dëshironi të enkriptoni: ");
        String plaintext = scanner.nextLine();
        String encrypted = encrypt(plaintext);
        System.out.println("Mesazhi i enkriptuar: " + encrypted);
    }

    private static void decryptMessage(Scanner scanner) {
        System.out.print("\nShkruani mesazhin e enkriptuar (psh. 11 12 23...): ");
        String cipherText = scanner.nextLine();
        try {
            String decrypted = decrypt(cipherText);
            System.out.println("Mesazhi i dekriptuar: " + decrypted);
        } catch (IllegalArgumentException e) {
            System.out.println("Gabim: " + e.getMessage());
        }
    }

    public static String encrypt(String plaintext) {
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", "");
        plaintext = plaintext.replace("J", "I");

        StringBuilder ciphertext = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (SQUARE[i][j] == c) {
                        ciphertext.append(i + 1).append(j + 1).append(" ");
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        }

        return ciphertext.toString().trim();
    }

    public static String decrypt(String cipherText) {

        StringBuilder plainText = new StringBuilder();
        cipherText = cipherText.replaceAll("\\s+", "");

        if (cipherText.length() % 2 != 0) {
            throw new IllegalArgumentException("Gjatesia e mesazhit duhet te jete cift.");
        }

        for (int i = 0; i < cipherText.length(); i += 2) {
            int row = Character.getNumericValue(cipherText.charAt(i)) - 1;
            int col = Character.getNumericValue(cipherText.charAt(i + 1)) - 1;

            if (row < 0 || row > 4 || col < 0 || col > 4) {
                throw new IllegalArgumentException("Indexet jane gabim.");
            }

            char letter = SQUARE[row][col];
            plainText.append(letter == 'I' ? "I/J" : letter);
        }

        return plainText.toString();
    }
}