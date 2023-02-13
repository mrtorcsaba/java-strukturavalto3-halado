package orders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testCreateOrder(){
        Order o = new Order("test1",2,2);
        Order o2 = new Order(1L,"test2",2,3);
        assertEquals("test1",o.getProductName());
        assertEquals(2,o.getProductCount());
        assertEquals(2,o.getPricePerProduct());
        assertEquals("test2",o2.getProductName());
        assertEquals(1L,o2.getId());
        assertEquals(2,o2.getProductCount());
    }


}