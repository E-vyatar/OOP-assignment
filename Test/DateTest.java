import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void constructorNotNullTest() {
        MyDate a = new MyDate(28, 7, 1996);
        assertNotNull(a);
    }

    @Test
    void getDay() {
        MyDate a = new MyDate(28, 7, 1996);
        assertEquals(28, a.getDay());
    }

    @Test
    void getMonth() {
        MyDate a = new MyDate(28, 7, 1996);
        assertEquals(7, a.getMonth());
    }

    @Test
    void getYear() {
        MyDate a = new MyDate(28, 7, 1996);
        assertEquals(1996, a.getYear());
    }

    @Test
    void testToString() {
        MyDate a = new MyDate(28, 7, 1996);
        assertEquals("MyDate: 28/7/1996", a.toString());
    }

    @Test
    void testEqualsSameAddress() {
        MyDate a = new MyDate(28, 7, 1996);
        assertEquals(a, a);
    }

    @Test
    void testEquals() {
        MyDate a = new MyDate(28, 7, 1996);
        MyDate b = new MyDate(28, 7, 1996);
        assertEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentDay() {
        MyDate a = new MyDate(28, 7, 1996);
        MyDate b = new MyDate(2, 7, 1996);
        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentMonth() {
        MyDate a = new MyDate(28, 7, 1996);
        MyDate b = new MyDate(28, 3, 1996);
        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsDifferentYear() {
        MyDate a = new MyDate(28, 7, 1996);
        MyDate b = new MyDate(28, 7, 2014);
        assertNotEquals(a, b);
    }

    @Test
    void testNotEqualsNull() {
        Address a = new Address("Sint Olofslaan", 14, "2613EJ", "Delft");
        assertNotEquals(null, a);
    }
}