package cn.org.test.service.impl;

import cn.org.test.common.ApplicationStatus;
import cn.org.test.mapper.CreateApplicationMapper;
import cn.org.test.pojo.CreateApplication;
import cn.org.test.req.CreateCourseReq;
import cn.org.test.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lyy on 2020/10/27 下午3:46
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    public CreateApplicationMapper createApplicationMapper;

    @Override
    public void createCourseApply(CreateCourseReq createCourseReq) {
        Integer teacherId = createCourseReq.getTeacherId();
        String name = createCourseReq.getName();
        String reason = createCourseReq.getReason();

        CreateApplication apply = new CreateApplication();
        apply.setTeacherId(teacherId);
        apply.setName(name);
        apply.setReason(reason);
        apply.setStatus(ApplicationStatus.WAITING.getValue());
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        System.out.println(formatter.format(date));
        apply.setCreateDate(new Date());
        createApplicationMapper.addCreateApplication(apply);
    }
}
