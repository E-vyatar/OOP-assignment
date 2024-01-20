/*
 Abstract class Equipment, contains one field:
 - requirements: textual description that indicates any special requirements the
   piece of equipment should meet for this particular job
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Equipment implements PowerSupply{

    // fields
    private String requirements;

    /**
     * constructor
     * @param requirements specific requirement for this equipment
     */

    public Equipment(String requirements) {
        this.requirements = requirements;
    }

    /**
     * read list of Equipments from given string
     * @param line string to read the list from
     * @return list of Equipments read from string
     */
    public static List<Equipment> readList(String line) {
        List<Equipment> scannedEquipment;

        if (!line.isBlank()) {
            scannedEquipment = new ArrayList<>();
            Scanner equipmentListScanner = new Scanner(line).useDelimiter("; |;");
            while (equipmentListScanner.hasNext()) {
                try {
                    scannedEquipment.add(Equipment.readEquipment(equipmentListScanner.next()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else {
            scannedEquipment = null;
        }

        return scannedEquipment;
    }

    private static Equipment readEquipment(String input) throws IOException {
        Scanner equipmentScanner = new Scanner(input).useDelimiter(", ");

        String name = equipmentScanner.next();
        String scannedRequirements = equipmentScanner.next();
        switch (name){
            case "ConcreteMixer":
                return new ConcreteMixer(scannedRequirements);
            case "JackHammer":
                return new JackHammer(scannedRequirements);
            case "ScaffoldingTower":
                return new ScaffoldingTower(scannedRequirements);
            case "Torch":
                return new Torch(scannedRequirements);
            default:
                throw new IOException();
        }

    }

    /**
     *
     * @return requirements field
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * equals method, check for same address, null parameter, same class and same number and zipCode
     * @param other object to check equality to
     * @return boolean for equality of the objects
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Equipment that = (Equipment) other;
        return Objects.equals(requirements, that.requirements);
    }

    /**
     * create file storing friendly string representation of this object
     * @return string representation of this object matching file format
     */
    public String stringToWrite() {
        return this.getClass().getSimpleName() + ", " + requirements + ";";
    }
}
