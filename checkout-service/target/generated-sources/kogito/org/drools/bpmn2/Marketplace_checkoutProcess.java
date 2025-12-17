package org.drools.bpmn2;

import org.drools.bpmn2.Marketplace_checkoutModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;
import org.jbpm.process.core.datatype.impl.type.BooleanDataType;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("marketplace_checkout")
@io.quarkus.runtime.Startup()
public class Marketplace_checkoutProcess extends org.kie.kogito.process.impl.AbstractProcess<org.drools.bpmn2.Marketplace_checkoutModel> {

    @javax.inject.Inject()
    public Marketplace_checkoutProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        super(app, java.util.Arrays.asList(), correlations);
        activate();
    }

    public Marketplace_checkoutProcess() {
    }

    @Override()
    public org.drools.bpmn2.Marketplace_checkoutProcessInstance createInstance(org.drools.bpmn2.Marketplace_checkoutModel value) {
        return new org.drools.bpmn2.Marketplace_checkoutProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.drools.bpmn2.Marketplace_checkoutProcessInstance createInstance(java.lang.String businessKey, org.drools.bpmn2.Marketplace_checkoutModel value) {
        return new org.drools.bpmn2.Marketplace_checkoutProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.drools.bpmn2.Marketplace_checkoutProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.drools.bpmn2.Marketplace_checkoutModel value) {
        return new org.drools.bpmn2.Marketplace_checkoutProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.drools.bpmn2.Marketplace_checkoutModel createModel() {
        return new org.drools.bpmn2.Marketplace_checkoutModel();
    }

    public org.drools.bpmn2.Marketplace_checkoutProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.drools.bpmn2.Marketplace_checkoutModel) value);
    }

    public org.drools.bpmn2.Marketplace_checkoutProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.drools.bpmn2.Marketplace_checkoutModel) value);
    }

    public org.drools.bpmn2.Marketplace_checkoutProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.drools.bpmn2.Marketplace_checkoutProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.drools.bpmn2.Marketplace_checkoutProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.drools.bpmn2.Marketplace_checkoutProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("marketplace_checkout", true);
        factory.variable("cartId", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("userId", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("totalAmount", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("inventoryAvailable", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), null, "customTags", null);
        factory.variable("paymentApproved", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), null, "customTags", null);
        factory.variable("orderId", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("orderStatus", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.name("Marketplace Checkout");
        factory.packageName("org.drools.bpmn2");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.example.com/marketplace-checkout");
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode1 = factory.startNode(1);
        startNode1.name("Start Checkout");
        startNode1.interrupting(false);
        startNode1.metaData("UniqueId", "StartEvent_Checkout");
        startNode1.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode2 = factory.workItemNode(2);
        workItemNode2.name("Validate Cart");
        workItemNode2.workName("validateCart");
        workItemNode2.workParameter("NodeName", "Validate Cart");
        workItemNode2.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("cartId", "cartId", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("Input_CartId", "cartId", "java.lang.Object", null), null, null));
        workItemNode2.done();
        workItemNode2.metaData("UniqueId", "Task_ValidateCart");
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode3 = factory.workItemNode(3);
        workItemNode3.name("Reserve Inventory");
        workItemNode3.workName("reserveInventory");
        workItemNode3.workParameter("NodeName", "Reserve Inventory");
        workItemNode3.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("cartId", "cartId", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("Inv_CartId", "cartId", "java.lang.Object", null), null, null));
        workItemNode3.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("Inv_Result", "inventoryAvailable", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("inventoryAvailable", "inventoryAvailable", "java.lang.Object", null), null, null));
        workItemNode3.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("Inv_Status", "orderStatus", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("orderStatus", "orderStatus", "java.lang.Object", null), null, null));
        workItemNode3.done();
        workItemNode3.metaData("UniqueId", "Task_ReserveInventory");
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode4 = factory.splitNode(4);
        splitNode4.name("Inventory OK?");
        splitNode4.type(2);
        splitNode4.metaData("UniqueId", "Gateway_InventoryOk");
        splitNode4.metaData("Default", null);
        splitNode4.constraint(5, "flow_inventory_ok_total", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String cartId = (java.lang.String) kcontext.getVariable("cartId");
            java.lang.String userId = (java.lang.String) kcontext.getVariable("userId");
            java.lang.String totalAmount = (java.lang.String) kcontext.getVariable("totalAmount");
            java.lang.Boolean inventoryAvailable = (java.lang.Boolean) kcontext.getVariable("inventoryAvailable");
            java.lang.Boolean paymentApproved = (java.lang.Boolean) kcontext.getVariable("paymentApproved");
            java.lang.String orderId = (java.lang.String) kcontext.getVariable("orderId");
            java.lang.String orderStatus = (java.lang.String) kcontext.getVariable("orderStatus");
            return inventoryAvailable == true;
        }, 0, false);
        splitNode4.constraint(11, "flow_inventory_not_ok_end", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String cartId = (java.lang.String) kcontext.getVariable("cartId");
            java.lang.String userId = (java.lang.String) kcontext.getVariable("userId");
            java.lang.String totalAmount = (java.lang.String) kcontext.getVariable("totalAmount");
            java.lang.Boolean inventoryAvailable = (java.lang.Boolean) kcontext.getVariable("inventoryAvailable");
            java.lang.Boolean paymentApproved = (java.lang.Boolean) kcontext.getVariable("paymentApproved");
            java.lang.String orderId = (java.lang.String) kcontext.getVariable("orderId");
            java.lang.String orderStatus = (java.lang.String) kcontext.getVariable("orderStatus");
            return inventoryAvailable == false;
        }, 0, false);
        splitNode4.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode5 = factory.workItemNode(5);
        workItemNode5.name("Calculate Total");
        workItemNode5.workName("calculateTotal");
        workItemNode5.workParameter("NodeName", "Calculate Total");
        workItemNode5.done();
        workItemNode5.metaData("UniqueId", "Task_CalculateTotal");
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode6 = factory.workItemNode(6);
        workItemNode6.name("Process Payment");
        workItemNode6.workName("processPayment");
        workItemNode6.workParameter("NodeName", "Process Payment");
        workItemNode6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("cartId", "cartId", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("Pay_CartId", "cartId", "java.lang.Object", null), null, null));
        workItemNode6.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("Pay_Approved", "paymentApproved", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("paymentApproved", "paymentApproved", "java.lang.Object", null), null, null));
        workItemNode6.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("Pay_Status", "orderStatus", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("orderStatus", "orderStatus", "java.lang.Object", null), null, null));
        workItemNode6.done();
        workItemNode6.metaData("UniqueId", "Task_ProcessPayment");
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode7 = factory.splitNode(7);
        splitNode7.name("Payment OK?");
        splitNode7.type(2);
        splitNode7.metaData("UniqueId", "Gateway_PaymentOk");
        splitNode7.metaData("Default", null);
        splitNode7.constraint(8, "flow_payment_ok_create_order", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String cartId = (java.lang.String) kcontext.getVariable("cartId");
            java.lang.String userId = (java.lang.String) kcontext.getVariable("userId");
            java.lang.String totalAmount = (java.lang.String) kcontext.getVariable("totalAmount");
            java.lang.Boolean inventoryAvailable = (java.lang.Boolean) kcontext.getVariable("inventoryAvailable");
            java.lang.Boolean paymentApproved = (java.lang.Boolean) kcontext.getVariable("paymentApproved");
            java.lang.String orderId = (java.lang.String) kcontext.getVariable("orderId");
            java.lang.String orderStatus = (java.lang.String) kcontext.getVariable("orderStatus");
            return paymentApproved == true;
        }, 0, false);
        splitNode7.constraint(12, "flow_payment_not_ok_end", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String cartId = (java.lang.String) kcontext.getVariable("cartId");
            java.lang.String userId = (java.lang.String) kcontext.getVariable("userId");
            java.lang.String totalAmount = (java.lang.String) kcontext.getVariable("totalAmount");
            java.lang.Boolean inventoryAvailable = (java.lang.Boolean) kcontext.getVariable("inventoryAvailable");
            java.lang.Boolean paymentApproved = (java.lang.Boolean) kcontext.getVariable("paymentApproved");
            java.lang.String orderId = (java.lang.String) kcontext.getVariable("orderId");
            java.lang.String orderStatus = (java.lang.String) kcontext.getVariable("orderStatus");
            return paymentApproved == false;
        }, 0, false);
        splitNode7.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode8 = factory.workItemNode(8);
        workItemNode8.name("Create Order");
        workItemNode8.workName("createOrder");
        workItemNode8.workParameter("NodeName", "Create Order");
        workItemNode8.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("Order_Status_Succ", "orderStatus", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("orderStatus", "orderStatus", "java.lang.Object", null), null, null));
        workItemNode8.done();
        workItemNode8.metaData("UniqueId", "Task_CreateOrder");
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode9 = factory.workItemNode(9);
        workItemNode9.name("Send Notification");
        workItemNode9.workName("sendNotification");
        workItemNode9.workParameter("NodeName", "Send Notification");
        workItemNode9.done();
        workItemNode9.metaData("UniqueId", "Task_SendNotification");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode10 = factory.endNode(10);
        endNode10.name("Success");
        endNode10.terminate(false);
        endNode10.metaData("UniqueId", "EndEvent_Success");
        endNode10.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode11 = factory.endNode(11);
        endNode11.name("Inventory Failed");
        endNode11.terminate(false);
        endNode11.metaData("UniqueId", "EndEvent_InventoryFailed");
        endNode11.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode12 = factory.endNode(12);
        endNode12.name("Payment Failed");
        endNode12.terminate(false);
        endNode12.metaData("UniqueId", "EndEvent_PaymentFailed");
        endNode12.done();
        factory.connection(1, 2, "flow_start_validate");
        factory.connection(2, 3, "flow_validate_inventory");
        factory.connection(3, 4, "flow_inventory_gateway");
        factory.connection(4, 5, "flow_inventory_ok_total");
        factory.connection(5, 6, "flow_total_payment");
        factory.connection(6, 7, "flow_payment_gateway");
        factory.connection(7, 8, "flow_payment_ok_create_order");
        factory.connection(8, 9, "flow_create_order_notify");
        factory.connection(9, 10, "flow_notify_end_success");
        factory.connection(4, 11, "flow_inventory_not_ok_end");
        factory.connection(7, 12, "flow_payment_not_ok_end");
        factory.validate();
        return factory.getProcess();
    }
}
