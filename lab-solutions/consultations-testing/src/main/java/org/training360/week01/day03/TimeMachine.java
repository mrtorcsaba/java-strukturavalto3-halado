package org.training360.week01.day03;

import java.time.LocalDateTime;

public class TimeMachine {

    private LocalDateTime timeMachineNow;

    public void setTimeMachineNow(LocalDateTime timeMachineNow) {
        this.timeMachineNow = timeMachineNow;
    }

    public LocalDateTime getTimeMachineNow() {
        if(timeMachineNow == null){
            return LocalDateTime.now();
        }
        return timeMachineNow;
    }
}
