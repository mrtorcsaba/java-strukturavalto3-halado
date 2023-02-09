package org.training360.week01.day03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.shouldHaveThrown;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VoteServiceTest {


    @Mock
    VoteRepository voteRepository;



    @Test
    void testCloseVoteTooEarly(){
        TimeMachine timeMachine = new TimeMachine();
        timeMachine.setTimeMachineNow(LocalDateTime.parse("2023-02-09T12:00:00"));
        VoteService voteService = new VoteService(voteRepository,timeMachine);



        LocalDateTime now = LocalDateTime.parse("2023-02-08T12:00:00");


        when(voteRepository.findVoteById(anyLong()))
                .thenReturn(new Vote(2L, now));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->voteService.closeVote(2L));


    }

    @Test
    void testCloseVote(){
        VoteService voteService = new VoteService(voteRepository,new TimeMachine());

        LocalDateTime now = LocalDateTime.parse("2023-02-02T12:00:00");

        when(voteRepository.findVoteById(anyLong()))
                .thenReturn(new Vote(1L, now));

        voteService.closeVote(34L);

    }





}