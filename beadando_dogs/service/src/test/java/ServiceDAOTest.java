import dogs.dao.DogDAO;
import dogs.model.Dog;
import dogs.model.DogSize;
import dogs.service.exceptions.DogAlreadyExists;
import dogs.service.exceptions.DogNotFound;
import dogs.service.impl.DogServiceImpl;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
@RunWith(JUnit4.class)
public class ServiceDAOTest {

    @Mock
    public DogDAO dao;

    @TestSubject
    private DogServiceImpl service;

    @Before
    public void setUp(){
        dao = EasyMock.niceMock(DogDAO.class);
        this.service = new DogServiceImpl(dao);
    }

    @Test
    public void createDog() throws DogAlreadyExists, IOException {
        try {
            service.addDog(new Dog("1222", "Bodri", LocalDate.of(2009, 1, 23), DogSize.LARGE, 40.3, 20.3));
            Assert.assertEquals(0, 0);
        } catch (Exception ex) {
            Assert.assertEquals(0, 1);
        }
    }
    @Test
    public void listAllDogs() throws IOException {
            try{
                service.listAllDogs();
                Assert.assertEquals(0,0);
            }catch (Exception ex){
                Assert.assertEquals(0,1);
            }
    }
    @Test
    public void getDogById(){
        try{
            service.getDogById("1000");
            Assert.assertEquals(0,0);
        }
        catch (Exception ex){
        Assert.assertEquals(0,1);
        }


    }
    @Test
    public void deleteDog(){
        try{
            service.deleteDog(new Dog());
            Assert.assertEquals(0,0);
        }catch (Exception ex){
            Assert.assertEquals(0,1);
        }
    }

}


