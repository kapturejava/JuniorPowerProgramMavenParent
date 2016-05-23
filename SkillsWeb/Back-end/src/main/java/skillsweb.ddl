
    create table PERSONS (
        id integer not null auto_increment,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        primary key (id)
    );

    create table SKILLGROUPS (
        id integer not null auto_increment,
        name varchar(255) not null,
        skillnature_id integer not null,
        primary key (id)
    );

    create table SKILLNATURES (
        id integer not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    );

    create table SKILLS (
        id integer not null auto_increment,
        name varchar(255) not null,
        weight double precision,
        skillgroup_id integer not null,
        primary key (id)
    );

    create table SURVEYDETAILS (
        id integer not null auto_increment,
        score integer,
        survey_id integer not null,
        skill_id integer not null,
        primary key (id)
    );

    create table SURVEYS (
        id integer not null auto_increment,
        date datetime not null,
        person_id integer not null,
        primary key (id)
    );

    alter table SKILLGROUPS 
        add index FK28317745E693BABA (skillnature_id), 
        add constraint FK28317745E693BABA 
        foreign key (skillnature_id) 
        references SKILLNATURES (id);

    alter table SKILLS 
        add index FK91E57442FD4242FA (skillgroup_id), 
        add constraint FK91E57442FD4242FA 
        foreign key (skillgroup_id) 
        references SKILLGROUPS (id);

    alter table SURVEYDETAILS 
        add index FK3FC34988699E79A (survey_id), 
        add constraint FK3FC34988699E79A 
        foreign key (survey_id) 
        references SURVEYS (id);

    alter table SURVEYDETAILS 
        add index FK3FC34988847713FA (skill_id), 
        add constraint FK3FC34988847713FA 
        foreign key (skill_id) 
        references SKILLS (id);

    alter table SURVEYS 
        add index FKBC5CD039C12321BA (person_id), 
        add constraint FKBC5CD039C12321BA 
        foreign key (person_id) 
        references PERSONS (id);
