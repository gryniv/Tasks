package com.hospital.tests;

import com.hospital.PatientCalculator;
import com.hospital.entity.Patient;
import com.hospital.factory.PatientFactory;
import com.hospital.factory.StateFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hospital.constant.QuarantineConstants.COMMA;
import static com.hospital.entity.HealthCondition.TUBERCULOSIS;
import static com.hospital.entity.HealthCondition.DIABETES;
import static com.hospital.entity.HealthCondition.HEALTHY;
import static com.hospital.entity.HealthCondition.FEVER;
import static org.junit.Assert.assertEquals;

public class FactoryTest {
    private List<Patient> patientList;

    @Before
    public void setUp() {
        this.patientList = new ArrayList<>();
        this.patientList.add(new Patient(TUBERCULOSIS));
        this.patientList.add(new Patient(DIABETES));
        this.patientList.add(new Patient(HEALTHY));
        this.patientList.add(new Patient(FEVER));
    }

    @Test
    public void stateFactoryShouldCorrectlyCount() {
        patientList.forEach(p -> StateFactory.getStrategy(p.getHealthCondition().getCondition()).useDrugs(p));
        assertEquals(new PatientCalculator().calculate(patientList), "F:1 H:1 D:1 T:1 X:0");
    }

    @Test
    public void patientFactoryShouldCorrectlyCreateAndCount() {
        String patients = "F,H,D,T";
        List<Patient> patientList = new ArrayList<>();
        Arrays.stream(patients.split(COMMA)).forEach(s -> patientList.add(PatientFactory.getPatient(s)));
        assertEquals(new PatientCalculator().calculate(patientList), "F:1 H:1 D:1 T:1 X:0");
    }
}
