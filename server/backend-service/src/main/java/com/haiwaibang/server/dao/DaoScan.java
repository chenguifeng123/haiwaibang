package com.haiwaibang.server.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan(basePackages = "com.haiwaibang.server.dao")
public class DaoScan {
}
