package service.manage;

import com.haiwaibang.BackApplication;
import com.haiwaibang.model.po.Banner;
import com.haiwaibang.model.service.manage.CommonDbManageService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by chenguifeng on 2018/12/5.
 */
@SpringBootTest(classes = BackApplication.class)
@RunWith(SpringRunner.class)
public class CommonDbManageServiceTest {

	@Autowired
	CommonDbManageService commonDbManageService;

	@Ignore
	@Test
	public void testCommonDb(){
		String objectName = "banner";
		Banner banner = new Banner();
		banner.setName("test");
		banner.setUrl("/");
		banner.setImageId(1);
		banner.setTitle("test");
		commonDbManageService.addObject(objectName, banner);
		Object object = commonDbManageService.getObjectById(objectName, banner.getId());
		Assert.assertNotNull(object);
		//Assert.assertSame(banner, object);
		commonDbManageService.updateObject(objectName, banner);
		commonDbManageService.deleteObject(objectName, banner.getId());
		object = commonDbManageService.getObjectById(objectName, banner.getId());
		Assert.assertNull(object);

	}
}
