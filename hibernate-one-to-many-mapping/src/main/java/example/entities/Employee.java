package example.entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_address", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns =
    @JoinColumn(name = "address_id"))
    private List<Address> addressList = new ArrayList<>();

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

    public List<Address> getAddressList() {
        return addressList;
    }
}
