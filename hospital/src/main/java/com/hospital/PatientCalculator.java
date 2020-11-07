package com.hospital;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.hospital.entity.Patient;
import com.hospital.entity.HealthCondition;

import static com.hospital.constant.QuarantineConstants.COLON;
import static com.hospital.constant.QuarantineConstants.SPACE;

public class PatientCalculator {
    public String calculate(List<Patient> patientList) {
        Map<String, Integer> conditionMap = new LinkedHashMap<>();
        for (HealthCondition value : HealthCondition.values()) {
            conditionMap.put(value.getCondition(), 0);
        }
        patientList.forEach(p -> conditionMap.computeIfPresent(p.getHealthCondition().getCondition(), (k, v) -> ++v));
        StringJoiner result = new StringJoiner(SPACE);
        conditionMap.forEach((key, value) -> result.add(key + COLON + value));
        return result.toString();
    }
}
