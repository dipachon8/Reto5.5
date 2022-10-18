package grupo0.reto5.Repositorio;

import grupo0.reto5.Modelo.Mensaje;
import grupo0.reto5.Repositorio.CRUD.MessageCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository
{
    @Autowired
    private MessageCRUDRepository messageCRUDRepository;

    public List<Mensaje> getAll(){return (List<Mensaje>) messageCRUDRepository.findAll();}

    public Optional<Mensaje> getMensaje(int id) {return messageCRUDRepository.findById(id);}

    public Mensaje save(Mensaje m) {return messageCRUDRepository.save(m);}

    public void delete(Mensaje m) {
        messageCRUDRepository.delete(m);}
}
