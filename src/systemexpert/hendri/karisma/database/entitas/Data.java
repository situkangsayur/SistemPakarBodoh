/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package systemexpert.hendri.karisma.database.entitas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author hendri
 */
@Entity
@Table(name = "data")
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
    @NamedQuery(name = "Data.findByNo", query = "SELECT d FROM Data d WHERE d.no = :no"),
    @NamedQuery(name = "Data.findByAbjad", query = "SELECT d FROM Data d WHERE d.abjad = :abjad"),
    @NamedQuery(name = "Data.findByMean", query = "SELECT d FROM Data d WHERE d.mean = :mean"),
    @NamedQuery(name = "Data.findByVal", query = "SELECT d FROM Data d WHERE d.val = :val")})
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no", nullable = false)
    private Integer no;
    @Column(name = "Abjad", length = 2)
    private String abjad;
    @Column(name = "Mean", length = 100)
    private String mean;
    @Column(name = "val")
    private Integer val;

    public Data() {
    }

    public Data(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAbjad() {
        return abjad;
    }

    public void setAbjad(String abjad) {
        this.abjad = abjad;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "systemexpert.hendri.karisma.service.Data[no=" + no + "]";
    }

}
