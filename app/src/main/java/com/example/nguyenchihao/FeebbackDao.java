package com.example.nguyenchihao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.nguyenchihao.model.FeedbackEntity;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface FeebbackDao {
    @Insert(onConflict = REPLACE)
    void insertCustomer(FeedbackEntity customer);
}
