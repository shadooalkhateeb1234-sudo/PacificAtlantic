/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacificatlantic;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
 
public class WaterFlow  extends JFrame {
    private static final int SIZE = 5;
    private CellButton[][] cells = new CellButton[SIZE][SIZE];
    private int[][] heights = {
        {1,2,2,3,5},
        {3,2,3,4,4},
        {2,4,5,3,1},
        {6,7,1,4,5},
        {5,1,1,2,4}
    };
       private final boolean[][] rivers = {
        {false, false, false, false, true},
        {false, false, false, false, false},
        {false, false, true, false, false},
        {false, false, false, false, false},
        {false, false, false, false, false}
    };

    private final boolean[][] deserts = {
        {false, false, false, false, false},
        {false, true, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false, true}
    };
      
    public WaterFlow () {
        setTitle(" pacificAtlantic ");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         PacificAtlantic  solver = new PacificAtlantic ();
 
         setVisible(true);
        setLayout(new BorderLayout());

        
        JLabel title = new JLabel(" pacificAtlantic", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBackground(Color.blue);
        add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());

        JPanel pacificPanel = new JPanel(new GridLayout(SIZE, 1));
            pacificPanel.setBackground(Color.BLUE);
            JLabel labelleft = new JLabel("Pacific ", SwingConstants.LEFT);
            labelleft.setFont(new Font("Arial", Font.PLAIN, 20));
            pacificPanel.add(labelleft);
        
        JPanel rightPanel = new JPanel(new GridLayout(SIZE, 1));
           rightPanel.setBackground(Color.CYAN);
           JLabel labell = new JLabel("Atlantic Ocean", SwingConstants.RIGHT);
           labell.setFont(new Font("Arial", Font.PLAIN, 20));
            rightPanel.add(labell);

          JPanel atlanticPanel = new JPanel(new GridLayout(1, SIZE));
          atlanticPanel.setBackground(Color.CYAN);
            JLabel label = new JLabel("Atlantic Ocean", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 24));
            atlanticPanel.add(label);
        
            JPanel abovPanel = new JPanel(new GridLayout(1, SIZE));
            abovPanel.setBackground(Color.BLUE);
            JLabel abovlabel = new JLabel("Atlantic Ocean", SwingConstants.CENTER);
            abovlabel.setFont(new Font("Arial", Font.PLAIN, 20));
             abovPanel.add(abovlabel, BorderLayout.NORTH);
        
          JPanel gridPanel = new JPanel(new GridLayout(SIZE, SIZE));
         for (int i = 0; i < heights.length; i++) {
         for (int j = 0; j < heights[0].length; j++) {
            CellButton btn = new CellButton(i, j, heights[i][j], rivers[i][j], deserts[i][j]);
            cells[i][j] = btn;
            gridPanel.add(btn);
    }

        }

        centerPanel.add(pacificPanel, BorderLayout.WEST);
        centerPanel.add(gridPanel, BorderLayout.CENTER);
        centerPanel.add(atlanticPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);
JButton simulateBtn = new JButton(" start ");
simulateBtn.addActionListener(e -> {
    
    List<List<Integer>> result = solver.pacificAtlantic(heights, rivers, deserts);

    for (int i = 0; i < heights.length; i++) {
        for (int j = 0; j < heights[0].length; j++) {
            boolean isInResult = result.contains(Arrays.asList(i, j));
            cells[i][j].updateColor(isInResult);
        }
    }
});
    add(simulateBtn, BorderLayout.SOUTH);
      setVisible(true);
     
    
    }
 
}  

