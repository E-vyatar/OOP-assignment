import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/* Class Job, contains six private fields:
 * - int jobNumber
 * - Address location
 * - String description
 * - List<Equipment> requiredEquipment
 * - MyDate plannedMyDate
 * - int jobTotal*/

public class Job {

    // attributes
    private int jobNumber;
    private Address location;
    private String description;
    private List<Equipment> requiredEquipment;
    private MyDate plannedMyDate;
    private static int jobTotal = 0;


    /**
     * constructor
     * @param location location of the job
     * @param description description of the job
     * @param requiredEquipment required equipment for the job
     * @param plannedMyDate planned date of the job
     */

    public Job(Address location, String description,
               List<Equipment> requiredEquipment, MyDate plannedMyDate) {
        this.location = location;
        this.description = description;
        this.requiredEquipment = requiredEquipment;
        this.plannedMyDate = plannedMyDate;

        // increment total number of jobs so far and assign value to jobNumber
        jobNumber = ++jobTotal;
    }

    /**
     *
     * @return jobNumber field
     */
    public int getJobNumber() {
        return jobNumber;
    }

    /**
     *
     * @return location field
     */
    public Address getLocation() {
        return location;
    }

    /**
     *
     * @return description field
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return requiredEquipment field
     */
    public List<Equipment> getRequiredEquipment() {
        return requiredEquipment;
    }

    /**
     *
     * @return plannedMyDate field
     */
    public MyDate getPlannedDate() {
        return plannedMyDate;
    }

    /**
     *
     * @return jobTotal field
     */
    public static int getJobTotal() {
        return jobTotal;
    }

    public void setPlannedDate(MyDate plannedMyDate) {
        this.plannedMyDate = plannedMyDate;
    }

    /**
     *
     * @return human friendly representation of this object
     */
    @Override
    public String toString() {
        return "Job: " +
                "jobNumber=" + jobNumber +
                ", location=" + location +
                ", description='" + description + '\'' +
                ", requiredEquipment=" + requiredEquipment +
                ", plannedMyDate=" + plannedMyDate;
    }

    /**
     * equals method, check for same address, null parameter, same class and
     * equality of all fields
     * @param other object to check equality to
     * @return boolean for equality of the objects
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof Job) {
            return true;
        }
        Job that = (Job) other;
        return location.equals(that.location)
                && description.equals(that.description)
                && requiredEquipment.equals(that.requiredEquipment)
                && plannedMyDate.equals(that.plannedMyDate);
    }

    /**
     * write a job to given fileWriter
     * @param writer fileWriter with the file to write to
     * @throws IOException exception in case one of the job attributes couldn't be written
     */
    public void write(FileWriter writer) throws IOException {
        writer.write(location.stringToWrite());
        writer.write("\n");

        writer.write(description.toString());
        writer.write("\n");

        if (requiredEquipment!=null && requiredEquipment.size() > 0) {
            for (int i = 0; i < requiredEquipment.size(); ++i) {
                writer.write(requiredEquipment.get(i).stringToWrite());
                if (i != requiredEquipment.size() - 1) {
                    writer.write(" ");
                }
            }
            writer.write("\n");
        } else {
            writer.write("\n");
        }

        writer.write(plannedMyDate.stringToWrite());
    }
}
