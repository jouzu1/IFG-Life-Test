package main.java.com.example.checkout;

import javax.enterprise.context.ApplicationScoped;
import org.kie.kogito.process.impl.DefaultWorkItemHandlerConfig;
import com.example.checkout.service.*;

@ApplicationScoped
public class CheckoutWorkItemHandlerConfig extends DefaultWorkItemHandlerConfig {

    public CheckoutWorkItemHandlerConfig(
            ValidateCartHandler validateCartHandler,
            ReserveInventoryHandler reserveInventoryHandler,
            CalculateTotalHandler calculateTotalHandler,
            ProcessPaymentHandler processPaymentHandler,
            CreateOrderHandler createOrderHandler,
            SendNotificationHandler sendNotificationHandler) {

        register("validateCart", validateCartHandler);
        register("reserveInventory", reserveInventoryHandler);
        register("calculateTotal", calculateTotalHandler);
        register("processPayment", processPaymentHandler);
        register("createOrder", createOrderHandler);
        register("sendNotification", sendNotificationHandler);
    }
}
