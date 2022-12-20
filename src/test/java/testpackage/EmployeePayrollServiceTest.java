package testpackage;

import org.example.EmployeePayrollData;
import org.example.EmployeePayrollService;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

import static org.example.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
        EmployeePayrollData [] arrayOfEmps = {
                new EmployeePayrollData(1, "Jeff Bezos", 100000.0),
                new EmployeePayrollData(2, "Bill Gates", 200000.0),
                new EmployeePayrollData(3, "Mark ZuckerBerg", 300000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
        employeePayrollService.printData(IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(IOService.FILE_IO);
        Assert.assertEquals(3,entries);
    }

    @Test
    public void givenFile_OnReadingFromFile_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        long entries = employeePayrollService.readEmployeePayrollData(IOService.FILE_IO);
        Assert.assertEquals(3, entries);
    }
}