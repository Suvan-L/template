package com.template.service.dao.impl;

import com.template.pojo.entity.StudentDO;
import com.template.dao.StudentMapper;
import com.template.service.dao.StudentDAOService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author amdin
 * @since 2022-04-04
 */
@Service
public class StudentDAOServiceImpl extends ServiceImpl<StudentMapper, StudentDO> implements StudentDAOService {

}
