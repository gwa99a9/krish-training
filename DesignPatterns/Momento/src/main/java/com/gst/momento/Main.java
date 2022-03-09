/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.momento;

/**
 *
 * @author OBITO
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CustomTextFile textFile = new CustomTextFile();

        textFile.write("hello world");
        textFile.write("hi how are you");
        textFile.save();
        textFile.write("finx");
        textFile.undo();

        System.out.println(textFile);

        System.out.println();
        Thread.sleep(2000); // sleep to get a different save time

        textFile.write("fine");
        textFile.save();
        System.out.println(textFile);
    }
}

class CustomTextFile {

    private final FileCareTaker careTaker = new FileCareTaker();
    private StringBuilder data = new StringBuilder();
    private Date dateModified = new Date();

    public String getData() {
        return data.toString();
    }

    public void write(String data) {
        this.data.append(System.lineSeparator()).append(data);
        dateModified = new Date();
    }

    public void save() {
        System.out.println("Saving File: Modified at - " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateModified));
        careTaker.addMemento(new CustomTextFileMemento(data));
    }

    public void undo() {
        CustomTextFileMemento memento = careTaker.getLastMemento();
        if (memento != null) {
            System.out.println("Retrieving: Last Modified File : Last save found at - " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateModified));
            this.data = memento.getData();
        }
    }

    @Override
    public String toString() {
        return getData();
    }
}

class CustomTextFileMemento {

    private final StringBuilder data = new StringBuilder();

    public CustomTextFileMemento(StringBuilder data) {
        this.data.append(data);
    }

    public StringBuilder getData() {
        return data;
    }
}

class FileCareTaker {

    private final Stack<CustomTextFileMemento> mementos = new Stack<>();

    public void addMemento(CustomTextFileMemento file) {
        mementos.push(file);
    }

    public CustomTextFileMemento getLastMemento() {
        if (mementos.isEmpty()) {
            return null;
        }
        return mementos.pop();
    }
}
