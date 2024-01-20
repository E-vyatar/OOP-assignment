import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    @Test
    void constructorNotNullTest() {
        ConcreteMixer a = new ConcreteMixer("being yellow");
        assertNotNull(a);
    }

    @Test
    void getRequirements() {
        ConcreteMixer a = new ConcreteMixer("being yellow");
        assertEquals("being yellow", a.getRequirements());
    }

    @Test
    void testEqualsSameAddress() {
        ConcreteMixer a = new ConcreteMixer("being yellow");
        assertEquals(a, a);
    }

    @Test
    void testToString() {
        ConcreteMixer a = new ConcreteMixer("being yellow");
        assertEquals("ConcreteMixer, requires being yellow", a.toString());
    }

    @Test
    void testNotEqualsDifferentRequirements() {
        ConcreteMixer a = new ConcreteMixer("being yellow");
        ConcreteMixer b = new ConcreteMixer("3 different parts of fuel");
        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentClass() {
        ConcreteMixer a = new ConcreteMixer("being yellow");
        JackHammer b = new JackHammer("being yellow");
        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsNull() {
        ConcreteMixer a = new ConcreteMixer("being yellow");
        assertNotEquals(null, a);
    }
}