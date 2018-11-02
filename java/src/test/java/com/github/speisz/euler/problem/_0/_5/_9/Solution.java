package com.github.speisz.euler.problem._0._5._9;

import com.github.speisz.euler.cryptography.XorCrypt;
import com.github.speisz.euler.stream.StringStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.ByteUtil.toByteArray;
import static com.github.speisz.euler.utils.StringUtil.stringCombinations;
import static com.google.common.collect.Sets.newHashSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {
    Set<String> commonEnglishWords = newHashSet("was", "and", "the", "of");

    Function<String, Path> pathOnClassPath = name -> Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(name)).getPath());
    Function<String, Function<String, String>> decrypt = cipher -> (key -> XorCrypt.decrypt(toByteArray(Stream.of(cipher.split(",")).map(Byte::valueOf)), key));

    @Test
    void decodesCipher() throws IOException {
        String cipher = new String(Files.readAllBytes(pathOnClassPath.apply("problem59/cipher.txt")));

        assertThat(stringCombinations(StringStream::lowerCaseAlphabet, 3)
                .map(decrypt.apply(cipher))
                .filter(text -> commonEnglishWords.stream().allMatch(text::contains))
                .peek(System.out::println)
                .flatMapToInt(String::chars)
                .sum(), is(107_359));
    }
}
