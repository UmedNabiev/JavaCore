package Lesson7.project;

import Lesson7.project.enums.Periods;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods period) throws IOException;

}
