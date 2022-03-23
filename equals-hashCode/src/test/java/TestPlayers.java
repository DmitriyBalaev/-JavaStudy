import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestPlayers {
    @Test
    public void withObjectHashCode() {
        PlayerWithObjectHashCode player = new PlayerWithObjectHashCode("Eduardo", "Rodriguez", "Pitcher");
        PlayerWithObjectHashCode indenticalPlayer = new PlayerWithObjectHashCode("Eduardo", "Rodriguez", "Pitcher");

        int hashCode1 = player.hashCode();
        int hashCode2 = player.hashCode();
        int hashCode3 = indenticalPlayer.hashCode();

        assertEquals(hashCode1, hashCode2);
        assertEquals(hashCode1, hashCode3);
    }

    @Test
    public void withObjectsHashCode() {
        PlayerWithObjectHashCode player = new PlayerWithObjectHashCode("Eduardo", "Rodriguez", "Pitcher");
        PlayerWithObjectHashCode indenticalPlayer = new PlayerWithObjectHashCode("Eduardo", "Rodriguez", "Pitcher");

        int hashCode1 = player.hashCode();
        int hashCode2 = player.hashCode();
        int hashCode3 = indenticalPlayer.hashCode();

        assertEquals(hashCode1, hashCode2);
        assertEquals(hashCode1, hashCode3);
    }

    @Test
    public void withObjectsHash() {
        PlayerWithObjectsHash player = new PlayerWithObjectsHash("Eduardo", "Rodriguez", "Pitcher");
        int hashCode = player.hashCode();
        String[] playerInfo = {"Eduardo", "Rodriguez", "Pitcher"};
        int hashCode2 = Arrays.hashCode(playerInfo);

        assertEquals(hashCode, hashCode2);
    }
}
