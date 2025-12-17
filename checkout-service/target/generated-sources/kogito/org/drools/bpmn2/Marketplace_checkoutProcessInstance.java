package org.drools.bpmn2;

import org.drools.bpmn2.Marketplace_checkoutModel;

public class Marketplace_checkoutProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<Marketplace_checkoutModel> {

    public Marketplace_checkoutProcessInstance(org.drools.bpmn2.Marketplace_checkoutProcess process, Marketplace_checkoutModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public Marketplace_checkoutProcessInstance(org.drools.bpmn2.Marketplace_checkoutProcess process, Marketplace_checkoutModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public Marketplace_checkoutProcessInstance(org.drools.bpmn2.Marketplace_checkoutProcess process, Marketplace_checkoutModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public Marketplace_checkoutProcessInstance(org.drools.bpmn2.Marketplace_checkoutProcess process, Marketplace_checkoutModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public Marketplace_checkoutProcessInstance(org.drools.bpmn2.Marketplace_checkoutProcess process, Marketplace_checkoutModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(Marketplace_checkoutModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(Marketplace_checkoutModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
