package web;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nadine fakih
 */
@Entity
@Table(name = "bar")

/*  Die folgende Zeile ist auskommentiert , 
um unsere Rest Api als Json anzuzeigen. Kommentieren wir das wieder aus , ist es sowohl als Json ,
als auch als XML Element verfügbar
 */
 //@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bar.findAll", query = "SELECT b FROM Bar b")
    , @NamedQuery(name = "Bar.findByBarId", query = "SELECT b FROM Bar b WHERE b.barId = :barId")
    , @NamedQuery(name = "Bar.findByName", query = "SELECT b FROM Bar b WHERE b.name = :name")
    , @NamedQuery(name = "Bar.findByStrasse", query = "SELECT b FROM Bar b WHERE b.strasse = :strasse")
    , @NamedQuery(name = "Bar.findByPlz", query = "SELECT b FROM Bar b WHERE b.plz = :plz")
    , @NamedQuery(name = "Bar.findByOrt", query = "SELECT b FROM Bar b WHERE b.ort = :ort")
    , @NamedQuery(name = "Bar.findByTelefon", query = "SELECT b FROM Bar b WHERE b.telefon = :telefon")})
public class Bar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bar_id")
    private Integer barId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "strasse")
    private String strasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plz")
    private int plz;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ort")
    private String ort;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefon")
    private int telefon;

    public Bar() {
    }

    public Bar(Integer barId) {
        this.barId = barId;
    }

    public Bar(Integer barId, String name, String strasse, int plz, String ort, int telefon) {
        this.barId = barId;
        this.name = name;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.telefon = telefon;
    }

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    
    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barId != null ? barId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "web.Bar[ barId=" + barId + " ]";
    }

}
