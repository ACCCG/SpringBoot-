package com.amumu.springbootgradle_helloworld.repository.es;

import com.amumu.springbootgradle_helloworld.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * EsBlog Repository 接口 测试测试测试测试测试测试测试测试测试测试
 *
 * @Author: amumu
 * @Date: 2019/4/21 0021 上午 12:14
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    //引进资源库
    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        //首先清除所有数据
        esBlogRepository.deleteAll();

        //搞了三首唐诗
        esBlogRepository.save(new EsBlog("行宫", "元稹", "寥落古行宫，宫花寂寞红。\n" +
                "白头宫女在，闲坐说玄宗。"));
        esBlogRepository.save(new EsBlog("登鹳雀楼", "王之涣", "白日依山尽，黄河入海流。\n" +
                "欲穷千里目，更上一层楼。"));
        esBlogRepository.save(new EsBlog("新嫁娘词", "王建", "三日入厨下，洗手作羹汤。\n" +
                "未谙姑食性，先遣小姑尝。"));
    }

    @Test
    public void TestFindDistinctByTitleContainingOrSummaryContainingOrContentContaining() {

        //分页
        //page – zero-based page index.
        //size – the size of the page to be returned.
        Pageable pageable = new PageRequest(0, 20);

        String title = "楼";
        String summary = "王";
        String content = "日";
        //查询
        Page<EsBlog> page = esBlogRepository.findDistinctByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        //设置断言
        assertThat(page.getTotalElements()).isEqualTo(2);

        System.out.println("--------------start 1");
        for (EsBlog b : page.getContent()) {
            System.out.println(b.toString());
        }
        System.out.println("--------------end 1");
    }
}
