package com.github.speisz.euler.problem11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.lang.System.arraycopy;
import static java.util.Arrays.deepToString;

public class LargestProductInGrid {
    private int[][] grid;

    LargestProductInGrid(int[][] grid) {
        this.grid = grid;
    }

    public int compute(int length) {
        return union(upDownDiagonals(length), downUpDiagonals(length), horizontals(length), verticals(length))
                .stream()
                .mapToInt(diagonal -> IntStream.of(diagonal).reduce(1, (n, m) -> n * m))
                .max()
                .orElseThrow(() -> new RuntimeException(format("Could not compute maximal product of %s", deepToString(grid))));
    }

    @SafeVarargs
    private Collection<int[]> union(Collection<int[]>... collections) {
        List<int[]> union = new ArrayList<>();
        Stream.of(collections).forEach(union::addAll);
        return union;
    }

    private Collection<int[]> upDownDiagonals(int length) {
        List<int[]> diagonals = new ArrayList<>();
        for (int row = 0; row < grid.length - (length - 1); row++) {
            for (int column = 0; column < grid.length - (length - 1); column++) {
                diagonals.add(upDownDiagonal(length, row, column));
            }
        }
        return diagonals;
    }

    private int[] upDownDiagonal(int length, int row, int column) {
        int[] diagonal = new int[length];
        for (int position = 0; position < length; position++) {
            diagonal[position] = grid[row + position][column + position];
        }
        return diagonal;
    }

    private Collection<int[]> downUpDiagonals(int length) {
        List<int[]> diagonals = new ArrayList<>();
        for (int row = length - 1; row < grid.length; row++) {
            for (int column = 0; column < grid.length - (length - 1); column++) {
                diagonals.add(downUpDiagonal(length, row, column));
            }
        }
        return diagonals;
    }

    private int[] downUpDiagonal(int length, int row, int column) {
        int[] diagonal = new int[length];
        for (int position = 0; position < length; position++) {
            diagonal[position] = grid[row - position][column + position];
        }
        return diagonal;
    }

    private Collection<int[]> horizontals(int length) {
        List<int[]> diagonals = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length - (length - 1); column++) {
                diagonals.add(horizontal(length, row, column));
            }
        }
        return diagonals;
    }

    private int[] horizontal(int length, int row, int column) {
        int[] diagonal = new int[length];
        arraycopy(grid[row], column, diagonal, 0, length);
        return diagonal;
    }

    private Collection<int[]> verticals(int length) {
        List<int[]> diagonals = new ArrayList<>();
        for (int row = 0; row < grid.length - (length - 1); row++) {
            for (int column = 0; column < grid.length; column++) {
                diagonals.add(vertical(length, row, column));
            }
        }
        return diagonals;
    }

    private int[] vertical(int length, int row, int column) {
        int[] diagonal = new int[length];
        for (int position = 0; position < length; position++) {
            diagonal[position] = grid[row + position][column];
        }
        return diagonal;
    }
}
