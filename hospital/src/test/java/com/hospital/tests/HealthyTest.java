package com.hospital.tests;

import com.hospital.entity.Patient;
import com.hospital.strategy.Healthy;
import org.junit.Before;
import org.junit.Test;

import static com.hospital.entity.Drug.PARACETAMOL;
import static com.hospital.entity.Drug.ANTIBIOTIC;
import static com.hospital.entity.Drug.INSULIN;
import static com.hospital.entity.Drug.ASPIRIN;
import static com.hospital.entity.HealthCondition.HEALTHY;
import static com.hospital.entity.HealthCondition.FEVER;
import static com.hospital.entity.HealthCondition.DIED;
import static org.junit.Assert.assertEquals;

public class HealthyTest {
    private Healthy healthy;
    private Patient healthyPatient;

    @Before
    public void setUp() {
        this.healthyPatient = new Patient(HEALTHY);
        this.healthy = new Healthy();
    }

    @Test
    public void healthyShouldBeStillHealthy() {
        healthyPatient.getDrugs().add(PARACETAMOL);
        healthy.useDrugs(healthyPatient);
        assertEquals(healthyPatient.getHealthCondition(), HEALTHY);
    }

    @Test
    public void healthyShouldBeFever() {
        healthyPatient.getDrugs().add(ANTIBIOTIC);
        healthyPatient.getDrugs().add(INSULIN);
        healthyPatient.setDays(40);
        healthy.useDrugs(healthyPatient);
        assertEquals(healthyPatient.getHealthCondition(), FEVER);
    }

    @Test
    public void healthyTakeAspirinAndParacetamolShouldBeDied() {
        healthyPatient.getDrugs().add(ASPIRIN);
        healthyPatient.getDrugs().add(PARACETAMOL);
        healthy.useDrugs(healthyPatient);
        assertEquals(healthyPatient.getHealthCondition(), DIED);
    }
}
