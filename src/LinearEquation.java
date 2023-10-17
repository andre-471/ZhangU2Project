public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    public double slope() {
        if (x1 == x2) { return Double.NaN; }
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public String slopeFormatter() {
        int deltaY = y2 - y1;
        int deltaX = x2 - x1;
        String slopeCoefficient = "";

        if (slope() == 0) {
            return "";
        } else if (slope() < 0) {
            slopeCoefficient += "-";
        }

        if (Math.abs(slope()) == 1) {
            return slopeCoefficient + "x";
        } else if (deltaY % deltaX == 0) {
            slopeCoefficient += deltaY / deltaX;
        } else {
            slopeCoefficient += simplifyFraction(Math.abs(deltaY), Math.abs(deltaX));
        }

        return slopeCoefficient + "x";
    }

    public String yInterceptFormatter() {
        if (yIntercept() == 0) {
            return "";
        } else if (yIntercept() < 0) {
            return " - " + Math.abs(yIntercept());
        }
        return " + " + yIntercept();
    }
    public String equation() {
        if (x1 == x2) { return "undefined"; }
        if (y1 == y2) { return "y = " + (yIntercept()); }

        return "y = " + slopeFormatter() + yInterceptFormatter();
    }

    public String coordinateForX(double x) {
        double y = (slope() * x) + yIntercept();
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The distance between these points is " + distance();
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

    private String simplifyFraction(int numerator, int denominator) {
        int i = 2;

        while (i < Math.min(numerator, denominator)) {  // i can't be equal numerator or denominator
            if (numerator % i == 0 && denominator % i == 0) {  // if i is a factor
                // simplify using i as factor
                numerator /= i;
                denominator /= i;
            } else {
                // no more factors at i, maybe more at i + 1
                i++;
            }
        }

        return numerator + "/" + denominator;
    }
}
