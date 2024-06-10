package br.edu.infnet.dr1_tp3.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "customMetrics")
public class CustomMetricsEndpoint {

    @ReadOperation
    public Map<String, Object> customMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("customMetric1", "value1");
        metrics.put("customMetric2", "value2");
        return metrics;
    }
}
