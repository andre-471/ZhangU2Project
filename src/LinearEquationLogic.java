import java.util.Scanner;

public class LinearEquationLogic {
    private final Scanner scan = new Scanner(System.in);
    private LinearEquation equation;
    public LinearEquationLogic() {
        equation = null;
        start();
    }

    public void start() {
        System.out.println("welcome");
        getInput();
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

    private void getInput() {
        do {
            String coord1 = scan.nextLine();
            String coord2 = scan.nextLine();
            createLinearEquaation(coord1, coord2);

            System.out.println(equation.lineInfo());
            System.out.println(equation.coordinateForX(scan.nextDouble()));
            scan.nextLine();

            System.out.print("y/n ");
        } while ("y".equals(scan.nextLine()));
    }
}
