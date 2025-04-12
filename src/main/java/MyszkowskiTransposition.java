import java.util.Arrays;

public class MyszkowskiTransposition {
    public static void main(String[] args) {

    }
    public static String encrypt(String message, String key) {
        while(key.length()<message.length()) {
            key+=key;
        }

        char[] messageArray=message.toCharArray();
        char[] keyArray=key.toCharArray();
        int[] sortedKeyIndexes=new int[key.length()];

        for(int i=0; i<key.length(); i++) {
            sortedKeyIndexes[i]=i;
        }

        Arrays.sort(sortedKeyIndexes);

        StringBuilder encryptedMessage=new StringBuilder();
        for(int i=0; i<key.length(); i++) {
            for(int j=1; j<message.length(); j+=key.length()) {
                encryptedMessage.append(messageArray[j]);
            }
        }
        return encryptedMessage.toString();
    }
}
