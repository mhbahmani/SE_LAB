package lab_6.builder_pattern;

public class BuilderPattern {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder(
                "1 TB", "16 GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(false)
                .build();

        System.out.println(computer);
    }
}
