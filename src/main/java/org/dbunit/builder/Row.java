package org.dbunit.builder;

import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.builder.DataSetBuilder;

public interface Row {
    String getTableName();

    DataSetBuilder addThisToDataSet(DataSetBuilder dataSetBuilder) throws DataSetException;
}
