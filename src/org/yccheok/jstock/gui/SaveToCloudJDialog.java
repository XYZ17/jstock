/*
 * JStock - Free Stock Market Software
 * Copyright (C) 2011 Yan Cheng CHEOK <yccheok@yahoo.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.yccheok.jstock.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.zip.ZipOutputStream;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yccheok.jstock.engine.Country;
import org.yccheok.jstock.gui.analysis.MemoryLogJDialog;
import org.yccheok.jstock.internationalization.GUIBundle;
import org.yccheok.jstock.internationalization.MessagesBundle;
import org.yccheok.jstock.network.Utils.Type;

/**
 *
 * @author yccheok
 */
public class SaveToCloudJDialog extends javax.swing.JDialog {

    /** Creates new form LoadFromCloudJDialog */
    public SaveToCloudJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.jLabel3.setVisible(false);
        this.jLabel4.setVisible(false);
        this.jLabel5.setVisible(false);

        final JStockOptions jStockOptions = MainFrame.getInstance().getJStockOptions();
        if (jStockOptions.isRememberGoogleAccountEnabled()) {
            this.jCheckBox1.setSelected(true);
            this.jTextField1.setText(Utils.decrypt(jStockOptions.getGoogleUsername()));
            this.jPasswordField1.setText(Utils.decrypt(jStockOptions.getGooglePassword()));
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/yccheok/jstock/data/gui"); // NOI18N
        setTitle(bundle.getString("SaveToCloudJDialog_Title")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(jPanel5, java.awt.BorderLayout.WEST);
        getContentPane().add(jPanel6, java.awt.BorderLayout.EAST);

        jXHeader1.setDescription(bundle.getString("SaveToCloudJDialog_Description")); // NOI18N
        jXHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/32x32/upload_to_cloud.png"))); // NOI18N
        jXHeader1.setTitle(bundle.getString("SaveToCloudJDialog_Title")); // NOI18N
        getContentPane().add(jXHeader1, java.awt.BorderLayout.NORTH);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/apply.png"))); // NOI18N
        jButton1.setText(bundle.getString("SaveToCloudJDialog_OK")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/button_cancel.png"))); // NOI18N
        jButton2.setText(bundle.getString("SaveToCloudJDialog_Cancel")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.BorderLayout(5, 5));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText(bundle.getString("SaveToCloudJDialog_SavingToCloud...")); // NOI18N
        jPanel4.add(jLabel3);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/spinner.gif"))); // NOI18N
        jPanel4.add(jLabel4);

        jLabel5.setText(bundle.getString("WizardDownloadlIndicatorJPanel_ViewLog")); // NOI18N
        this.jLabel3.setVisible(false);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel4.add(jLabel5);

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("SaveToCloudJDialog_GoogleAccount"))); // NOI18N

        jLabel1.setText(bundle.getString("SaveToCloudJDialog_Username")); // NOI18N

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("SaveToCloudJDialog_Password")); // NOI18N

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getSize()-1f));
        jLabel6.setText(bundle.getString("SaveToCloudJDialog_EmailExample")); // NOI18N

        jCheckBox1.setText(bundle.getString("SaveToCloudJDialog_KeepMeSignedIn")); // NOI18N

        jLabel7.setText(bundle.getString("SaveToCloudJDialog_ViewPrivacyInformation")); // NOI18N
        this.jLabel3.setVisible(false);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-420)/2, (screenSize.height-331)/2, 420, 331);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cancel();
        final JStockOptions jStockOptions = MainFrame.getInstance().getJStockOptions();
        // No matter Cancel or OK, once user untick, we will remove account
        // information.
        if (this.jCheckBox1.isSelected() == false) {
            jStockOptions.setRememberGoogleAccountEnabled(false);
            jStockOptions.setGoogleUsername("");
            jStockOptions.setGooglePassword("");
        }
    }//GEN-LAST:event_formWindowClosed

    private void cancel() {
        if (saveToCloudTask != null) {
            saveToCloudTask.cancel(true);
            saveToCloudTask = null;
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        MemoryLogJDialog memoryLogJDialog = new MemoryLogJDialog(MainFrame.getInstance(), true);
        memoryLogJDialog.setLocationRelativeTo(this);
        memoryLogJDialog.setLog(memoryLog);
        memoryLogJDialog.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jLabel5MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.jTextField1.getText().trim().length() == 0)
        {
            JOptionPane.showMessageDialog(this, MessagesBundle.getString("warning_message_username_cannot_be_empty"), MessagesBundle.getString("warning_title_username_cannot_be_empty"), JOptionPane.WARNING_MESSAGE);
            this.jTextField1.requestFocus();
            return;
        }

        if (false == org.apache.commons.validator.EmailValidator.getInstance().isValid(this.jTextField1.getText().trim())) {
            JOptionPane.showMessageDialog(this, MessagesBundle.getString("warning_message_invalid_email_address"), MessagesBundle.getString("warning_title_invalid_email_address"), JOptionPane.WARNING_MESSAGE);
            this.jTextField1.requestFocus();
            return;
        }

        if (this.jPasswordField1.getPassword().length == 0)
        {
            JOptionPane.showMessageDialog(this, MessagesBundle.getString("warning_message_password_cannot_be_empty"), MessagesBundle.getString("warning_title_password_cannot_be_empty"), JOptionPane.WARNING_MESSAGE);
            this.jPasswordField1.requestFocus();
            return;
        }

        final String password = new String(jPasswordField1.getPassword()).trim();
        if (password.length() == 0)
        {
            JOptionPane.showMessageDialog(this, MessagesBundle.getString("warning_message_password_cannot_be_empty"), MessagesBundle.getString("warning_title_password_cannot_be_empty"), JOptionPane.WARNING_MESSAGE);
            this.jPasswordField1.requestFocus();
            return;
        }

        this.jButton1.setEnabled(false);
        this.jTextField1.setEnabled(false);
        this.jPasswordField1.setEnabled(false);
        this.jCheckBox1.setEnabled(false);

        // Update GUI immediately. So that user will not feel our app is slow.
        jLabel3.setText(GUIBundle.getString("SaveToCloudJDialog_PreparingData..."));
        jLabel4.setIcon(Icons.BUSY);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);

        this.saveToCloudTask = this.getSaveToCloudTask();
        this.saveToCloudTask.execute();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Utils.launchWebBrowser(org.yccheok.jstock.network.Utils.getURL(Type.PRIVACY_HTML));
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jLabel7MouseExited

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private static class Status {
        public final String message;
        public final Icon icon;
        private Status(String message, Icon icon) {
            if (message == null || icon == null) {
                throw new IllegalArgumentException("Method arguments cannot be null");
            }
            this.message = message;
            this.icon = icon;
        }
        public static Status newInstance(String message, Icon icon) {
            return new Status(message, icon);
        }
    }

    private SwingWorker<Boolean, Status> getSaveToCloudTask() {
        SwingWorker<Boolean, Status> worker = new SwingWorker<Boolean, Status>() {
            @Override
            protected void done() {
                boolean result = false;

                // Some developers suggest to catch this exception, instead of
                // checking on isCancelled. As I am not confident by merely
                // isCancelled check can prevent CancellationException (What
                // if cancellation is happen just after isCancelled check?),
                // I will apply both techniques. 
                if (this.isCancelled() == false) {
                    try {
                        result = this.get();
                    } catch (InterruptedException ex) {
                        log.error(null, ex);
                    } catch (ExecutionException ex) {
                        log.error(null, ex);
                    } catch (CancellationException ex) {
                        log.error(null, ex);
                    }
                }

                jButton1.setEnabled(true);
                jTextField1.setEnabled(true);
                jPasswordField1.setEnabled(true);
                jCheckBox1.setEnabled(true);

                if (result == true) {
                    JOptionPane.showMessageDialog(SaveToCloudJDialog.this, GUIBundle.getString("SaveToCloudJDialog_Success"));
                    
                    final JStockOptions jStockOptions = MainFrame.getInstance().getJStockOptions();
                    // Only save account information when cloud operation success.
                    if (jCheckBox1.isSelected() == true) {
                        jStockOptions.setRememberGoogleAccountEnabled(true);
                        jStockOptions.setGoogleUsername(Utils.encrypt(jTextField1.getText().trim()));
                        jStockOptions.setGooglePassword(Utils.encrypt(new String(jPasswordField1.getPassword())).trim());
                    }
                    // Close the dialog once cloud operation success.
                    setVisible(false);
                    dispose();
                }
            }

            @Override
            protected void process(java.util.List<Status> statuses) {
                for (Status status : statuses) {
                    writeToMemoryLog(status.message);
                    jLabel3.setText(status.message);
                    jLabel4.setIcon(status.icon);
                    jLabel3.setVisible(true);
                    jLabel4.setVisible(true);
                    if (status.icon == Icons.ERROR || status.icon == Icons.WARNING) {
                        jLabel3.setForeground(Color.RED);
                        jLabel5.setVisible(true);
                    }
                    else
                    {
                        jLabel3.setForeground(Color.BLUE);
                        jLabel5.setVisible(false);
                    }
                }
            }

            @Override
            protected Boolean doInBackground() {
                if (isCancelled()) {
                    return false;
                }

                memoryLog.clear();

                publish(Status.newInstance(GUIBundle.getString("SaveToCloudJDialog_PreparingData..."), Icons.BUSY));

                MainFrame.getInstance().commitBeforeUploadToCloud();
                
                final File zipFile = getJStockZipFile();
                
                // Place isCancelled check after time consuming operation.
                // Not the best way, but perhaps the easiest way to cancel
                // the operation.
                if (isCancelled()) {
                    return false;
                }

                if (zipFile == null) {
                    publish(Status.newInstance(GUIBundle.getString("SaveToCloudJDialog_PreparingDataFail"), Icons.ERROR));
                    return false;
                }

                publish(Status.newInstance(GUIBundle.getString("SaveToCloudJDialog_VerifyGoogleAccount..."), Icons.BUSY));

                final String username = jTextField1.getText().trim();
                final String password = new String(jPasswordField1.getPassword()).trim();
                if (false == Utils.saveToCloud(username, password, zipFile)) {
                    publish(Status.newInstance(GUIBundle.getString("SaveToCloudJDialog_VerifyGoogleAccountFail"), Icons.ERROR));
                    return false;
                }

                publish(Status.newInstance(GUIBundle.getString("SaveToCloudJDialog_Success"), Icons.OK));

                return true;
            }
        };
        return worker;
    }

    private static class FileEx {
        final File input;       // Source for input disk file.
        final String output;    // Entry name for output zip file.
        private FileEx(File input, String output) {
            this.input = input;
            this.output = output;
        }
        public static FileEx newInstance(File input, String output) {
            return new FileEx(input, output);
        }
    }

    // Version of getFileEx which ignores LastErrorCode.
    private List<FileEx> getFileEx(List<FileEx> fileExs, String name) {
        return getFileEx(fileExs, name, null);
    }

    // name can be anything which is found under directory
    // C:\Users\yccheok\.jstock\1.0.5
    // For example, "Australia", "config", "chat"...
    // The returned FileEx list, will only contain files. No directories
    // will be included.
    private List<FileEx> getFileEx(List<FileEx> fileExs, String name, LastErrorCode lastErrorCode) {
        final File dir = new File(org.yccheok.jstock.gui.Utils.getUserDataDirectory() + name);

        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String child : children) {
				// Must call back method with lastErrorCode.
                getFileEx(fileExs, name + File.separator + child, lastErrorCode);
            }
        }
        else {
            if (name.equalsIgnoreCase("config" + File.separator + "options.xml")) {
                // Special case. Skip it! We will handle it through insensitiveClone.
            } else if (name.contains("watchlist") && name.endsWith("realtimestock.xml")) {
                // Some users add all stocks into a watchlist. Since the file
                // will be very large (around 50MB). We have no way, but ignore
                // the file.
                if (dir.length() < 1024 * 1024 * 24) {
                    // Currently, we place 24MB as our limitation.
                    fileExs.add(FileEx.newInstance(dir, name));
                } else {
                    // Flag a warning. We are going to tell user that his file
                    // will be ignored.
					if (lastErrorCode != null) {
                    	lastErrorCode.flag = true;
					}
                }
            }
            else {
                fileExs.add(FileEx.newInstance(dir, name));
            }
        }
        return fileExs;
    }

    /**
     * LastErrorCode is used to indicate whether something has gone wrong during
     * getFileEx operation.
     */
    private static class LastErrorCode {
        /**
         * When false, it means everything just fine.
         */
        boolean flag = false;
    }

    // We will ask user whether he want to continue to save to cloud, as we are
    // going to ignore his stock watchlist file(s). Returns true if user wants
    // to continue.
    private boolean promptUserToContinue(final List<Country> countryWithWatchlistFilesBeingIgnored) {
        if (countryWithWatchlistFilesBeingIgnored.isEmpty()) {
            // No watchlist file(s) is ignored.
            return true;
        }

        int size = countryWithWatchlistFilesBeingIgnored.size();
        final String message;
        final String title;
        if (size == 1) {
            message = MessageFormat.format(MessagesBundle.getString("question_message_too_many_stocks_during_save_to_cloud_template"), countryWithWatchlistFilesBeingIgnored.get(0));
            title = MessagesBundle.getString("question_title_too_many_stocks_during_save_to_cloud");
        } else {
            message = MessageFormat.format(MessagesBundle.getString("question_message_too_many_stocks_in_multiple_countries_during_save_to_cloud_template"), size);
            title = MessagesBundle.getString("question_title_too_many_stocks_in_multiple_countries_during_save_to_cloud");
        }


        // Ensure thread safety when we pop up confirmation dialog box. Is it
        // possible to cause deadlock due to invokeAndWait?
        final int[] choice = new int[1];
        choice[0] = JOptionPane.NO_OPTION;
        if (SwingUtilities.isEventDispatchThread()) {
            choice[0] = JOptionPane.showConfirmDialog(SaveToCloudJDialog.this, message, title, JOptionPane.YES_NO_OPTION);
        } else {
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    @Override
                    public void run() {
                        choice[0] = JOptionPane.showConfirmDialog(SaveToCloudJDialog.this, message, title, JOptionPane.YES_NO_OPTION);
                    }
                });
            } catch (InterruptedException ex) {
                log.error(null, ex);
            } catch (InvocationTargetException ex) {
                log.error(null, ex);
            }
        }
        return choice[0] == JOptionPane.YES_OPTION;
    }

    private File getJStockZipFile() {
        // Look for "user-defined-database.xml" for all countries.
        final List<File> files = getUserDefinedDatabaseFiles();
        final List<FileEx> fileExs = new ArrayList<FileEx>();
        for (File file : files) {
            final String filename;
            try {
                filename = file.getCanonicalPath();
            } catch (IOException ex) {
                // Should we return null? As the saved information is not complete.
                log.error(null, ex);
                continue;
            }
            final int index = filename.indexOf(Utils.getApplicationVersionString());
            if (index < 0) {
                continue;
            }
            final String output = filename.substring(index + Utils.getApplicationVersionString().length() + File.separator.length());
            fileExs.add(FileEx.newInstance(file, output));
        }

        final JStockOptions jStockOptions = MainFrame.getInstance().getJStockOptions();
        // User will sue us, if we store their Google account information in our server.
        // Let's get a copy of JStockOptions, without any sensitive data.
        final JStockOptions insensitiveJStockOptions = jStockOptions.insensitiveClone();
        try {
            final File tempJStockOptions = File.createTempFile(Utils.getJStockUUID(), ".xml");
            // Delete temp file when program exits.
            tempJStockOptions.deleteOnExit();
            org.yccheok.jstock.gui.Utils.toXML(insensitiveJStockOptions, tempJStockOptions);
            fileExs.add(FileEx.newInstance(tempJStockOptions, "config" + File.separator + "options.xml"));
        } catch (IOException ex) {
            // Should we return null? As the saved information is not complete.
            log.error(null, ex);
        }

        final List<Country> countryWithWatchlistFilesBeingIgnored = new ArrayList<Country>();
        getFileEx(fileExs, "config");
        getFileEx(fileExs, "indicator");
        getFileEx(fileExs, "logos");
        for (Country country : Country.values()) {
            getFileEx(fileExs, country + File.separator + "portfolios");
            // For legacy usage. Shall be removed after a few more release
            // later than 1.0.5k
            getFileEx(fileExs, country + File.separator + "config");

            LastErrorCode lastErrorCode = new LastErrorCode();
            getFileEx(fileExs, country + File.separator + "watchlist", lastErrorCode);
            if (lastErrorCode.flag) {
                // Watchlist file(s) is being ignored due to too much stocks in
                // the watchlist.
                countryWithWatchlistFilesBeingIgnored.add(country);
            }
        }

        if (false == promptUserToContinue(countryWithWatchlistFilesBeingIgnored)) {
            return null;
        }

        // Create a buffer for reading the files
        final byte[] buf = new byte[1024];

        ZipOutputStream out = null;
        File temp = null;
        
        try {

            // Create the ZIP file
            temp = File.createTempFile(Utils.getJStockUUID(), ".zip");
            // Delete temp file when program exits.
            temp.deleteOnExit();
            out = new ZipOutputStream(new FileOutputStream(temp));

            // Compress the files
            for (FileEx fileEx : fileExs) {
                FileInputStream in = null;
                try {
                    in = new FileInputStream(fileEx.input);
                    final String zipEntryName = fileEx.output;
                    // Add ZIP entry to output stream.
                    out.putNextEntry(Utils.getZipEntry(zipEntryName));

                    // Transfer bytes from the file to the ZIP file
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                }
                catch (IOException exp) {
                    log.error(null, exp);
                    // Should we return null? As the saved information is not complete.
                    continue;
                }
                finally {
                    // Complete the entry
                    Utils.closeEntry(out);
                    Utils.close(in);
                }
            }
        } 
        catch (IOException exp) {
            // Should we return null? As the saved information is not complete.
            log.error(null, exp);
        }
        finally {
            Utils.close(out);
        }
        return temp;
    }

    private List<File> getUserDefinedDatabaseFiles() {
        final List<File> files = new ArrayList<File>();
        for (Country country : Country.values()) {
            final File file = new File(org.yccheok.jstock.gui.Utils.getUserDataDirectory() + country + File.separator + "database" + File.separator + "user-defined-database.xml");
            if (file.exists()) {
                files.add(file);
            }
        }
        return files;
    }

    private void writeToMemoryLog(String message) {
        // http://www.leepoint.net/notes-java/io/10file/sys-indep-newline.html
        // public static String newline = System.getProperty("line.separator");
        // When NOT to use the system independent newline characters
        // JTextArea lines should be separated by a single '\n' character, not the sequence that is used for file line separators in the operating system.
        // Console output (eg, System.out.println()), works fine with '\n', even on Windows.
        final DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
        final String s = dateFormat.format(new Date()) + "\n" + message;
        this.memoryLog.add(s);
    }

    private volatile SwingWorker<Boolean, Status> saveToCloudTask = null;
    private final List<String> memoryLog = new ArrayList<String>();

    private static final Log log = LogFactory.getLog(LoadFromCloudJDialog.class);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    // End of variables declaration//GEN-END:variables

}
