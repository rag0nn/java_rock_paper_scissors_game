
package odev.ui;


public class SonucEkrani extends javax.swing.JPanel {
            /**
             * 
             * @param ilkoyuncuskor
             * @param ikincioyuncuskor
             * @param ilkoyuncuismi
             * @param ikincioyuncuismi 
             * Oyun sürecinden gelen sonuçları gösterir
             * 
             */
       
            public SonucEkrani(int ilkoyuncuskor,int ikincioyuncuskor,String ilkoyuncuismi,String ikincioyuncuismi) {
                        initComponents();
                        
                        lblbirincioyuncuskor.setText(String.valueOf(ilkoyuncuskor));
                        lblikinciyoncuskor.setText(String.valueOf(ikincioyuncuskor));
                        
                        if (ilkoyuncuskor == ikincioyuncuskor){
                                    lblkazanan.setText("BERABERE!");
                        }else if (ilkoyuncuskor > ikincioyuncuskor){
                                    int fark = ilkoyuncuskor -ikincioyuncuskor;
                                    lblkazanan.setText(String.format("%d farkla Kazanan %s !",fark,ilkoyuncuismi));
                        }else if (ilkoyuncuskor < ikincioyuncuskor){
                                    int fark = ikincioyuncuskor - ilkoyuncuskor;
                                     lblkazanan.setText(String.format("%d farkla Kazanan %s !",fark,ikincioyuncuismi));
                        
                        }
            }

  
            @SuppressWarnings("unchecked")
            // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
            private void initComponents() {

                        lblkazanan2 = new javax.swing.JLabel();
                        lblbirincioyuncuskor = new javax.swing.JLabel();
                        lblikinciyoncuskor = new javax.swing.JLabel();
                        btntekraroyna = new javax.swing.JButton();
                        lblkazanan = new javax.swing.JLabel();
                        lblkazanan3 = new javax.swing.JLabel();
                        jLabel1 = new javax.swing.JLabel();

                        lblkazanan2.setFont(new java.awt.Font("Lithos Pro Regular", 0, 36)); // NOI18N
                        lblkazanan2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblkazanan2.setText("kazanan");

                        setMaximumSize(new java.awt.Dimension(1200, 700));
                        setMinimumSize(new java.awt.Dimension(1200, 700));
                        setLayout(null);

                        lblbirincioyuncuskor.setFont(new java.awt.Font("Lithos Pro Regular", 0, 60)); // NOI18N
                        lblbirincioyuncuskor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblbirincioyuncuskor.setText("skor1");
                        add(lblbirincioyuncuskor);
                        lblbirincioyuncuskor.setBounds(140, 200, 150, 150);

                        lblikinciyoncuskor.setFont(new java.awt.Font("Lithos Pro Regular", 0, 60)); // NOI18N
                        lblikinciyoncuskor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblikinciyoncuskor.setText("skor2");
                        add(lblikinciyoncuskor);
                        lblikinciyoncuskor.setBounds(910, 200, 150, 150);

                        btntekraroyna.setFont(new java.awt.Font("Lithos Pro Regular", 0, 40)); // NOI18N
                        btntekraroyna.setText("TEKRAR OYNA");
                        btntekraroyna.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                btntekraroynaActionPerformed(evt);
                                    }
                        });
                        add(btntekraroyna);
                        btntekraroyna.setBounds(400, 440, 400, 200);

                        lblkazanan.setFont(new java.awt.Font("Lithos Pro Regular", 0, 36)); // NOI18N
                        lblkazanan.setForeground(new java.awt.Color(255, 110, 0));
                        lblkazanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblkazanan.setText("kazanan");
                        add(lblkazanan);
                        lblkazanan.setBounds(290, 220, 600, 200);

                        lblkazanan3.setFont(new java.awt.Font("Lithos Pro Regular", 0, 36)); // NOI18N
                        lblkazanan3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblkazanan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/kedi.png"))); // NOI18N
                        lblkazanan3.setText("kazanan");
                        add(lblkazanan3);
                        lblkazanan3.setBounds(300, 220, 600, 200);

                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/sonucekrani_arkaplan.jpg"))); // NOI18N
                        add(jLabel1);
                        jLabel1.setBounds(0, 0, 1190, 710);
            }// </editor-fold>//GEN-END:initComponents
            /**
             * Yeniden oynamak için giriş sayfasına tekrar yönlendirir
             * @param evt 
             */
            private void btntekraroynaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntekraroynaActionPerformed
                        UygulamaEkrani.uygulama.girisSayfasiniAc();
            }//GEN-LAST:event_btntekraroynaActionPerformed


            // Variables declaration - do not modify//GEN-BEGIN:variables
            private javax.swing.JButton btntekraroyna;
            private javax.swing.JLabel jLabel1;
            private javax.swing.JLabel lblbirincioyuncuskor;
            private javax.swing.JLabel lblikinciyoncuskor;
            private javax.swing.JLabel lblkazanan;
            private javax.swing.JLabel lblkazanan2;
            private javax.swing.JLabel lblkazanan3;
            // End of variables declaration//GEN-END:variables
}
