package ru.hh.school.entity;

import javax.persistence.*;


@Entity
@Table(name = "resume")
public class Resume {

    // таким образом, мы сможем отправлять в бд запросы батчами.
    // нужно учитывать, что описание sequence при создании таблицы также должно соответствовать
    // хиберовской сущности (см. create_resume.sql)
    //
    // Подробнее:
    // https://vladmihalcea.com/how-to-batch-insert-and-update-statements-with-hibernate/
    // https://vladmihalcea.com/from-jpa-to-hibernates-legacy-and-enhanced-identifier-generators/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resume_id_seq")
    @SequenceGenerator(name = "resume_gen", sequenceName = "resume_id_seq", allocationSize = 10)
    @Column(name = "id")
    private Integer id;


    private String description;

    Resume() {
    }

    public Resume(String description) {
        this.description = description;
    }

}
