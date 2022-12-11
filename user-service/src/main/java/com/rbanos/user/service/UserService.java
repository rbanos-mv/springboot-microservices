package com.rbanos.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rbanos.user.VO.Department;
import com.rbanos.user.VO.ResponseTemplateVO;
import com.rbanos.user.entity.User;
import com.rbanos.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  public User saveUser(User user) {
    log.info("Inside UserService.saveUser");
    return userRepository.save(user);
  }

  public ResponseTemplateVO getUserWithDepartment(Long userId) {
    log.info("Inside UserService.getUserWithDepartment");
    ResponseTemplateVO vo = new ResponseTemplateVO();
    User user = userRepository.findByUserId(userId);

    Department department = restTemplate.getForObject("http://127.0.0.1:9001/departments/" + user.getDepartmentId(),
        Department.class);

    vo.setUser(user);
    vo.setDepartment(department);

    return vo;
  }
}
