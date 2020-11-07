package com.hospital.entity;

import static com.hospital.constant.QuarantineConstants.D;
import static com.hospital.constant.QuarantineConstants.F;
import static com.hospital.constant.QuarantineConstants.H;
import static com.hospital.constant.QuarantineConstants.T;
import static com.hospital.constant.QuarantineConstants.X;

public enum HealthCondition {
    FEVER(F), HEALTHY(H), DIABETES(D), TUBERCULOSIS(T), DIED(X);

    private String condition;

    HealthCondition(final String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
