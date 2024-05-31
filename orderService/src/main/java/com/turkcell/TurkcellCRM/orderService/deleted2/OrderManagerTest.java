package com.turkcell.TurkcellCRM.orderService.deleted2;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;

//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@ExtendWith(MockitoExtension.class)//test classının mockito ile uyumlu çalışması için gerekli bi anatasuondur
public class OrderManagerTest {
//    @Mock//mockitonun mock nesneleri oluşturmasını sağlar test sırasında kullanilabilir sahte nesneler oluşturur
//    private OrderRepository orderRepository;
//
//    @Mock
//    private OrderProducer orderProducer;
//
//    @InjectMocks
//    private OrderManager orderManager;
//
//    @BeforeEach
//    void setUp(){
//        orderRepository = Mockito.mock(OrderRepository.class);
//        ModelMapper mapper = new ModelMapper();//dış kaynaga ve dış servise bağlı olmadığı için mocklamadık
//        OrderBusinnesRules businnesRules = new OrderBusinnesRules(orderRepository);
//        ModelMapperService modelMapperService = new ModelMapperManager(mapper);
//        orderProducer=Mockito.mock(OrderProducer.class);
//        orderManager = new OrderManager( modelMapperService,orderRepository,orderProducer,businnesRules);
//    }
//
//    @Test
//    public void addOrderSuccess() {
//        Order order =new Order();
//        Product product1=new Product("test","test",12,12,order);
//        Product product2=new Product("test","test",12,12,order);
//
//        List<Product> products = new ArrayList<Product>();
//        products.add(product1);
//        products.add(product2);
//        order.setAddress(new Address());
//        order.setCustomer(new Customer());
//        order.setProducts(products);
//
//        order.setTotalAmount(24);
//        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(order);
//        CreateOrderRequest request = new CreateOrderRequest(1,1,12,products);
//        orderManager.add(request);
//        assert true;
//    }
//
//    @Test
//    public void getAllOrderSuccess() {
//        Order order =new Order();
//        Product product1=new Product("test","test",12,12,order);
//        Product product2=new Product("test","test",12,12,order);
//        List<Product> products = new ArrayList<Product>();
//        products.add(product1);
//        products.add(product2);
//        order.setAddress(new Address());
//        order.setCustomer(new Customer());
//        order.setProducts(products);
//        List<Order> orders = new ArrayList<Order>();
//        orders.add(order);
//        orders.add(order);
//        Mockito.when(orderRepository.findAll()).thenReturn(orders);
//        orderManager.getAll();
//        assert true;
//    }
//        @Test
//    void updateOrderSuccess(){
//        Order order =new Order();
//        Product product1=new Product("test","test",12,12,order);
//        Product product2=new Product("test","test",12,12,order);
//        List<Product> products = new ArrayList<Product>();
//        products.add(product1);
//        products.add(product2);
//        order.setAddress(new Address());
//        order.setCustomer(new Customer());
//        order.setProducts(products);
//        Mockito.when(orderRepository.findById(order.getId())).thenReturn(Optional.of(new Order()));
//        Mockito.when(orderRepository.save(order)).thenReturn(order);
//        UpdateOrderRequest request = new UpdateOrderRequest(1,1,1,12,products);
//        orderManager.update(request,1);
//        assert true;
//        }
//    @Test
//    void updateOrderNotExists_ShouldThrowException(){
//        Order order =new Order();
//        Product product1=new Product("test","test",12,12,order);
//        Product product2=new Product("test","test",12,12,order);
//        List<Product> products = new ArrayList<Product>();
//        products.add(product1);
//        products.add(product2);
//        order.setAddress(new Address());
//        order.setCustomer(new Customer());
//        order.setProducts(products);
//        UpdateOrderRequest request = new UpdateOrderRequest(1,1,1,12,products);
//        assertThrows(BusinessException.class,()->{
//            orderManager.update(request,2);
//        });
//    }
//        @Test
//    public void getByIdOrderSuccess() {
//        Mockito.when(orderRepository.findById(1)).thenReturn(Optional.of(new Order()));
//        orderManager.getById(1);
//        assert true;
//    }

}


