package com.example.postgresdemo.transfer;

import com.example.postgresdemo.model.DataState;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDataRequest {
    DataState state;

    UserDataRequest(DataState state)
    {
        this.state = state;
    }
    UserDataRequest()
    {

    }
}
