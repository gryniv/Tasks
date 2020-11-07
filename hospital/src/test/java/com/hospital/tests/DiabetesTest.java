package com.hospital.tests;

import com.hospital.entity.Patient;
import com.hospital.strategy.Diabetes;
import org.junit.Before;
import org.junit.Test;

import static com.hospital.entity.Drug.ASPIRIN;
import static com.hospital.entity.Drug.PARACETAMOL;
import static com.hospital.entity.HealthCondition.DIABETES;
import static com.hospital.entity.HealthCondition.DIED;
import static org.junit.Assert.assertEquals;

public class DiabetesTest {
    private Diabetes diabetes;
    private Patient diabetesPatient;

    @Before
    public void setUp() {
        this.diabetesPatient = new Patient(DIABETES);
        this.diabetes = new Diabetes();
    }

    @Test
    public void diabetesShouldBeStillSick() {
        diabetesPatient.getDrugs().add(ASPIRIN);
        diabetes.useDrugs(diabetesPatient);
        assertEquals(diabetesPatient.getHealthCondition(), DIABETES);
    }

    @Test
    public void diabetesShouldBeDied() {
        diabetesPatient.getDrugs().add(ASPIRIN);
        diabetesPatient.setDays(40);
        diabetes.useDrugs(diabetesPatient);
        assertEquals(diabetesPatient.getHealthCondition(), DIED);
    }

    @Test
    public void diabetesTakeAspirinAndParacetamolShouldBeDied() {
        diabetesPatient.getDrugs().add(ASPIRIN);
        diabetesPatient.getDrugs().add(PARACETAMOL);
        diabetes.useDrugs(diabetesPatient);
        assertEquals(diabetesPatient.getHealthCondition(), DIED);
    }
}
