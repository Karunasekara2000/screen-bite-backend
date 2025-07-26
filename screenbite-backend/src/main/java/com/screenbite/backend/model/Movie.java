package com.screenbite.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.screenbite.backend.model.enumeration.Day;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private int id;
    private String title;
    private Day day;
    private Time time;
    private String url;
    private String description;

}
