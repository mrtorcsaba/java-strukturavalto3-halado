package org.training360.week01.day03;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class VoteService {


    private VoteRepository repository;
    private TimeMachine timeMachine;

    public VoteService(VoteRepository repository, TimeMachine timeMachine) {
        this.repository = repository;
        this.timeMachine = timeMachine;
    }


    public void closeVote(long id){
        Optional<Vote> vote = repository.findVoteById(id);

        LocalDateTime now = timeMachine.getTimeMachineNow();

        if(vote.isPresent()){
         if(Duration.between(vote.get().getStartDate(), now).toDays()<2){

            throw new IllegalArgumentException(String.format("Vote with id %d cannot be closed",vote.get().getId()));
            }

        vote.get().setEndDate(now);
        }
    }


    public VoteRepository getRepository() {
        return repository;
    }


}
