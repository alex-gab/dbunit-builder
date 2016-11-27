package org.dbunit.builder;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;

import java.util.ArrayList;
import java.util.List;

public final class DataSetBuilder implements Builder<IDataSet> {
    private final org.dbunit.dataset.builder.DataSetBuilder undelyingBuilder;
    private final List<Row> rows;

    private DataSetBuilder(org.dbunit.dataset.builder.DataSetBuilder undelyingBuilder) {
        this.undelyingBuilder = undelyingBuilder;
        rows = new ArrayList<>();
    }

    public static DataSetBuilder aDataSet() {
        try {
            return new DataSetBuilder(new org.dbunit.dataset.builder.DataSetBuilder());
        } catch (DataSetException e) {
            throw new RuntimeException("An unexpected exception occurred when building the data set", e);
        }
    }

    public final DataSetBuilder withRow(final Row row) {
        rows.add(row);
        return this;
    }

    @Override
    public final IDataSet build() {
        try {
            org.dbunit.dataset.builder.DataSetBuilder builder = undelyingBuilder;
            for (Row row : rows) {
                builder = row.addThisToDataSet(builder);
            }
            return builder.build();
        } catch (DataSetException e) {
            throw new RuntimeException("An unexpected exception occurred when building the data set", e);
        }
    }
}
