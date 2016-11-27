package org.dbunit.builder;

import org.dbunit.dataset.builder.ColumnSpec;

public final class Column<T> {
    private final ColumnSpec<T> columnSpec;
    private final T value;

    public Column(ColumnSpec<T> columnSpec, T value) {
        this.columnSpec = columnSpec;
        this.value = value;
    }

    public final ColumnSpec<T> getColumnSpec() {
        return columnSpec;
    }

    public final T getValue() {
        return value;
    }
}
