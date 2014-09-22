package com.payu.workshops;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractJpaTest {

    @Autowired
    protected DataSource dataSource;

    @Before
    public void initDB() throws Exception {
        ResourceDatabasePopulator dbPopulate = new ResourceDatabasePopulator();
        dbPopulate.addScript(new ClassPathResource("data.sql"));
        Connection conn = null;
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            dbPopulate.populate(conn);
        } finally {
            if (conn != null) {
                DataSourceUtils.releaseConnection(conn, dataSource);
            }
        }
    }
}
