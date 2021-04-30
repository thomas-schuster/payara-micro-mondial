package de.hspf.swt.dao;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThomasSchuster
 */
@Entity
@Table(name = "province")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p"),
    @NamedQuery(name = "Province.findByName", query = "SELECT p FROM Province p WHERE p.provincePK.name = :name"),
    @NamedQuery(name = "Province.findByCountry", query = "SELECT p FROM Province p WHERE p.provincePK.country = :country"),
    @NamedQuery(name = "Province.findByPopulation", query = "SELECT p FROM Province p WHERE p.population = :population"),
    @NamedQuery(name = "Province.findByArea", query = "SELECT p FROM Province p WHERE p.area = :area")})
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProvincePK provincePK;
    @Column(name = "population")
    private BigInteger population;
    @Column(name = "area")
    private BigInteger area;

    public Province() {
    }

    public Province(ProvincePK provincePK) {
        this.provincePK = provincePK;
    }

    public Province(String name, String country) {
        this.provincePK = new ProvincePK(name, country);
    }

    public ProvincePK getProvincePK() {
        return provincePK;
    }

    public void setProvincePK(ProvincePK provincePK) {
        this.provincePK = provincePK;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }

    public BigInteger getArea() {
        return area;
    }

    public void setArea(BigInteger area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provincePK != null ? provincePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.provincePK == null && other.provincePK != null) || (this.provincePK != null && !this.provincePK.equals(other.provincePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.hspf.swt.dao.Province[ provincePK=" + provincePK + " ]";
    }
    
}
