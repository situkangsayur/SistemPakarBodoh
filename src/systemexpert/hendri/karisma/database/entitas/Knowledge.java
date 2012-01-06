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
@Table(name = "knowledge")
@NamedQueries({
    @NamedQuery(name = "Knowledge.findAll", query = "SELECT k FROM Knowledge k"),
    @NamedQuery(name = "Knowledge.findByNo", query = "SELECT k FROM Knowledge k WHERE k.no = :no"),
    @NamedQuery(name = "Knowledge.findByRule", query = "SELECT k FROM Knowledge k WHERE k.rule = :rule"),
    @NamedQuery(name = "Knowledge.findByResult", query = "SELECT k FROM Knowledge k WHERE k.result = :result")})
public class Knowledge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no", nullable = false)
    private Integer no;
    @Basic(optional = false)
    @Column(name = "rule", nullable = false, length = 10)
    private String rule;
    @Basic(optional = false)
    @Column(name = "result", nullable = false, length = 10)
    private String result;

    public Knowledge() {
    }

    public Knowledge(Integer no) {
        this.no = no;
    }

    public Knowledge(Integer no, String rule, String result) {
        this.no = no;
        this.rule = rule;
        this.result = result;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
        if (!(object instanceof Knowledge)) {
            return false;
        }
        Knowledge other = (Knowledge) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "systemexpert.hendri.karisma.service.Knowledge[no=" + no + "]";
    }

}
