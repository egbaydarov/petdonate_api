package com.example.postgresdemo.transfer;

import com.example.postgresdemo.model.DataState;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserDataResponse {
    DataState state;

    public UserDataResponse(DataState state, LocalDateTime sentTime) {
        this.state = state;
    }
}
