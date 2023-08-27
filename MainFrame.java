package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.PrintWriter;

import static org.example.CollectionofCollors.*;

public class MainFrame extends JFrame {
    //Komponenty
    JPanel pNorth,pCenter,pEast;
    JTextField tfJmeno, tfRed, tfGreen, tfBlue, tfColor;
    JButton btnSubmit, btnOdeber, btnZobraz, btnExportuj;
    JTable table ;
    //Konstruktor
    public MainFrame(){
        InitGUI();
        setSize(640,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Collorfull-World-v2 GUI");
    }
    //GUI
    public void InitGUI(){
        pNorth = new JPanel(new GridLayout(1,5));
            tfJmeno = new JTextField("Jméno"); pNorth.add(tfJmeno);
            tfRed = new JTextField("Red"); pNorth.add(tfRed);
            tfGreen = new JTextField("Green"); pNorth.add(tfGreen);
            tfBlue = new JTextField("Blue"); pNorth.add(tfBlue);
            btnSubmit = new JButton("Submit"); pNorth.add(btnSubmit);
            btnSubmit.addActionListener(e -> {
                String jmeno = tfJmeno.getText();
                int red = Integer.parseInt(tfRed.getText());
                int green = Integer.parseInt(tfGreen.getText());
                int blue = Integer.parseInt(tfBlue.getText());
                if( red > 255 || green > 255 || blue > 255){
                    JOptionPane.showMessageDialog(this,"Byly zadány hodnoty přesahující hranice","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Color color = new Color(jmeno,red,green,blue);
                    addCollor(color);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{jmeno,String.valueOf(red),String.valueOf(green),String.valueOf(blue),color.getHexCode()});
                    tfColor.setBackground(new java.awt.Color(red,green,blue));
                }
            });
        add(pNorth,BorderLayout.NORTH);

        pCenter = new JPanel(new GridLayout(1,1));
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Jméno");
            model.addColumn("Red");
            model.addColumn("Green");
            model.addColumn("Blue");
            model.addColumn("Hex");
            table = new JTable(model);pCenter.add(table);
        add(pCenter);

        pEast = new JPanel(new GridLayout(4,1));
            tfColor = new JTextField(); pEast.add(tfColor);
            btnOdeber = new JButton("Odeber"); pEast.add(btnOdeber);
            btnOdeber.addActionListener(e -> {
                int row = table.getSelectedRow();
                model.removeRow(row);
            });
            btnZobraz = new JButton("Zobraz"); pEast.add(btnZobraz);
            btnZobraz.addActionListener(e -> {
                int row = table.getSelectedRow();
                int red =  Integer.parseInt((String) model.getValueAt(row,1));
                int green = Integer.parseInt((String) model.getValueAt(row,2));
                int bluee = Integer.parseInt((String) model.getValueAt(row,3));
                tfColor.setBackground(new java.awt.Color(red,green,bluee));
            });
            btnExportuj = new JButton("Exportuj"); pEast.add(btnExportuj);
            btnExportuj.addActionListener(e ->{
                //TODO
                try {
                    PrintWriter vystup = new PrintWriter("Export.txt");
                    vystup.println("Export Barev");
                    for (int rows = 0; rows < model.getRowCount(); rows++) {
                        for (int collums = 0; collums < model.getColumnCount(); collums++) {
                            vystup.print(model.getValueAt(rows,collums));
                            vystup.print(" ");
                        }
                        vystup.println();
                    }
                    vystup.close();
                }catch (Exception a){
                    a.printStackTrace();
                }
            });
        add(pEast,BorderLayout.EAST);

        pack();
    }
    //Main
    public static void main(String[] args){
        new MainFrame().setVisible(true);
    }
}
