package com.hospital.strategy;

import com.hospital.entity.Patient;

public interface StateStrategy {
    /**
     * @param patient health status changed by provides drugs  .
     * @apiNote ASPIRIN cure Fever
     * ANTIBIOTIC cure Tuberculosis
     * INSULIN prevent a diabetic subject from dying, does not cure Diabetes.
     * diabetics die without INSULIN
     * If INSULIN is mixed with an ANTIBIOTIC, healthy people catch Fever
     * PARACETAMOL heals fever
     * mixing PARACETAMOL & ASPIRIN INSTANTLY kills subject!
     */
    void useDrugs(Patient patient);
}
