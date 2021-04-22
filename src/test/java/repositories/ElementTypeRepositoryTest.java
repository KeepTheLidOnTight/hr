package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementTypeRepositoryTest {

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Test
    public void testFindByElementName(){
        ElementType elementType = new ElementType("Dell");
        elementTypeRepository.save(elementType);

        ElementType foundByNameElement = elementTypeRepository.findByElementTypeName("Dell");

        assertEquals(elementType.getId(), foundByNameElement.getId());
    }

    @Test
    public void testFindAllByElementType(){
        ElementType elementType1 = new ElementType("FindTest");
        elementTypeRepository.save(elementType1);
        ElementType elementType2 = new ElementType("FindTest");
        elementTypeRepository.save(elementType2);
        ElementType elementType3 = new ElementType("FindTest");
        elementTypeRepository.save(elementType3);

        List<ElementType> foundAllByNameElement = elementTypeRepository.findAllByElementTypeName("FindTest");

        foundAllByNameElement.size();

        assertEquals(3, foundAllByNameElement.size());
    }
}
