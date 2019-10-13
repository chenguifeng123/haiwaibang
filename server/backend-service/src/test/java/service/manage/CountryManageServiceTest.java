package service.manage;

import com.haiwaibang.BackApplication;
import com.haiwaibang.model.po.Country;
import com.haiwaibang.model.service.manage.CountryManageService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by chenguifeng on 2018/11/27.
 */
@SpringBootTest(classes = BackApplication.class)
@RunWith(SpringRunner.class)
public class CountryManageServiceTest {

	@Autowired
	CountryManageService countryManageService;

	Country newCountry(){
		Country country = new Country();
		country.setName("test");
		country.setNameZh("新国家");
		country.setContinentId(1);
		country.setContinentName("美洲");
		return country;
	}

	@Test
	@Ignore
	public void testCountry(){
		Country country = newCountry();
		countryManageService.addCountry(country);
		countryManageService.updateCountry(country);
		countryManageService.deleteCountry(country.getId());
		Assert.assertFalse(countryManageService.isCountryExists(country.getId()));

	}
}
