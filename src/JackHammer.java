/*
 Equipment subclass JackHammer:
 takes String requirements, and passes this value on to the constructor of the parent (Equipment)
*/

public class JackHammer extends Equipment implements PowerSupply{

    /**
     * constructor
     * @param requirements specific requirement for this equipment
     */
    public JackHammer(String requirements) {
        super(requirements);
    }

    /**
     *
     * @return human friendly representation of this object
     */
    @Override
    public String toString() {
        return "JackHammer, requires " + getRequirements()
                + " and " + getPowerSupply();
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
        JackHammer that = (JackHammer) other;
        return super.equals(other);
    }

    /**
     *
     * @return name of power supply needed for this equipment
     */
    @Override
    public String getPowerSupply() {
        return "Air Compressor";
    }
}
