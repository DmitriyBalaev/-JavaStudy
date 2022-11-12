package removerElementArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class RemoveElementTest {
    List<String> sports = new ArrayList<>();

    @BeforeEach
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

        assertThat(sports.size()).isEqualTo(4);
        assertThat(sports.get(1)).isNotEqualTo("Basketball");
    }

    @Test
    public void removeByElement(){
        sports.remove("Baseball");

        assertThat(sports.size()).isEqualTo(4);
        assertThat(sports).doesNotContain("Baseball");

    }

    @Test
    public void removeElementDuringIteration(){
        Iterator<String> iterator = sports.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("Boxing")){
                iterator.remove();
            }
        }
        assertThat(sports.size()).isEqualTo(4);
        assertThat(sports).doesNotContain("Boxing");
    }

    @Test
    public void removeWithRemoveIf(){
        sports.removeIf(p -> p.equals("Cycling"));

        assertThat(sports.size()).isEqualTo(4);
        assertThat(sports).doesNotContain("Cycling");
    }

}