package dogs.service.impl;

import dogs.dao.DogDAO;
import dogs.model.Dog;
import dogs.model.DogSize;
import dogs.service.DogService;
import dogs.service.exceptions.DogAlreadyExists;
import dogs.service.exceptions.DogNotFound;

import java.io.IOException;
import java.util.Collection;

public class DogServiceImpl implements DogService {
    DogDAO dao;

    public DogServiceImpl(DogDAO dao) { this.dao = dao; }

    public Collection<Dog> listAllDogs() throws IOException {
        return dao.readDogs();
    }

    public Dog getDogById(String id) throws DogNotFound, IOException {
        return dao.readDogById(id);
    }

    public void addDog(Dog dog) throws DogAlreadyExists, IOException {
        dao.createDog(dog);
    }

    public void updateDog(Dog dog) throws DogNotFound,  IOException {
        dao.updateDog(dog);
    }

    public void deleteDog(Dog dog) throws DogNotFound, IOException {
        dao.removeDog(dog);
    }

    @Override
    public Collection<Dog> listOnSize(DogSize s) throws IOException {
        return dao.listOnSize(s);
    }
}
