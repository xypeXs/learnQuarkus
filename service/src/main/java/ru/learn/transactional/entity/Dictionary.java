package ru.learn.transactional.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DICTIONARY")
public class Dictionary extends PanacheEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "SYS_NAME")
    private String sysName;

    @Column(name = "VALUE")
    private String value;
}
