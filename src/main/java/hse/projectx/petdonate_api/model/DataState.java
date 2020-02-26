package hse.projectx.petdonate_api.model;


import lombok.Data;

@Data
public class DataState {
    private String name = "Name", ID;
    private int cur_HP = 30, cur_Mana = 30, cur_Stamina = 30;
    private String type;
    private int skin;

    public DataState(String name, String ID, int cur_HP, int cur_Mana, int cur_Stamina, String type, int skin) {
        this.name = name;
        this.ID = ID;
        this.cur_HP = cur_HP;
        this.cur_Mana = cur_Mana;
        this.cur_Stamina = cur_Stamina;
        this.type = type;
        this.skin = skin;
    }

    public DataState() {
    }
}

