package com.sample.camel.props;

import java.util.Properties;

import org.apache.camel.spring.spi.BridgePropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class TestBridgePropertyPlaceholderConfigurer extends BridgePropertyPlaceholderConfigurer {
    private static final String NODE_NAME_PLACEHOLDER = "de.cluster.instance.name";
    private static final String NODE_NAME_VALUE = "node_" + System.currentTimeMillis();

    @Override
    public void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) {
        if (!props.containsKey(NODE_NAME_PLACEHOLDER)) {
            props.put(NODE_NAME_PLACEHOLDER, NODE_NAME_VALUE);
        }
        super.processProperties(beanFactoryToProcess, props);
        props.put("test.input.number", "4000");
        System.out.println("Property test.input.number is ::"+super.resolvePlaceholder("test.input.number",props));
    }

    @Override
    public String resolvePlaceholder(String placeholder, Properties props) {
        String propVal = super.resolvePlaceholder(placeholder, props);
        if ((propVal == null || "".equals(propVal.trim())) && NODE_NAME_PLACEHOLDER.equals(placeholder)) {
            propVal = NODE_NAME_VALUE;
        }
        return "40000";
    }
}