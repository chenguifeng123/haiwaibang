package service;

import com.haiwaibang.BackApplication;
import com.haiwaibang.model.po.multi.CountryProjectTree;
import com.haiwaibang.server.dao.ProjectSourceManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/25.
 */
@SpringBootTest(classes = BackApplication.class)
@RunWith(SpringRunner.class)
public class CountryProjectTreeTest {

	@Autowired
	ProjectSourceManageMapper countryProjectCombineMapper;

	//@Ignore
	@Test
	public void testTree(){
		List<CountryProjectTree> list = countryProjectCombineMapper.getCountryProjectTree();
		System.out.print(1);
	}
}
