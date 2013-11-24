/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "microfone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Microfone.findAll", query = "SELECT m FROM Microfone m"),
    @NamedQuery(name = "Microfone.findByIdMicrofone", query = "SELECT m FROM Microfone m WHERE m.idMicrofone = :idMicrofone"),
    @NamedQuery(name = "Microfone.findByPosicao", query = "SELECT m FROM Microfone m WHERE m.posicao = :posicao"),
    @NamedQuery(name = "Microfone.findByLigado", query = "SELECT m FROM Microfone m WHERE m.ligado = :ligado")})
public class Microfone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_microfone")
    private Long idMicrofone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "posicao")
    private String posicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ligado")
    private String ligado;
    @JoinColumn(name = "id_cpf", referencedColumnName = "id_cpf")
    @ManyToOne(optional = false)
    private Pessoa idCpf;

    public Microfone() {
    }

    public Microfone(Long idMicrofone) {
        this.idMicrofone = idMicrofone;
    }

    public Microfone(Long idMicrofone, String posicao, String ligado) {
        this.idMicrofone = idMicrofone;
        this.posicao = posicao;
        this.ligado = ligado;
    }

    public Long getIdMicrofone() {
        return idMicrofone;
    }

    public void setIdMicrofone(Long idMicrofone) {
        this.idMicrofone = idMicrofone;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getLigado() {
        return ligado;
    }

    public void setLigado(String ligado) {
        this.ligado = ligado;
    }

    public Pessoa getIdCpf() {
        return idCpf;
    }

    public void setIdCpf(Pessoa idCpf) {
        this.idCpf = idCpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMicrofone != null ? idMicrofone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Microfone)) {
            return false;
        }
        Microfone other = (Microfone) object;
        if ((this.idMicrofone == null && other.idMicrofone != null) || (this.idMicrofone != null && !this.idMicrofone.equals(other.idMicrofone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return posicao;
    }
    
}
