package grupo0.reto5.Web;


import grupo0.reto5.Modelo.Admin;
import grupo0.reto5.Servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdminController
{
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> GetAdmins() {return adminService.GetAll();}

    @GetMapping("/{id}")
    public Optional<Admin> GetAdmin(@PathVariable("id")int id){return adminService.getAdmin(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin a){return adminService.save(a);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin a)
    {
        return adminService.update(a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id) {return adminService.deleteAdmin(id);}
}
