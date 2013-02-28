
/*
 * 
 */
package layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.AncestorListener;

public class GridBagLayoutDemo {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    static boolean bx1 = false, bx2 = false;
    static int box1 = 0, box2 = 0;
    
    static String comboChoice1 = null, comboChoice2 = null;
    static String time1, time2;
    static String rate1, rate2;
    static String mw1, mw2;
    static JTable table;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        /**declare variables*/
        JPanel periodHelpPanel, knownComboPanel, unknownComboPanel, sliderPanel,
                playPausePanel, tablePanel, boxPanel,checkResetButtonPanel;
        JButton periodButton, helpButton, goButton, playButton, pauseButton, 
                resetButton, checkAnswerButton;
        JLabel gasDiffuseLabel,enterLabel,knownComboBoxLabel,
                unknownComboBoxLabel,tempLabel;
        JScrollPane jsp;
        final JComboBox knownComboBox,unknownComboBox;
        JList knownList,unknownList;
        final JSlider slider;
        
        
        /**make raisedBevel border*/
        Border raisedBevel = BorderFactory.createRaisedSoftBevelBorder();
        
        /**set pane layout to grid bag layout*/
	pane.setLayout(new GridBagLayout());
        
        /**set pane color*/
        pane.setBackground(new Color(12,66,116));
        
        /**make grid bag constraints object*/
	GridBagConstraints c = new GridBagConstraints();
        
        /**natural height, maximum width*/
        if (shouldFill) {
	c.fill = GridBagConstraints.HORIZONTAL;
	}
        
        //*****************************TITLE**************************
        /**title label*/
        gasDiffuseLabel = new JLabel("Gaseous Diffusion");
        
        /**set font for label*/
        gasDiffuseLabel.setFont(new Font("Verdana",Font.BOLD,50));
        
        /**set foreground color for label*/
        gasDiffuseLabel.setForeground(Color.white);
        
        /**set grid bag layout constraints*/
        c.insets = new Insets(10,10,10,10);
        c.ipadx = 0;
        c.ipady = 0;
	c.weightx = 0.5;
        c.weighty = 0;
        c.gridwidth = 15;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
	c.gridx = 0;
	c.gridy = 0;
        
        /**add panel and contraints to pane*/
	pane.add(gasDiffuseLabel, c);
        
        //********PERIODIC TABLE BUTTON AND HELP BUTTON***************
        /**panel for periodButton and helpButton*/
        periodHelpPanel = new JPanel();
        
        /**set panel color*/
        periodHelpPanel.setBackground(new Color(203,228,38));
        
        /**set border for button*/
        periodHelpPanel.setBorder(raisedBevel);
        
        /**make buttons*/
        periodButton = new JButton("Periodic Table");
        helpButton = new JButton("Help");
        
        /**create a listener for the periodic button*/
        periodButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                /**make icon object and reference the periodic table image*/
                final Icon icon = new javax.swing.ImageIcon(getClass().getResource("periodictablesmall.png"));
                
                /**make string title variable*/
                String periodic = "Periodic Table";
                
//                //is not resizable
//                JFrame frame = new JFrame();
//                JOptionPane.showMessageDialog(frame, null, periodic, JOptionPane.INFORMATION_MESSAGE,icon);
                
                /**make joptionpane object*/
                JOptionPane pane = new JOptionPane(icon, JOptionPane.PLAIN_MESSAGE);
                
                /**make jdialog object*/
                JDialog dialog = pane.createDialog(null, periodic);
                
                /**set dialog to resizable*/
                dialog.setResizable(true);
                
                /**make dialog visible*/
                dialog.setVisible(true);
            }
        });        
        
        /**create a listener for the help button*/
        helpButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                /**make icon object and reference the periodic table image*/
                final Icon icon = new javax.swing.ImageIcon(getClass().getResource("periodictablesmall.png"));
                
                /**make string title variable*/
                String help = "Help Readme";
                
                /**make string variable for help content*/
                String helpContent = "This program is designed to show you\n"
                        + "the concept of diffusion.\n\nInstructions: \n"
                        + "Select from the drop down boxes the two elements\n"
                        + "you want to see displayed in the simulation box.\n\n"
                        + "The colors and size of the particles in the box\n"
                        + "will change to represent the elements you've\n"
                        + "chosen.  \n\nAfter one particle of each element"
                        + " has crossed\nthe finish line the table will display"
                        + "the time in\nseconds for each element particle.\n\n"
                        + "Using the periodic table, available by clicking "
                        + "the\nPeriodic Table button, and the information in "
                        + "the table\nat the bottom of the screen you will be "
                        + "able to \ncalculate the rate of speed in meters per "
                        + "second\nand the molecular weight of each particle\n"
                        + "and type them into the table.\n\nYou can then "
                        + "check your answers by using the check\nanswer "
                        + "button. If the answers are correct \nyou'll see "
                        + "'Correct' show \nif the answers are incorrect "
                        + "you'll have the\nchance to change your answers and "
                        + "recheck 2 \nmore times.  Good Luck!";
                        
                
                /**make joptionpane object*/
                JOptionPane pane = new JOptionPane(helpContent, JOptionPane.PLAIN_MESSAGE);
                
                /**make jdialog object*/
                JDialog dialog = pane.createDialog(null, help);
                
                /**set dialog to resizable*/
                dialog.setResizable(true);
                
                /**make dialog visible*/
                dialog.setVisible(true);
            }
        });
        
//                /** create listener for Help button */
//        helpButton.addActionListener(new ActionListener(){
//            String instructions = "Instructions"
//                        + "\n\n1. Helium is selected already, to change the selection of elements choose two elements from the drop down boxes.  "
//                        + "\n2. Click the 'Go' button to start simulation, press any key after that to Pause/Play."
//                        + "\n3. Once the first particle of the first element and the first particle of the second element have crossed the finish line"
//                        + "\n    enter the Rate and MW of the elements in the Table."
//                        + "\n4. Check your answers.  They must be within +/- 5%";
//            
//            public void actionPerformed(ActionEvent e){
//                  JOptionPane.showMessageDialog(null, instructions);               
//            }  
//        });
        
        /**set grid bag layout constraints*/
        /**set fill*/
	c.fill = GridBagConstraints.HORIZONTAL;
        
        /**set padding*/
        c.insets = new Insets(0,0,0,0);
        
        /**set weight*/
        c.weightx = 0.5;
        
        /**set grid position*/
	c.gridx = 9;
	c.gridy = 0;
        
        /**set height and width of grid cell*/
        c.ipadx = 0;
        c.ipady = 0;
        
        /**set anchor point within cell*/
        c.anchor = GridBagConstraints.EAST;
        
        /**add buttons to panel*/
        periodHelpPanel.add(periodButton);
        periodHelpPanel.add(helpButton);
        
        /**add panel and contraints to pane*/
	pane.add(periodHelpPanel, c);
        
        //*********DRAWING START BOX, RACE BOX, GATE AND FINISH*********
        
        /**make boxPanel and set layout to gridbaglayout*/
        boxPanel = new JPanel();
        
        boxPanel.setBackground(new Color(12,66,116));
        
        /**make gaschamber object bt*/
        final GasChamber bt = new GasChamber();
        
        /**initialize bt*/
        bt.init();
        
        /**add bt object to boxPanel*/
        boxPanel.add(bt);
        
        //** initialize particleFill from GasChamber */
        bt.particleFill(0, 0);                 // AEB initialize and for the Combo
                                              // Box listeners and uses the
                                             // variables set by the Combo Boxes
        
        

        /**set grid bag layout constraints*/
        c.insets = new Insets(10,10,10,10);
        c.ipadx = 500;                                              // AEB added
        c.ipady = 200;                                              // AEB added
	c.weightx = 0.5;
        c.gridwidth = 15;                                            // AEB was 1
        c.gridheight = 1;                         // AEB was 5 and commented out
        c.fill = GridBagConstraints.BOTH;
	c.gridx = 0;
	c.gridy = 1;
        
        /**add panel and contraints to pane*/
	pane.add(boxPanel, c);
        
        //*******KNOWN COMBO BOX***********
        
        /**new jpanel for the known molecules combobox*/
        knownComboPanel = new JPanel(new BorderLayout());
        
        /**set panel color*/
        knownComboPanel.setBackground(new Color(203,228,38));
        
        /**set border for button*/
        knownComboPanel.setBorder(raisedBevel);
        
        /**create known combo box list label*/
        knownComboBoxLabel = new JLabel("Select Known Molecules: ");
        
        /**set font for label*/
        knownComboBoxLabel.setFont(new Font("Verdana",Font.BOLD,15));
        
        /**set foreground color for label*/
        knownComboBoxLabel.setForeground(new Color(12,66,116));
        
        /**create array of list data for JList*/
        String [] knownComboBoxListData = {"Helium (He)",
            "Neon (Ne)", "Argon (Ar)",};
        
        /**create combobox and add list data to it*/
        knownComboBox = new JComboBox(knownComboBoxListData);
        
        /**create a courses list*/
        knownList  = new JList(knownComboBoxListData);
        
        /**set visible amount of rows in JList to 1*/
        knownList.setVisibleRowCount(1);
        
        /** listener to start mix using particleFill method from GasChamber */
        knownComboBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                bx1 = true;
                
                box1 = knownComboBox.getSelectedIndex();
                  if (bx1 && bx2){
                      bt.particleFill(box1, box2);
                  }  
            }  
        });
       
        
        /**set grid bag layout constraints*/
	c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(0,10,0,10);
        c.weightx = 0.5;
        c.gridwidth = 1;
	c.gridx = 0;
	c.gridy = 3;
        c.ipadx = 0;
        c.ipady = 0;
        
        /** listener to start mix using particleFill method from GasChamber */
        knownComboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bx1 = true;
                
                /**set box1 to get the selected index*/
                box1 = knownComboBox.getSelectedIndex();
                  if (bx1 && bx2){
                      bt.particleFill(box1, box2);
                  }  
                  
                  if(bx1){
                      /**declares choice1 var. and sets value to selected item*/
                      String choice1 = knownComboBox.getSelectedItem().toString();
                      
                      /**sets value at 0,0 in table to choice1*/
                      table.setValueAt(choice1, 0, 0);
                  }
            }  
        });
        
        /**add combo box label to panel*/
        knownComboPanel.add(knownComboBoxLabel,BorderLayout.NORTH);
        
        /**add combo box label to panel*/
        knownComboPanel.add(knownComboBox,BorderLayout.SOUTH);
        
        /**add panel to pane*/
	pane.add(knownComboPanel, c);

        //***********UNKNOWN/KNOWN COMBO BOX***************
        
        /**create jpanel for the unknown molecules combobox*/
        unknownComboPanel = new JPanel(new BorderLayout());
        
        /**set panel color*/
        unknownComboPanel.setBackground(new Color(203,228,38));
        
        /**set border for button*/
        unknownComboPanel.setBorder(raisedBevel);
        
        /**create known combo box list label*/
        unknownComboBoxLabel = new JLabel("Select Unknown Molecules: ");
        
        /**set font for label*/
        unknownComboBoxLabel.setFont(new Font("Verdana",Font.BOLD,15));
        
        /**set foreground color for label*/
        unknownComboBoxLabel.setForeground(new Color(12,66,116));
        
        /**create array of list data for JList*/
        String [] unknownComboBoxListData = {"Helium (He)", 
            "Neon (Ne)", "Argon (Ar)", "Unknown 1", "Unknown 2", "Unknown 3"};
        
        /**create combobox and add data to it*/
        unknownComboBox = new JComboBox(unknownComboBoxListData);
        
        /**create a list*/
        unknownList  = new JList(unknownComboBoxListData);
        
        /**set visible amount of rows in combo box to 1*/
        unknownList.setVisibleRowCount(1);
        
        /** listener to start mix using particleFill method from GasChamber */
        unknownComboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bx2 = true;
                /**set box2 to get the selected index*/
                box2 = unknownComboBox.getSelectedIndex();
                  if (bx1 && bx2){
                      bt.particleFill(box1, box2);
                  }  
                  
                  if(bx2){
                      /**declares choice2 var. and sets value to selected item*/
                      String choice2 = unknownComboBox.getSelectedItem().toString();
                      /**sets value at 1,0 in table to choice2*/
                      table.setValueAt(choice2, 1, 0);
                  }
            }  
        });
        
        
        /**set grid bag layout constraints*/
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(10,10,10,10);
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 3;
        c.ipadx = 0;
        c.ipady = 0;
        
        /**add combo box label to panel*/
        unknownComboPanel.add(unknownComboBoxLabel,BorderLayout.NORTH);
        
        /**add combo box to panel*/
        unknownComboPanel.add(unknownComboBox,BorderLayout.SOUTH);
        
        /**add panel to pane*/
	pane.add(unknownComboPanel, c);
        
        //*********TEMPERATURE/REACTION RATE +- SLIDER**************
        
        /**make new panel*/
        sliderPanel = new JPanel(new BorderLayout());
        
        /**set panel color*/
        sliderPanel.setBackground(new Color(12,66,116));
        
        /**make slider*/
        slider = new JSlider();
        
        /**set slider color*/
        slider.setBackground(new Color(12,66,116));
        
        /**make temperature label*/
        tempLabel = new JLabel("< - Temperature + >");
        
        /**set font for label*/
        tempLabel.setFont(new Font("Verdana",Font.BOLD,15));
        
        /**set foreground color for label*/
        tempLabel.setForeground(Color.white);
        
        /**set foreground color for slider*/
        slider.setForeground(Color.white);
        
        /**set slider constraints*/
        slider.setSize(100,20);
        slider.setMinimum(10);
        slider.setMaximum(200);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        
        /** listener to update topSpeed in GasChamber and Element */
        slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                float value = slider.getValue();
                
                Element.setTopSpeed((value/10));
            }
        });
        
        
        /**set grid bag layout constraints*/
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,10,0,0);
	c.weightx = 150;
        c.gridwidth = 1;
	c.gridx = 2;
	c.gridy = 3;
        c.ipadx = 0;
        c.ipady = 0;
        
        /**add slider to panel*/
        sliderPanel.add(tempLabel,BorderLayout.NORTH);
        sliderPanel.add(slider, BorderLayout.CENTER);
        
        /**add button to pane*/
	pane.add(sliderPanel, c);
        
        //******************GO BUTTON********************
        
        /**create go button*/
	goButton = new JButton("GO");
        
        /**set button color*/
        goButton.setBackground(new Color(203,228,38));
        
        /**set font for label*/
        goButton.setFont(new Font("Verdana",Font.BOLD,20));
        
        /**set foreground color for label*/
        goButton.setForeground(Color.darkGray);
        
        /**set border for button*/
        goButton.setBorder(raisedBevel);
        
        /** listener to open the gate and start the race */
        goButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                  bt.setGateOpen(true);  
                
            }  
        });
        
        /**set grid bag layout constraints*/
        c.insets = new Insets(0,0,0,30);
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 50;
        c.weighty = 0;
        c.gridwidth = 2;
	c.gridx = 9;
	c.gridy = 3;
        c.ipadx = 30;
        c.ipady = 0;
        
        /**add button to pane*/
	pane.add(goButton, c);
        
        //******************TABLE**********************
        
        /**create panel for table*/
        tablePanel = new JPanel(new BorderLayout());
        
        /**set panel color*/
        tablePanel.setBackground(new Color(12,66,116));
        
        /**create label for table*/
        enterLabel = new JLabel("Use the data in the table to "
        + "compute the Rate and Molecular Weight...");
        
        /**set font for label*/
        enterLabel.setFont(new Font("Verdana",Font.BOLD,20));
        
        /**set foreground color for label*/
        enterLabel.setForeground(Color.white);
        
        /**create arrays for column headings and table data*/
        String [] colHeading = {"Chosen Molecules", "Time", "Rate (m/s)", "Molecular Weight (MW)"};
        String [][] data = {{"","","",""},
            {"","","",""}};
        
        /**create table*/
        table = new JTable(data,colHeading);
        
        /**make tool tip*/
        table.setToolTipText("Enter your answers in the table");
        
        /**make table not enabled to be edited*/
        table.setEnabled(true);
        
        /**create scrollpane for table*/
        jsp = new JScrollPane(table);
        
        /**set grid bag layout constraints*/
	c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10,10,10,10);
        c.weightx = 0;
        c.weighty = 0;
	c.gridx = 0;
	c.gridy = 5;
        c.gridwidth = 15;
        c.ipadx = 50;
        c.ipady = 30;
        
        /**add label to panel*/
        tablePanel.add(enterLabel, BorderLayout.NORTH);
        
        /**add scrollpane to panel*/
        tablePanel.add(jsp);
        
        /**add panel to pane*/
	pane.add(tablePanel, c);
        
        if(Element.getIsWinner() == false){
            
            Double time1 = GasChamber.time1;
            Double time2 = GasChamber.time2;
            
            table.setValueAt(time1.toString(), 0, 1);
            table.setValueAt(time2.toString(), 1, 1);
        }
        
        //*******************CHECK ANSWER AND RESET BUTTONS****************
        
        /**create panel for reset and answer buttons*/
        checkResetButtonPanel = new JPanel();
        
        /**set panel color*/
        checkResetButtonPanel.setBackground(new Color(12,66,116));
        
        /**create reset and answer buttons*/
        resetButton = new JButton("Reset");
        checkAnswerButton = new JButton("Check Answer");
        
        /** listener for reset button */
        resetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bt.setGateOpen(false);
                knownComboBox.setSelectedIndex(0);
                unknownComboBox.setSelectedIndex(0);
                clearTable(table);
                
            }
        });
        
        /** listener for check answer button */
        checkAnswerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                /**get the values from user input cells and compare them to 
                 * correct values*/
                rate1 = table.getValueAt(0,2).toString();
                rate2 = table.getValueAt(1,2).toString();
                mw1 = table.getValueAt(0,3).toString();
                mw2 = table.getValueAt(1,3).toString();
                
                JOptionPane.showMessageDialog(table, rate1);
                JOptionPane.showMessageDialog(table, rate2);
                JOptionPane.showMessageDialog(table,mw1);
                JOptionPane.showMessageDialog(table, mw2);
                
            }
        });
        
        
        /**set grid bag layout constraints*/
	c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0,0,0,0);
	c.weightx = 1;
	c.gridx = 9;
	c.gridy = 7;
        c.gridwidth = 2;
        c.ipadx = 0;
        c.ipady = 0;
        
        /**add buttons to panel*/
        checkResetButtonPanel.add(resetButton);
        checkResetButtonPanel.add(checkAnswerButton);
        
        /**add panel to pane*/
	pane.add(checkResetButtonPanel, c);
    }
    public static void clearTable(final JTable table) {
        for (int i = 0; i < table.getRowCount(); i++)
            for(int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
        }
    }
    
    /**Create the GUI and display it*/
    private static void createAndShowGUI() {
        /**create frame*/
        JFrame frame = new JFrame("GridBagLayoutDemo");
        
        /**set default close operation*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**set up content pane*/
        addComponentsToPane(frame.getContentPane());

        /**display the window*/
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /**Schedule a job for the event-dispatching thread:
         * creating and showing this application's GUI.
         */ 
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
        
    }
}    

