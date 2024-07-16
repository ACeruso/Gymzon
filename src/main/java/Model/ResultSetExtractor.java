package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<B> {
    B extract(ResultSet resultSet) throws SQLException;     //prende in input un resultset e restituisce un generico
                                                            //bean che sarà l'entità che si vuole mappare

}
