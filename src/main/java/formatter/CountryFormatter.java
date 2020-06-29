package formatter;

import model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.ICountryService;

import java.text.ParseException;
import java.util.Locale;


@Component
public class CountryFormatter implements Formatter<Country> {

    private ICountryService iCountryService;

    @Autowired
    public CountryFormatter(ICountryService iCountryService) {
        this.iCountryService=iCountryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return iCountryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + ", " +object.getCountryName() + "]";
    }


}
