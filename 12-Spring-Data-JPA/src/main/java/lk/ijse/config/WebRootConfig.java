package lk.ijse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(JPAConfig.class)
@Configuration
public class WebRootConfig {
}
