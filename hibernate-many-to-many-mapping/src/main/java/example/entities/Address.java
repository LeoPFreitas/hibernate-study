package example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "street_name", length = 50)
    private String streetName;
    @Column(name = "city_name", length = 50)
    private String cityName;
    @Column(name = "state_name", length = 50)
    private String stateName;
    @Column(name = "cep", length = 8)
    private String cep;

    @ManyToMany(mappedBy = "addressList")
    private Collection<Employee> employeeList = new ArrayList<>();

    public Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


    public Collection<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Collection<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
