package com.github.speisz.euler.problem._0._1._8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.util.stream.Collectors.toList;

public class Triangle {

    private List<List<Integer>> rows;

    public Triangle(String triangleString) {
        this.rows = Stream.of(triangleString.split("\n"))
                .map(row -> Stream.of(row.split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()))
                .collect(toList());

    }

    public List<List<Integer>> getRows() {
        return rows;
    }

    public List<Integer> getRow(int index) {
        return rows.get(index);
    }

    public int calculateMaximumPathSum() {
        Triangle copy = copy();
        for (int rowIndex = copy.rows.size() - 2; rowIndex >= 0; rowIndex--) {
            List<Integer> row = copy.getRow(rowIndex);
            List<Integer> underlyingRow = copy.getRow(rowIndex + 1);
            for (int elementInRowIndex = 0; elementInRowIndex < row.size(); elementInRowIndex++) {
                computeNewValue(row, underlyingRow, elementInRowIndex);
            }
        }
        return copy.getRow(0).get(0);
    }

    private void computeNewValue(List<Integer> row, List<Integer> underlyingRow, int index) {
        row.set(index, row.get(index) + max(underlyingRow.get(index), underlyingRow.get(index + 1)));
    }

    private Triangle copy() {
        return new Triangle(rows.stream()
                .map(ArrayList::new)
                .collect(toList()));
    }

    private Triangle(List<List<Integer>> rows) {
        this.rows = rows;
    }
}
