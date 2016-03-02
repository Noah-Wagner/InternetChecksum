import java.util.ArrayList;

public class InternetChecksum {

    ArrayList<Integer> messageWords;

    final static int WORD_LENGTH = 16;
    final static int MODULO_TERM = 0xFF;

    public InternetChecksum(ArrayList<Integer> messageWords) {
        this.messageWords = messageWords;
    }

    public int computeSum() {
        return onesComplement(sumWords()) & MODULO_TERM;
    }

    private static int onesComplement(int binarySequence) {
        return ~binarySequence;
    }

    private int sumWords() {
        int sumVar = 0;
        for (int indexInt : messageWords) {
            sumVar = onesComplementAdd(sumVar, indexInt);
        }
        return sumVar;
    }

    public void setMessageWords(ArrayList<Integer> messageWords) {
        this.messageWords = messageWords;
    }

    public static int onesComplementAdd(int a, int b) {
        int retVal = 0;
        int carrySize = 0b10000000000000000;
        retVal += a += b;

        while ((retVal / carrySize) > 0) {
            retVal -= carrySize;
            retVal += 1;
        }
        return retVal;
    }

    public static String insertLeadingZeros(int binary) {
        String bufferSequence = Integer.toBinaryString(binary);
        String substring = "";
        int num = bufferSequence.length();
        while ((16 - num) > 0) {
            substring += "0";
            num++;
        }
        substring += bufferSequence;
        return substring;
    }

}
