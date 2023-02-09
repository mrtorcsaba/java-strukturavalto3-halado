package org.training360.week01.day03;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VoteService {


    private VoteRepository repository;
    private TimeMachine timeMachine;

    public VoteService(VoteRepository repository, TimeMachine timeMachine) {
        this.repository = repository;
        this.timeMachine = timeMachine;
    }

    public void closeVote(long id){
        Vote vote = repository.findVoteById(id);
        LocalDateTime now = timeMachine.getTimeMachineNow();

        if(Duration.between(vote.getStartDate(), now).toDays()<2){

            throw new IllegalArgumentException(String.format("Vote with id %d cannot be closed",vote.getId()));
        }

        vote.setEndDate(now);
    }


    public VoteRepository getRepository() {
        return repository;
    }


}
