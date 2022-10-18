package grupo0.reto5.Web;


import grupo0.reto5.Modelo.Mensaje;
import grupo0.reto5.Servicio.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController
{
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Mensaje> getMensajes() {return messageService.getAll();}

    @GetMapping("/{id}")
    public Optional<Mensaje> getMensaje(@PathVariable("id")int id)
    {
        return messageService.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje m)
    {
        return messageService.save(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje m)
    {
        return messageService.update(m);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id)
    {
        return messageService.deleteMessage(id);
    }
}
