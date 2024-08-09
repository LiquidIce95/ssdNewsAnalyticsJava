package ssd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        // Test that the DataSource is not null
        assertThat(dataSource).isNotNull();

        // Test that a connection can be established
        try (Connection connection = dataSource.getConnection()) {
            assertThat(connection).isNotNull();
            assertThat(connection.isValid(2)).isTrue();
        } catch (SQLException e) {
            throw new AssertionError("Failed to establish a connection to the database.", e);
        }
    }

    @Test
    public void testJdbcTemplate() {
        // Test that JdbcTemplate can execute a simple query
        assertDoesNotThrow(() -> {
            jdbcTemplate.execute("SELECT 1");
        }, "JdbcTemplate failed to execute a simple query.");
    }
}
