package com.example.labs.calculations;
import java.util.List;
import java.util.stream.Stream;

public class StreamLogic {
    interface ResultCounter{
        int Result(int n);
    }
    public int calculateSum(String[] arr){
        ResultCounter res = (n)->{
            if(Integer.parseInt(arr[2])==0){
                n = Integer.parseInt(arr[0])*Integer.parseInt(arr[1]);
            }
            else if(Integer.parseInt(arr[2])==1){
                n = Integer.parseInt(arr[0])*Integer.parseInt(arr[1]);
            }
            return n;
        };
        return res.Result(0);
    }
}
