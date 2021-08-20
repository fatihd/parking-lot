package com.tarnet.deneme.service;

import com.tarnet.deneme.domain.Spot;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
@ActiveProfiles("development")
public class ReservationApplicationServiceTest {

    @SneakyThrows
    @Transactional
    @Commit
    @Test
    public void test() {
        long userId = -1L;
        long spotId = -2L;
        LocalDateTime start = LocalDateTime.now().plusDays(1);
        LocalDateTime end = start.plusHours(2);

        List<Spot> beforeList = service.getEmptySpots(start, end);

        service.makeReservation(userId, spotId, start, end);

        List<Spot> afterList = service.getEmptySpots(start, end);

        System.out.println();
    }

    @Autowired
    ReservationApplicationService service;
}
