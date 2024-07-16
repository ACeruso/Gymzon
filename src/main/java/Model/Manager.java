package Model;                                  //il datasorce è un oggetto che automaticamente dà e chiude le connessioni in automatico
import org.apache.tomcat.jdbc.pool.DataSource;  //senza che a farlo siamo noi, gestendone un pool

public abstract class Manager {
    protected static DataSource source;

    public Manager(DataSource source) {
        this.source = source;
    }

}
