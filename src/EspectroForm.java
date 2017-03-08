
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.XYPlot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public class EspectroForm extends javax.swing.JFrame {

    /**
     * Creates new form EspectroForm
     */
    public EspectroForm(HashMap<Double,Double> espectro) {
        initComponents();
        initChart(espectro);
        initPanel();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spectroPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 375));
        setMinimumSize(new java.awt.Dimension(500, 375));
        setResizable(false);

        javax.swing.GroupLayout spectroPanelLayout = new javax.swing.GroupLayout(spectroPanel);
        spectroPanel.setLayout(spectroPanelLayout);
        spectroPanelLayout.setHorizontalGroup(
            spectroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        spectroPanelLayout.setVerticalGroup(
            spectroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spectroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spectroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton okButton;
    private javax.swing.JPanel spectroPanel;
    // End of variables declaration//GEN-END:variables
    private ChartPanel spectroChart;

    private void initPanel() {
        GridLayout gL = new GridLayout();
        gL.setColumns(1);
        gL.setRows(1);

        spectroPanel.setLayout(gL);
        spectroPanel.setPreferredSize(new Dimension(240,350));
        spectroPanel.add(spectroChart);
    }

    private void initChart(HashMap<Double,Double> spectro) 
    {
        spectroChart = new ChartPanel(GeneradorDeGraphicas.getInstance().drawSpectro(spectro));
        //removerYAxisLabels();
        
    }

    private void removerYAxisLabels()
    {  
        XYPlot plot = (XYPlot) spectroChart.getChart().getPlot();
        plot.getRangeAxis().setMinorTickMarksVisible(false);
        plot.getDomainAxis().setTickLabelsVisible(false);  
    }
}
