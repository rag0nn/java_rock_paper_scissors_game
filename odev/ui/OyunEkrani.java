
package odev.ui;

import java.awt.Color;
import java.util.Random;

public class OyunEkrani extends javax.swing.JPanel{

            
            int birincioyuncuskor = 0;          //birinci oyncunun skorunu tutar
            int ikincioyuncuskor = 0;           //ikinci oyuncunun skorunu tutar
            int turSayisi = 0;                  // tur sayısını tutar
            
            public int maxTurSayisi = 0;        // giriş sayfasından gelen oynanacak tur sayısını tutar
            public String oyuncuIsmi1;          
            public String oyuncuIsmi2;
            public OyunEkrani(String oyuncuismi1,String oyuncuismi2,Object tur) {
                        initComponents();
                        
                        //giriş sayfasından aldığımız değerleri dönüştürüp global değişkenlere atıyoruz
                        maxTurSayisi = Integer.valueOf(String.valueOf(tur));
                        oyuncuIsmi1 = oyuncuismi1;
                        oyuncuIsmi2 = oyuncuismi2;
                        
                        //buttonlara tag atıyoruz
                        btntas.setActionCommand("tas");
                        btnkagit.setActionCommand("kagit");
                        btnmakas.setActionCommand("makas");
                        
                        //görsel değişiklikler
                        lbltas.setBackground(Color.white);
                        lbltas.setOpaque(true);
                        lbltas.repaint();
                        
                        lblkagıt.setBackground(Color.white);
                        lblkagıt.setOpaque(true);
                        lblkagıt.repaint();
                        
                        lblmakas.setBackground(Color.white);
                        lblmakas.setOpaque(true);
                        lblmakas.repaint();
               
                        lblbirinciyounu.setText(oyuncuismi1);
                        lblikincioyuncu.setText(oyuncuismi2);
                        lbltursayisi.setText("0");
                        
                       
            }
            /**
             * 
             * @param secim 
             * parametre olarak oyuncunun seçiminin kodunu alır,
             * Random kütüphanesini kullanarak rastgele çıktı üreterek bilgisayardan bir taş kağıt makas arasından bir seçim alır
             */
            public void secimYap(int secim) { //secim == 0 -> taş    ,    secim==1 ->   kağıt ,    secim == 2 -> makas
                        
                        
                        Random rast = new Random();
                        int oto_secim = rast.nextInt(3); // bilgisayarın tercihini tutan değişken 
                        switch (oto_secim) {
                                    case 0:
                                                System.out.println("2. Oyuncunun (bilgisayar) seçimi : taş");
                                                
                                                lbltas.setBackground(new Color(255,rastgeleRenk(180),rastgeleRenk(180))); //bilgisayarın seçtiği seçeneğin label öğesinin arkaplanın rastgeleRenk(B,G,R) ile değiştirir
                                                
                                                lbltas.repaint();
                                                
                                               
                                                
                                           
                                                break;
                                    case 1:
                                                System.out.println("2. Oyuncunun (bilgisayar) seçimi : kağıt");
                                                
                                                lblkagıt.setBackground(new Color(255,230,rastgeleRenk(255)));//bilgisayarın seçtiği seçeneğin label öğesinin arkaplanın rastgeleRenk(B,G,R) ile değiştirir
                                                
                                                lblkagıt.repaint();
                                                
                                                
                                                
                                                
                                                break;
                                    case 2:
                                                System.out.println("2. Oyuncunun (bilgisayar) seçimi : makas");
                                                
                                                lblmakas.setBackground(new Color(rastgeleRenk(255),230,255));//bilgisayarın seçtiği seçeneğin label öğesinin arkaplanın rastgeleRenk(B,G,R) ile değiştirir
                                                lblmakas.repaint();
                                                
                                                
                                                
                                               
                                                break;
                        }
                        
                        
                        int sonuclar[] = kazanan(secim, oto_secim);                 // sonuclar dizisi  , [0,0] ise berabere , [1,0] ilk oyuncu , [0,1] ise (bilgisayar) kazanır.
                        
                        // duruma göre kazanan oyuncunun skorunu artırır  ve lblkazanantur öğesinin durumunu düzenler
                        if (sonuclar[0] > sonuclar[1]) {
                                    birincioyuncuskor += 1;
                                    lblbirincioyuncuskor.setText(String.valueOf(birincioyuncuskor));
                                    lblkazanantur.setText("İlk oyuncu kazandı!");
                        } else if (sonuclar[0] < sonuclar[1]) {
                                    ikincioyuncuskor += 1;
                                    lblikincioyunskor.setText(String.valueOf(ikincioyuncuskor));
                                    lblkazanantur.setText("İkinci oyuncu kazandı!");
                        } else {
                                    lblkazanantur.setText("Berabere!");
                        }
                        
                        
                        
                        turSayisi+=1;
                        lbltursayisi.setText(String.valueOf(turSayisi));            // tur sayısı , istenilen tur sayısına eşitse sonuç ekranına gider
                        if (turSayisi ==maxTurSayisi){
                                    UygulamaEkrani.uygulama.sonucSayfasiniAc(birincioyuncuskor,ikincioyuncuskor,oyuncuIsmi1,oyuncuIsmi2);
                        }

                                                
                        
                        
            }
            
            /**
             * 
             * @param a
             * @param b
             * @return sonuclar [] , sonuclar olarak iki öğeli bir dizi döndürür , [0,0] berabere ,[1,0] ilk oyuncunun kazanması , [0,1] ikinci oyuncunun kazanması
             */
            public static int[] kazanan(int a, int b) {

                        int[] secimDizi = {-1, 0, 5};       // taş:-1 , kağıt : 0 ,makas :5 , her drawda sonuç aynı olacağından x-y yaparak "0" buluruz bu şekilde işlem fazlalığından kurtulabiliriz.
                        int x = secimDizi[a];               // input olarak gelen 0 , 1 ,2 yi secimDiziyi indeksleyerek -1 , 0 ,5 ten birini seçiyoruz
                        int y = secimDizi[b];               // input olarak gelen 0 , 1 ,2 yi secimDiziyi indeksleyerek -1 , 0 ,5 ten birini seçiyoruz
                        int sonuc = x - y;                  // x öğesinden y yi çıkartarak sonuçları karşılaştırırız         
                        int[] sonuclar = new int[2];        //return ediceğımız sonuclarımızı tutacak olan dizi

                        if (sonuc == 0) {
                                    System.out.println("Eşitlik var");
                                    sonuclar[0] = 0;
                                    sonuclar[1] = 0;
                        } else if (sonuc == -6 || sonuc == 1 || sonuc == 5) {// x-y fonksiyonuna göre -6 ,1 ,5 ilk sıradaki oyuncunun kazandığını söyler(önceden tablo yaparak buldum)
                                    System.out.println("1.Oyuncu  kazandı");
                                    sonuclar[0] = 1;
                                    sonuclar[1] = 0;
                                    
                        } else if (sonuc == -1 || sonuc == -5 || sonuc == 6) { // x-y  fonksiyonuna göre -1,-5,6 ikinci sıradaki oyuncunun kazandığını söyler(önceden tablo yaparak buldum)
                                    System.out.println("2.Oyuncu  kazandı");
                                    sonuclar[0] = 0;
                                    sonuclar[1] = 1;
                        }
                        return sonuclar;
            }
            
            /**
             * 
             * @return 0 ile 255 arasında rastgele bir sayı döndürür 
             */
            public static int rastgeleRenk(int max){
                        Random rast = new Random();
                        int sayi = rast.nextInt(max); 
                        return sayi;
            }
            
            
            
            
            
            
            @SuppressWarnings("unchecked")
            // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
            private void initComponents() {

                        lblbirinciyounu = new javax.swing.JLabel();
                        lblbirincioyuncuskor = new javax.swing.JLabel();
                        lblikincioyuncu = new javax.swing.JLabel();
                        lblTur = new javax.swing.JLabel();
                        lbltursayisi = new javax.swing.JLabel();
                        lblikincioyunskor = new javax.swing.JLabel();
                        btnmakas = new javax.swing.JButton();
                        lblkazanantur = new javax.swing.JLabel();
                        btnkagit = new javax.swing.JButton();
                        btntas = new javax.swing.JButton();
                        lblmakas = new javax.swing.JLabel();
                        lbltas = new javax.swing.JLabel();
                        lblkagıt = new javax.swing.JLabel();
                        jLabel1 = new javax.swing.JLabel();

                        setMaximumSize(new java.awt.Dimension(1200, 700));
                        setPreferredSize(new java.awt.Dimension(1200, 700));
                        setLayout(null);

                        lblbirinciyounu.setBackground(new java.awt.Color(0, 0, 0));
                        lblbirinciyounu.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
                        lblbirinciyounu.setForeground(new java.awt.Color(255, 255, 255));
                        lblbirinciyounu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblbirinciyounu.setText("Oyuncu1");
                        lblbirinciyounu.setToolTipText("");
                        lblbirinciyounu.setAlignmentX(2.0F);
                        lblbirinciyounu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        add(lblbirinciyounu);
                        lblbirinciyounu.setBounds(70, 340, 180, 60);

                        lblbirincioyuncuskor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
                        lblbirincioyuncuskor.setForeground(new java.awt.Color(255, 255, 255));
                        lblbirincioyuncuskor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblbirincioyuncuskor.setText("0");
                        add(lblbirincioyuncuskor);
                        lblbirincioyuncuskor.setBounds(500, 80, 60, 60);

                        lblikincioyuncu.setBackground(new java.awt.Color(0, 0, 0));
                        lblikincioyuncu.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
                        lblikincioyuncu.setForeground(new java.awt.Color(255, 255, 255));
                        lblikincioyuncu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblikincioyuncu.setText("Oyuncu2");
                        lblikincioyuncu.setToolTipText("");
                        lblikincioyuncu.setAlignmentX(2.0F);
                        lblikincioyuncu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        add(lblikincioyuncu);
                        lblikincioyuncu.setBounds(950, 340, 180, 60);

                        lblTur.setFont(new java.awt.Font("Lithos Pro Regular", 0, 18)); // NOI18N
                        lblTur.setForeground(new java.awt.Color(255, 255, 255));
                        lblTur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblTur.setText("TUR");
                        add(lblTur);
                        lblTur.setBounds(540, 20, 120, 50);

                        lbltursayisi.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
                        lbltursayisi.setForeground(new java.awt.Color(255, 255, 255));
                        lbltursayisi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lbltursayisi.setText("0");
                        add(lbltursayisi);
                        lbltursayisi.setBounds(560, 70, 80, 80);

                        lblikincioyunskor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
                        lblikincioyunskor.setForeground(new java.awt.Color(255, 255, 255));
                        lblikincioyunskor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblikincioyunskor.setText("0");
                        add(lblikincioyunskor);
                        lblikincioyunskor.setBounds(640, 80, 60, 60);

                        btnmakas.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
                        btnmakas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/makas_sol.png"))); // NOI18N
                        btnmakas.setText("MAKAS");
                        btnmakas.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                btnmakasActionPerformed(evt);
                                    }
                        });
                        add(btnmakas);
                        btnmakas.setBounds(360, 460, 200, 100);

                        lblkazanantur.setForeground(new java.awt.Color(255, 255, 255));
                        lblkazanantur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblkazanantur.setText("berabere");
                        lblkazanantur.setToolTipText("");
                        add(lblkazanantur);
                        lblkazanantur.setBounds(520, 330, 160, 80);

                        btnkagit.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
                        btnkagit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/kagit_sol.png"))); // NOI18N
                        btnkagit.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                btnkagitActionPerformed(evt);
                                    }
                        });
                        add(btnkagit);
                        btnkagit.setBounds(300, 320, 200, 100);

                        btntas.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
                        btntas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/tas_sol.png"))); // NOI18N
                        btntas.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                btntasActionPerformed(evt);
                                    }
                        });
                        add(btntas);
                        btntas.setBounds(360, 180, 200, 100);

                        lblmakas.setBackground(new java.awt.Color(204, 0, 153));
                        lblmakas.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
                        lblmakas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblmakas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/makas_sag.png"))); // NOI18N
                        lblmakas.setText("MAKAS");
                        lblmakas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
                        add(lblmakas);
                        lblmakas.setBounds(640, 460, 200, 100);

                        lbltas.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
                        lbltas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lbltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/tas_sag.png"))); // NOI18N
                        lbltas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
                        add(lbltas);
                        lbltas.setBounds(640, 180, 200, 100);

                        lblkagıt.setBackground(new java.awt.Color(204, 0, 51));
                        lblkagıt.setFont(new java.awt.Font("Lithos Pro Regular", 0, 24)); // NOI18N
                        lblkagıt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        lblkagıt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/kagit_sag.png"))); // NOI18N
                        lblkagıt.setText("KAĞIT");
                        lblkagıt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
                        add(lblkagıt);
                        lblkagıt.setBounds(700, 320, 200, 100);

                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/odev/res/oyunekrani_Arkaplan.jpg"))); // NOI18N
                        add(jLabel1);
                        jLabel1.setBounds(0, 0, 1200, 680);
            }// </editor-fold>//GEN-END:initComponents
            /**
             * 
             * @param evt
             * Butona tıkladığında seçimYap() fonksiyonunu (2) ile çağır
             */
            
            private void btnmakasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmakasActionPerformed
                        System.out.println("\nOyuncu Seçimi makas , 2");
                        btnmakas.setBackground(new Color(rastgeleRenk(255),230,255));
                        btnmakas.repaint();
                        secimYap(2);
                
                        
            }//GEN-LAST:event_btnmakasActionPerformed
            
            /**
             * 
             * @param evt
             * Butona tıkladığında seçimYap() fonksiyonun (1) ile çağır
             */
            
            private void btnkagitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkagitActionPerformed
                       System.out.println("\nOyuncu seçimi kağıt , 1");
                       btnkagit.setBackground(new Color(255,230,rastgeleRenk(255)));
                       btnkagit.repaint();
                        secimYap(1);
                      
                       
            }//GEN-LAST:event_btnkagitActionPerformed
            
            /**
             * 
             * @param evt
             * Butona tıkladığında seçimYap() fonksiyonun (0) ile çağır
             */
            private void btntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntasActionPerformed
                         System.out.println("\nOyuncu seçimi tas , 0");
                       btntas.setBackground(new Color(255,rastgeleRenk(180),rastgeleRenk(170)));
                        btntas.repaint();
                        secimYap(0);
                   
                       
            }//GEN-LAST:event_btntasActionPerformed

            
            

            // Variables declaration - do not modify//GEN-BEGIN:variables
            private javax.swing.JButton btnkagit;
            private javax.swing.JButton btnmakas;
            private javax.swing.JButton btntas;
            private javax.swing.JLabel jLabel1;
            private javax.swing.JLabel lblTur;
            private javax.swing.JLabel lblbirincioyuncuskor;
            private javax.swing.JLabel lblbirinciyounu;
            private javax.swing.JLabel lblikincioyuncu;
            private javax.swing.JLabel lblikincioyunskor;
            private javax.swing.JLabel lblkagıt;
            private javax.swing.JLabel lblkazanantur;
            private javax.swing.JLabel lblmakas;
            private javax.swing.JLabel lbltas;
            private javax.swing.JLabel lbltursayisi;
            // End of variables declaration//GEN-END:variables
}
