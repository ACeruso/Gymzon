package Model;

import org.apache.tomcat.jdbc.pool.DataSource;

public abstract class SqlDAO {
    protected final DataSource source;

    public SqlDAO(DataSource source) {
        this.source = source;
    }
}
