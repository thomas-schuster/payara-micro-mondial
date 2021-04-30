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
@Table(name = "city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.cityPK.name = :name"),
    @NamedQuery(name = "City.findByCountry", query = "SELECT c FROM City c WHERE c.cityPK.country = :country"),
    @NamedQuery(name = "City.findByProvince", query = "SELECT c FROM City c WHERE c.cityPK.province = :province"),
    @NamedQuery(name = "City.findByPopulation", query = "SELECT c FROM City c WHERE c.population = :population"),
    @NamedQuery(name = "City.findByLatitude", query = "SELECT c FROM City c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "City.findByLongitude", query = "SELECT c FROM City c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "City.findByElevation", query = "SELECT c FROM City c WHERE c.elevation = :elevation")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CityPK cityPK;
    @Column(name = "population")
    private BigInteger population;
    @Column(name = "latitude")
    private BigInteger latitude;
    @Column(name = "longitude")
    private BigInteger longitude;
    @Column(name = "elevation")
    private BigInteger elevation;

    public City() {
    }

    public City(CityPK cityPK) {
        this.cityPK = cityPK;
    }

    public City(String name, String country, String province) {
        this.cityPK = new CityPK(name, country, province);
    }

    public CityPK getCityPK() {
        return cityPK;
    }

    public void setCityPK(CityPK cityPK) {
        this.cityPK = cityPK;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }

    public BigInteger getLatitude() {
        return latitude;
    }

    public void setLatitude(BigInteger latitude) {
        this.latitude = latitude;
    }

    public BigInteger getLongitude() {
        return longitude;
    }

    public void setLongitude(BigInteger longitude) {
        this.longitude = longitude;
    }

    public BigInteger getElevation() {
        return elevation;
    }

    public void setElevation(BigInteger elevation) {
        this.elevation = elevation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityPK != null ? cityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityPK == null && other.cityPK != null) || (this.cityPK != null && !this.cityPK.equals(other.cityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.hspf.swt.dao.City[ cityPK=" + cityPK + " ]";
    }
    
}
