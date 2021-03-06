package org.doomer.qnotez.db;

import java.util.Date;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

@Entity(tableName = NoteModel.TABLE_NAME)
public class NoteModel {
    public static final String TABLE_NAME = "notes";
    public static final String COL_TRASH = "in_trash";

    @PrimaryKey(autoGenerate = true)
    public int id;

    private String title;
    private String text;

    @TypeConverters(DateConverter.class)
    private Date created;
    @TypeConverters(DateConverter.class)
    private Date updated;

    @ColumnInfo(name = NoteModel.COL_TRASH)
    private boolean inTrash;

    public NoteModel(String title, String text, Date created) {
        this.title = title;
        this.text = text;
        this.created = created;
        this.updated = this.created;
        this.inTrash = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public boolean isInTrash() {
        return inTrash;
    }

    public void setInTrash(boolean inTrash) {
        this.inTrash = inTrash;
    }
}
