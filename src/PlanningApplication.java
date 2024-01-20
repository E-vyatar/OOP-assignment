import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlanningApplication {

    /**
     * execute action on jobCatalog based on user input
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) throws IOException {
        JobCatalog catalog = JobCatalog.read(new Scanner(new File("resources/jobListCopy.txt")));

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Choose action:
                    1 - Show all jobs in the catalog
                    2 - Add a new job
                    3 - Delete existing job
                    4 - Change date of existing job
                    5 - Print jobs by date
                    6 - Print required materials by date
                    7 - Quit application
                    """);
            
            int userChoice = scan.nextInt();

            switch (userChoice) {
                case 1 -> System.out.println(catalog);
                case 2 -> {
                    catalog.add(jobFromUser());
                    catalog.sortByDate();
                }
                case 3 -> catalog.deleteJob();
                case 4 -> {
                    catalog.changeDate();
                    catalog.sortByDate();
                }
                case 5 -> catalog.filterByDate().forEach(job -> System.out.println(job));
                case 6 -> catalog.printEquipmentByDate(catalog.filterByDate());
                case 7 -> {
                    FileWriter writer = new FileWriter(new File("resources/jobListCopy.txt"));
                    catalog.getJob(0).write(writer);
                    for (int i = 1; i < catalog.getSize(); ++i) {
                        writer.write("\n");
                        catalog.getJob(i).write(writer);
                    }
                    writer.close();
                    System.exit(0);
                }
            }
        }
    }

    /**
     * build job based on user input
     * @return Job
     */
    public static Job jobFromUser() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please provide the following information:");

        System.out.println("Address: (format: street,number,zipcode,city)");
        String stringInput = inputScanner.next();
        Scanner strScanner = new Scanner(stringInput).useDelimiter(",");
        Address address = new Address(
                strScanner.next(), strScanner.nextInt(), strScanner.next(), strScanner.next());

        System.out.println("Job description: (Enter 'None' if none");
        String description = inputScanner.next();

        List<Equipment> equipmentList = makeEquipmentList();

        System.out.println("MyDate: (format: day,month,year)");
        stringInput = inputScanner.next();
        strScanner = new Scanner(stringInput).useDelimiter(",");
        MyDate dAte = new MyDate(
                strScanner.nextInt(), strScanner.nextInt(), strScanner.nextInt());

        return new Job(address, description, equipmentList, dAte);

    }

    /**
     * build arraylist of equipments based on user input
     * @return arraylist of equipment
     */
    public static List<Equipment> makeEquipmentList() {
        Scanner scanner = new Scanner(System.in);
        List<Equipment> equipmentList = new ArrayList<>();
        boolean keepLoop = true;
        while (keepLoop) {
            System.out.println("Required equipment:\n" +
                    "(choose one:\n" +
                    "1 - Concrete Mixer\n" +
                    "2 - JackHammer\n" +
                    "3 - Scaffolding Tower\n" +
                    "4 - Torch\n" +
                    "5 - done)");
            int userEquipmentChoice = scanner.nextInt();
            switch (userEquipmentChoice) {
                case 1:
                    System.out.print("Enter description: ");
                    equipmentList.add(new ConcreteMixer(scanner.next()));
                    break;
                case 2:
                    System.out.print("Enter description: ");
                    equipmentList.add(new JackHammer(scanner.next()));
                    break;
                case 3:
                    System.out.print("Enter description: ");
                    equipmentList.add(new ScaffoldingTower(scanner.next()));
                    break;
                case 4:
                    System.out.print("Enter description: ");
                    equipmentList.add(new Torch(scanner.next()));
                    break;
                case 5:
                    keepLoop = false;
                    break;
                default:
                    System.out.print("Error, choose again: ");
            }
        }
        return equipmentList;
    }
}
