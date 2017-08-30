/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Marcelo
 */
@Entity
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date finicio;
    private Date ffin;
    private int precioalquiler;
    private int litrosgasoil;
    private int preciototal;
    
    @ManyToOne
    private Cliente cli;    
    
    @ManyToMany
    private List<Coche> auto;
    @ManyToOne
    private Agencia agen;

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public int getPrecioalquiler() {
        return precioalquiler;
    }

    public void setPrecioalquiler(int precioalquiler) {
        this.precioalquiler = precioalquiler;
    }

    public int getLitrosgasoil() {
        return litrosgasoil;
    }

    public void setLitrosgasoil(int litrosgasoil) {
        this.litrosgasoil = litrosgasoil;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Coche> getAuto() {
        return auto;
    }

    public void setAuto(Coche auto) {
        this.auto = (List<Coche>) auto;
    }

    public Agencia getAgen() {
        return agen;
    }

    public void setAgen(Agencia agen) {
        this.agen = agen;
    }
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IO.Reserva[ id=" + id + " ]";
    }
    
}
