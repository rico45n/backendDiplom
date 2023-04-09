package ru.pesnin.system.accounting.domain.controllers.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
import ru.pesnin.system.accounting.services.service.interfase.pac.user.IUserService;

import java.util.List;

class UserControllerTest {
    @MockBean
    private IUserService userService;
    @BeforeEach
    void setUp(){
        userService = Mockito.mock(IUserService.class);
    }
    @Test
    @DisplayName("Получить всех пользователей")
    void findAll() {

        Mockito.when(userService.findAll())

                .thenReturn(List.of(UsersEntity.builder().build()));

        userService.findAll();

        Mockito.verify(userService, Mockito.times(1)).findAll();
    }

    @Test
    void read() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void create() {
    }

    @Test
    void loginUserSearch() {
    }
}