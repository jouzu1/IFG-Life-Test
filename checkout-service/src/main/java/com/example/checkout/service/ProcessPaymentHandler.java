package com.example.checkout.service;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.internal.process.runtime.KogitoWorkItem;
import org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler;
import org.kie.kogito.internal.process.runtime.KogitoWorkItemManager;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessPaymentHandler implements KogitoWorkItemHandler {

    @Override
    public void executeWorkItem(KogitoWorkItem workItem, KogitoWorkItemManager manager) {
        String cartId = (String) workItem.getParameter("cartId");
        
        Map<String, Object> results = new HashMap<>();
        if ("CART-002".equals(cartId)) {
             results.put("paymentApproved", false);
             results.put("orderStatus", "PAYMENT_FAILED");
        } else {
             results.put("paymentApproved", true);
        }
        
        manager.completeWorkItem(workItem.getStringId(), results);
    }

    @Override
    public void abortWorkItem(KogitoWorkItem workItem, KogitoWorkItemManager manager) {
    }
}
