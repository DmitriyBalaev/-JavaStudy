import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.Objects;

import static org.junit.Assert.*;

public class TestHashAndHashCode {

    @Test
    public void objectHashCode(){
        Integer value1 = 1313;
        Integer value2 = 1313;

        int hashcode1 = value1.hashCode();
        int hashcode2 = value2.hashCode();

        assertEquals(hashcode1, hashcode2);
    }
    
    @Test
    public void objetHashCodeWithNull(){
        Integer value = null;
        ThrowingRunnable NullPointerException = null;
        Throwable throwable = assertThrows(java.lang.NullPointerException.class, () ->{
            value.hashCode();
        });
        assertNotNull(throwable.getMessage());
    }

    @Test
    public void objectsHashCode(){
        String string1 = "test";
        String string2 = "test";
        int hashCode1 = Objects.hashCode(string1);
        int hashCode2 = Objects.hashCode(string2);

        assertEquals(hashCode1, hashCode2);
    }

    @Test
    public void objectsHashCodeWithNull(){
        String nullString = null;
        int hashCode = Objects.hashCode(nullString);
        assertEquals(0, hashCode);
    }

    @Test
    public void objectsHash(){
        String stringOne = "1";
        String stringTwo = "2";
        String stringOne2 = "1";
        String stringTwo2 = "2";

        int hashCode1 = Objects.hash(stringOne, stringTwo);
        int hashCode2 = Objects.hash(stringOne2, stringTwo2);

        assertEquals(hashCode1, hashCode2);
    }
}
