# Marketplace Checkout Service (Kogito)

This project implements a marketplace checkout service using **Kogito** (based on Quarkus). The business process is defined using the **BPMN 2.0** standard and executed by the Kogito engine.

## 📋 BPMN Process Description

Process definition file: `src/main/resources/marketplace-checkout.bpmn2`
Process ID: `marketplace_checkout`

The checkout process flow is designed as follows:

1.  **Start Checkout**: The process initiates by receiving cart data (`cartId`) and user information (`userId`).
2.  **Validate Cart**: Validates whether the shopping cart is valid.
3.  **Reserve Inventory**: Checks and reserves stock for the items.
    *   *Inventory Gateway*: If stock is **unavailable**, the process ends with `INVENTORY_FAILED` status.
    *   If stock is **available**, the process continues.
4.  **Calculate Total**: Calculates the total purchase amount.
5.  **Process Payment**: Processes the payment transaction.
    *   *Payment Gateway*: If payment **fails**, the process ends with `PAYMENT_FAILED` status.
    *   If payment is **successful**, the process proceeds.
6.  **Create Order**: Creates an official order record in the system.
7.  **Send Notification**: Sends a success notification to the user.
8.  **Success**: The process concludes successfully (Status `SUCCESS`).

---

## 🛠️ Service Handlers

Each *Service Task* in the BPMN is mapped to Java code via Kogito's `WorkItemHandler` mechanism. Below are the handlers used:

| BPMN Task Name | Handler Class | Description |
| :--- | :--- | :--- |
| **Validate Cart** | `ValidateCartHandler` | Ensures `cartId` is valid and not empty. |
| **Reserve Inventory** | `ReserveInventoryHandler` | Checks stock availability. Returns `inventoryAvailable=false` for specific carts (simulation). |
| **Calculate Total** | `CalculateTotalHandler` | Calculates the shopping total (dummy logic). |
| **Process Payment** | `ProcessPaymentHandler` | Processes payment. Returns `paymentApproved=false` for payment failure scenarios. |
| **Create Order** | `CreateOrderHandler` | Creates the order record and sets the status to `SUCCESS`. |
| **Send Notification** | `SendNotificationHandler` | Sends a notification (logs to console). |

> **Technical Note**: Integration is achieved using the `drools:taskName` attribute in the BPMN file, which matches the handler name registered in `CheckoutWorkItemHandlerConfig`.

---

## 🧪 BPMN Illustration in Test Code

The BPMN flow is verified through unit tests in `src/test/java/com/example/checkout/CheckoutProcessTest.java`. These tests simulate various business scenarios:

### 1. Success Scenario (`testSuccessfulCheckout`)
*   **Input**: `cartId="CART-001"`
*   **Flow**: Pass Inventory → Pass Payment → Create Order.
*   **Expectation**: Process finishes (`STATE_COMPLETED`) and `orderStatus` is `SUCCESS`.

### 2. Payment Failed Scenario (`testPaymentFailed`)
*   **Input**: `cartId="CART-002"`
*   **Flow**: Pass Inventory → **Payment Fails** (Gateway redirects to Payment Failed End Event).
*   **Expectation**: Process finishes and `orderStatus` is `PAYMENT_FAILED`.

### 3. Out of Stock Scenario (`testInventoryFailed`)
*   **Input**: `cartId="CART-003"`
*   **Flow**: **Inventory Fails** (Gateway redirects to Inventory Failed End Event).
*   **Expectation**: Process finishes and `orderStatus` is `INVENTORY_FAILED`.

---

## 🚀 How to Run

### Prerequisites
*   Java 11+
*   Maven 3.8.1+

### Running Unit Tests
To verify that the BPMN flow runs as designed:
```bash
mvn clean test
```

### Running in Dev Mode (Optional, since there is no requirement to running it like a service)
To run the application locally (with hot-reload):
```bash
mvn quarkus:dev
```
The application will be running at `http://localhost:8080`.
