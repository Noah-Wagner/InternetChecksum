import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> randomBinary = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            randomBinary.add((int) (Math.random() * 65535 + 1));
        }

        InternetChecksum internetChecksum = new InternetChecksum(randomBinary);
        System.out.println(Integer.toBinaryString(internetChecksum.computeSum()));

        ArrayList<Integer> randomBinary2 = randomBinary;
        String temp = InternetChecksum.insertLeadingZeros(randomBinary.get(0));
        randomBinary2.set(0, Integer.valueOf(temp.substring(0, 1) + (Integer.valueOf(temp.substring(1, 2)) ^ 1) + temp.substring(2), 2));
        internetChecksum.setMessageWords(randomBinary2);
        System.out.println(Integer.toBinaryString(internetChecksum.computeSum()));

        ArrayList<Integer> randomBinary3 = randomBinary;

        String buffer1 = InternetChecksum.insertLeadingZeros(randomBinary3.get(0));
        String buffer2 = InternetChecksum.insertLeadingZeros(randomBinary3.get(2));

        char swap = buffer1.charAt(0);
        buffer1 = buffer2.substring(0, 1) + buffer1.substring(1);
        buffer2 = swap + buffer2.substring(1);
        randomBinary3.set(0, Integer.parseInt(buffer1, 2));
        randomBinary3.set(2, Integer.parseInt(buffer2, 2));

        internetChecksum.setMessageWords(randomBinary3);
        System.out.println(Integer.toBinaryString(internetChecksum.computeSum()));

    }


}
