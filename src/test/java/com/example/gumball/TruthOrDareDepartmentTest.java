package com.example.gumball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TruthOrDareDepartmentTest {
    TruthOrDareDepartment department;

    @BeforeEach
    void setUp() {
        department = new TruthOrDareDepartment();
    }

    @Test
    void testTruth() {
        String possibleTruth = department.pickRandom(TruthOrDareDepartment.GumballType.TRUTH);
        assertTrue(department.isTruth(possibleTruth), "A random truth should be truth.");
    }

    @Test
    void testDare() {
        String possibleDare = department.pickRandom(TruthOrDareDepartment.GumballType.DARE);
        assertTrue(department.isDare(possibleDare), "A random dare should be a dare.");
    }


}
