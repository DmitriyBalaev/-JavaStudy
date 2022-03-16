package removerElementArrayList;


import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


public class RemoveElementTest {
    List<String> sports = new ArrayList<>();

    @Before
    public void init(){
        sports.add("Football");
        sports.add("Basketball");
        sports.add("Baseball");
        sports.add("Boxing");
        sports.add("Cycling");
    }

    @Test
    public void removeElementByIndex(){
        sports.remove(1);//remove "basketball"

        assertEquals(4, sports.size());
        assertNotEquals(sports.get(1), "Basketball");
    }

    @Test
    public void removeByElement(){
        sports.remove("Baseball");

        assertEquals(4, sports.size());
        assertFalse(sports.contains("Baseball"));
    }

    @Test
    public void removeElementDuringIteration(){
        Iterator<String> iterator = sports.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("Boxing")){
                iterator.remove();
            }
        }

        assertEquals(4, sports.size());
        assertFalse(sports.contains("Boxing"));
    }

    @Test
    public void removeWithRemoveIf(){
        sports.removeIf(p -> p.equals("Cycling"));

        assertEquals(4, sports.size());
        assertFalse(sports.contains("Cycling"));
    }

}