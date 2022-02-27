
package com.magicpythons.owm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coord",
        "weather",
        "base",
        "main",
        "visibility",
        "wind",
        "clouds",
        "dt",
        "sys",
        "timezone",
        "id",
        "name",
        "cod"
})

public class DataTransferObject {

    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("weather")
    private List<Weather> weather = null;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("timezone")
    private Integer timezone;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("coord")
    public Coord getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @JsonProperty("weather")
    public List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @JsonProperty("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @JsonProperty("sys")
    public Sys getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonProperty("timezone")
    public Integer getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("cod")
    public Integer getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\ncoord = ");
        sb.append(" lon: " + coord.getLon() + " | lat: " + coord.getLat());
        sb.append("\nweather = ");
        sb.append(" id: " + weather.get(0).getId() + " | main: " + weather.get(0).getMain() +
                " | description: " + weather.get(0).getDescription() + " | icon: " + weather.get(0).getIcon());
        sb.append("\nbase = ");
        sb.append(base);
        sb.append("\nmain = ");
        sb.append("temp: " + main.getTemp() + " | feels_like: " + main.getFeelsLike() + " | temp_min: " + main.getTempMin() +
                " | temp_max: " + main.getTempMax() + " | pressure: " + main.getPressure() + " | humidity: " + main.getHumidity());
        sb.append("\nvisibility = ");
        sb.append(visibility);
        sb.append("\nwind = ");
        sb.append("speed: " + wind.getSpeed() + " | deg: " + wind.getDeg());
        sb.append("\nclouds = ");
        sb.append("all: " + clouds.getAll());
        sb.append("\ndt = ");
        sb.append(dt);
        sb.append("\nsys = ");
        sb.append("type: " + sys.getType() + " | id: " + sys.getId() + " | message: " + sys.getMessage() +
                " | country: " + sys.getCountry() + " | sunrise: " + sys.getSunrise() + " | sunset: " + sys.getSunset());
        sb.append("\ntimezone = ");
        sb.append(timezone);
        sb.append("\nid = ");
        sb.append(id);
        sb.append("\nname = ");
        sb.append(name);
        sb.append("\ncod = ");
        sb.append(cod);
        sb.append("\nadditionalProperties = ");
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        return sb.toString();
    }
}
