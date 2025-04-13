import java.util.*;

public class MyszkowskiTransposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1 - Encrypt");
            System.out.println("2 - Decrypt");
            System.out.print("Choice: ");
            choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter message to encrypt: ");
                String message = sc.nextLine();
                System.out.print("Enter key: ");
                String key = sc.nextLine();

                String encrypted = Myszkowski.encrypt(message, key);
                System.out.println("Original: " + message.toUpperCase().replaceAll(" ", ""));
                System.out.println("Encrypted: " + encrypted);

            } else if (choice.equals("2")) {
                System.out.print("Enter message to decrypt: ");
                String encrypted = sc.nextLine();
                System.out.print("Enter key: ");
                String key = sc.nextLine();

                String decrypted = Myszkowski.decrypt(encrypted, key);
                System.out.println("Encrypted: " + encrypted.toUpperCase());
                System.out.println("Decrypted: " + decrypted);
            } else {
                System.out.println("Invalid choice. Try again.");
            }

            System.out.print("\n Continue? (y/n): ");
            choice = sc.nextLine().trim().toLowerCase();

        } while (!choice.equals("n"));

        System.out.println("Program finished executing!");
    }
}

class Myszkowski {
    public static String encrypt(String message, String key) {
        message = message.replaceAll(" ", "").toUpperCase();
        key = key.toUpperCase();

        int cols = key.length();
        int rows = (int) Math.ceil((double) message.length() / cols);

        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (index < message.length()) ?
                        message.charAt(index++)
                        : 'X';
            }
        }

        TreeMap<Character, List<Integer>> keyMap = new TreeMap<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!keyMap.containsKey(c)) {
                keyMap.put(c, new ArrayList<>());
            }
            keyMap.get(c).add(i);
        }

        StringBuilder cipherText = new StringBuilder();
        for (List<Integer> columns : keyMap.values()) {
            for (int row = 0; row < rows; row++) {
                for (int col : columns) {
                    cipherText.append(matrix[row][col]);
                }
            }
        }

        return cipherText.toString().replaceAll(" ", "");
    }

    public static String decrypt(String cipherText, String key) {
        cipherText = cipherText.toUpperCase().replaceAll(" ", "");
        key = key.toUpperCase();

        int cols = key.length();
        int rows = (int) Math.ceil((double) cipherText.length() / cols);
        char[][] matrix = new char[rows][cols];

        Map<Character, List<Integer>> keyMap = new TreeMap<>();
        for (int i = 0; i < cols; i++) {
            keyMap.putIfAbsent(key.charAt(i), new ArrayList<>());
            keyMap.get(key.charAt(i)).add(i);
        }
        int cipherIndex = 0;
        for (List<Integer> positions : keyMap.values()) {
            for (int row = 0; row < rows; row++) {
                for (int col : positions) {
                    if (cipherIndex < cipherText.length()) {
                        matrix[row][col] = cipherText.charAt(cipherIndex++);
                    }
                }
            }
        }
        StringBuilder plain = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                plain.append(matrix[i][j]);
            }
        }
        return plain.toString().replaceAll("X+$", "");
    }
}
