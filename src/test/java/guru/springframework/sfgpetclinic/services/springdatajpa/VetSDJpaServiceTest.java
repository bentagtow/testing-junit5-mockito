package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {
    @Mock
    SpecialtyRepository mockSpecialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void deleteById(){
        service.deleteById(1l);
        verify(mockSpecialtyRepository).deleteById(1l);
    }
}