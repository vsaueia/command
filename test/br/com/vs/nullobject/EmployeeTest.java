package br.com.vs.nullobject;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class EmployeeTest {

    @Test
    public void nullTest() {
        Employee e = DB.getEmployee("Bob");
        if (e.isTimeToPay(LocalDateTime.now())) {
            Assert.fail();
        }
        Assert.assertEquals(Employee.NULL, e);
    }
}
