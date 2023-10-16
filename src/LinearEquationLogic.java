import java.util.Scanner;

public class LinearEquationLogic {
    private final Scanner scan = new Scanner(System.in);
    private LinearEquation equation;
    public LinearEquationLogic() {
        equation = null;
    }

    public void start() {
        System.out.println("welcome");
    }
    public int[] coordParser(String coord) {
        int mid = coord.indexOf(",");
        return new int[]{Integer.parseInt(coord.substring(1, mid)),
                Integer.parseInt(coord.substring(mid + 1, coord.length() - 1))};
    }

    private void getInput() {
        do {
            int[] coord1 = coordParser(scan.nextLine());
            int[] coord2 = coordParser(scan.nextLine());

            equation = new LinearEquation(coord1[0], coord1[1], coord2[0], coord2[1]);

            System.out.println(equation.lineInfo());


            System.out.print("y/n");
        } while ("y".equals(scan.nextLine()));
    }
}
