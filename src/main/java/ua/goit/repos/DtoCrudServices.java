package ua.goit.repos;

import java.util.List;
import java.util.Optional;

public interface DtoCrudServices <T>  {
   void save(T entity);

    Optional<T> findById(Long id);

   List<T> findAll();

    void update(T entity);

   void deleteById(Long id);

    void delete(T entity);

  void deleteAll();
}
