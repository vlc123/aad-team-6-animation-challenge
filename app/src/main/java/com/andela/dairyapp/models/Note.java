package com.andela.dairyapp.models;

public class Note {
    private int _id;
    private int color_code;
    private String note_name;
    private String note_description;
    private String created_at;

    public Note() {
    }

    public Note(int _id) {
        this._id = _id;
    }

    public Note(int _id, int color_code, String note_name, String note_description, String created_at) {
        this._id = _id;
        this.color_code = color_code;
        this.note_name = note_name;
        this.note_description = note_description;
        this.created_at = created_at;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getColor_code() {
        return color_code;
    }

    public void setColor_code(int color_code) {
        this.color_code = color_code;
    }

    public String getNote_name() {
        return note_name;
    }

    public void setNote_name(String note_name) {
        this.note_name = note_name;
    }

    public String getNote_description() {
        return note_description;
    }

    public void setNote_description(String note_description) {
        this.note_description = note_description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
