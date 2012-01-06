/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package systemexpert.hendri.karisma.Controll;

import javax.swing.JOptionPane;
import systemexpert.hendri.karisma.model.ModelExpert;
import systemexpert.hendri.karisma.view.PanelExpert;

/**
 *
 * @author hendri
 */
public class ControlExpert {

    private ModelExpert model;

      
    public void setModel(ModelExpert model) {
        this.model = model;
    }


    public void activeExpert(PanelExpert form) {

        String nama = form.getTextNama().getText();
        String uang = form.getTextUang().getText();
        String umur = form.getTextUmur().getText();
        String pendidikan = form.getComboPendidikan().getSelectedItem().toString();
        String pendapatan = form.getTextPendapatan().getText();
        Integer uangInt;
        Integer umurInt;
        Integer pendapatanInt;

        if (uang.equals("")) {
            uangInt = new Integer(0);
        } else {
            uangInt = new Integer(uang);
        }

        if (umur.equals("")) {
            umurInt = new Integer(0);
        } else {
            umurInt = new Integer(umur);
        }
        if (pendapatan.equals("")) {
            pendapatanInt = new Integer(0);
        } else {
            pendapatanInt = new Integer(pendapatan);
        }


        if (nama.equals("")) {
            JOptionPane.showMessageDialog(form, "Nama tidak valid!");

        } else {
            model.setNama(nama);
            model.setJumlahUang(uangInt);
            model.setUmur(umurInt);
            model.setTingkatPendidikan(pendidikan);
            model.setPendapatan(pendapatanInt);
            model.onCheck();

        }


    }
}
