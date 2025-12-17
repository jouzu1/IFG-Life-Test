package test.java.com.example.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import javax.inject.Named;

@QuarkusTest
public class CheckoutProcessTest {

    @Inject
    @Named("marketplace_checkout")
    Process<? extends Model> checkoutProcess;

    @Test
    void testSuccessfulCheckout() {
        Model model = checkoutProcess.createModel();
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", "CART-001");
        params.put("userId", "USER-001");
        // Handlers will set inventoryAvailable=true and paymentApproved=true for CART-001
        model.fromMap(params);

        ProcessInstance<?> instance = checkoutProcess.createInstance(model);
        instance.start();

        assertEquals(ProcessInstance.STATE_COMPLETED, instance.status());

        Model result = (Model) instance.variables();
        Map<String, Object> output = result.toMap();
        assertEquals("SUCCESS", output.get("orderStatus"));
    }

    @Test
    void testPaymentFailed() {
        Model model = checkoutProcess.createModel();
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", "CART-002");
        params.put("userId", "USER-002");
        // Handlers will set inventoryAvailable=true but paymentApproved=false for CART-002
        model.fromMap(params);

        ProcessInstance<?> instance = checkoutProcess.createInstance(model);
        instance.start();

        assertEquals(ProcessInstance.STATE_COMPLETED, instance.status());

        Model result = (Model) instance.variables();
        Map<String, Object> output = result.toMap();
        assertEquals("PAYMENT_FAILED", output.get("orderStatus"));
    }

    @Test
    void testInventoryFailed() {
        Model model = checkoutProcess.createModel();
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", "CART-003");
        params.put("userId", "USER-003");
        // Handlers will set inventoryAvailable=false for CART-003
        model.fromMap(params);

        ProcessInstance<?> instance = checkoutProcess.createInstance(model);
        instance.start();

        assertEquals(ProcessInstance.STATE_COMPLETED, instance.status());

        Model result = (Model) instance.variables();
        Map<String, Object> output = result.toMap();
        assertEquals("INVENTORY_FAILED", output.get("orderStatus"));
    }
}
