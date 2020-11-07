package com.hospital;

import com.hospital.entity.Drug;
import com.hospital.factory.StateFactory;
import com.hospital.factory.PatientFactory;
import com.hospital.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hospital.constant.QuarantineConstants.COMMA;
import static com.hospital.constant.QuarantineConstants.FORTY_DAYS;

/**
 * To perform this exercise, you will use a readable, maintainable & pragmatic coding style.
 * Please remember that how it's done is as important as the end result.
 */
public class Quarantine {
    private static final Logger LOG = LogManager.getLogger(Quarantine.class);
    final List<Patient> patientList = new ArrayList<>();

    public Quarantine(String patients) {
        parsePatients(patients);
    }

    public void aspirin() {
        patientList.forEach(p -> p.getDrugs().add(Drug.ASPIRIN));
    }

    public void antibiotic() {
        patientList.forEach(p -> p.getDrugs().add(Drug.ANTIBIOTIC));
    }

    public void insulin() {
        patientList.forEach(p -> p.getDrugs().add(Drug.INSULIN));
    }

    public void paracetamol() {
        patientList.forEach(p -> p.getDrugs().add(Drug.PARACETAMOL));
    }

    public void wait40Days() {
        patientList.forEach(s -> s.setDays(FORTY_DAYS));
    }

    public String report() {
        useDrugs();
        return calculate();
    }

    private void parsePatients(final String patients) {
        Arrays.stream(patients.split(COMMA)).forEach(s -> patientList.add(PatientFactory.getPatient(s)));
        LOG.info("Patients come into Hospital {} \n", calculate());
    }

    private void useDrugs() {
        patientList.forEach(p -> StateFactory.getStrategy(p.getHealthCondition().getCondition()).useDrugs(p));
        LOG.info("Patients after Healing {} \n", calculate());
    }

    private String calculate() {
        return new PatientCalculator().calculate(patientList);
    }
}
