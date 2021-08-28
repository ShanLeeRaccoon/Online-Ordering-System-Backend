package orderTest;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.models.OrderForm;
import com.group4.orderSystem.models.User;
import com.group4.orderSystem.repository.OrderFormRepository;
import com.group4.orderSystem.services.OrderFormService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTests {
    @Mock
    private OrderFormRepository orderFormRepository;

    @InjectMocks
    private OrderFormService service;

    @Test
    public void save_order(){
        OrderForm order = new OrderForm();
        order.setId(1L);
        order.setQuantity(5);
        order.setStatus("Paid");
        when(orderFormRepository.save(ArgumentMatchers.any(OrderForm.class))).thenReturn(order);
        OrderForm created = service.save(order);
        assertEquals(created.getQuantity(), order.getQuantity());
        assertEquals(created.getStatus(), order.getStatus());

        verify(orderFormRepository).save(order);
    }
    @Test
    public void canGetAllOrders(){
        service.listAllOrders();
        verify(orderFormRepository).findAll();
    }
//    @Test
//    public void canGetOrdersByID(){
//        Item item = new Item();
//        item.setId(1L);
//        User user = new User();
//        user.setId(1L);
//
//        when(orderFormRepository.getById(1L)).thenReturn(new OrderForm(1L,4,"paid", item, user));
//
//        OrderForm order = service.getOrderById(1L);
//
//        assertEquals("paid", order.getStatus());

//    }
    @Test
    public void canGetOrdersByUserID(){
        service.getOrderByUser(1L);
        verify(orderFormRepository).findOrdersByUserId(1L);
    }
    @Test
    public void canGetOrdersByItemID(){
        service.getOrderByItem(2L);
        verify(orderFormRepository).findOrdersByItemId(2L);
    }
    @Test
    public void whenFoundOrder_deleteOrder() {
        OrderForm order = new OrderForm();
        order.setQuantity(10);
        order.setStatus("Outstanding");
        order.setId(1L);


        service.deleteOrder(order.getId());
        verify(orderFormRepository).deleteById(order.getId());
    }

}
