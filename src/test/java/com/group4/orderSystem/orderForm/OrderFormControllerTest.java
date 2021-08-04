//package com.group4.orderSystem.orderForm;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.group4.orderSystem.models.Item;
//import com.group4.orderSystem.models.OrderForm;
//import com.group4.orderSystem.models.User;
//import com.group4.orderSystem.repository.OrderFormRepository;
//import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(OrderFormControllerTest.class)
//public class OrderFormControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    OrderFormRepository repo;
//
////    Item item_1 = new Item("Minecraft", 25, 590,
////            "Minecraft is a sandbox video game developed by Mojang Studios.", "Sandbox", 959, "https://www.minecraft.net/content/dam/games/minecraft/key-art/CavesandCliffsPt1-dotNET-HomepagePromo-600x360.png");
//    Item item_1 = new Item();
//    User user_1 = new User();
//    OrderForm order_1 = new OrderForm(1l, 1, "Paid", item_1, user_1);
//    OrderForm order_2 = new OrderForm(2l, 2, "Outstanding", item_1, user_1);
//    OrderForm order_3 = new OrderForm(3l, 3, "StandBy", item_1, user_1);
//
//    @Test
//    public void getAllOrders_success() throws Exception {
//        List<OrderForm> orders = new ArrayList<>(Arrays.asList(order_1, order_2, order_3));
//
//        Mockito.when(repo.findAll()).thenReturn(orders);
//
//        mockMvc.perform(MockMvcRequestBuilders
//            .get("/orders")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andExpect(jsonPath("$[2].status", is("Outstanding")));
//
//    }
//}
