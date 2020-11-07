package com.hospital.strategy;

import com.hospital.entity.Drug;
import com.hospital.entity.Patient;
import com.hospital.entity.HealthCondition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.hospital.constant.QuarantineConstants.FORTY_DAYS;
import static com.hospital.entity.Drug.PARACETAMOL;
import static com.hospital.entity.Drug.ANTIBIOTIC;
import static com.hospital.entity.Drug.INSULIN;
import static com.hospital.entity.Drug.ASPIRIN;

public class Healthy implements StateStrategy {
    private static final Logger LOG = LogManager.getLogger(Healthy.class);

    @Override
    public void useDrugs(Patient patient) {
        final int days = patient.getDays();
        final List<Drug> drugs = patient.getDrugs();
        if ((days >= FORTY_DAYS && drugs.contains(ANTIBIOTIC) && drugs.contains(INSULIN))) {
            LOG.info("[!] {} patient now - is Fever.", patient.getName());
            patient.setHealthCondition(HealthCondition.FEVER);
        } else if (drugs.contains(ASPIRIN) && drugs.contains(PARACETAMOL)) {
            LOG.info("[X] {} patient now - is Died.", patient.getName());
            patient.setHealthCondition(HealthCondition.DIED);
        } else {
            LOG.info("[+] {} patient is Healthy.", patient.getName());
        }
    }
}
