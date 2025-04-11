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
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║    DEMONSTRIM I POLYBIUS SQUARE CIPHER         ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        // Shfaqja e Polybius Square
        System.out.println("\n┌─────────────── Polybius Square ────────────┐");
        for (int i = 0; i < 5; i++) {
            System.out.print("│ ");
            for (int j = 0; j < 5; j++) {
                System.out.printf("%c → %d%d │ ", SQUARE[i][j], i+1, j+1);
            }
            System.out.println();
        }
        System.out.println("└────────────────────────────────────────────┘");

        // Shembull i enkriptimit
        String[] examples = {
                "Projekti i punuar nga Mehmeti, Muhamedi, Natyra dhe Olsa",
                "Shihemi ne Route 66 ne ora 6"
        };

        for (String example : examples) {
            System.out.println("\n┌──────────────────────────────────────────────────────────────────────────────────────────────────-─────────────────┐");
            System.out.println("│ Shembull: " + String.format("%-40s", example));
            System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────────────────-────────┤");

            String cleaned = example.toUpperCase()
                    .replaceAll("[^A-Z]", "")
                    .replace("J", "I");
            System.out.println("│ Teksti në proces: " + String.format("%-30s", cleaned));

            String encrypted = encrypt(example);
            System.out.println("│ Teksti i enkriptuar: " + String.format("%-28s", encrypted));
            System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
        }

        // Përmbledhje
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║              Përmbledhje                         ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ • Zëvendësohet 'J' me 'I'                        ║");
        System.out.println("║ • Hiqen të gjitha karakteret jo-alfabetike       ║");
        System.out.println("║ • Çdo shkronjë zëvendësohet me koordinatat e saj ║");
        System.out.println("║   në tabelën Polybius (rresht+kolonë)            ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}