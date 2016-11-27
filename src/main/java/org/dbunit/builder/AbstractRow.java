package org.dbunit.builder;

public abstract class AbstractRow implements Row {
    protected final String tableName;

    protected AbstractRow(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public final String getTableName() {
        return null;
    }
}
