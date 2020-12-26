package example.entities;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "employee_table")
@DynamicUpdate
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer EmployeeId;

    @Column(name = "employee_name", length = 100, nullable = false)
    private String employeeName;

    @Column(name = "email", unique = true)
    private String email;

    @ElementCollection
    @JoinTable(name = "address_table", joinColumns = @JoinColumn(name = "employee_id"))
    @CollectionId(columns = {@Column(name = "address_id")}, generator = "sequence", type = @Type(type = "int"))
    private Collection<Address> addressList = new HashSet<>();

    @Column(name = "salary")
    private Double salary;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return EmployeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId=" + EmployeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", addressList=" + addressList +
                ", salary=" + salary +
                '}';
    }
}
