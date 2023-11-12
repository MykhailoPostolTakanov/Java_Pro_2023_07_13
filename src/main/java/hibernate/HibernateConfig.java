package hibernate;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.yml")
public class HibernateConfig {
    @Value("${db.serverName}")
    private String serverName;
    @Value("${db.dataBaseName}")
    private String dataBaseName;
    @Value("${db.login}")
    private String login;
    @Value("${db.password}")
    private String password;

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("hibernate");
        return sessionFactory;
    }

    @Bean
    public DataSource createDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(new String[]{serverName});
        dataSource.setDatabaseName(dataBaseName);
        dataSource.setUser(login);
        dataSource.setPassword(password);
        return dataSource;
    }
}
