CREATE TABLE candidatura (
                             id_candidatura                  INTEGER NOT NULL,
                             data_candidatura                TIMESTAMP,
                             carta_apresentacao              VARCHAR(3000),
                             estudante_id_estudante          INTEGER NOT NULL,
                             vaga_empresa_id_vaga_empresa    INTEGER NOT NULL
);

ALTER TABLE candidatura ADD CONSTRAINT candidatura_pk PRIMARY KEY ( id_candidatura );

CREATE TABLE competencia (
                             id_competencia     INTEGER NOT NULL,
                             descricao          VARCHAR(1000),
                             nivel_proficiencia VARCHAR(100)
);

ALTER TABLE competencia ADD CONSTRAINT competencia_pk PRIMARY KEY ( id_competencia );

CREATE TABLE competencia_estudante (
                                       id_competencia_estudante      INTEGER NOT NULL,
                                       competencia_id_competencia    INTEGER NOT NULL,
                                       estudante_id_estudante        INTEGER NOT NULL
);

ALTER TABLE competencia_estudante ADD CONSTRAINT competencia_estudante_pk PRIMARY KEY ( id_competencia_estudante );

CREATE TABLE competencia_vaga (
                                  id_competencia_vaga           INTEGER NOT NULL,
                                  vaga_id_vaga                  INTEGER NOT NULL,
                                  competencia_id_competencia    INTEGER NOT NULL
);

ALTER TABLE competencia_vaga ADD CONSTRAINT competencia_vaga_pk PRIMARY KEY ( id_competencia_vaga );

CREATE TABLE empresa (
                         id_empresa        INTEGER NOT NULL,
                         nome_empresa      VARCHAR(100),
                         email_empresa     VARCHAR(100),
                         login_empresa     VARCHAR(100),
                         senha_empresa     VARCHAR(100),
                         razao_social      VARCHAR(100),
                         biografia_empresa VARCHAR(2000)
);

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY ( id_empresa );

CREATE TABLE estudante (
                           id_estudante     INTEGER NOT NULL,
                           numero_matricula INTEGER,
                           nome_estudante   VARCHAR(100),
                           email            VARCHAR(100),
                           login            VARCHAR,
                           senha            VARCHAR(100),
                           data_nascimento  TIMESTAMP,
                           biografia        VARCHAR(1000)
);

ALTER TABLE estudante ADD CONSTRAINT estudantes_pk PRIMARY KEY ( id_estudante );

CREATE TABLE vaga (
                      id_vaga           INTEGER NOT NULL,
                      cargo             VARCHAR(100),
                      descricao_vaga    VARCHAR(1000),
                      data_publicacao   TIMESTAMP,
                      data_encerramento TIMESTAMP,
                      salario           NUMERIC(3, 2)
);

ALTER TABLE vaga ADD CONSTRAINT vaga_pk PRIMARY KEY ( id_vaga );

CREATE TABLE vaga_empresa (
                              id_vaga_empresa       INTEGER NOT NULL,
                              vaga_id_vaga          INTEGER NOT NULL,
                              empresa_id_empresa    INTEGER NOT NULL
);

ALTER TABLE vaga_empresa ADD CONSTRAINT vaga_empresa_pk PRIMARY KEY ( id_vaga_empresa );

ALTER TABLE candidatura
    ADD CONSTRAINT candidatura_estudante_fk FOREIGN KEY ( estudante_id_estudante )
        REFERENCES estudante ( id_estudante );

ALTER TABLE candidatura
    ADD CONSTRAINT candidatura_vaga_empresa_fk FOREIGN KEY ( vaga_empresa_id_vaga_empresa )
        REFERENCES vaga_empresa ( id_vaga_empresa );

ALTER TABLE competencia_estudante
    ADD CONSTRAINT competencia_estudante_competencia_fk FOREIGN KEY ( competencia_id_competencia )
        REFERENCES competencia ( id_competencia );

ALTER TABLE competencia_estudante
    ADD CONSTRAINT competencia_estudante_estudante_fk FOREIGN KEY ( estudante_id_estudante )
        REFERENCES estudante ( id_estudante );

ALTER TABLE competencia_vaga
    ADD CONSTRAINT competencia_vaga_competencia_fk FOREIGN KEY ( competencia_id_competencia )
        REFERENCES competencia ( id_competencia );

ALTER TABLE competencia_vaga
    ADD CONSTRAINT competencia_vaga_vaga_fk FOREIGN KEY ( vaga_id_vaga )
        REFERENCES vaga ( id_vaga );

ALTER TABLE vaga_empresa
    ADD CONSTRAINT vaga_empresa_empresa_fk FOREIGN KEY ( empresa_id_empresa )
        REFERENCES empresa ( id_empresa );

ALTER TABLE vaga_empresa
    ADD CONSTRAINT vaga_empresa_vaga_fk FOREIGN KEY ( vaga_id_vaga )
        REFERENCES vaga ( id_vaga );