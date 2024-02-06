package mg.zotoavina.core;

import org.junit.jupiter.api.Test;

import static  org.junit.jupiter.api.Assertions.*;
class DirectionTest {

    @Test
    void testOpposition() {
        // arrange , act and assert
        assertTrue(Direction.UP.opposed(Direction.DOWN));
        assertTrue(Direction.LEFT.opposed(Direction.RIGHT));
        assertFalse(Direction.UP.opposed(Direction.LEFT));
    }

}