package com.hospital.tests;

import com.hospital.entity.Patient;
import com.hospital.strategy.Fever;
import org.junit.Before;
import org.junit.Test;

import static com.hospital.entity.Drug.ASPIRIN;
import static com.hospital.entity.Drug.PARACETAMOL;
import static com.hospital.entity.HealthCondition.HEALTHY;
import static com.hospital.entity.HealthCondition.FEVER;
import static com.hospital.entity.HealthCondition.DIED;
import static org.junit.Assert.assertEquals;

public class FeverTest {
    private Fever fever;
    private Patient feverPatient;

    @Before
    public void setUp() {
        this.feverPatient = new Patient(FEVER);
        this.fever = new Fever();
    }

    @Test
    public void feverShouldBeStillSick() {
        feverPatient.getDrugs().add(PARACETAMOL);
        fever.useDrugs(feverPatient);
        assertEquals(feverPatient.getHealthCondition(), FEVER);
    }

    @Test
    public void feverShouldBeHealthy() {
        feverPatient.getDrugs().add(PARACETAMOL);
        feverPatient.setDays(40);
        fever.useDrugs(feverPatient);
        assertEquals(feverPatient.getHealthCondition(), HEALTHY);
    }

    @Test
    public void feverTakeAspirinAndParacetamolShouldBeDied() {
        feverPatient.getDrugs().add(ASPIRIN);
        feverPatient.getDrugs().add(PARACETAMOL);
        fever.useDrugs(feverPatient);
        assertEquals(feverPatient.getHealthCondition(), DIED);
    }
}
