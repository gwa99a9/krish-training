/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.builderdesignpattern;

/**
 *
 * @author OBITO
 */
public class Main {

    public static void main(String[] args) {
        Smartphone p1 = new Smartphone.Builder()
                .setModel("A21")
                .setBrand("Google")
                .setCamera(22)
                .setDisplaySize(6.6)
                .setRam(8)
                .setNfc(true)
                .setStorage(128)
                .setPrice(5500.00)
                .build();
        System.out.println(p1);

        Smartphone p2 = new Smartphone.Builder()
                .setModel("HM55")
                .setBrand("Samsung")
                .setCamera(48)
                .setDisplaySize(6.6)
                .setRam(12)
                .setNfc(true)
                .setStorage(512)
                .setPrice(110000.00)
                .build();
        System.out.println(p2);
    }
}

class Smartphone {

    private final String brand;
    private final String model;
    private final int camera;
    private final int ram;
    private final boolean nfc;
    private final double price;
    private final int storage;
    private final double displaySize;

    public Smartphone(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.camera = builder.camera;
        this.ram = builder.ram;
        this.nfc = builder.nfc;
        this.price = builder.price;
        this.storage = builder.storage;
        this.displaySize = builder.displaySize;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getCamera() {
        return camera;
    }

    public int getRam() {
        return ram;
    }

    public boolean isNfc() {
        return nfc;
    }

    public double getPrice() {
        return price;
    }

    public int getStorage() {
        return storage;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    @Override
    public String toString() {
        return "Smartphone{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", camera=" + camera + "MP"
                + ", ram=" + ram + "GB"
                + ", nfc=" + nfc
                + ", price=" + "Rs." + price
                + ", storage=" + storage + "GB"
                + ", displaySize=" + displaySize + " inches"
                + '}';
    }

    static class Builder {

        private String brand;
        private String model;
        private int camera;
        private int ram;
        private boolean nfc;
        private double price;
        private int storage;
        private double displaySize;

        public Smartphone build() {
            return new Smartphone(this);
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setCamera(int camera) {
            this.camera = camera;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setNfc(boolean nfc) {
            this.nfc = nfc;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setDisplaySize(double displaySize) {
            this.displaySize = displaySize;
            return this;
        }
    }
}
