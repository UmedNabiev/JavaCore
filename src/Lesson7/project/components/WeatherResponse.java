package Lesson7.project.components;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.OffsetDateTime;

public class WeatherResponse {
    private OffsetDateTime localObservationDateTime;
    private WeatherTemperature temperature;

    @JsonGetter("LocalObservationDateTime")
    public OffsetDateTime getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    @JsonGetter("Temperature")
    public WeatherTemperature getTemperature() {
        return temperature;
    }

    @JsonSetter("LocalObservationDateTime")
    public void setLocalObservationDateTime(OffsetDateTime localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    @JsonSetter("Temperature")
    public void setTemperature(WeatherTemperature temperature) {
        this.temperature = temperature;
    }
}
