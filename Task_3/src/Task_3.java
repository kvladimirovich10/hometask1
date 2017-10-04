public class Task_3 {

    private static final double MAX_VAL = Double.MAX_VALUE;

    public static void main(String[] args) {

        double left = 0;
        double right = 5;
        double step = 0.005;
        double pos = left;

        System.out.println("ARG     VALUE");

        while (pos <= right) {
            if (Math.abs(function(pos)) > MAX_VAL)
                System.out.format("%f    inf%n", pos);
            else {
                System.out.format("%f    %f%n", pos, function(pos));
            }
            pos = pos + step;
        }

    }

    private static double function(double arg) {
        return Math.tan(2 * arg) - 3;
    }
}
