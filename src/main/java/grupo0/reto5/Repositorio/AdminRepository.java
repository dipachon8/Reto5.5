package grupo0.reto5.Repositorio;

import grupo0.reto5.Modelo.Admin;
import grupo0.reto5.Repositorio.CRUD.AdminCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository
{
    @Autowired
    private AdminCRUDRepository adminCRUDRepository;

    public List<Admin> GetAll(){return (List<Admin>) adminCRUDRepository.findAll();}

    public Optional<Admin> getAdmin(int id) {return adminCRUDRepository.findById(id);}

    public Admin save(Admin a) {return adminCRUDRepository.save(a);}

    public void delete(Admin a) {
        adminCRUDRepository.delete(a);}
}
