import java.util.Scanner;

public class PolybiusSquareCipherDecryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PolybiusDekriptim decryptor = new PolybiusDekriptim();

        System.out.println("Vendosni mesazhin e enkriptuar me Polybius Square-cipher (psh, 32 15 32...): ");
        String input = scanner.nextLine();

        try {
            String decryptedMessage = decryptor.decrypt(input);
            System.out.println("Mesazhi i dekriptuar: " + decryptedMessage);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

class PolybiusDekriptim {

    // Definimi i matrices (5x5) POLYBIUS_SQUARE
    private static final char[][] POLYBIUS_SQUARE = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'}, // I/J jane njesoj
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}
    };

    // Funksioni per dekriptim
    public String decrypt(String cipherText) {
        StringBuilder plainText = new StringBuilder();

        // Inputi pa spaces
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

            char letter = POLYBIUS_SQUARE[row][col];
            plainText.append(letter == 'I' ? "I/J" : letter);
        }

        return plainText.toString();
    }
}