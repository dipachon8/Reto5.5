package grupo0.reto5.Repositorio.CRUD;


import grupo0.reto5.Modelo.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

//Interfaz encargada de recibir los datos de las entidades para realizar los servicios CRUD.
public interface ReservationCRUDRepository extends CrudRepository<Reserva,Integer>
{

    //3er punto Reto5
    //@Query("SELECT r.cloud,COUNT (r.cloud)FROM Reserva AS r GROUP BY r.cloud ORDER BY COUNT (r.cloud) DESC ")
    //public List<Object[]> TotalReservasporNubes();

    // [client,total]
    @Query("SELECT r.client,COUNT (r.client)FROM Reserva AS r GROUP BY r.client ORDER BY COUNT (r.client) DESC")
    public List<Object[]> TotalReservasporClients();

    // SELECT * FROM RESERVA WHERE idReservation BETWEEN a AND b;
    //public void findAllByIdReservationBetweenAnd(Integer a,Integer b);

    // SELECT * FROM RESERVA WHERE StartDate AFTER FechaInicio AND FechaDevolución BEFORE FechaFin;
    public List<Reserva> findAllByStartDateAfterAndDevolutionDateBefore (Date dateOne,Date dateTwo);

    // SELECT * FROM RESERVA WHERE status = 'canceled'
    public List<Reserva> findAllByStatus (String status);
}
