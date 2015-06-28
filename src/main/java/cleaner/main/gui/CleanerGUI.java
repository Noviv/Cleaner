package cleaner.main.gui;

import cleaner.cleaners.BruteDirectoryCleaner;
import cleaner.cleaners.BruteDualCleaner;
import cleaner.cleaners.BruteFileCleaner;
import cleaner.cleaners.Cleaner;
import cleaner.utils.CleanerTextUtils;
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

public class CleanerGUI extends javax.swing.JFrame {

    private Cleaner cleaner;
    private File[] emptiesList;
    private long selectedBytes;

    public CleanerGUI() {
        emptiesList = new File[]{};
        selectedBytes = 0l;
        initComponents();
        setLocationRelativeTo(null);
        bothCleanerButton.setEnabled(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeButtonGroup = new javax.swing.ButtonGroup();
        cleanerProgressBar = new javax.swing.JProgressBar();
        fileCleanerButton = new javax.swing.JRadioButton();
        directoryCleanerButton = new javax.swing.JRadioButton();
        bothCleanerButton = new javax.swing.JRadioButton();
        typeLabel = new javax.swing.JLabel();
        runButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        excludedTextArea = new javax.swing.JTextArea();
        typeLabel1 = new javax.swing.JLabel();
        selectedBytesLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cleaner");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        cleanerProgressBar.setToolTipText("Progress");
        cleanerProgressBar.setString("");
        cleanerProgressBar.setStringPainted(true);

        typeButtonGroup.add(fileCleanerButton);
        fileCleanerButton.setSelected(true);
        fileCleanerButton.setText("File");

        typeButtonGroup.add(directoryCleanerButton);
        directoryCleanerButton.setText("Directory");

        typeButtonGroup.add(bothCleanerButton);
        bothCleanerButton.setText("Both");
        bothCleanerButton.setEnabled(false);

        typeLabel.setText("Cleaner Type");

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        fileList.setModel(new AbstractListModel() {
            public int getSize() {
                return emptiesList.length;
            }

            public Object getElementAt(int i) {
                return emptiesList[i].getAbsolutePath();
            }
        });
        fileList.setToolTipText("Select items to delete.");
        fileList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(fileList);

        jButton1.setText("Delete Selected");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        excludedTextArea.setColumns(20);
        excludedTextArea.setLineWrap(true);
        excludedTextArea.setRows(5);
        excludedTextArea.setText("Click here to add excluded directories/files and seperate with commas.");
        excludedTextArea.setToolTipText("Add excluded directories/files and seperate with commas.");
        excludedTextArea.setWrapStyleWord(true);
        excludedTextArea.setDisabledTextColor(new java.awt.Color(159, 182, 205));
        excludedTextArea.setEnabled(false);
        excludedTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excludedTextAreaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(excludedTextArea);

        typeLabel1.setText("Excluded Directories/Files");

        selectedBytesLabel.setText("0 bytes");

        jMenu1.setText("Cleaner");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Quit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cleanerProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(typeLabel)
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bothCleanerButton)
                            .addComponent(directoryCleanerButton)
                            .addComponent(fileCleanerButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(typeLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(runButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectedBytesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(fileCleanerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directoryCleanerButton)
                    .addComponent(typeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bothCleanerButton)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(typeLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(runButton)
                .addGap(11, 11, 11)
                .addComponent(cleanerProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectedBytesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(58, 58, 58))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        cleanerProgressBar.setString("0.00%");
        cleanerProgressBar.setValue(0);
        if (fileCleanerButton.isSelected()) {
            cleaner = new BruteFileCleaner(new ArrayList<String>(Arrays.asList(excludedTextArea.getText().split(","))), false);
        } else if (directoryCleanerButton.isSelected()) {
            cleaner = new BruteDirectoryCleaner(new ArrayList<String>(Arrays.asList(excludedTextArea.getText().split(","))), false);
        } else if (bothCleanerButton.isSelected()) {
            cleaner = new BruteDualCleaner(new ArrayList<String>(Arrays.asList(excludedTextArea.getText().split(","))), false);
        } else {
            JOptionPane.showMessageDialog(null, "Must select a cleaner type.");
            return;
        }
        cleaner.setJProgressBar(cleanerProgressBar);
        runButton.setEnabled(false);
        new Thread(() -> {
            ArrayList<File> a = cleaner.getEmpties();
            cleanerProgressBar.setValue(100);
            cleanerProgressBar.setString("100.00%");
            emptiesList = new File[a.size()];
            for (int i = 0; i < emptiesList.length; i++) {
                emptiesList[i] = a.get(i);
            }
            runButton.setEnabled(true);
            fileList.setListData(emptiesList);
        }).start();
    }//GEN-LAST:event_runButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (int i : fileList.getSelectedIndices()) {
            File f = emptiesList[i];
            if (!emptiesList[i].delete()) {
                switch (JOptionPane.showOptionDialog(null, "Could not delete " + f.getName(), "Delete Failed", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new String[]{"OK", "Open In Explorer"}, "OK")) {
                    case 1:
                        try {
                            Desktop.getDesktop().open(f);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Could not open file in explorer.");
                        }
                        break;
                    case 0:
                    case -1:
                        break;
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void excludedTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excludedTextAreaMouseClicked
        excludedTextArea.setEnabled(true);
        excludedTextArea.setLineWrap(false);
        excludedTextArea.setWrapStyleWord(false);
        excludedTextArea.setText("");
    }//GEN-LAST:event_excludedTextAreaMouseClicked

    private void fileListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileListMouseClicked
        selectedBytes = 0l;
        for (int i : fileList.getSelectedIndices()) {
            selectedBytes += emptiesList[i].length();
        }
        selectedBytesLabel.setText(selectedBytes + " bytes");
    }//GEN-LAST:event_fileListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bothCleanerButton;
    private javax.swing.JProgressBar cleanerProgressBar;
    private javax.swing.JRadioButton directoryCleanerButton;
    private javax.swing.JTextArea excludedTextArea;
    private javax.swing.JRadioButton fileCleanerButton;
    private javax.swing.JList fileList;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton runButton;
    private javax.swing.JLabel selectedBytesLabel;
    private javax.swing.ButtonGroup typeButtonGroup;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel typeLabel1;
    // End of variables declaration//GEN-END:variables
}
