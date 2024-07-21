package com.gdg_market.app.product.model;

import com.gdg_market.app.bible.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "hate__descript")
public class HateDescript extends BaseModel {

    @Column(name = "item", unique = true, length = 256)
    private String item;
    @Column(name = "similer", length = 256)
    private List<String> similer;


}
