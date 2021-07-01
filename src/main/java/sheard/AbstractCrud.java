package sheard;

import java.sql.SQLException;
import java.util.List;

public interface AbstractCrud<T> {
   T create(T t);
   T read(Integer id) throws SQLException;
   T update(T t);
   void delete(Integer id);
   List<T> readAll();
}
