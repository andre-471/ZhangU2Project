import java.util.Scanner;

public class LinearEquationLogic {
    private final Scanner scan = new Scanner(System.in);
    private LinearEquation equation;

    public LinearEquationLogic() {
        equation = null;
        start();
//        goThruTestCasesPleaseThankYou();
    }

    private void start() {
        System.out.println("welcome");
        getInput();
    }

    private void getInput() {
        do {
            System.out.print("Enter coordinate 1: ");
            String coord1 = scan.nextLine();
            System.out.print("Enter coordinate 2: ");
            String coord2 = scan.nextLine();
            createLinearEquaation(coord1, coord2);

            System.out.println(equation.lineInfo());

            if (!Double.isNaN(equation.slope())) {
                System.out.print("Enter a value for x: ");
                System.out.println("The point on the line is " + equation.coordinateForX(scan.nextDouble()));
                scan.nextLine();
            }

            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        } while ("y".equalsIgnoreCase(scan.nextLine()));
    }

    private int[] coordParser(String coord) {
        int mid = coord.indexOf(",");
        return new int[]{Integer.parseInt(coord.substring(1, mid).trim()),
                Integer.parseInt(coord.substring(mid + 1, coord.length() - 1).trim())};
    }

    private void createLinearEquaation(String coord1, String coord2) {
        int[] parsedCoord1 = coordParser(coord1);
        int[] parsedCoord2 = coordParser(coord2);

        equation = new LinearEquation(parsedCoord1[0], parsedCoord1[1], parsedCoord2[0], parsedCoord2[1]);
    }

    private void goThruTestCasesPleaseThankYou() {
        String[][] testCases = {
                {"(-1, 5)", "(3, 10)"},
                {"(2, 10)", "(-1, 3)"},
                {"(-6, -2)", "(1, -1)"},
                {"(1, 4)", "(7, 12)"},
                {"(0, 0)", "(4, 5)"},
                {"(-1, 4)", "(-7, 12)"},
                {"(6, 3)", "(-1, 4)"},
                {"(4, 0)", "(6, 10)"},
                {"(6, 2)", "(8,-12)"},
                {"(1, -10)", "(-3, 2)"},
                {"(7, 14)", "(5, 10)"},
                {"(-1, 3)", "(2, 6)"},
                {"(-1, 2)", "(-3, 4)"},
                {"(-2, -2)", "(4, 4)"},
                {"(7, 12)", "(3, 12)"},
                {"(16, -2)", "(3, -2)"}
        };

        for (String[] testCase : testCases) {
            createLinearEquaation(testCase[0], testCase[1]);
            System.out.println(equation.lineInfo() + "\n");
        }
    }
}
