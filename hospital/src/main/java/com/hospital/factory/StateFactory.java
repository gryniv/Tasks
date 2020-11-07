package com.hospital.factory;

import com.hospital.exception.UnknownHealthConditionException;
import com.hospital.strategy.*;

import static com.hospital.constant.QuarantineConstants.*;
import static com.hospital.constant.QuarantineConstants.H;

public class StateFactory {
    private StateFactory() {
    }

    public static StateStrategy getStrategy(String healthCondition) {
        switch (healthCondition) {
            case F:
                return new Fever();
            case D:
                return new Diabetes();
            case T:
                return new Tuberculosis();
            case H:
                return new Healthy();
            default:
                throw new UnknownHealthConditionException("Patient with unknown health condition is come.");
        }
    }
}
