package Lesson7.project.components;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherTemperature {
    private TemperatureEntry metric;
    private TemperatureEntry imperial;

    @JsonGetter("Metric")
    public TemperatureEntry getMetric() {
        return metric;
    }

    @JsonGetter("Imperial")
    public TemperatureEntry getImperial() {
        return imperial;
    }

    @JsonSetter("Metric")
    public void setMetric(TemperatureEntry metric) {
        this.metric = metric;
    }

    @JsonSetter("Imperial")
    public void setImperial(TemperatureEntry imperial) {
        this.imperial = imperial;
    }
}
