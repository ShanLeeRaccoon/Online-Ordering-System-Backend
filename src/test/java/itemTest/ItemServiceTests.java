package itemTest;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.repository.ItemRepository;
import com.group4.orderSystem.services.ItemService;
import org.hibernate.mapping.Array;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTests {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService service;

    @Test
    public void whenSaveCustomer_shouldReturnCustomer() {
        Item item = new Item();
        item.setTitle("Test Name");

        when(itemRepository.save(ArgumentMatchers.any(Item.class))).thenReturn(item);

        Item created = service.save(item);

        assertEquals(created.getTitle(), item.getTitle());
        verify(itemRepository).save(item);
    }

    @Test
    public void canGetAllItems(){
        service.listAllItems();
        verify(itemRepository).findAll();
    }

    @Test
    public void canGetItemsByTitle(){
        service.getItemsByTitle("T");
        verify(itemRepository).findItemByTitleContaining("T");
    }

    @Test
    public void canGetItemsByGenre(){
        service.getItemsByGenre("WHY");
        verify(itemRepository).findItemByGenre("WHY");
    }

    @Test
    public void whenFoundItem_deleteItem() {
        Item item = new Item();
        item.setTitle("Test Item");
        item.setId(1L);

//        when(itemRepository.save(ArgumentMatchers.any(Item.class))).thenReturn(item);

        service.deleteItemById(item.getId());
        verify(itemRepository).deleteById(item.getId());
    }


}
