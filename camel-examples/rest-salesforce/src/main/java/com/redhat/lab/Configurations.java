package com.redhat.lab;

import org.apache.camel.component.salesforce.AuthenticationType;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;


@ApplicationScoped
public class Configurations {

    @ConfigProperty(name = "sf.client.id")
    String clientId;

    @ConfigProperty(name = "sf.client.secret")
    String clientSecret;

    @ConfigProperty(name = "sf.instance")
    String instance;

    @Named
    SalesforceComponent salesforce(){

        SalesforceComponent component = new SalesforceComponent();
        component.setClientId(clientId);
        component.setClientSecret(clientSecret);
        component.setAuthenticationType(AuthenticationType.CLIENT_CREDENTIALS);
        component.setInstanceUrl(instance);
        component.setLoginUrl(instance);

        return component;
    }

}
