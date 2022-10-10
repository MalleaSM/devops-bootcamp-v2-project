import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import services.ReadDataService;

public class ReadDataServiceTest {
    
    private ReadDataService readDataService;

    @Test
    public void ShouldReadStudentFileSuccessfully() throws Exception {
       var result = readDataService.getStudentJsonData();
       assertThat(result).isNotNull();
    }

    @Test
    public void ShouldReadTeacherFileSuccessfully() throws Exception {
       var result = readDataService.getTeachersJsonData();
       assertThat(result).isNotNull();
    }


}
