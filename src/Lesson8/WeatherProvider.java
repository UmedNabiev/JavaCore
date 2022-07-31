package Lesson8;

import Lesson7.project.enums.Periods;
import java.sql.SQLException;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods, DatabaseRepository dbRepo) throws IOException, SQLException;
    void getWeather(Periods periods) throws IOException;

}
