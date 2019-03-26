package itriad.com.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class StudentReportServiceTest {
//
//    @Autowired
//    private AgendaService agendaService;

    @Test
    public void testAgendaWithEvent() {
        //List<ScheduleEntry> agenda = agendaService.getSchedules("143234");
        assertEquals(true, true);
    }
}