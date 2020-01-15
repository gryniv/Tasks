package org.training.calculator.service.impl;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.training.calculator.operations.hash.HashOperations;
import org.training.calculator.service.Calculator;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.training.calculator.constants.HashAction.DECODE;
import static org.training.calculator.constants.HashAction.ENCODE;

public class MD5HashCalculator implements Calculator {

    private static final String COMMAND_NOT_FOUND = "Command not found";
    private HashOperations operations;

    public MD5HashCalculator(final HashOperations operations) {
        this.operations = operations;
    }

    /**
     * Encode/decode input value
     * Example of input: decode 4fd0101ea3d0f5abbe296ef97f47afec
     * Example of input: encode titkos
     *
     * @param input input string
     * @return encoded/decoded value
     * @throws IOException if input is black
     */
    @Override
    public String calculate(final String input) throws IOException {
        if (StringUtils.isBlank(input)) {
            throw new IOException("Input should not be blank");
        }

        if (input.startsWith(ENCODE.name().toLowerCase())) {
            return operations.encode(input.replace(ENCODE.name().toLowerCase(), EMPTY).trim());
        } else if (input.startsWith(DECODE.name().toLowerCase())) {
            return operations.decode(input.replace(DECODE.name().toLowerCase(), EMPTY).trim());
        } else {
            return COMMAND_NOT_FOUND;
        }
    }
}
