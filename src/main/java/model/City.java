package model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min=2,max=10)
    private String cityName;
    @NotEmpty
    @Min(0)
    private String cityArea;
    @NotEmpty
    @Min(0)
    private String cityPopulation;
    @NotEmpty
    @Min(0)
    private String cityGDP;
    @NotEmpty
    @Min(0)
    private String cityDescription;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    public City(){}

    public City(Long id, String cityName, String cityArea, String cityPopulation, String cityGDP, String cityDescription, Country country) {
        this.id = id;
        this.cityName = cityName;
        this.cityArea = cityArea;
        this.cityPopulation = cityPopulation;
        this.cityGDP = cityGDP;
        this.cityDescription = cityDescription;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityArea() {
        return cityArea;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public String getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(String cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public String getCityGDP() {
        return cityGDP;
    }

    public void setCityGDP(String cityGDP) {
        this.cityGDP = cityGDP;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }



//    @Override
//    public boolean supports(Class<?> clazz) {
//        return City.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        City city =(City)target;
//        String cityName= city.getCityName();
//        String cityPopulation = city.getCityPopulation();
//        String cityGDP = city.getCityGDP();
//        String cityArea = city.getCityArea();
//        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
//        if(cityName.length()>11||cityName.length()<1){
//            errors.rejectValue("number","city.length");
//        }
//
//        if(!cityPopulation.matches("(^$|[0-9]*$)\n")){
//            errors.rejectValue("number","number.matches");
//        }
//        if(!cityGDP.matches("(^$|[0-9]*$)\n")){
//            errors.rejectValue("number","number.matches");
//        }
//        if(!cityArea.matches("(^$|[0-9]*$)\n")){
//            errors.rejectValue("number","number.matches");
//        }
//    }
}
