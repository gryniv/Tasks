package com.hospital.strategy;

import com.hospital.entity.Drug;
import com.hospital.entity.Patient;
import com.hospital.entity.HealthCondition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.hospital.constant.QuarantineConstants.FORTY_DAYS;
import static com.hospital.entity.Drug.ASPIRIN;
import static com.hospital.entity.Drug.PARACETAMOL;

public class Fever implements StateStrategy {
    private static final Logger LOG = LogManager.getLogger(Fever.class);

    @Override
    public void useDrugs(Patient patient) {
        final int days = patient.getDays();
        final List<Drug> drugs = patient.getDrugs();
        if (days >= FORTY_DAYS && (drugs.contains(PARACETAMOL) || drugs.contains(ASPIRIN))) {
            LOG.info("[+] {} patient now - is Healthy.", patient.getName());
            patient.setHealthCondition(HealthCondition.HEALTHY);
        } else if (drugs.contains(ASPIRIN) && drugs.contains(PARACETAMOL)) {
            LOG.info("[X] {} patient now - is Died.", patient.getName());
            patient.setHealthCondition(HealthCondition.DIED);
        } else {
            LOG.info("[-] {} patient is still sick.", patient.getName());
        }
    }
}
