package service;

public interface IService<Model> {
    Iterable<Model>findAll();
    Model findById(Long id);
    void save(Model model);
    void remove(Long id);
}
