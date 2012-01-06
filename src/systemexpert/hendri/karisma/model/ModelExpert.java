/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package systemexpert.hendri.karisma.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import systemexpert.hendri.karisma.database.entitas.Data;
import systemexpert.hendri.karisma.database.entitas.Knowledge;
import systemexpert.hendri.karisma.database.service.database;
import systemexpert.hendri.karisma.listener.ListenerExpert;

/**
 *
 * @author hendri
 */
public class ModelExpert {

    private String nama;
    private int jumlahUang;
    private int umur;
    private String tingkatPendidikan;
    private int pendapatan;
    private String result;

    public ListenerExpert getListener() {
        return listener;
    }

    public void setListener(ListenerExpert listener) {
        this.listener = listener;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    private ListenerExpert listener;

    public int getJumlahUang() {
        return jumlahUang;
    }

    public void setJumlahUang(int jumlahUang) {
        this.jumlahUang = jumlahUang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(int pendapatan) {
        this.pendapatan = pendapatan;
    }

    public String getTingkatPendidikan() {
        return tingkatPendidikan;
    }

    public void setTingkatPendidikan(String tingkatPendidikan) {
        this.tingkatPendidikan = tingkatPendidikan;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    protected void fireOnCheck() {
        if (listener != null) {
            listener.onCheck(this);
        }
    }

    public void onCheck() {

        String ans = "";

        EntityManager manager = database.getEntityManager();
        Query query = manager.createNamedQuery("Data.findAll");
        List<Data> data = query.getResultList();

        Query queryKnowledge = manager.createNamedQuery("Knowledge.findAll");
        List<Knowledge> know = queryKnowledge.getResultList();

        if (jumlahUang > 0) {
            if (jumlahUang >= data.get(0).getVal()) {
                ans = ans + data.get(0).getAbjad();
            }
        }
        if (umur > 0) {
            if (umur < data.get(1).getVal()) {
                ans = ans + data.get(1).getAbjad();
            }
        }
        if ((!tingkatPendidikan.equals("")) && tingkatPendidikan.equals(data.get(2).getMean())) {
            ans = ans + data.get(2).getAbjad();
        }
        if (pendapatan > 0) {
            if (pendapatan >= data.get(3).getVal()) {
                ans = ans + data.get(3).getAbjad();
            }
        }

        int r1 = 0;

        for (int i = 0; i < know.size(); i++) {

            r1 = ans.indexOf(know.get(i).getRule().charAt(0));
            if (know.get(i).getRule().length() >= 2) {
                int r2 = ans.indexOf(know.get(i).getRule().charAt(1));
                if ((r1 > -1) && (r2 > -1)) {

                    r2 = ans.indexOf(know.get(i).getResult());

                    if (r2 == -1) {
                        ans = ans + know.get(i).getResult();
                        i = -1;

                    } else {
                        System.out.println("yg ke2");
                    }

                }
            } else {
                if (r1 > -1) {
                    r1 = ans.indexOf(know.get(i).getResult());

                    if (r1 <= -1) {
                        ans = ans + know.get(i).getResult();
                        i = -1;

                    }
                }
            }

        }

        for (int i = 0; i < data.size(); i++) {
            r1 = ans.indexOf(data.get(i).getAbjad());
            if (r1 != -1) {
                setResult(data.get(i).getMean());
            }
        }
        fireOnCheck();

    }
}
