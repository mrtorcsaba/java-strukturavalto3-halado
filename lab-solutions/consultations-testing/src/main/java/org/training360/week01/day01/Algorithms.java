package org.training360.week01.day01;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithms {


    public int findNotSingleNumber(List<Integer> numbers){
        for(int i = 0;i<numbers.size();i++){
            for(int j=i+1;j<numbers.size();j++){
                if(numbers.get(i)==numbers.get(j)){
                    return numbers.get(i);
                }
            }
        }
        throw new IllegalArgumentException("Input is not valid!");
    }

    public int findNotSingleNumberWithMap(List<Integer> numbers){
        Map<Integer, Integer> result = collectNumberToMap(numbers);

        for(Map.Entry<Integer,Integer> actual : result.entrySet()){
            if(actual.getValue()>1){
                return actual.getKey();
            }
        }
        throw new IllegalArgumentException("Input is not valid!");
    }

    public int findNotSingleNumberWithSort(List<Integer> numbers){
        Collections.sort(numbers);
        for(int i=0; i<numbers.size()-1;i++){
            if(numbers.get(i)==numbers.get(i+1)){
                return numbers.get(i);
            }
        }
        throw new IllegalArgumentException("Input is not valid!");
    }

    private  Map<Integer, Integer> collectNumberToMap(List<Integer> numbers) {
        Map<Integer,Integer> result = new HashMap<>();

        for(Integer i : numbers){
            if(!result.containsKey(i)){
                result.put(i,0);
            }
            result.put(i,result.get(i)+1);
        }
        return result;
    }


}
