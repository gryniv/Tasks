package com.hospital;

import com.hospital.tests.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        QuarantineTest.class,
        DiabetesTest.class,
        FeverTest.class,
        HealthyTest.class,
        TuberculosisTest.class,
        FactoryTest.class,
        ExceptionTest.class,
})
public class RunnerTests {
}
