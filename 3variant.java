public class Barycenter {

    public static double[] calculateBarycenter(double[] pointA, double[] pointB, double[] pointC) {
        // Проверка на корректность входных данных
        if (pointA == null || pointB == null || pointC == null ||
            pointA.length != 2 || pointB.length != 2 || pointC.length != 2) {
            throw new IllegalArgumentException("Invalid input: Points must be non-null arrays of length 2.");
        }

        double barycenterX = (pointA[0] + pointB[0] + pointC[0]) / 3.0;
        double barycenterY = (pointA[1] + pointB[1] + pointC[1]) / 3.0;

        return new double[]{barycenterX, barycenterY};
    }

    public static void main(String[] args) {
        // Пример использования
        double[] pointA = {4, 6};
        double[] pointB = {12, 4};
        double[] pointC = {10, 10};

        try {
            double[] barycenter = calculateBarycenter(pointA, pointB, pointC);
            System.out.printf("Barycenter: {%.4f, %.4f}%n", barycenter[0], barycenter[1]);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}