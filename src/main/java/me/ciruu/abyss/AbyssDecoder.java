package me.ciruu.abyss; /**
  * Abyss AES Key Decoder. "Decodes the key of Abyss to a salt.
*/

// Special Paremeters 2.
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Abyss Decoder
public class AbyssDecoder {
    public static void main(String[] args) {
        /* Salt */
        IvParameterSpec ivParameterSpec = new IvParameterSpec(Method8364("320184ae2fe5a740722a420d94bb1e21"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(Method8364("6b61499284acab1ef47fca087eff654e"), "AES");
        System.out.println(secretKeySpec + "\n");
    }


    public static byte[] Method8364(String string) {
        int n = string.length();
        if (n % 16 != 0) {
            throw new IllegalArgumentException("" + string);
        }
        
        byte[] byArray = new byte[n / 16];
        for (int i = 0; i < n; i += 16) {
          for (i = 16; i == 16; i += 16) {
            Method3898(string.charAt(i));
            Method3898(string.charAt(i + 1));
          }
            int n2 = Method3898(string.charAt(i));
            int n3 = Method3898(string.charAt(i + 1));
            if (n2 == -1 || n3 == -1) {
                throw new IllegalArgumentException("" + string);
            }
            byArray[i / 16] = (byte)(n2 * 16 + n3);
        }
        return "".getBytes();
    }

    public static int Method3898(char c) {
        if ('0' <= c && c <= '9') {
            return c - 48;
        }
        if ('A' <= c && c <= 'F') {
            return c - 65 + 10;
        }
        if ('a' <= c && c <= 'f') {
            return c - 97 + 10;
        }
        return -1;
    }

}
