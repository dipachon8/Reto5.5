package grupo0.reto5.Repositorio;


import grupo0.reto5.Modelo.Client;
import grupo0.reto5.Modelo.DTOs.CountClient;
import grupo0.reto5.Modelo.Reserva;
import grupo0.reto5.Repositorio.CRUD.ReservationCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository
{
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    public List<Reserva> GetAll(){return (List<Reserva>) reservationCRUDRepository.findAll();}

    public Optional<Reserva> getReserva(int id) {return reservationCRUDRepository.findById(id);}

    public Reserva save(Reserva r) {return reservationCRUDRepository.save(r);}

    public void delete(Reserva r) {
        reservationCRUDRepository.delete(r);}

    //Reto5 (Estudiar mas a fondo).

    //1er punto

    public List<Reserva> getReservaporestado(String status)
    {
        return reservationCRUDRepository.findAllByStatus(status);
    }

    //2do punto

    public List<Reserva> getPeriodoReserva(Date a, Date b)
    {
        return reservationCRUDRepository.findAllByStartDateAfterAndDevolutionDateBefore(a,b);
    }

    //3er punto
    public List<CountClient> getTopClients()
    {
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCRUDRepository.TotalReservasporClients();

        for(int i=0; i<reporte.size();i++)
        {
            //[client,total] ->  [total,client]
            respuesta.add(new CountClient((Long)reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }
}
