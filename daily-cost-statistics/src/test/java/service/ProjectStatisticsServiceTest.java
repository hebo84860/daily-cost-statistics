package service;

import com.yeapoo.statistics.service.impl.ProjectStatisticsServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 *
 * Created by yea on 2016/3/24.
 */
public class ProjectStatisticsServiceTest  extends BaseTest{

    @Autowired
    private ProjectStatisticsServiceImpl projectStatisticsService;

    @Test
    public void testGetFirstOnlineTime(){
        System.out.println("================= getFirstOnlineTime begin");
        System.out.println(projectStatisticsService.getFirstOnlineTime());
        System.out.println("================= getFirstOnlineTime end");
    }
    @Test
    public void testCountProjcetMouthly(){
        System.out.println("================= testCountProjcetMouthly begin");
        System.out.println(projectStatisticsService.countSaledProject(null));
        System.out.println("================= testCountProjcetMouthly end");
    }
    @Test
    public void tesCountSaleProjectAmount(){
        System.out.println("================= countSaleProjectAmount begin");
        System.out.println(projectStatisticsService.countSaleProjectAmount(null));
        System.out.println("================= countSaleProjectAmount end");
    }
    @Test
    public void testGetProjectSaledTimeDiff(){
        System.out.println("================= getProjectSaledTimeDiff begin");
        System.out.println(projectStatisticsService.getProjectSaledTimeDiff());
        System.out.println("================= getProjectSaledTimeDiff end");
    }
    @Test
    public void testCountProjectMember(){
        System.out.println("================= countProjectMember begin");
        System.out.println(projectStatisticsService.countProjectMember(null));
        System.out.println("================= countProjectMember end");
    }
    @Test
    public void testCountBuyeredProjectMember(){
        System.out.println("================= countBuyeredProjectMember begin");
        System.out.println(projectStatisticsService.countBuyeredProjectMember(null));
        System.out.println("================= countBuyeredProjectMember end");
    }
    @Test
    public void testCountPlatformScale(){
        System.out.println("================= testCountPlatformScale begin");
        System.out.println(projectStatisticsService.countPlatformScale(null));
        System.out.println("================= testCountPlatformScale end");
    }
    @Test
    public void testAreaCount(){
        System.out.println("================= testAreaCount begin");
        System.out.println(projectStatisticsService.countSalesMap(new HashMap<String, Object>()));
        System.out.println("================= testAreaCount end");
    }
}
