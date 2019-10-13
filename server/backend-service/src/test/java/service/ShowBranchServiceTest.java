package service;

import com.haiwaibang.BackApplication;
import com.haiwaibang.model.dto.ShowType;
import com.haiwaibang.model.po.multi.ComplexBanner;
import com.haiwaibang.model.service.ShowBranchService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by chenguifeng on 2018/12/18.
 */
@SpringBootTest(classes = BackApplication.class)
@RunWith(SpringRunner.class)
public class ShowBranchServiceTest {

	@Autowired
	ShowBranchService showBranchService;

	@Ignore
	@Test
	public void testShow(){
		List<ComplexBanner> list = showBranchService.listBanner(ShowType.COMPUTER);
		System.out.print(list);
	}
}
