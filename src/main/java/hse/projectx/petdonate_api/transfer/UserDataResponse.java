package hse.projectx.petdonate_api.transfer;

import hse.projectx.petdonate_api.model.DataState;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserDataResponse {
    DataState state;

    public UserDataResponse(DataState state, LocalDateTime sentTime) {
        this.state = state;
    }
}
