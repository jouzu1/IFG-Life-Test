/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.bpmn2;

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "marketplace_checkout", name = "Marketplace_checkout", hidden = false)
public class Marketplace_checkoutModel implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<Marketplace_checkoutModelOutput> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "totalAmount")
    @javax.validation.Valid()
    private java.lang.String totalAmount;

    public java.lang.String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(java.lang.String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "orderId")
    @javax.validation.Valid()
    private java.lang.String orderId;

    public java.lang.String getOrderId() {
        return orderId;
    }

    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "cartId")
    @javax.validation.Valid()
    private java.lang.String cartId;

    public java.lang.String getCartId() {
        return cartId;
    }

    public void setCartId(java.lang.String cartId) {
        this.cartId = cartId;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "inventoryAvailable")
    @javax.validation.Valid()
    private java.lang.Boolean inventoryAvailable;

    public java.lang.Boolean getInventoryAvailable() {
        return inventoryAvailable;
    }

    public void setInventoryAvailable(java.lang.Boolean inventoryAvailable) {
        this.inventoryAvailable = inventoryAvailable;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "paymentApproved")
    @javax.validation.Valid()
    private java.lang.Boolean paymentApproved;

    public java.lang.Boolean getPaymentApproved() {
        return paymentApproved;
    }

    public void setPaymentApproved(java.lang.Boolean paymentApproved) {
        this.paymentApproved = paymentApproved;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "orderStatus")
    @javax.validation.Valid()
    private java.lang.String orderStatus;

    public java.lang.String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(java.lang.String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "userId")
    @javax.validation.Valid()
    private java.lang.String userId;

    public java.lang.String getUserId() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    @Override()
    public Marketplace_checkoutModelOutput toModel() {
        Marketplace_checkoutModelOutput result = new Marketplace_checkoutModelOutput();
        result.setId(getId());
        result.setTotalAmount(getTotalAmount());
        result.setOrderId(getOrderId());
        result.setCartId(getCartId());
        result.setInventoryAvailable(getInventoryAvailable());
        result.setPaymentApproved(getPaymentApproved());
        result.setOrderStatus(getOrderStatus());
        result.setUserId(getUserId());
        return result;
    }
}
