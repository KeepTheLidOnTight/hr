package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setFirstName("RyanTest");
        employee.setLastName("FreeseTest");
        employee.setBackground("Java Developer");

        assertNull(employee.getId());
        employeeRepository.save(employee);
        assertNotNull(employee.getId());

        //fetch
        Employee fetchedEmployee = employeeRepository.findOne(employee.getId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee.getId(), fetchedEmployee.getId());

        //update
        fetchedEmployee.setFirstName("Ryan");
        employeeRepository.save(fetchedEmployee);

        Employee fetchUpdatedEmployee = employeeRepository.findOne(fetchedEmployee.getId());
        assertEquals("Ryan", fetchUpdatedEmployee.getFirstName());
    }
}
