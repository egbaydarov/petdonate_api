package hse.projectx.petdonate_api.transfer;

import hse.projectx.petdonate_api.model.DataState;
import lombok.Data;

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
