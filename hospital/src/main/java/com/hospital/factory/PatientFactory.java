package com.hospital.factory;

import com.hospital.entity.Patient;
import com.hospital.exception.UnexpectedHealthCondition;
import com.hospital.exception.UnknownHealthConditionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.hospital.constant.QuarantineConstants.*;
import static com.hospital.entity.HealthCondition.*;

public class PatientFactory {
    private static final Logger LOG = LogManager.getLogger(PatientFactory.class);

    private PatientFactory() {
    }

    public static Patient getPatient(String patientCondition) {
        switch (patientCondition) {
            case F:
                LOG.info("New Fever patient is come.");
                return new Patient(FEVER);
            case D:
                LOG.info("New Diabetes patient is come.");
                return new Patient(DIABETES);
            case T:
                LOG.info("New Tuberculosis patient is come.");
                return new Patient(TUBERCULOSIS);
            case H:
                LOG.info("New health patient is come.");
                return new Patient(HEALTHY);
            case X:
                throw new UnexpectedHealthCondition("New patient arrived already dead.");
            default:
                throw new UnknownHealthConditionException("Patient with unknown health condition is come.");
        }
    }
}
