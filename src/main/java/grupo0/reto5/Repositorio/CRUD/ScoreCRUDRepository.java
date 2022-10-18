package grupo0.reto5.Repositorio.CRUD;


import grupo0.reto5.Modelo.Score;
import org.springframework.data.repository.CrudRepository;

//Interfaz encargada de recibir los datos de las entidades para realizar los servicios CRUD.
public interface ScoreCRUDRepository extends CrudRepository<Score,Integer>
{
}
