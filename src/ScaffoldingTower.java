/*
 Equipment subclass ScaffoldingTower:
 takes String requirements, and passes this value on to the constructor of the parent (Equipment)
*/

public class ScaffoldingTower extends Equipment{

    /**
     * constructor
     * @param requirements specific requirement for this equipment
     */
    public ScaffoldingTower(String requirements) {
        super(requirements);
    }

    /**
     *
     * @return human friendly representation of this object
     */
    @Override
    public String toString() {
        return "ScaffoldingTower, requires " + getRequirements();
    }

    /**
     * equals method, check for same address, null parameter, same class and
     * then uses superclass equals
     * @param other object to check equality to
     * @return boolean for equality of the objects
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ScaffoldingTower that = (ScaffoldingTower) other;
        return super.equals(other);
    }

    @Override
    public String getPowerSupply() {
        return null;
    }
}
