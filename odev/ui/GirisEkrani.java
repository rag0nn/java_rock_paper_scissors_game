/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package odev.ui;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Asus
 */
public class GirisEkrani extends javax.swing.JPanel {

            /**
             * Creates new form GirisEkrani
             */
            public GirisEkrani() {
                        initComponents();
                        tursayisispinner.setValue(1);// tur sayisini 1'den başlat

            
            }

            /**
             * This method is called from within the constructor to initialize
             * the form. WARNING: Do NOT modify this code. The content of this
             * method is always regenerated by the Form Editor.
             */
            @SuppressWarnings("unchecked")
            // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
            private void initComponents() {

                        jLabel3 = new javax.swing.JLabel();
                        ikinciyouncuismi = new javax.swing.JTextField();
                        tursayisispinner = new javax.swing.JSpinner();
                        jLabel7 = new javax.swing.JLabel();
                        jLabel6 = new javax.swing.JLabel();
                        birincioyuncuismi = new javax.swing.JTextField();
                        oyunubaslatbutton = new javax.swing.JButton();
                        jLabel1 = new javax.swing.JLabel();

                        setPreferredSize(new java.awt.Dimension(1200, 700));
                        setLayout(null);

                        jLabel3.setFont(new java.awt.Font("Lithos Pro Regular", 0, 40)); // NOI18N
                        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel3.setText("1. Oyuncu İsmİ");
                        jLabel3.setPreferredSize(new java.awt.Dimension(230, 60));
                        add(jLabel3);
                        jLabel3.setBounds(228, 139, 320, 60);

                        ikinciyouncuismi.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                ikinciyouncuismiActionPerformed(evt);
                                    }
                        });
                        add(ikinciyouncuismi);
                        ikinciyouncuismi.setBounds(636, 217, 331, 60);

                        tursayisispinner.setFont(new java.awt.Font("Letter Gothic Std", 0, 36)); // NOI18N
                        tursayisispinner.addChangeListener(new javax.swing.event.ChangeListener() {
                                    public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                                tursayisispinnerStateChanged(evt);
                                    }
                        });
                        add(tursayisispinner);
                        tursayisispinner.setBounds(806, 331, 87, 95);

                        jLabel7.setFont(new java.awt.Font("Lithos Pro Regular", 0, 40)); // NOI18N
                        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel7.setText("oynanacak tur sayısı");
                        jLabel7.setPreferredSize(new java.awt.Dimension(230, 60));
                        add(jLabel7);
                        jLabel7.setBounds(228, 331, 499, 95);

                        jLabel6.setFont(new java.awt.Font("Lithos Pro Regular", 0, 40)); // NOI18N
                        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
                        jLabel6.setText("2. Oyuncu İsmİ");
                        jLabel6.setPreferredSize(new java.awt.Dimension(230, 60));
                        add(jLabel6);
                        jLabel6.setBounds(228, 217, 320, 60);

                        birincioyuncuismi.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                birincioyuncuismiActionPerformed(evt);
                                    }
                        });
                        add(birincioyuncuismi);
                        birincioyuncuismi.setBounds(636, 139, 331, 60);

                        oyunubaslatbutton.setFont(new java.awt.Font("Lithos Pro Regular", 0, 48)); // NOI18N
                        oyunubaslatbutton.setText("oyunu başlat");
                        oyunubaslatbutton.setActionCommand("oyunubaslatbutton");
                        oyunubaslatbutton.setMaximumSize(new java.awt.Dimension(400, 70));
                        oyunubaslatbutton.setMinimumSize(new java.awt.Dimension(400, 70));
                        oyunubaslatbutton.setPreferredSize(new java.awt.Dimension(400, 70));
                        oyunubaslatbutton.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                oyunubaslatbuttonActionPerformed(evt);
                                    }
                        });
                        add(oyunubaslatbutton);
                        oyunubaslatbutton.setBounds(424, 499, 400, 130);

                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/giris_arkaplan_leonardo.jpg"))); // NOI18N
                        add(jLabel1);
                        jLabel1.setBounds(0, 0, 1310, 770);
            }// </editor-fold>//GEN-END:initComponents
            /**
             * 
             * @param evt   (event)
             * oyunu başlatmak için buttondan action bekler
             */
            private void oyunubaslatbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oyunubaslatbuttonActionPerformed
                        String oyuncuismi1 = birincioyuncuismi.getText();
                        String oyuncuismi2 = ikinciyouncuismi.getText();
                        Object tursayisi = tursayisispinner.getModel().getValue();
            
                        UygulamaEkrani.uygulama.oyunSayfasiniAc(oyuncuismi1,oyuncuismi2,tursayisi);
            }//GEN-LAST:event_oyunubaslatbuttonActionPerformed

            private void birincioyuncuismiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birincioyuncuismiActionPerformed
                        // TODO add your handling code here:
            }//GEN-LAST:event_birincioyuncuismiActionPerformed

            private void ikinciyouncuismiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ikinciyouncuismiActionPerformed
                        // TODO add your handling code here:
            }//GEN-LAST:event_ikinciyouncuismiActionPerformed
            
            /**
             * 
             *Tur sayısını belirlediğmiz spinner,
             * otomatik olarak 10 dan daha büyük veya 1 den daha küçük olamaz
             * 
             */
            private void tursayisispinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tursayisispinnerStateChanged
                        JSpinner s = (JSpinner) evt.getSource();
                        System.out.println(s.getValue());
                        if (s.getValue().equals(11)){
                                    tursayisispinner.setValue(10);
                        }
                        if (s.getValue().equals(0)){
                        tursayisispinner.setValue(1);
                        }
            }//GEN-LAST:event_tursayisispinnerStateChanged


            // Variables declaration - do not modify//GEN-BEGIN:variables
            private javax.swing.JTextField birincioyuncuismi;
            private javax.swing.JTextField ikinciyouncuismi;
            private javax.swing.JLabel jLabel1;
            private javax.swing.JLabel jLabel3;
            private javax.swing.JLabel jLabel6;
            private javax.swing.JLabel jLabel7;
            public javax.swing.JButton oyunubaslatbutton;
            private javax.swing.JSpinner tursayisispinner;
            // End of variables declaration//GEN-END:variables
}