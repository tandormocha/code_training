package com.kouyy.training.dowith.pojo;

import lombok.*;


//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Data
public class Consumer implements Comparable{
    private String name;
    private String password;
    private String address;


    @Override
    public int compareTo(Object o) {
        if(this ==o){
            return 0;
        }
        else if (o!=null && o instanceof Consumer) {
            Consumer u = (Consumer) o;
            if(password.length()<=u.password.length()){
                return -1;
            }else{
                return 1;
            }
        }else{
            return -1;
        }
    }
}
