import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void constructorNotNullTest() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);
        assertNotNull(a);
    }

    @Test
    void getLocation() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);
        assertEquals(new Address("Sint Olofslaan", 14, "2613EJ", "Delft"), a.getLocation());
    }

    @Test
    void getDescription() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);
        assertEquals(new String("Some kind of job"), a.getDescription());
    }

    @Test
    void getRequiredEquipment() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);

        List<Equipment> equipmentList2 = new ArrayList<>();
        equipmentList2.add(new ConcreteMixer("being yellow"));
        equipmentList2.add(new JackHammer("3 different parts of fuel"));
        assertEquals(equipmentList2, a.getRequiredEquipment());
    }

    @Test
    void getPlannedDate() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);
        assertEquals(new MyDate(28, 7, 1996), a.getPlannedDate());
    }

    @Test
    void testToString() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);

        String b = "Job: jobNumber=3, location=Address: Sint Olofslaan 14, 2613EJ, Delft, description='Some kind of job', requiredEquipment=[ConcreteMixer, requires being yellow, JackHammer, requires 3 different parts of fuel], plannedDate=MyDate: 28/7/1996";
        assertEquals(b, a.toString());
    }

    @Test
    void testEqualsSameAddress() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);

        assertEquals(a, a);
    }

    @Test
    void testEquals() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);
        Job b = new Job(address, description, equipmentList, someMyDate);

        assertEquals(a, b);
    }

    @Test
    void testNotEqualsNull() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);
        assertNotEquals(null, a);
    }

    @Test
    void testNotEqualsDifferentAddress() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);

        Address secondAddress = new Address("Sint Olofslaan", 27, "2613EJ", "Delft");
        Job b = new Job(secondAddress, description, equipmentList, someMyDate);

        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentDescription() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);

        String description2 = "Other kind of job";
        Job b = new Job(address, description2, equipmentList, someMyDate);

        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentEquipmentList() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);

        List<Equipment> equipmentList2 = new ArrayList<>();
        equipmentList2.add(new ConcreteMixer("4 different parts of fuel"));
        equipmentList2.add(new JackHammer("being purple"));
        Job b = new Job(address, description, equipmentList2, someMyDate);

        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentPlannedDate() {
        Address address =  new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        String description = "Some kind of job";
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new ConcreteMixer("being yellow"));
        equipmentList.add(new JackHammer("3 different parts of fuel"));
        MyDate someMyDate = new MyDate(28, 7, 1996);
        Job a = new Job(address, description, equipmentList, someMyDate);

        MyDate someMyDate2 = new MyDate(14, 1, 2005);
        Job b = new Job(address, description, equipmentList, someMyDate2);

        assertNotEquals(a, b);
    }
}