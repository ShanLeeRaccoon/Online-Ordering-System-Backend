package itemTest;

import com.group4.orderSystem.models.Item;

import com.group4.orderSystem.repository.ItemRepository;
import com.group4.orderSystem.services.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
public class ThrowExceptionTests {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService service;


    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_item_doesnt_exist() {
        Item customer = new Item();
        customer.setId(727L);
        customer.setTitle("Test Name");

        given(itemRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        service.deleteItemById(customer.getId());
    }
}
