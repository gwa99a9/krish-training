/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gst.prototypedesignpattern;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author obito
 */
public class Helper {

    private static HashMap<String, Camera> cameras = new HashMap<>();

    static ImageIcon tileBarIcon = new ImageIcon("main.png");

    public static String formatName(String name) {
        String re = "Not Selected";
        if (name != null) {
            re = name;
        }
        return re;
    }

    private static Component getParentComponentWithIcon() {
        JFrame jFrame = new JFrame();
        jFrame.setIconImage(tileBarIcon.getImage());
        return jFrame;
    }

    public static boolean save(String brand, String model, String type, String sensor, String imageSen, String videoRes, String storage, String flash, String lcdDisplay, JTable jTable1) {
        if (validate(brand, model, type, sensor, imageSen, videoRes, storage)) {
            return false;
        }
        Camera camera = new Camera(brand, model, type, sensor, imageSen, videoRes, storage, flash, lcdDisplay);
        String id = (cameras.size() + 1) + "";
        cameras.put(id, camera);
        addToTable(id, camera, (DefaultTableModel) jTable1.getModel());
        return true;
    }

    private static void addToTable(String id, Camera c, DefaultTableModel dtm) {
        Vector v = new Vector();
        v.add(id);
        v.add(c.getBrand());
        v.add(c.getModel());
        v.add(c.getType());
        v.add(c.getSensor());
        v.add(c.getImageSen());
        v.add(c.getVideoRes());
        v.add(c.getStorage());
        v.add(c.getFlsh());
        v.add(c.getLcdDisplay());
        dtm.addRow(v);
    }

    private static boolean validate(String brand, String model, String type, String sensor, String imageSen, String videoRes, String storage) {
        if (brand.isEmpty()) {
            popErrorMessage("Please enter the brand name!");
            return true;
        } else if (model.isEmpty()) {
            popErrorMessage("Please enter the model no!");
            return true;
        } else if (type.isEmpty()) {
            popErrorMessage("Please enter the type!");
            return true;
        } else if (sensor.isEmpty()) {
            popErrorMessage("Please enter the sensor name!");
            return true;
        } else if (imageSen.isEmpty()) {
            popErrorMessage("Please enter the image sensor name!");
            return true;
        } else if (videoRes.isEmpty()) {
            popErrorMessage("Please enter the video resolution!");
            return true;
        } else if (storage.isEmpty()) {
            popErrorMessage("Please enter the storage amount!");
            return true;
        }
        return false;
    }

    public static void popInformationMessage(String message) {
        JOptionPane.showMessageDialog(getParentComponentWithIcon(), message, "CameraLK", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void popErrorMessage(String message) {
        JOptionPane.showMessageDialog(getParentComponentWithIcon(), message, "CameraLK", JOptionPane.ERROR_MESSAGE);
    }

    public static void remove(String id, JTable jTable1) {
        cameras.remove(id);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.removeRow(Integer.parseInt(id) - 1);
    }

    public static void clear(JTextField txtBrand, JTextField txtImgSens, JTextField txtModel, JTextField txtSens, JTextField txtStorage, JTextField txtType, JTextField txtVidRes, JComboBox<String> selDisplay, JComboBox<String> selFlash) {
        txtBrand.setText("");
        txtImgSens.setText("");
        txtModel.setText("");
        txtSens.setText("");
        txtStorage.setText("");
        txtType.setText("");
        txtVidRes.setText("");
        selDisplay.setSelectedIndex(0);
        selFlash.setSelectedIndex(0);
    }

    public static void duplicate(String id, JTable jTable1, JTextField txtBrand, JTextField txtImgSens, JTextField txtModel, JTextField txtSens, JTextField txtStorage, JTextField txtType, JTextField txtVidRes, JComboBox<String> selDisplay, JComboBox<String> selFlash) {
        Camera c = cameras.get(id).clone();
        txtBrand.setText(c.getBrand());
        txtImgSens.setText(c.getImageSen());
        txtModel.setText(c.getModel());
        txtSens.setText(c.getSensor());
        txtStorage.setText(c.getStorage());
        txtType.setText(c.getType());
        txtVidRes.setText(c.getVideoRes());
        selDisplay.setSelectedItem(c.getLcdDisplay());
        selFlash.setSelectedItem(c.getFlsh());
    }

    public static void addListener(JTable jTable1, MouseAdapter mouseAdapter) {
        jTable1.addMouseListener(mouseAdapter);
    }

    public static void showSelectedCamera(int row) {
        Camera c = cameras.get(row + 1 + "");
        popInformationMessage(c.toString());
    }

}
