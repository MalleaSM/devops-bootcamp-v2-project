import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import repositories.StudentRepository;
import repositories.TeacherRepository;
import services.AccessValidator;
import services.ReadDataService;

public class AccessValidatorTest {

   private AccessValidator accessValidator;

   @Mock
   private StudentRepository studentRepository;

   @Mock
   private TeacherRepository teacherRepository;

   @Test
    public void ShouldFindStudentSuccessfully() throws Exception {
        String code = "ST-01-John";
        when(studentRepository.getStudentByCode(code)).thenReturn(true);

        var result = accessValidator.verifyStudentAccess(code);
       assertThat(result).isNotNull();
       assertTrue(result);
    }

    @Test
    public void ShouldNotFindStudentSuccessfully() throws Exception {
        String code = "S-01-John";
        when(studentRepository.getStudentByCode(code)).thenReturn(false);

        var result = accessValidator.verifyStudentAccess(code);
       assertThat(result).isNotNull();
       assertFalse(result);
    }

    @Test
    public void ShouldFindTeacherSuccessfully() throws Exception {
        String code = "TE-01-Andrea";
        when(teacherRepository.getTeacherByCode(code)).thenReturn(true);

        var result = accessValidator.verifyTeacherAccess(code);
       assertThat(result).isNotNull();
       assertTrue(result);
    }

    @Test
    public void ShouldNotFindTeacherSuccessfully() throws Exception {
        String code = "T-01-Andrea";
        when(teacherRepository.getTeacherByCode(code)).thenReturn(false);

        var result = accessValidator.verifyTeacherAccess(code);
       assertThat(result).isNotNull();
       assertFalse(result);
    }



    
}
