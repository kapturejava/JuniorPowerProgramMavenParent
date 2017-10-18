package be.kapture.testutil;

import be.kapture.repository.VraagRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by peeters.t on 18/10/2017.
 */
@Profile("test")
@Configuration
public class VraagRepositoryMock {

    @Bean
    @Primary
    public VraagRepository vraagRepository(){
        return Mockito.mock(VraagRepository.class);
    }

}
