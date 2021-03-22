CREATE TABLE salesforce.telsupportreservation__c (
    emptystatus__c character varying(255),
    startdatetime__c timestamp without time zone,
    type__c character varying(255),
    name character varying(80),
    enddatetime__c timestamp without time zone,
    lastmodifieddate timestamp without time zone,
    isdeleted boolean,
    systemmodstamp timestamp without time zone,
    createddate timestamp without time zone,
    reservationcustomer__c character varying(255),
    reservationdatetime__c timestamp without time zone,
    externalid__c character varying(255),
    sfid character varying(18) COLLATE pg_catalog.ucs_basic,
    id integer NOT NULL,
    _hc_lastop character varying(32),
    _hc_err text
);

CREATE SEQUENCE salesforce.telsupportreservation__c_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE salesforce.telsupportreservation__c_id_seq OWNED BY salesforce.telsupportreservation__c.id;

ALTER TABLE ONLY salesforce.telsupportreservation__c ALTER COLUMN id SET DEFAULT nextval('salesforce.telsupportreservation__c_id_seq'::regclass);

ALTER TABLE ONLY salesforce.telsupportreservation__c
    ADD CONSTRAINT telsupportreservation__c_pkey PRIMARY KEY (id);
CREATE INDEX hc_idx_telsupportreservation__c_systemmodstamp ON salesforce.telsupportreservation__c USING btree (systemmodstamp);

CREATE UNIQUE INDEX hcu_idx_telsupportreservation__c_externalid__c ON salesforce.telsupportreservation__c USING btree (externalid__c);

CREATE UNIQUE INDEX hcu_idx_telsupportreservation__c_sfid ON salesforce.telsupportreservation__c USING btree (sfid);
