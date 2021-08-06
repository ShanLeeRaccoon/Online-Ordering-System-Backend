package itemTest;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.models.User;
import com.group4.orderSystem.repository.UserRepository;
import com.group4.orderSystem.services.ItemService;
import com.group4.orderSystem.services.UserService;
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
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService service;

    @Test
    public void whenSaveUser_shouldReturnUser() {
        User user = new User();
        user.setEmail("user@email.com");
        user.setId(1L);

        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        User created = service.save(user);

        assertEquals(created.getEmail(), user.getEmail());
        verify(userRepository).save(user);
    }

    @Test
    public void canGetAllUsers(){
        service.listAllUsers();
        verify(userRepository).findAll();
    }


}
