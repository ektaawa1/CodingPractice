package prampPract;

public class DecryptMessage {
//TC = O(n), SC = O(n)
    public static String decrypt(String word) {
        StringBuilder result = new StringBuilder();

        int prev = 0;

        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i);

            int decrypted;
            if (i == 0) {
                decrypted = curr - 1;
            } else {
                decrypted = curr - prev;
            }

            // bring back into 'a' to 'z'
            while (decrypted < 'a') {
                decrypted += 26;
            }

            result.append((char) decrypted);
            prev = curr;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(decrypt("dnotq"));        // crime
        System.out.println(decrypt("flgxswdliefy")); // encyclopedia
    }
}

/**
 * Encryption Rule-
 * enc[0] = dec[0] + 1
 * enc[i] = dec[i] + enc[i-1]
 *
 * Decryption Rule- (simply reverses this)
 * dec[0] = enc[0] - 1
 * dec[i] = enc[i] - enc[i-1]
 *
 * then If result goes below 'a', add 26 until valid
 */

/**
 * Dry Run-
 * Given encrypted word: "dnotq"
 * d  n  o  t  q
 * 100 110 111 116 113
 *
 * Decrypt first character:
 * dec[0] = enc[0] - 1
 *         = 100 - 1
 *         = 99  → 'c'
 *
 * Decrypt remaining characters
 * For each i ≥ 1:
 * dec[i] = enc[i] - enc[i-1]
 *
 * Result: "crime"
 */
