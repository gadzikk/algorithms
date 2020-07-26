package design_patterns.creational.builder;

/**
 * Created by gadzik on 26.07.20.
 */
public class Computer {
    private String hdd;
    private String ram;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    private Computer(Builder builder) {
        hdd = builder.hdd;
        ram = builder.ram;
        isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public static final class Builder {
        private String hdd;
        private String ram;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public Builder() {
        }

        public Builder hdd(String val) {
            hdd = val;
            return this;
        }

        public Builder ram(String val) {
            ram = val;
            return this;
        }

        public Builder isGraphicsCardEnabled(boolean val) {
            isGraphicsCardEnabled = val;
            return this;
        }

        public Builder isBluetoothEnabled(boolean val) {
            isBluetoothEnabled = val;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
