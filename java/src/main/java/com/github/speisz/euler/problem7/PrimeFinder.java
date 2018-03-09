package com.github.speisz.euler.problem7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.github.speisz.euler.utils.ListUtil.getLastElement;
import static com.github.speisz.euler.utils.LoopUtil.repeatNTimes;
import static com.github.speisz.euler.utils.MathUtil.findNextPrime;

class PrimeFinder {

    BigInteger findNth(long n) {
        return getLastElement(firstNPrimes(n));
    }

    private List<BigInteger> firstNPrimes(long n) {
        List<BigInteger> primes = new ArrayList<>();
        repeatNTimes(n, () -> primes.add(findNextPrime(primes)));
        return primes;
    }
}
