package com.solvd.enums;

public enum ComputerEnum {
    HP("HP", "Pavilion") {
        @Override
        public String getBrand() {
            return "HP";
        }

        @Override
        public String getModel() {
            return "Pavilion";
        }
    },

    DELL("Dell", "XPS") {
        @Override
        public String getBrand() {
            return "Dell";
        }

        @Override
        public String getModel() {
            return "XPS";
        }
    },

    ASUS("Asus", "ROG") {
        @Override
        public String getBrand() {
            return "Asus";
        }

        @Override
        public String getModel() {
            return "ROG";
        }
    },

    LENOVO("Lenovo", "ThinkPad") {
        @Override
        public String getBrand() {
            return "Lenovo";
        }

        @Override
        public String getModel() {
            return "ThinkPad";
        }
    },

    APPLE("Apple", "MacBook") {
        @Override
        public String getBrand() {
            return "Apple";
        }

        @Override
        public String getModel() {
            return "MacBook";
        }
    };

    private final String brand;
    private final String model;

    ComputerEnum(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}