package com.azubike.ellipsis.usermcs.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
  @Value("classpath:h2/init.sql")
  private Resource initSql;

  private final R2dbcEntityTemplate entityTemplate;

  @Override
  public void run(String... args) throws Exception {
    final String sql = StreamUtils.copyToString(initSql.getInputStream(), StandardCharsets.UTF_8);
    log.info("Executing query ,{}" ,sql);
    entityTemplate.getDatabaseClient().sql(sql).then().subscribe();
  }
}
