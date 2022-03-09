/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gst.prototypedesignpattern;

/**
 *
 * @author obito
 */
public class Camera implements CameraPrototype {

    private String brand;
    private String model;
    private String type;
    private String sensor;
    private String imageSen;
    private String videoRes;
    private String storage;
    private String flash;
    private String lcdDisplay;

    public Camera(String brand, String model, String type, String sensor, String imageSen, String videoRes, String storage, String flsh, String lcdDisplay) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.sensor = sensor;
        this.imageSen = imageSen;
        this.videoRes = videoRes;
        this.storage = storage;
        this.flash = flsh;
        this.lcdDisplay = lcdDisplay;
    }

    public String getLcdDisplay() {
        return lcdDisplay;
    }

    public void setLcdDisplay(String lcdDisplay) {
        this.lcdDisplay = lcdDisplay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getImageSen() {
        return imageSen;
    }

    public void setImageSen(String imageSen) {
        this.imageSen = imageSen;
    }

    public String getVideoRes() {
        return videoRes;
    }

    public void setVideoRes(String videoRes) {
        this.videoRes = videoRes;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getFlsh() {
        return flash;
    }

    public void setFlsh(String flsh) {
        this.flash = flsh;
    }

    @Override
    public String toString() {
        String lineSep = System.lineSeparator();
        StringBuilder result = new StringBuilder();
        result.append("Brand : ").append(Helper.formatName(brand)).append(lineSep);
        result.append("Model : ").append(Helper.formatName(model)).append(lineSep);
        result.append("Type : ").append(Helper.formatName(type)).append(lineSep);
        result.append("Sensor : ").append(Helper.formatName(sensor)).append(lineSep);
        result.append("Image Sensor : ").append(Helper.formatName(imageSen)).append(lineSep);
        result.append("Video Resolution : ").append(Helper.formatName(videoRes)).append(lineSep);
        result.append("Storage : ").append(Helper.formatName(storage)).append(lineSep);
        result.append("Flash : ").append(Helper.formatName(flash)).append(lineSep);
        result.append("LCD Display : ").append(Helper.formatName(lcdDisplay)).append(lineSep);
        return result.toString();
    }

    @Override
    public Camera clone() {
        return new Camera(this.brand, this.model, this.type, this.sensor, this.imageSen, this.videoRes, this.storage, this.flash, this.lcdDisplay);
    }

}
