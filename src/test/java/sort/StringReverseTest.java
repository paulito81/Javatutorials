package sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringReverseTest {

    @Test
    public void testReverseMethod(){
        StringReverse reverse = new StringReverse();
        assertEquals("gnihtemoS", reverse.reverse("Something"));
    }
}
