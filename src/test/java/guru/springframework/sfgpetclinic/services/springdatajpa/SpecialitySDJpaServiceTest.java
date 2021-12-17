package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {
    @Mock
    SpecialtyRepository specialityRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void testDeleteByObject(){
        Speciality speciality = new Speciality();
        service.delete(speciality);

        verify(specialityRepository).delete(any(Speciality.class));
    }

    @Test
    void findByIdTest(){
        Speciality speciality = new Speciality();

        when(specialityRepository.findById(1l)).thenReturn(Optional.of(speciality));

        Speciality foundSpeciality = service.findById(1l);

        assertThat(foundSpeciality).isNotNull();

        verify(specialityRepository).findById(1l);

    }
    @Test
    void findByIdBDDTest(){
        //given
        Speciality speciality = new Speciality();
        given(specialityRepository
                .findById(1l))
                .willReturn(Optional.of(speciality));

        //when
        Speciality foundSpeciality = service.findById(1l);

        //then
        assertThat(foundSpeciality).isNotNull();
        then(specialityRepository).should().findById(anyLong());
        then(specialityRepository).shouldHaveNoMoreInteractions();
    }

}