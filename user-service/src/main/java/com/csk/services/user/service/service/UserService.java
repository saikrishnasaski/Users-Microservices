package com.csk.services.user.service.service;

import com.csk.services.user.service.VO.Department;
import com.csk.services.user.service.VO.ResponseTemplateVO;
import com.csk.services.user.service.entity.User;
import com.csk.services.user.service.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService.......");
        return userRepository.save(user);
    }

    @CircuitBreaker(name = "department-service", fallbackMethod = "fallBackGetDepartment")
    public ResponseTemplateVO getUser(Long userId, Long time) {
        log.info("Inside getUser of UserService.......");
        User user = userRepository.findByUserId(userId);
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("time", time);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId() + "?time={time}", Department.class, uriVariables);

        return new ResponseTemplateVO(user, department, null);
    }

    public ResponseTemplateVO fallBackGetDepartment(Long userId, Long time, Exception e) {
        return new ResponseTemplateVO(null, null, "Department Service is down.");
    }
}
