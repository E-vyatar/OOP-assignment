import java.util.*;
import java.util.stream.Stream;

public class JobCatalog {
    private List<Job> jobs;

    /**
     * constructor, initialize jobs as arraylist
     */
    public JobCatalog() {
        this.jobs = new ArrayList<>();
    }

    /**
     * read JobCatalog from given scanner
     * @param scanner scanner of file containing jobs
     * @return JobCatalog with jobs read from scanner
     */
    public static JobCatalog read(Scanner scanner) {
        JobCatalog jobCatalog = new JobCatalog();

        while (scanner.hasNextLine()) {
            Address address = Address.read(scanner.nextLine());
            String description = scanner.nextLine();
            List<Equipment> requiredEquipment = Equipment.readList(scanner.nextLine());
            MyDate date = MyDate.read(scanner.nextLine());

            jobCatalog.add(new Job(address, description, requiredEquipment, date));
        }

        jobCatalog.sortByDate();

        return jobCatalog;
    }

    /**
     *
     * @param job job to add to jobs list
     * @return boolean to indicate  if added successfully
     */
    public boolean add(Job job) {
        return jobs.add(job);
    }

    /**
     * get job from jobs list by index
     * @param i index of the wanted job
     * @return job at requested index if successful, else ArrayIndexOutOfBoundsException
     */
    public Job getJob(int i) {
        if (0 <= i && i < jobs.size()) {
            return jobs.get(i);
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * get the size of jobs list
     * @return size of jobs list
     */
    public int getSize() {
        return jobs.size();
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     *
     * @return human friendly representation of this object
     */
    @Override
    public String toString() {
        String allJobs = "JobCatalog{\n";

        for (int i = 0; i < jobs.size(); ++i) {
            allJobs += jobs.get(i).toString() + "\n";
        }

        allJobs += "}\n";
        return allJobs;
    }

    /**
     * equals method, check for same address, null parameter, same class and
     * same job lists
     * @param other object to check equality to
     * @return boolean for equality of the objects
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        JobCatalog that = (JobCatalog) other;
        return Objects.equals(jobs, that.jobs);
    }

    public void deleteJob() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please select the number of the job you would like to delete:");
        int choice = inputScanner.nextInt();

        System.out.println("You chose job number " + choice
                + ", are you sure you want to delete this job? y/n");
        String choice2 = inputScanner.next();
        if (choice2.equals("y")) {
            for (int i = 0; i < jobs.size(); ++i) {
                if (jobs.get(i).getJobNumber() == choice) {
                    jobs.remove(i);
                    break;
                }
            }
        }
        else if (choice2.equals("n")){
            System.out.println("Action cancelled");
        }
    }

    public void changeDate() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println(
                "Please select the number of the job you would like to change the date of:");
        int choice = inputScanner.nextInt();

        Job chosenJob = jobs.stream()
                .filter(job -> job.getJobNumber() == choice)
                .toList()
                .get(0);
        System.out.println("This job current date is "
                + chosenJob.getPlannedDate().stringToWrite());
        System.out.println("Please enter new date: (format: day-month-year)");
        MyDate chosenDate = MyDate.read(inputScanner.next());

        chosenJob.setPlannedDate(chosenDate);
    }

    public Stream<Job> filterByDate() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter a date: (format: day-month-year)");
        MyDate chosenDate = MyDate.read(inputScanner.next());

        return jobs.stream()
                .filter(job -> job.getPlannedDate().equals(chosenDate));
    }

    public void printEquipmentByDate(Stream<Job> filterByDate) {
        var x = filterByDate
                .map(job -> job.getRequiredEquipment())
                .filter(eList -> eList != null)
                .flatMap(eList -> eList.stream())
                .toList();

        var y = x.stream()
                .map(equipment -> equipment.getClass().getSimpleName())
                .distinct();
        System.out.println("Equipment:");
        y.forEach(equipment -> System.out.println(equipment));

        var z = x.stream()
                .map(equipment -> equipment.getPowerSupply())
                .filter(powerSupply -> powerSupply != null)
                .distinct();

        System.out.println("Power supplies:");
        z.forEach(powerSupply -> System.out.println(powerSupply));
    }

    public void sortByDate() {
        List<Job> myDates = this.getJobs().stream()
                .sorted(Comparator.comparing(Job::getPlannedDate))
                .toList();
        this.setJobs(myDates);
    }

}
