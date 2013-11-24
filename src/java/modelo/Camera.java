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
@Table(name = "camera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camera.findAll", query = "SELECT c FROM Camera c"),
    @NamedQuery(name = "Camera.findByIdCamera", query = "SELECT c FROM Camera c WHERE c.idCamera = :idCamera"),
    @NamedQuery(name = "Camera.findByPosicao", query = "SELECT c FROM Camera c WHERE c.posicao = :posicao"),
    @NamedQuery(name = "Camera.findByLigado", query = "SELECT c FROM Camera c WHERE c.ligado = :ligado")})
public class Camera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_camera")
    private Long idCamera;
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

    public Camera() {
    }

    public Camera(Long idCamera) {
        this.idCamera = idCamera;
    }

    public Camera(Long idCamera, String posicao, String ligado) {
        this.idCamera = idCamera;
        this.posicao = posicao;
        this.ligado = ligado;
    }

    public Long getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(Long idCamera) {
        this.idCamera = idCamera;
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
        hash += (idCamera != null ? idCamera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camera)) {
            return false;
        }
        Camera other = (Camera) object;
        if ((this.idCamera == null && other.idCamera != null) || (this.idCamera != null && !this.idCamera.equals(other.idCamera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return posicao;
    }
    
}
