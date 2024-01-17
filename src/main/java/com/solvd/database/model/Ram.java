package com.solvd.database.model;

public class Ram {
    private Integer id;
    private Integer capacity;
    private Integer computer_computer_id;

    private Ram() {
        // Private constructor for use by the builder
    }

    public Integer getId() {
        return id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getComputer_computer_id() {
        return computer_computer_id;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", computer_computer_id=" + computer_computer_id +
                '}';
    }

    // Builder Pattern
    public static class RamBuilder {
        private Integer id;
        private Integer capacity;
        private Integer computer_computer_id;

        public RamBuilder() {
            // No-args constructor
        }

        public RamBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public RamBuilder capacity(Integer capacity) {
            this.capacity = capacity;
            return this;
        }

        public RamBuilder computerId(Integer computerId) {
            this.computer_computer_id = computerId;
            return this;
        }

        public Ram build() {
            return new Ram(this);
        }
    }

    private Ram(RamBuilder builder) {
        this.id = builder.id;
        this.capacity = builder.capacity;
        this.computer_computer_id = builder.computer_computer_id;
    }

    // Listener Pattern
    public interface RamListener {
        void onRamCreated(Ram ram);
    }
}