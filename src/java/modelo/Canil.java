/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "canil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canil.findAll", query = "SELECT c FROM Canil c"),
    @NamedQuery(name = "Canil.findByIdCanil", query = "SELECT c FROM Canil c WHERE c.idCanil = :idCanil"),
    @NamedQuery(name = "Canil.findByNome", query = "SELECT c FROM Canil c WHERE c.nome = :nome"),
    @NamedQuery(name = "Canil.findByTrava", query = "SELECT c FROM Canil c WHERE c.trava = :trava")})
public class Canil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_canil")
    private Long idCanil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "trava")
    private String trava;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCanil")
    private Collection<Refeicao> refeicaoCollection;
    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal")
    @ManyToOne(optional = false)
    private Animal idAnimal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCanil")
    private Collection<Log> logCollection;

    public Canil() {
    }

    public Canil(Long idCanil) {
        this.idCanil = idCanil;
    }

    public Canil(Long idCanil, String nome, String trava) {
        this.idCanil = idCanil;
        this.nome = nome;
        this.trava = trava;
    }

    public Long getIdCanil() {
        return idCanil;
    }

    public void setIdCanil(Long idCanil) {
        this.idCanil = idCanil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTrava() {
        return trava;
    }

    public void setTrava(String trava) {
        this.trava = trava;
    }

    @XmlTransient
    public Collection<Refeicao> getRefeicaoCollection() {
        return refeicaoCollection;
    }

    public void setRefeicaoCollection(Collection<Refeicao> refeicaoCollection) {
        this.refeicaoCollection = refeicaoCollection;
    }

    public Animal getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Animal idAnimal) {
        this.idAnimal = idAnimal;
    }

    @XmlTransient
    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCanil != null ? idCanil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canil)) {
            return false;
        }
        Canil other = (Canil) object;
        if ((this.idCanil == null && other.idCanil != null) || (this.idCanil != null && !this.idCanil.equals(other.idCanil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
