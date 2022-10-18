package grupo0.reto5.Repositorio;


import grupo0.reto5.Modelo.Category;
import grupo0.reto5.Repositorio.CRUD.CategoryCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository
{
    @Autowired
    private CategoryCRUDRepository categoryCRUDRepository;

    public List<Category> GetAll(){return (List<Category>) categoryCRUDRepository.findAll();}

    public Optional<Category> getCategoria(int id) {return categoryCRUDRepository.findById(id);}

    public Category save(Category c) {return categoryCRUDRepository.save(c);}

    public void delete(Category c) {
        categoryCRUDRepository.delete(c);}


}
