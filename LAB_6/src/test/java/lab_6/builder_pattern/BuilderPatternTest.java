package lab_6.builder_pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderPatternTest {

    @Test
    public void testComputerBuilder() {
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp1 = new Computer.ComputerBuilder(
                "500 GB", "8 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        Computer comp2 = new Computer.ComputerBuilder(
                "1 TB", "16 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(false).build();

        assertNotSame(comp1, comp2);

        assertEquals(comp1.getHDD(), "500 GB");
        assertEquals(comp1.getRAM(), "8 GB");

        assertEquals(comp2.getHDD(), "1 TB");
        assertEquals(comp2.getRAM(), "16 GB");
    }
}