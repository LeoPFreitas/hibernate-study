package example.entities;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@DynamicUpdate
public class Employee {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_address", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns =
    @JoinColumn(name = "address_id"))
    private final List<Address> addressList = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer EmployeeId;
    @Column(name = "employee_name", length = 100)
    private String employeeName;
    @Column(name = "email", unique = true)
    private String email;
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

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId=" + EmployeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
