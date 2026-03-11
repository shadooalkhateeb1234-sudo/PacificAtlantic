/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacificatlantic;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

enum CellType { NORMAL, RIVER, DESERT }

class CellButton extends JButton {
    int row, col, height;
    boolean isRiver, isDesert;

    public CellButton(int row, int col, int height, boolean isRiver, boolean isDesert) {
        this.row = row;
        this.col = col;
        this.height = height;
        this.isRiver = isRiver;
        this.isDesert = isDesert;

        setText(String.valueOf(height));
        setFont(new Font("Arial", Font.BOLD, 16));
        updateColor(false);
    }

    public void updateColor(boolean isInResult) {
        if (isDesert) {
            setBackground(Color.YELLOW);
        } else if (isRiver) {
            setBackground(Color.CYAN);
        } else if (isInResult) {
            setBackground(new Color(245, 222, 179)); // Beige
        } else {
            setBackground(Color.WHITE);
        }
    }
}