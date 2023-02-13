package orders;

import org.assertj.core.api.ObjectAssert;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import static org.assertj.core.api.Assertions.assertThat;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    OrderRepository orderRepository;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect!", se);
        }

        Flyway flyway = Flyway.configure().cleanDisabled(false).dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        orderRepository = new OrderRepository(dataSource);
    }

    @Test
    void testSaveOrder(){
       long id = orderRepository.saveOrder(new Order("Test1", 20, 20));
        assertNotEquals(0, id);
    }
    @Test
    void testGetOrders(){
        orderRepository.saveOrder(new Order("Test1", 20, 200));
        orderRepository.saveOrder(new Order("Test2", 30, 30));
        orderRepository.saveOrder(new Order("Test3", 40, 240));
        orderRepository.saveOrder(new Order("Test4", 50, 500));

        = assertThat(orderRepository.getOrders())
                .hasSize(4)
                .extracting(Order::getProductName)
                .containsExactly("Test1","Test2","Test3","Test4");
    }
}