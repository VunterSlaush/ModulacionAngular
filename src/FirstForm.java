
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpinnerNumberModel;
import org.jfree.chart.ChartPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class FirstForm extends javax.swing.JFrame 
{


    public FirstForm() {
        initComponents();
        initBoxes();
        initSpinners();
        initCharts();
        initPanels();
        resetButtonActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        modularButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        tipoModulacionBox = new javax.swing.JComboBox();
        pHSpinner = new javax.swing.JSpinner();
        pDSpinner = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        timeUnidadSpinner = new javax.swing.JComboBox<String>();
        desviacionLabel = new javax.swing.JLabel();
        desviacionSpinner = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        funcionPortadoraBox = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        frecuenciaPortadoraSpinner = new javax.swing.JSpinner();
        frecuenciaPortadoraUnidad = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        fasePortadoraSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        amplitudPortadoraSpinner = new javax.swing.JSpinner();
        amplitudPortadoraUnidad = new javax.swing.JComboBox<String>();
        ruidoPortadoraCheck = new javax.swing.JCheckBox();
        portadoraButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        funcionModuladoraBox = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        frecuenciaModuladoraSpinner = new javax.swing.JSpinner();
        frecuenciaModuladoraUnidad = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        faseModuladoraSpinner = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        amplitudModuladoraSpinner = new javax.swing.JSpinner();
        amplitudModuladoraUnidad = new javax.swing.JComboBox<String>();
        ruidoModuladoraCheck = new javax.swing.JCheckBox();
        moduladoraButton = new javax.swing.JButton();
        portadoraPanel = new javax.swing.JPanel();
        moduladoraPanel = new javax.swing.JPanel();
        moduladaPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Tipo de Modulacion");

        modularButton.setText("Modular");
        modularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modularButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Resetear");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        tipoModulacionBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("De:");

        jLabel12.setText("Tiempo del Espectro");

        jLabel14.setText("Hasta:");

        timeUnidadSpinner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        desviacionLabel.setText("Indice de Modulacion {m}(Adimensional)");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Señal Portadora", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        funcionPortadoraBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        funcionPortadoraBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionPortadoraBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Frecuencia");

        frecuenciaPortadoraUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Fase (Rad)");

        jLabel5.setText("Amplitud");

        amplitudPortadoraUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ruidoPortadoraCheck.setText("Ruido");

        portadoraButton.setText("Ver Señal");
        portadoraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portadoraButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(funcionPortadoraBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(15, 15, 15)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(amplitudPortadoraSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(frecuenciaPortadoraSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fasePortadoraSpinner, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amplitudPortadoraUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(frecuenciaPortadoraUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ruidoPortadoraCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(portadoraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(funcionPortadoraBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(frecuenciaPortadoraSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frecuenciaPortadoraUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fasePortadoraSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(amplitudPortadoraSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amplitudPortadoraUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruidoPortadoraCheck)
                    .addComponent(portadoraButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Señal Moduladora", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        funcionModuladoraBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Frecuencia");

        frecuenciaModuladoraUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Fase(Rad)");

        jLabel8.setText("Amplitud");

        amplitudModuladoraUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ruidoModuladoraCheck.setText("Ruido");

        moduladoraButton.setText("Ver Señal");
        moduladoraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduladoraButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(funcionModuladoraBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ruidoModuladoraCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moduladoraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(15, 15, 15)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(amplitudModuladoraSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(faseModuladoraSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frecuenciaModuladoraSpinner, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frecuenciaModuladoraUnidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amplitudModuladoraUnidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(funcionModuladoraBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(frecuenciaModuladoraSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frecuenciaModuladoraUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(faseModuladoraSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(amplitudModuladoraSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amplitudModuladoraUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruidoModuladoraCheck)
                    .addComponent(moduladoraButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        portadoraPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grafica Señal Portadora", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        javax.swing.GroupLayout portadoraPanelLayout = new javax.swing.GroupLayout(portadoraPanel);
        portadoraPanel.setLayout(portadoraPanelLayout);
        portadoraPanelLayout.setHorizontalGroup(
            portadoraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
        portadoraPanelLayout.setVerticalGroup(
            portadoraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        moduladoraPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grafica Señal Moduladora", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        javax.swing.GroupLayout moduladoraPanelLayout = new javax.swing.GroupLayout(moduladoraPanel);
        moduladoraPanel.setLayout(moduladoraPanelLayout);
        moduladoraPanelLayout.setHorizontalGroup(
            moduladoraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        moduladoraPanelLayout.setVerticalGroup(
            moduladoraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        moduladaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grafica Señal Modulada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        javax.swing.GroupLayout moduladaPanelLayout = new javax.swing.GroupLayout(moduladaPanel);
        moduladaPanel.setLayout(moduladaPanelLayout);
        moduladaPanelLayout.setHorizontalGroup(
            moduladaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        moduladaPanelLayout.setVerticalGroup(
            moduladaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desviacionLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(modularButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)
                        .addComponent(pDSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)
                        .addGap(4, 4, 4)
                        .addComponent(pHSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeUnidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipoModulacionBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(desviacionSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(portadoraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moduladoraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moduladaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(portadoraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moduladoraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoModulacionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desviacionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desviacionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pDSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pHSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(timeUnidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modularButton)
                            .addComponent(resetButton)))
                    .addComponent(moduladaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modularButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modularButtonActionPerformed
        ModulateSignal modulada = armarModuladada();
        System.out.println(modulada);
        generarGraficaModuladoda(modulada);
        ResultScreen result = new ResultScreen(modulada);
        result.setVisible(true);
        
    }//GEN-LAST:event_modularButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        resetPortadora();
        resetModuladora();
        resetModulada();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void portadoraButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        Signal portadora = armarPortadora();
        System.out.println(portadora);
        mostrarGrafica(portadora,portadoraChart);
    }

    private void moduladoraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduladoraButtonActionPerformed
        Signal moduladora = armarModuladora();
        System.out.println(moduladora);
        mostrarGrafica(moduladora,moduladoraChart);
    }//GEN-LAST:event_moduladoraButtonActionPerformed

    private void mostrarGrafica(Signal p, ChartPanel chart)
    {
        GeneradorDeGraphicas instance = GeneradorDeGraphicas.getInstance();
        chart.setChart(instance.drawSignal(p));
    }
    
    private void funcionPortadoraBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionPortadoraBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_funcionPortadoraBoxActionPerformed


    private void initBoxes()
    {
        ComboBoxManager manager = ComboBoxManager.getInstance();
        manager.initAmplitudBox(this.amplitudModuladoraUnidad);
        manager.initAmplitudBox(amplitudPortadoraUnidad);
        manager.initFrequencyBox(frecuenciaModuladoraUnidad);
        manager.initFrequencyBox(frecuenciaPortadoraUnidad);
        manager.initModulationTypeBox(tipoModulacionBox);
        manager.initTimeBox(timeUnidadSpinner);
        manager.initSignalFunctionBox(funcionModuladoraBox);
        manager.initSignalFunctionBox(funcionPortadoraBox);
    }

    private Signal armarPortadora()
    {
        double frecuencia = (double) frecuenciaPortadoraSpinner.getValue();
        double phase = (double) fasePortadoraSpinner.getValue();
        double amplitud = (double) amplitudPortadoraSpinner.getValue();
        boolean ruido = ruidoPortadoraCheck.isSelected();
        String amplitudUnidad = (String)this.amplitudPortadoraUnidad.getSelectedItem();
        String freqUnidad = (String) this.frecuenciaPortadoraUnidad.getSelectedItem();
        String tipoFuncion = (String) this.funcionPortadoraBox.getSelectedItem();
        frecuencia = ConversorDeUnidades.getInstance().convertir(frecuencia,freqUnidad);
        amplitud = ConversorDeUnidades.getInstance().convertir(amplitud,amplitudUnidad);
        return new Signal(frecuencia,amplitud,phase,ruido,tipoFuncion);
    }
    
    private void initPanels()
    {
        GridLayout gL = new GridLayout();
        gL.setColumns(1);
        gL.setRows(1);
        portadoraPanel.setLayout(gL);
        portadoraPanel.setPreferredSize(new Dimension(60,60));
        moduladoraPanel.setLayout(gL);
        moduladoraPanel.setPreferredSize(new Dimension(60,60));
        moduladaPanel.setLayout(gL);
        moduladaPanel.setPreferredSize(new Dimension(60,200));
        portadoraPanel.add(portadoraChart);
        moduladoraPanel.add(moduladoraChart);
        moduladaPanel.add(moduladaChart);
    }

    private void initSpinners()
    {
        this.desviacionSpinner.setModel(new SpinnerNumberModel(0.0,0.0 ,100000.0,0.1));
        this.faseModuladoraSpinner.setModel(new SpinnerNumberModel(0.0,0.0 ,100000.0,0.1));
        this.fasePortadoraSpinner.setModel(new SpinnerNumberModel(0.0,0.0 ,100000.0,0.1));
        this.amplitudModuladoraSpinner.setModel(new SpinnerNumberModel(0.0,0.0 ,100000.0,0.1));
        this.amplitudPortadoraSpinner.setModel(new SpinnerNumberModel(0.0,0.0 ,100000.0,0.1));
        this.frecuenciaPortadoraSpinner.setModel(new SpinnerNumberModel(0.0,0.0 ,100000.0,0.1));
        this.frecuenciaModuladoraSpinner.setModel(new SpinnerNumberModel(0.0,0.0 ,100000.0,0.1));
    }

    private Signal armarModuladora()
    {
        double frecuencia = (double) frecuenciaModuladoraSpinner.getValue();
        double phase = (double) faseModuladoraSpinner.getValue();
        double amplitud = (double) amplitudModuladoraSpinner.getValue();
        boolean ruido = ruidoModuladoraCheck.isSelected();
        String amplitudUnidad = (String)this.amplitudModuladoraUnidad.getSelectedItem();
        String freqUnidad = (String) this.frecuenciaModuladoraUnidad.getSelectedItem();
        String tipoFuncion = (String) this.funcionModuladoraBox.getSelectedItem();
        frecuencia = ConversorDeUnidades.getInstance().convertir(frecuencia,freqUnidad);
        amplitud = ConversorDeUnidades.getInstance().convertir(amplitud,amplitudUnidad);
        return new Signal(frecuencia,amplitud,phase,ruido,tipoFuncion);
    }
    
    private ChartPanel moduladoraChart;
    private ChartPanel portadoraChart;
    private ChartPanel moduladaChart;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner amplitudModuladoraSpinner;
    private javax.swing.JComboBox<String> amplitudModuladoraUnidad;
    private javax.swing.JSpinner amplitudPortadoraSpinner;
    private javax.swing.JComboBox<String> amplitudPortadoraUnidad;
    private javax.swing.JLabel desviacionLabel;
    private javax.swing.JSpinner desviacionSpinner;
    private javax.swing.JSpinner faseModuladoraSpinner;
    private javax.swing.JSpinner fasePortadoraSpinner;
    private javax.swing.JSpinner frecuenciaModuladoraSpinner;
    private javax.swing.JComboBox<String> frecuenciaModuladoraUnidad;
    private javax.swing.JSpinner frecuenciaPortadoraSpinner;
    private javax.swing.JComboBox<String> frecuenciaPortadoraUnidad;
    private javax.swing.JComboBox<String> funcionModuladoraBox;
    private javax.swing.JComboBox<String> funcionPortadoraBox;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel moduladaPanel;
    private javax.swing.JButton moduladoraButton;
    private javax.swing.JPanel moduladoraPanel;
    private javax.swing.JButton modularButton;
    private javax.swing.JSpinner pDSpinner;
    private javax.swing.JSpinner pHSpinner;
    private javax.swing.JButton portadoraButton;
    private javax.swing.JPanel portadoraPanel;
    private javax.swing.JButton resetButton;
    private javax.swing.JCheckBox ruidoModuladoraCheck;
    private javax.swing.JCheckBox ruidoPortadoraCheck;
    private javax.swing.JComboBox<String> timeUnidadSpinner;
    private javax.swing.JComboBox tipoModulacionBox;
    // End of variables declaration//GEN-END:variables

    private void initCharts() 
    {
        moduladoraChart = new ChartPanel(null);
        portadoraChart = new ChartPanel(null);
        moduladaChart = new ChartPanel(null);
    }

    private void resetPortadora() 
    {
        portadoraChart.setChart(null);
        fasePortadoraSpinner.setValue(0.0);
        frecuenciaPortadoraSpinner.setValue(0.0);
        frecuenciaPortadoraUnidad.setSelectedIndex(3);
        amplitudPortadoraSpinner.setValue(0.0);
        amplitudPortadoraUnidad.setSelectedIndex(3);
        ruidoPortadoraCheck.setSelected(false);
        funcionPortadoraBox.setSelectedIndex(0);
    }

    private void resetModuladora() 
    {
        moduladoraChart.setChart(null);
        faseModuladoraSpinner.setValue(0.0);
        frecuenciaModuladoraSpinner.setValue(0.0);
        frecuenciaModuladoraUnidad.setSelectedIndex(3);
        amplitudModuladoraSpinner.setValue(0.0);
        amplitudModuladoraUnidad.setSelectedIndex(3);
        ruidoModuladoraCheck.setSelected(false);
        funcionModuladoraBox.setSelectedIndex(0);
    }

    private void resetModulada() 
    {
        moduladaChart.setChart(null);
        this.desviacionSpinner.setValue(0.0);
        this.pHSpinner.setValue(0);
        this.pDSpinner.setValue(0);
        this.tipoModulacionBox.setSelectedIndex(0);
        this.timeUnidadSpinner.setSelectedIndex(1);
    }

    private ModulateSignal armarModuladada() 
    {
        double m = (double)this.desviacionSpinner.getValue();
        int type = tipoModulacionBox.getSelectedIndex();
        return new ModulateSignal(armarPortadora(),armarModuladora(),m,type);
    }

    private void generarGraficaModuladoda(ModulateSignal modulada) 
    {
        int desde = (int)pDSpinner.getValue();
        int hasta = (int)pHSpinner.getValue();
        String unidadTiempo = (String)this.timeUnidadSpinner.getSelectedItem();
        moduladaChart.setChart(GeneradorDeGraphicas.getInstance().drawSignal(modulada, desde, hasta,
                ConversorDeUnidades.getInstance().retornarMultiploUnidad(unidadTiempo)));
    }
}
