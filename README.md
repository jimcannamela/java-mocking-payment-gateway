# Exercise - Payment Gateway Integration


You are developing an e-commerce application that requires integrating with a payment gateway to process customer payments. To test the payment gateway integration, you want to mock the dependencies and simulate different scenarios.

Classes and Dependencies:
1. `PaymentGateway`: The main class responsible for processing customer payments.
2. `PaymentProcessor`: A class or interface representing the payment processing functionality.
3. `OrderRepository`: A class or interface for accessing order information.

Mocking Exercise:
Consider the following scenario for the mocking exercise:

- `PaymentGatewayTests` Starter Code
    ```java 
    @ExtendWith(MockitoExtension.class)
    class PaymentGatewayTests {
        PaymentGateway paymentGateway;

        @BeforeEach
        void setUp() {
            // Create mocks for paymentProcessor and orderRepository
            paymentGateway = new PaymentGateway(paymentProcessor, orderRepository);
        }
    }
    ```

1. Create a test case for the `PaymentGateway` class.
2. Mock the `PaymentProcessor` dependency and simulate processing payments.
3. Mock the `OrderRepository` dependency and simulate retrieving order information.
4. Write tests and implementations for the following acceptance criteria.
    - Can start the gateway (with mocks)
    - Can process a successful payent (with mocks)
    - Can handle a failed payment (with mocks)
    - Verify that the proper methods are called upon processing (with mocks)
    - Can handle an order not found (with mocks)
    - Verify the interactions and assertions

## Hints

- Add the following dependency in `build.gradle`:
    ```groovy 
    testImplementation 'org.mockito:mockito-core:5.2.0'
    ```
- Creating mocks - Two Methods
    - `Mockito.mock(ClassToMock.class)`
    - Using `@ExtendWith` Annotation
        - Add this dependency in `build.gradle`:
            ```groovy 
            testImplementation 'org.mockito:mockito-junit-jupiter:5.2.0'
            ```
        ```java 
        @ExtendWith(MockitoExtension.class)
        public class MyClassTests{
            @Mock 
            private ClassToMock classToMock;
        }
        ```
- Scenarios
    - Static methods in `import static org.makito.Makito.*`
        - `when(Class.methodToCall(args)).thenReturn(something)`
        - `when(Class.methodToCall(args)).thenThrow(ExceptionToThrow.class)`
        - Throw an exception, or do something from a void method
            ```java 
            doThrow(new RuntimeException("message")).when(objectName).method(args);
            ```
        - Verify that a method was called (spy)
            ```java 
            verify(objectName).method(arg);
            verify(objectName).method(arg);
            verifyNoInteractions(objectName);
            ```
