package Lesson8;

import Lesson7.project.enums.Functionality;
import Lesson7.project.enums.Periods;
import Lesson8.entity.WeatherData;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();
    DatabaseRepositorySQLiteImpl dbRepo = new DatabaseRepositorySQLiteImpl();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_WEATHER_FROM_DB);
        dbRepo.createTableIfNotExists();
    }

    public void onUserInput(String input) throws IOException, SQLException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_WEATHER_FROM_DB:
                getWeatherFromDB();
                break;
        }
    }

    public void getCurrentWeather() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.NOW, dbRepo);
    }

    public void getWeatherIn5Days() throws IOException, SQLException {
        weatherProvider.getWeather(Periods.FIVE_DAYS, dbRepo);
    }

    public void getWeatherFromDB() throws SQLException, IOException {
        List<WeatherData> result = dbRepo.getAllSavedData();
        for (WeatherData _result : result) {
            System.out.printf("city=%s | localDate=%s | text=%s | temperature=%s\n",
                    _result.getCity(),
                    _result.getLocalDate(),
                    _result.getText(),
                    _result.getTemperature()
            );
        }
    }
}
