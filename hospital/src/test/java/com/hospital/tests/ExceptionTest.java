package com.hospital.tests;

import com.hospital.Quarantine;
import com.hospital.entity.Patient;
import com.hospital.exception.UnexpectedHealthCondition;
import com.hospital.exception.UnknownHealthConditionException;
import com.hospital.factory.StateFactory;
import org.junit.Assert;
import org.junit.Test;

import static com.hospital.entity.HealthCondition.DIABETES;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @Test
    public void nameShouldBeNotNullPointerException() {
        Patient patient = new Patient(DIABETES);
        Assert.assertNotNull(patient.getName());
    }

    @Test
    public void stateFactoryUnsupportedPatients() {
        Throwable exception = assertThrows(UnknownHealthConditionException.class,
                () -> StateFactory.getStrategy("Z,Z,X"));
        assertEquals("Patient with unknown health condition is come.", exception.getMessage());
    }

    @Test
    public void shouldShowErrorWhenComesIncorrectPatients() {
        Throwable exception = assertThrows(UnknownHealthConditionException.class,
                () -> new Quarantine("Z,H,D"));
        assertEquals("Patient with unknown health condition is come.", exception.getMessage());
    }

    @Test
    public void shouldShowErrorWhenComesDeadPatients() {
        Throwable exception = assertThrows(UnexpectedHealthCondition.class,
                () -> new Quarantine("X,H,D"));
        assertEquals("New patient arrived already dead.", exception.getMessage());
    }

}
