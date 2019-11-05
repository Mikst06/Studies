package QuickSort1;

import java.util.Random;

public class RandomNumber {
    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
