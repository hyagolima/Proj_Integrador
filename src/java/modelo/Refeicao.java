/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "refeicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refeicao.findAll", query = "SELECT r FROM Refeicao r"),
    @NamedQuery(name = "Refeicao.findByIdRefeicao", query = "SELECT r FROM Refeicao r WHERE r.idRefeicao = :idRefeicao"),
    @NamedQuery(name = "Refeicao.findByHora", query = "SELECT r FROM Refeicao r WHERE r.hora = :hora"),
    @NamedQuery(name = "Refeicao.findByPesoRefeicao", query = "SELECT r FROM Refeicao r WHERE r.pesoRefeicao = :pesoRefeicao"),
    @NamedQuery(name = "Refeicao.findByDescricao", query = "SELECT r FROM Refeicao r WHERE r.descricao = :descricao")})
public class Refeicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_refeicao")
    private Long idRefeicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_refeicao")
    private double pesoRefeicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_canil", referencedColumnName = "id_canil")
    @ManyToOne(optional = false)
    private Canil idCanil;

    public Refeicao() {
    }

    public Refeicao(Long idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public Refeicao(Long idRefeicao, Date hora, double pesoRefeicao, String descricao) {
        this.idRefeicao = idRefeicao;
        this.hora = hora;
        this.pesoRefeicao = pesoRefeicao;
        this.descricao = descricao;
    }

    public Long getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(Long idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public double getPesoRefeicao() {
        return pesoRefeicao;
    }

    public void setPesoRefeicao(double pesoRefeicao) {
        this.pesoRefeicao = pesoRefeicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Canil getIdCanil() {
        return idCanil;
    }

    public void setIdCanil(Canil idCanil) {
        this.idCanil = idCanil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRefeicao != null ? idRefeicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Refeicao)) {
            return false;
        }
        Refeicao other = (Refeicao) object;
        if ((this.idRefeicao == null && other.idRefeicao != null) || (this.idRefeicao != null && !this.idRefeicao.equals(other.idRefeicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
