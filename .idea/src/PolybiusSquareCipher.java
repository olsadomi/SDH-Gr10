public class PolybiusSquareCipher {

    private static final char[][] SQUARE = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}
    };

    public static String encrypt(String plaintext) {
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", "");
        plaintext = plaintext.replace("J", "I"); // Bashkëtingëllorja J zevendesohet me I

        StringBuilder ciphertext = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (SQUARE[i][j] == c) {
                        ciphertext.append(i + 1).append(j + 1);
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        }

        return ciphertext.toString();
    }

    public static void main(String[] args) {
        String message = "Siguria e te dhenave";
        String encrypted = encrypt(message);
        System.out.println("Mesazhi origjinal: " + message);
        System.out.println("Mesazhi i enkriptuar: " + encrypted);
    }
}