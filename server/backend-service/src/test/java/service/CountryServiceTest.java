package service;

import com.haiwaibang.BackApplication;
import com.haiwaibang.model.service.CountryService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by chenguifeng on 2018/12/18.
 */
@SpringBootTest(classes = BackApplication.class)
@RunWith(SpringRunner.class)
public class CountryServiceTest {

	@Autowired
	CountryService countryService;

	@Ignore
	@Test
	public void testCountryService(){

	}
}
