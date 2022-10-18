package grupo0.reto5.Web;


import grupo0.reto5.Modelo.DTOs.CountClient;
import grupo0.reto5.Modelo.DTOs.CountStatus;
import grupo0.reto5.Modelo.Reserva;
import grupo0.reto5.Servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController
{
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reserva> GetReservas() {return reservationService.GetAll();}

    @GetMapping("/{id}")
    public Optional<Reserva> GetReserva(@PathVariable("id")int id)
    {
        return reservationService.getReserva(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva r)
    {
        return reservationService.save(r);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva r)
    {
        return reservationService.update(r);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id)
    {
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-clients")
    public List <CountClient> getReportTopClients()
    {
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List <Reserva> getReservationDate(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo)
    {
        return reservationService.getPeriodoReserva(dateOne,dateTwo);
    }

    @GetMapping("/report-status")
    public CountStatus getReportStatusReservations()
    {
        return reservationService.getReservaporestado();
    }
}
