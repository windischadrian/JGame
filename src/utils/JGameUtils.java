package utils;

public class JGameUtils {

    public static int randomNumberFromInterval(int lowerInterval, int upperInterval) {
        return (int) (Math.random() * (upperInterval - lowerInterval)) + lowerInterval;
    }
}
